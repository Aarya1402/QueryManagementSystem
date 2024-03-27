package com.ddu.ce.query_management.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Query {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int queryId;

	private String content;

	private QueryStatus status;

	public enum QueryStatus {
		PENDING, APPROVED, DELETED,
	}

	public int getQueryId() {
		return queryId;
	}

	public void setQueryId(int queryId) {
		this.queryId = queryId;
	}

	public String getContent() {
		return content;
	}

	public QueryStatus getStatus() {
		return status;
	}

	public void setStatus(QueryStatus status) {
		this.status = status;
	}

	public void setContent(String content) {
		this.content = content;
	}


	public Query() {
		super();
		this.status = QueryStatus.PENDING;
		// TODO Auto-generated constructor stub
	}

	public Query(int queryId, String content,  String status) {
		super();
		this.queryId = queryId;
		this.content = content;
	
		this.status = QueryStatus.PENDING;
	}

	@Override
	public String toString() {
		return "Query [queryId=" + queryId + ", content=" + content + ", status=" + status + "]";
	}

}