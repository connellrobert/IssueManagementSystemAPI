package dev.connellrobert.ims.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.connellrobert.ims.dto.ProjectDTO;
import dev.connellrobert.ims.model.Project;
import dev.connellrobert.ims.service.PersistenceService;
import dev.connellrobert.ims.service.QueryService;

@RestController
@RequestMapping("/project")
public class ProjectController {

	@Autowired
	private QueryService query;

	@Autowired
	private PersistenceService persister;

	@GetMapping
	public Page<ProjectDTO> getAllProjects(@RequestParam(value = "page", required = false, defaultValue = "0") int page,
			@RequestParam(value = "offset", required = false, defaultValue = "25") int offset) {
		return query.findAllProjects(page, offset);
	}

	@GetMapping(value = "/{name}")
	public ProjectDTO findProjectById(@PathVariable("name") String name) {
		System.out.println(name);
		System.out.println("called get mapping");
		return query.findProjectByName(name);
	}

	@PostMapping
	public ProjectDTO createProject(@RequestBody Project project) {
		return persister.saveProject(project);
	}

	@DeleteMapping("/{name}")
	public ProjectDTO deleteProject(@PathVariable("name") String name) {
		ProjectDTO dto = query.findProjectByName(name);
		persister.deleteProject(name);
		return dto;
	}

}
