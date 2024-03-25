package com.ddu.ce.query_management.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ddu.ce.query_management.entities.Query;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class QueryDAOImp implements QueryDAO {

	private EntityManager entityManager;

	@Autowired
	public QueryDAOImp(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public List<Query> findAll() {

		// create a query
		TypedQuery<Query> theQuery = entityManager.createQuery("from Query", Query.class);

		// execute query and get result list
		List<Query> query = theQuery.getResultList();

		// return the results
		return query;
	}

	@Override
	public Query findById(int id) {
		// TODO Auto-generated method stub
		// get query
		Query theQuery = entityManager.find(Query.class, id);

		// return query
		return theQuery;

	}

	@Override
	public void save(Query query) {
		System.out.println("Before setting:-" + query.getQueryId());

		// save or update the query
		Query dbQuery = entityManager.merge(query);

		// update with id from db ... so we can get generated id for save/insert

		System.out.println("After setting:-" + query.getQueryId());
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int queryId) {
		// TODO Auto-generated method stub
		Query theQuery = (Query) entityManager.createQuery("delete from Query where id=:queryId");

		((jakarta.persistence.Query) theQuery).setParameter("employeeId", queryId);

		((jakarta.persistence.Query) theQuery).executeUpdate();

	}

	@Override
	public void update(Query query) {
		// TODO Auto-generated method stub
		entityManager.merge(query);
	}

}
