package com.cj.service;

import com.cj.constant.CateConst;
import com.cj.dao.BusinessDao;
import com.cj.dto.AdvertisementDto;
import com.cj.dto.BusinessDto;
import com.cj.dto.BusinessListDto;
import com.cj.entity.Advertisement;
import com.cj.entity.Business;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BusinessService {

    @Autowired
    private BusinessDao businessDao;

    @Value("${business.url}")
    private String imgURL;

    public int Add(BusinessDto b) {
        Business business = new Business();
        BeanUtils.copyProperties(b, business);
        return businessDao.Add(business);
    }

    public boolean AddBatch() {
        List<Business> businesses = new ArrayList<Business>();
        for (int i = 0; i < 100; i++) {
            Business b = new Business();
            b.setBusinessImgName(i + ".jpg");
            b.setBusinessTitle("汉堡王" + i);
            b.setBusinessSubtitle("好好吃的" + i);
            b.setBusinessPrice(i);
            b.setBusinessDistance(i);
            b.setBusinessNumber(i);
            b.setBusinessStar(i / 11);
            b.setBusinessDesc(i + "hhhh");
            b.setBusinessCateCode("KTV");
            b.setBusinessCityCode("北京");
            businesses.add(b);
        }
        businessDao.AddBatch(businesses);
        return true;
    }

    public int Delete(Integer id) {
        return businessDao.Delete(id);
    }

    public int Update(Integer id, BusinessDto b) {
        Business business = new Business();
        BeanUtils.copyProperties(b, business);
        return businessDao.Update(business);
    }

    public int UpdateRedundancy() {
        return businessDao.UpdateRedundancy();
    }

    public int newUpdateStar() {
        return businessDao.newUpdateStar();
    }

    public int UpdateNumber() {
        return businessDao.UpdateNumber();
    }

    public int newUpdateNumber() {
        return businessDao.newUpdateNumber();
    }

    public BusinessDto QueryById(int id) {
        BusinessDto businessDto = new BusinessDto();
        Business b = businessDao.QueryById(id);
        BeanUtils.copyProperties(b, businessDto);
        businessDto.setImg(imgURL + b.getBusinessImgName());
        return businessDto;
    }

    public BusinessDto ForApiQueryById(Long id) {
        BusinessDto businessDto = new BusinessDto();
        Business b = businessDao.QueryById(id);
        BeanUtils.copyProperties(b, businessDto);
        businessDto.setImg(imgURL + b.getBusinessImgName());
        businessDto.setTitle(b.getBusinessTitle());
        businessDto.setStar(b.getBusinessStar());
        businessDto.setPrice(b.getBusinessPrice());
        businessDto.setSubTitle(b.getBusinessSubtitle());
        businessDto.setDesc(b.getBusinessDesc());

        //将不需要的数据手动置空, 减少访问流量
        businessDto.setBusinessId(null);
        businessDto.setBusinessImgName(null);
        businessDto.setBusinessTitle(null);
        businessDto.setBusinessSubtitle(null);
        businessDto.setBusinessPrice(null);
        businessDto.setBusinessDistance(null);
        businessDto.setBusinessNumber(null);
        businessDto.setBusinessStar(null);
        businessDto.setBusinessDesc(null);
        businessDto.setBusinessCityCode(null);
        businessDto.setBusinessCateCode(null);
        businessDto.setPage(null);
        return businessDto;
    }

    public List<BusinessDto> QueryAll() {
        List<BusinessDto> businessDtos = new ArrayList<BusinessDto>();

        List<Business> businesses = businessDao.QueryAll();
        for (Business b : businesses) {
            BusinessDto businessDto = new BusinessDto();
            BeanUtils.copyProperties(b, businessDto);
            businessDtos.add(businessDto);
        }
        return businessDtos;
    }

    public List<BusinessDto> QueryByPage(BusinessDto businessDto) {
        Business business = new Business();
        BeanUtils.copyProperties(businessDto, business);
        List<Business> bs = businessDao.QueryByPage(business);
//        System.out.println(businessDto.getPage());
        List<BusinessDto> businessDtos = new ArrayList<BusinessDto>();
        for (Business b : bs) {
            BusinessDto t = new BusinessDto();
            BeanUtils.copyProperties(b, t);
            businessDtos.add(t);
        }
        return businessDtos;
    }

    public BusinessListDto ForApiQueryLikeByPage(BusinessDto businessDto) {
        BusinessListDto result = new BusinessListDto();
        Business business = new Business();

        //设置模糊查询的关键字
        String keyword = businessDto.getKeyword();
//        System.out.println(keyword);
        if (keyword != null) {
            businessDto.setBusinessTitle(keyword);
            businessDto.setBusinessSubtitle(keyword);
            businessDto.setBusinessDesc(keyword);
        }
        //解决前端直接搜索传的Cate参数为all
        if (CateConst.ALL.equals(businessDto.getBusinessCateCode())) {
            businessDto.setBusinessCateCode(null);
        }
        BeanUtils.copyProperties(businessDto, business);

        //解决前端页码是从0开始的, 当前页码设置为+1
        int currentPage = business.getPage().getCurrentPage();
        business.getPage().setCurrentPage(currentPage + 1);

        List<Business> businesses = businessDao.QueryLikeByPage(business);
//        System.out.println(businesses);
        int totalPages = business.getPage().getTotalPage();
        if (business.getPage().getCurrentPage() <= totalPages) {
            result.setHasMore(true);
        } else {
            result.setHasMore(false);
        }
        List<BusinessDto> rdata = new ArrayList<BusinessDto>();
        for (Business b : businesses) {
            BusinessDto t = new BusinessDto();
            BeanUtils.copyProperties(b, t);
            t.setImg(imgURL + b.getBusinessImgName());
            t.setTitle(b.getBusinessTitle());
            t.setSubTitle(b.getBusinessSubtitle());
            t.setPrice(b.getBusinessPrice());
            t.setDistance(b.getBusinessDistance() + "m");
            t.setMumber(b.getBusinessNumber());
            t.setId(b.getBusinessId().toString());

            //将不需要的数据手动置空, 减少访问流量
            t.setBusinessId(null);
            t.setBusinessImgName(null);
            t.setBusinessTitle(null);
            t.setBusinessSubtitle(null);
            t.setBusinessPrice(null);
            t.setBusinessDistance(null);
            t.setBusinessDesc(null);
            t.setBusinessCityCode(null);
            t.setBusinessCateCode(null);
            t.setBusinessNumber(null);
            t.setBusinessStar(null);
            t.setCateDic(null);
            t.setCityDic(null);

            rdata.add(t);
        }
        result.setData(rdata);
        return result;
    }

}
