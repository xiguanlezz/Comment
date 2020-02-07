package com.cj.controller;

import com.cj.dao.CommentDao;
import com.cj.dto.CommentDto;
import com.cj.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/comments")
@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @RequestMapping
    public String show(Model model, CommentDto c) {
        System.out.println(c);
        List<CommentDto> commentDtoList = commentService.QueryByPage(c);
        model.addAttribute("comments", commentDtoList);
        model.addAttribute("searchct", c);

        Map<Integer, Integer> map1 = new LinkedHashMap<Integer, Integer>();   //封装评论id和订单id
        Map<Integer, Long> map2 = new LinkedHashMap<Integer, Long>();   //封装评论id和手机号
        for (CommentDto commentDto : commentDtoList) {
            map1.put(commentDto.getCommentId(), commentDto.getCommentOrder().getOrderId());
            map2.put(commentDto.getCommentId(), commentDto.getCommentMember().getMemberPhone());
        }
        model.addAttribute("Id_OIdMap", map1);
        model.addAttribute("Id_PhoneMap", map2);
        return "content/commentList";
    }

    @RequestMapping("/search")
    public String search(Model model, CommentDto c) {
        System.out.println(c);
        List<CommentDto> commentDtoList = commentService.QueryByPage(c);
        model.addAttribute("comments", commentDtoList);
        model.addAttribute("searchct", c);

        //前端不怎么会操作json, 只能后台封装map回显给jsp页面
        Map<Integer, Integer> map1 = new LinkedHashMap<Integer, Integer>();   //封装评论id和订单id
        Map<Integer, Long> map2 = new LinkedHashMap<Integer, Long>();   //封装评论id和手机号
        for (CommentDto commentDto : commentDtoList) {
            map1.put(commentDto.getCommentId(), commentDto.getCommentOrder().getOrderId());
            map2.put(commentDto.getCommentId(), commentDto.getCommentMember().getMemberPhone());
        }
        model.addAttribute("Id_OIdMap", map1);
        model.addAttribute("Id_PhoneMap", map2);
        return "content/commentList";
    }

}
