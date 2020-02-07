package com.cj.service;

import com.cj.dao.CommentDao;
import com.cj.dto.CommentDto;
import com.cj.dto.CommentListDto;
import com.cj.entity.Business;
import com.cj.entity.Comment;
import com.cj.entity.Orders;
import com.cj.entity.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentDao commentDao;
    @Autowired
    private OrderService orderService;

    @Transactional
    public boolean Add(CommentDto commentDto) {
        Comment comment = new Comment();
        BeanUtils.copyProperties(commentDto, comment);
        if (commentDao.Add(comment) > 0) {
            if (orderService.UpdateState(commentDto.getCommentOId())) {
                return true;
            }
        }
        return false;
    }

    public CommentListDto ForApiQueryByPage(Integer BId, Page p) {
        Comment comment = new Comment();
        Orders orders = new Orders();
        Business business = new Business();
        comment.setCommentOrder(orders);
        comment.getCommentOrder().setOrderBusiness(business);
        comment.setPage(p);
        comment.getPage().setCurrentPage(p.getCurrentPage() + 1);
        comment.getCommentOrder().getOrderBusiness().setBusinessId(BId);
        CommentListDto result = new CommentListDto();
        List<CommentDto> commentDtoList = new ArrayList<CommentDto>();

        List<Comment> comments = commentDao.QuerySingleByPage(comment);
//        System.out.println(comments);
        for (Comment c : comments) {
            CommentDto t = new CommentDto();
            BeanUtils.copyProperties(c, t);
            t.setComment(c.getCommentContent());
            t.setStar(c.getCommentStar());
//            t.setUsername();
            //隐藏手机号中间四位
            String tt = String.valueOf(c.getCommentMember().getMemberPhone());
            String t1 = tt.substring(0, 3);
            String t2 = tt.substring(7, 11);
            System.out.println(tt);
            String phone = t1 + "****" + t2;
            t.setUsername(phone);

            //手动清空不需要的数据
            phone = null;
            t1 = null;
            t2 = null;
            t.setCommentId(null);
            t.setCommentMId(null);
            t.setCommentOId(null);
            t.setCommentOrder(null);
            t.setCommentMember(null);


            commentDtoList.add(t);
        }
        Page page = comment.getPage();
        if (page.getTotalPage() < p.getCurrentPage()) {
            result.setHasMore(false);
        } else {
            result.setHasMore(true);
        }
        result.setData(commentDtoList);



        return result;
    }

    public List<CommentDto> QueryAll() {
        List<Comment> comments = commentDao.QueryAll();
        List<CommentDto> result = new ArrayList<CommentDto>();
        for (Comment c : comments) {
            CommentDto t = new CommentDto();
            BeanUtils.copyProperties(c, t);
            result.add(t);
        }
        return result;
    }

    public List<CommentDto> QueryByPage(CommentDto commentDto) {
        Comment comment = new Comment();
        BeanUtils.copyProperties(commentDto, comment);
        List<Comment> comments = commentDao.QueryByPage(comment);
        List<CommentDto> result = new ArrayList<CommentDto>();
        for (Comment c : comments) {
            CommentDto t = new CommentDto();
            BeanUtils.copyProperties(c, t);
            result.add(t);
        }
        return result;
    }
}
