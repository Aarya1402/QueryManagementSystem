package com.ddu.ce.query_management.dao;
import com.ddu.ce.query_management.entities.Comment;
import java.util.List;
public interface CommentDAO {
	public List<Comment> findAll();//to fetch all comments
	public Comment findById(int id);// to fetch a perticular comment
	public List<Comment> findByQueryId(int QueryId);// to fetch all comments for perticular query
	public void save(Comment comment);
	public void delete(Comment comment);

	public void update(Comment comment); 
	

}
