package com.ddu.ce.query_management.dao;

import java.util.List;

import com.ddu.ce.query_management.entities.Query;

public interface QueryDAO {
	public List<Query> findAll();//to fetch all queries
	public Query findById(int id);// to fetch a perticular query
	
	public void save(Query query);
	public void delete(int queryId);
	public void update(Query query );

}
