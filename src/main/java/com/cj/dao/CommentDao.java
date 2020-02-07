package com.cj.dao;

import com.cj.entity.Comment;

import java.util.List;

public interface CommentDao {
    public int Add(Comment comment);

    public List<Comment> QuerySingleByPage(Comment comment);

    public List<Comment> QueryAll();

    public List<Comment> QueryByPage(Comment comment);
}
