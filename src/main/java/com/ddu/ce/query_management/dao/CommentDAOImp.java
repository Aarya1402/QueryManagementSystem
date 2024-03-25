package com.ddu.ce.query_management.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ddu.ce.query_management.entities.Comment;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

@Repository
public class CommentDAOImp implements CommentDAO {

	private EntityManager entityManager;

	@Autowired
	public CommentDAOImp(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public List<Comment> findAll() {

		// create a query
		TypedQuery<Comment> theQuery = entityManager.createQuery("from Employee", Comment.class);

		// execute query and get result list
		List<Comment> employees = theQuery.getResultList();

		// return the results
		return employees;
	}

	@Override
	public Comment findById(int id) {

		// get comment
		Comment theComment = entityManager.find(Comment.class, id);

		return theComment;
	}

	@Override
	public List<Comment> findByQueryId(int QueryId) {
		return null;

	}

	@Override
	public void save(Comment comment) {
		entityManager.persist(comment);
	}

	@Override
	public void deleteById(int commentId) {
		Query theQuery = entityManager.createQuery("delete from Employee where id=:commentId");

		theQuery.setParameter("CommentId", commentId);

		theQuery.executeUpdate();

	}

	@Override
	public void update(Comment comment) {
		entityManager.merge(comment);
	}

	@Override
	public void delete(Comment comment) {
		// TODO Auto-generated method stub

	}

}