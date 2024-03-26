package com.ddu.ce.query_management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ddu.ce.query_management.dao.CommentDAO;
import com.ddu.ce.query_management.dao.CommentDAOImp;
import com.ddu.ce.query_management.entities.Comment;

@Service
public class CommentServiceImp implements CommentService {

	private CommentDAOImp commentDAO;

	@Autowired
	public CommentServiceImp(@Qualifier("commentDAOJpaImp") CommentDAOImp theCommentDAO) {
		commentDAO = theCommentDAO;
	}

	@Override
	@Transactional
	public List<Comment> findAll() {
		// TODO Auto-generated method stub
		return commentDAO.findAll();
	}

	@Override
	@Transactional
	public Comment findById(int id) {
		// TODO Auto-generated method stub
		return commentDAO.findById(id);
	}

	@Override
	@Transactional
	public List<Comment> findByQueryId(int QueryId) {
		return commentDAO.findByQueryId(QueryId);
		// TODO Auto-generated method stub
	}

	@Override
	@Transactional
	public void save(Comment comment) {
		commentDAO.save(comment);
		// TODO Auto-generated method stub

	}

	@Override
	@Transactional
	public void deleteById(int Id) {
		commentDAO.deleteById(Id);
		// TODO Auto-generated method stub

	}

	@Override
	@Transactional
	public void update(Comment comment) {
		commentDAO.save(comment);
		// TODO Auto-generated method stub

	}

}
