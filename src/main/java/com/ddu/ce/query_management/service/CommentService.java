package com.ddu.ce.query_management.service;

import java.util.List;

import com.ddu.ce.query_management.entities.Comment;

public interface CommentService {

	public List<Comment> findAll();// to fetch all comments

	public Comment findById(int id);// to fetch a particular comment

	public List<Comment> findByQueryId(int QueryId);// to fetch all comments for particular query

	public void save(Comment comment);

	public void deleteById(int Id);

	public void update(Comment comment);
}
