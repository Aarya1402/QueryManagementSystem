package com.ddu.ce.query_management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ddu.ce.query_management.dao.QueryDAO;
import com.ddu.ce.query_management.entities.Query;

@Service
public class QueryServiceImp implements QueryService{

	private QueryDAO queryDAO;
	
	@Autowired
	public QueryServiceImp(@Qualifier("QueryDAOImp") QueryDAO theQueryDAO) {
		queryDAO = theQueryDAO;
	}
	
	@Override
	@Transactional
	public List<Query> findAll() {
		// TODO Auto-generated method stub
		return queryDAO.findAll();
	}

	@Override
	@Transactional
	public Query findById(int id) {
		// TODO Auto-generated method stub
		return queryDAO.findById(id);
	}

	@Override
	@Transactional
	public void save(Query query) {
		queryDAO.save(query);
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public void delete(int queryId) {
		queryDAO.delete(queryId);
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public void update(Query query) {
		queryDAO.save(query);
		// TODO Auto-generated method stub
		
	}
	
}
