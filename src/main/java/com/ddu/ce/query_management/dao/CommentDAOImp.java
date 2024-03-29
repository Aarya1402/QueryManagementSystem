package com.ddu.ce.query_management.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.ddu.ce.query_management.entities.Comment;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;


@Repository
@Qualifier("commentDAOImp")
public class CommentDAOImp implements CommentDAO{
	
	private EntityManager entityManager;
	
	@Autowired
	public CommentDAOImp(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	@Override
	public List<Comment> findAll() {

		// create a query  
		TypedQuery<Comment> theQuery = 
				entityManager.createQuery("from Employee", Comment.class);
		
		// execute query and get result list
		List<Comment> employees = theQuery.getResultList();
		
		// return the results		
		return employees;
	}

	@Override
	public Comment findById(int id) {
		
		// get comment
		Comment theComment = 
				entityManager.find(Comment.class, id);
		
		return theComment;
	}

	@Override
	public List<Comment> findByQueryId(int QueryId) {
		TypedQuery<Comment> query = entityManager.createQuery(
	            "SELECT c FROM Comment c WHERE c.query.id = :queryId", Comment.class);
	    query.setParameter("queryId", QueryId);
	    return query.getResultList();
		
	}

	@Override
	public void save(Comment comment) {
		//entityManager.persist(comment);
		System.out.println("Before setting:-"+comment.getCommentId());
		
		// save or update the comment
		Comment dbComment = entityManager.merge(comment);
				
		// update with id from db ... so we can get generated id for save/insert
		
		 System.out.println("After setting:-"+comment.getCommentId());
	}

	@Override
	public void deleteById(int commentId) {
		Query theQuery = entityManager.createQuery(
				"delete from Employee where id=:commentId");

		theQuery.setParameter("CommentId", commentId);

		theQuery.executeUpdate();

		
	}

	@Override
	public void update(Comment comment) {
		entityManager.merge(comment);
	}


}
