package com.ddu.ce.query_management.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;
    
    private String content;
    
    
    @ManyToOne
    @JoinColumn(name = "query_id")
    private Query query;

	public Long getCommentId() {
		return commentId;
	}

	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}



	public Query getQuery() {
		return query;
	}

	public void setQuery(Query query) {
		this.query = query;
	}

	public Comment(Long commentId, String content, Query query) {
		super();
		this.commentId = commentId;
		this.content = content;
		
		this.query = query;
	}

	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", content=" + content + ", query=" + query + "]";
	}

	public Comment() {
		super();
	}
    
    
}