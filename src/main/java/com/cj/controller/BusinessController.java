package com.cj.controller;

import com.cj.constant.DicTypeConst;
import com.cj.dto.AdvertisementDto;
import com.cj.dto.BusinessDto;
import com.cj.entity.Dic;
import com.cj.service.BusinessService;
import com.cj.service.DicService;
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

@RequestMapping("/business")
@Controller
public class BusinessController {

    @Autowired
    private BusinessService businessService;
    @Autowired
    private DicService dicService;

    @Value("${business.savePath}")
    private String imgSavePath;
    @Value("${business.url}")
    private String imgURL;

    @RequestMapping
    public String show(Model model, BusinessDto b) {
        List<BusinessDto> businessDtoList = businessService.QueryByPage(b);
        model.addAttribute("bList", businessDtoList);
        System.out.println(b.getPage());
        model.addAttribute("searchbs", b);
        return "content/businessList";
    }

    @RequestMapping("/search")
    public String search(Model model, BusinessDto b) {
        //取出jsp暂存的关键字放到Dto和实体类公共属性里面
        b.setBusinessTitle(b.getKeyword());

        List<BusinessDto> businessDtoList = businessService.QueryByPage(b);
        model.addAttribute("bList", businessDtoList);

        model.addAttribute("searchbs", b);
        return "content/businessList";
    }

    @RequestMapping("/toadd")
    public String toadd(Model model) {
        List<Dic> dicCities = dicService.QueryByType(DicTypeConst.CITY);
        List<Dic> dicCates = dicService.QueryByType(DicTypeConst.CATE);
        model.addAttribute("dicCities", dicCities);
        model.addAttribute("dicCates", dicCates);
        return "content/businessAdd";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String add(@RequestParam(value = "file", required = false) MultipartFile file,
                      @Valid BusinessDto businessDto, Model model, BindingResult result) {
        if (result.hasErrors()) {
            StringBuilder s = new StringBuilder();
            List<FieldError> errors = result.getFieldErrors();
            for (FieldError error : errors) {
                String message = error.getDefaultMessage();
//                System.out.println(message);
                s.append(message + " ");
            }
            model.addAttribute("error", s);
            return "content/businessAdd";

        } else {
            String fileName = file.getOriginalFilename();
            File f = new File(imgSavePath + "/" + fileName);

            businessDto.setBusinessImgName(fileName);
            businessService.Add(businessDto);
            System.out.println(businessDto);
            try {
                file.transferTo(f);
            } catch (IOException e) {
                e.printStackTrace();
            }
            model.addAttribute("msg", "新增成功");
            return "content/businessList";
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Integer id, Model model) {
        if (businessService.Delete(id) > 0) {
            model.addAttribute("msg", "删除成功");
            return "content/businessList";
        } else {
            model.addAttribute("msg", "删除失败");
            return "content/businessList";
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String toupdate(@PathVariable("id") int id, Map<String, Object> map) {
        BusinessDto b = businessService.QueryById(id);
        List<Dic> dicCities = dicService.QueryByType(DicTypeConst.CITY);
        List<Dic> dicCates = dicService.QueryByType(DicTypeConst.CATE);
        map.put("dicCities", dicCities);
        map.put("dicCates", dicCates);
        map.put("bdto", b);
        return "content/businessUpdate";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String update(@RequestParam(value = "file", required = false) MultipartFile file,
                         @PathVariable("id") Integer id, BusinessDto b, Model model) {
//        System.out.println(b);

        if (file != null && file.getSize() != 0) {
            b.setBusinessImgName(file.getOriginalFilename());
        }

        if (businessService.Update(id, b) > 0) {
            model.addAttribute("msg", "更新成功");
            return "content/businessUpdate";
        } else {
            model.addAttribute("msg", "更新失败");
            model.addAttribute("bdto", b);
            List<Dic> dicCities = dicService.QueryByType(DicTypeConst.CITY);
            List<Dic> dicCates = dicService.QueryByType(DicTypeConst.CATE);
            model.addAttribute("dicCities", dicCities);
            model.addAttribute("dicCates", dicCates);
            return "content/businessUpdate";
        }
    }

}
