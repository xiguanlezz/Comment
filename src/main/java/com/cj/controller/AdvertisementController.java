package com.cj.controller;

import com.cj.dto.AdvertisementDto;
import com.cj.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RequestMapping("/ad")
@Controller
public class AdvertisementController {

    @Autowired
    private AdvertisementService advertisementService;

    @Value("${ad.savePath}")
    private String imgSavePath;
    @Value("${ad.url}")
    private String imgURL;

    @RequestMapping
    public String show(Model model, AdvertisementDto a) {
        //POJO只是为了page对象
//        System.out.println(a);
        List<AdvertisementDto> adList = advertisementService.QueryByPage(a);
        model.addAttribute("ads", adList);
        model.addAttribute("searchad", a);
        return "content/adList";
    }

    @RequestMapping("/search")
    public String search(Model model, AdvertisementDto a) {
        List<AdvertisementDto> adList = advertisementService.QueryByPage(a);
        model.addAttribute("ads", adList);
        System.out.println(a.getPage());
        model.addAttribute("searchad", a);
        return "content/adList";
    }

    @RequestMapping("/toadd")
    public String toadd() {
        return "content/adAdd";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String add(@RequestParam(value = "file", required = false) MultipartFile file,
                      @Valid AdvertisementDto advertisement, BindingResult result,
                      Model model) {
        if (result.hasErrors()) {
            StringBuilder s = new StringBuilder();
            List<FieldError> errors = result.getFieldErrors();
            for (FieldError error : errors) {
                String message = error.getDefaultMessage();
//                System.out.println(message);
                s.append(message + " ");
            }
            model.addAttribute("error", s);
            return "content/adAdd";

        } else {
            if (file != null && file.getSize() > 0) {
                String fileName = file.getOriginalFilename();
                File f = new File(imgSavePath + "/" + fileName);

                advertisement.setAdvertisementImgName(fileName);
                advertisementService.Add(advertisement);
                System.out.println(advertisement);
                try {
                    file.transferTo(f);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                model.addAttribute("msg", "新增成功");
                return "content/adList";
            } else {
                model.addAttribute("msg", "新增失败, 文件不能为空");
                return "content/adList";
            }
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Integer id, Model model) {
        if (advertisementService.Delete(id) > 0) {
            model.addAttribute("msg", "删除成功");
            return "content/adList";
        } else {
            model.addAttribute("msg", "删除失败");
            return "content/adList";
        }

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String toupdate(@PathVariable("id") Integer id, Map<String, Object> map) {
        AdvertisementDto a = advertisementService.QueryById(id);
        map.put("ad", a);
        return "content/adUpdate";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String update(@RequestParam(value = "file", required = false) MultipartFile file,
                         @PathVariable("id") Integer id, AdvertisementDto a, Model model) {
//        System.out.println(a);

        if (file != null && file.getSize() != 0) {
            a.setAdvertisementImgName(file.getOriginalFilename());
        }

        if (advertisementService.Update(id, a) > 0) {
            model.addAttribute("msg", "更新成功");
            return "content/adUpdate";
        } else {
            model.addAttribute("msg", "更新失败");
            model.addAttribute("ad", a);
            return "content/adUpdate";
        }
    }

}
