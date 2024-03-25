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

import com.ddu.ce.query_management.entities.Query;
import com.ddu.ce.query_management.service.QueryService;

@RestController
@RequestMapping("/api")
public class QueryRestController {
	private QueryService queryService;

	@Autowired
	public QueryRestController(QueryService theQueryService) {
		queryService = theQueryService;
	}

	// expose "/query" and return list of query
	@GetMapping("/Query")
	public List<Query> findAll() {
		return queryService.findAll();
	}

	// add mapping for GET /query/{queryId}

	@GetMapping("/Query/{queryId}")
	public Query getQuery(@PathVariable int queryId) {

		Query theQuery = queryService.findById(queryId);

		if (theQuery == null) {
			throw new RuntimeException("Query id not found - " + queryId);
		}

		return theQuery;
	}
	// add mapping for POST /query - add new query

	@PostMapping("/Query")
	public Query addQuery(@RequestBody Query theQuery) {

		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update

		// take a look at this...
		// theQuery.setId(0);

		queryService.save(theQuery);

		return theQuery;
	}

	// add mapping for PUT /query - update existing query

	@PutMapping("/Query")
	public Query updateQuery(@RequestBody Query theQuery) {

		queryService.save(theQuery);

		return theQuery;
	}

	// add mapping for DELETE /query/{queryId} - delete query

	@DeleteMapping("/Query/{queryId}")
	public String deleteQuery(@PathVariable int queryId) {

		Query tempQuery = queryService.findById(queryId);

		// throw exception if null

		if (tempQuery == null) {
			throw new RuntimeException("Query id not found - " + queryId);
		}

		queryService.delete(queryId);

		return "Deleted Comment id - " + queryId;
	}

}
