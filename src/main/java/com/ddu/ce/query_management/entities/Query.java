package com.ddu.ce.query_management.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Query {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long queryId;
    
    private String content;
    @Enumerated(EnumType.STRING)
	private QueryStatus status;
    
    public enum QueryStatus {
        PENDING,
        APPROVED,
        DELETED,
    }
    
	public Long getQueryId() {
		return queryId;
	}

	public void setQueryId(Long queryId) {
		this.queryId = queryId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}


	public Query() {
		super();
    	this.status = QueryStatus.PENDING;
		// TODO Auto-generated constructor stub
	}

	public Query(Long queryId, String content, String status) {
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