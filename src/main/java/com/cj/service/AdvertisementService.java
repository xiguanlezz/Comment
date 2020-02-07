package com.cj.service;

import com.cj.dao.AdvertisementDao;
import com.cj.dto.AdvertisementDto;
import com.cj.entity.Advertisement;
import com.cj.entity.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.util.pattern.PathPattern;

import java.util.*;

@Service
public class AdvertisementService {

    @Autowired
    private AdvertisementDao advertisementDao;

    @Value("${ad.url}")
    private String imgURL;

    public int Add(AdvertisementDto a) {
        Advertisement advertisement = new Advertisement();
        advertisement.setAdvertisementName(a.getAdvertisementName());
        advertisement.setAdvertisementImgName(a.getAdvertisementImgName());
        advertisement.setAdvertisementLink(a.getAdvertisementLink());
        advertisement.setAdvertisementWeight(a.getAdvertisementWeight());
        return advertisementDao.Add(advertisement);
    }

    public boolean AddBatch() {
        List<Advertisement> ads = new ArrayList<Advertisement>();
        for (int i = 0; i < 100; i++) {
            Advertisement a = new Advertisement(null, i + "hhhh", i + ".jpg", "www", i);
            ads.add(a);
        }
        advertisementDao.AddBatch(ads);
        return true;
    }

    public int Delete(Integer id) {
        return advertisementDao.Delete(id);
    }

    public int Update(Integer id, AdvertisementDto a) {
        Advertisement advertisement = new Advertisement();
        advertisement.setAdvertisementId(id);
        advertisement.setAdvertisementName(a.getAdvertisementName());
        advertisement.setAdvertisementImgName(a.getAdvertisementImgName());
        advertisement.setAdvertisementLink(a.getAdvertisementLink());
        advertisement.setAdvertisementWeight(a.getAdvertisementWeight());
        return advertisementDao.Update(advertisement);
    }

    public AdvertisementDto QueryById(Integer id) {
        AdvertisementDto advertisementDto = new AdvertisementDto();

        Advertisement a = advertisementDao.QueryById(id);
        advertisementDto.setAdvertisementId(a.getAdvertisementId());
        advertisementDto.setAdvertisementName(a.getAdvertisementName());
        advertisementDto.setAdvertisementImgName(a.getAdvertisementImgName());
        advertisementDto.setAdvertisementLink(a.getAdvertisementLink());
        advertisementDto.setAdvertisementWeight(a.getAdvertisementWeight());
        advertisementDto.setTitle(a.getAdvertisementName());
        advertisementDto.setLink(a.getAdvertisementLink());
        advertisementDto.setImg(imgURL + a.getAdvertisementImgName());
        return advertisementDto;
    }

    public List<AdvertisementDto> ForApiQueryShow() {
        List<AdvertisementDto> advertisementDtos = new ArrayList<AdvertisementDto>();
        List<AdvertisementDto> result = new ArrayList<AdvertisementDto>();
        List<Advertisement> ads = advertisementDao.QueryAll();
        for (int i = 0; i < ads.size(); i++) {
            Advertisement a = ads.get(i);
            AdvertisementDto advertisementDto = new AdvertisementDto();
            advertisementDto.setAdvertisementWeight(a.getAdvertisementWeight());
            advertisementDto.setTitle(a.getAdvertisementName());
            advertisementDto.setLink(a.getAdvertisementLink());
            advertisementDto.setImg(imgURL + a.getAdvertisementImgName());
            advertisementDtos.add(advertisementDto);
        }
        Collections.sort(advertisementDtos);
        for (int i = 0; i < 6; i++) {
            AdvertisementDto a = advertisementDtos.get(i);
            //将不需要的数据手动置空, 减少访问流量
            a.setPage(null);
            a.setAdvertisementWeight(null);
            result.add(a);
        }
        advertisementDtos = null;
//        System.out.println(result);
        return result;
    }

    public List<AdvertisementDto> QueryByPage(AdvertisementDto aDto) {
        List<AdvertisementDto> advertisementDtos = new ArrayList<AdvertisementDto>();
        Advertisement advertisement = new Advertisement();

        //模糊查询设置这个
        advertisement.setAdvertisementName(aDto.getAdvertisementName());

        //分页记得设置这个
        advertisement.setPage(aDto.getPage());
        List<Advertisement> ads = advertisementDao.QueryByPage(advertisement);
        aDto.setPage(advertisement.getPage());

        for (Advertisement a : ads) {
            AdvertisementDto advertisementDto = new AdvertisementDto();
            advertisementDto.setAdvertisementId(a.getAdvertisementId());
            advertisementDto.setAdvertisementName(a.getAdvertisementName());
            advertisementDto.setAdvertisementImgName(a.getAdvertisementImgName());
            advertisementDto.setAdvertisementLink(a.getAdvertisementLink());
            advertisementDto.setAdvertisementWeight(a.getAdvertisementWeight());
            advertisementDto.setTitle(a.getAdvertisementName());
            advertisementDto.setLink(a.getAdvertisementLink());
            advertisementDto.setImg(imgURL + a.getAdvertisementImgName());
            advertisementDtos.add(advertisementDto);
        }
        return advertisementDtos;
    }

    public Integer QueryTotalCount() {
        return advertisementDao.QueryTotalCount();
    }
}
