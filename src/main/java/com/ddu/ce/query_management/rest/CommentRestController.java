package com.ddu.ce.query_management.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ddu.ce.query_management.entities.Comment;
import com.ddu.ce.query_management.service.CommentService;


@RestController
@RequestMapping("/api")
public class CommentRestController {
	private CommentService commentService;
	
	@Autowired
	public CommentRestController(CommentService theCommentService) {
		commentService = theCommentService;
	}
	
	// expose "/comment" and return list of comment
	@GetMapping("/Comment")
	public List<Comment> findAll() {
		return commentService.findAll();
	}

	// add mapping for GET /comment/{commentId}
	
	@GetMapping("/Comment/{commentId}")
	public Comment getComment(@PathVariable int commentId) {
		
		Comment theComment = commentService.findById(commentId);
		
		if (theComment == null) {
			throw new RuntimeException("Comment id not found - " + commentId);
		}
		
		return theComment;
	}
	@GetMapping("/Comment/query/{QueryId}")
	public List<Comment> findByQueryId(@PathVariable int QueryId){
		List<Comment> comment = commentService.findByQueryId(QueryId);
		if (comment == null || comment.isEmpty()) {
	        throw new RuntimeException("No comments found for query id - " + QueryId);
	    }
	    return comment;
	}
	
	// add mapping for POST /comment - add new comment
	
	@PostMapping("/Comment")
	public Comment addComment(@RequestBody Comment theComment) {
		
		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update
		
		//take a look at this...
		//theComment.setCommentId(0);
		
		commentService.save(theComment);
		
		return theComment;
	}
	
	// add mapping for PUT /comment - update existing comment
	
	@PutMapping("/Comment")
	public Comment updateEmployee(@RequestBody Comment theComment) {
		
		commentService.save(theComment);
		
		return theComment;
	}
	
	// add mapping for DELETE /comment/{commentId} - delete comment
	
	@DeleteMapping("/Comment/{commentId}")
	public String deleteComment(@PathVariable int commentId) {
		
		Comment tempComment = commentService.findById(commentId);
		
		// throw exception if null
		
		if (tempComment == null) {
			throw new RuntimeException("Comment id not found - " + commentId);
		}
		
		commentService.deleteById(commentId);
		
		return "Deleted Comment id - " + commentId;
	}
	

}
