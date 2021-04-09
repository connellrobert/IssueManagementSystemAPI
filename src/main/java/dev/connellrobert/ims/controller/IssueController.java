package dev.connellrobert.ims.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.connellrobert.ims.dto.IssueDTO;
import dev.connellrobert.ims.service.PersistenceService;
import dev.connellrobert.ims.service.QueryService;

@RestController
@RequestMapping("/issue")
public class IssueController {

	@Autowired
	private QueryService query;

	@Autowired
	private PersistenceService persister;

	@GetMapping
	public Page<IssueDTO> findAllIssues(@PathParam("page") int page, @PathParam("offset") int offset) {
		return query.findAllIssues(page, offset);
	}

	@GetMapping(value = "/{id}")
	public IssueDTO findIssueById(@RequestParam("id") long id) {
		return query.findIssueById(id);
	}

	@PostMapping
	public IssueDTO createIssue(@RequestBody IssueDTO issue) {
		return persister.saveIssue(issue);
	}
	
	@DeleteMapping("/{id}")
	public IssueDTO deleteIssue(@PathParam("id") int id) {
		IssueDTO dto = query.findIssueById((long)id);
		persister.deleteIssue(id);
		return dto;
	}
}
