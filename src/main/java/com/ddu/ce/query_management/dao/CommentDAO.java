package com.ddu.ce.query_management.dao;
import com.ddu.ce.query_management.entities.Comment;
import java.util.List;
public interface CommentDAO {
	
	public List<Comment> findAll();//to fetch all comments
	
	public Comment findById(int id);// to fetch a particular comment
	
	public List<Comment> findByQueryId(int QueryId);// to fetch all comments for particular query
	
	public void save(Comment comment);
	
	public void deleteById(int Id);

	public void update(Comment comment); 
}
