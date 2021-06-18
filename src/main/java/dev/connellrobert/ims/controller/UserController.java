package dev.connellrobert.ims.controller;

import dev.connellrobert.ims.model.IMSUser;
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

import dev.connellrobert.ims.dto.UserProjectDTO;
import dev.connellrobert.ims.dto.UserSubscribeDTO;
import dev.connellrobert.ims.service.PersistenceService;
import dev.connellrobert.ims.service.QueryService;

@RestController
@RequestMapping(value = "user")
public class UserController {

	@Autowired
	private PersistenceService persister;

	@Autowired
	private QueryService query;

	@GetMapping
	public Page<UserProjectDTO> findAllUsers(
			@RequestParam(value = "page", required = false, defaultValue = "0") int page,
			@RequestParam(value = "offset", required = false, defaultValue = "25") int offset) {
		return query.findAllUsers(page, offset);
	}

	@GetMapping(value = "/{name}")
	public UserProjectDTO findUserById(@PathVariable("name") String name) {
		return query.findUserByUsername(name);
	}

	@PostMapping
	public IMSUser createUser(@RequestBody IMSUser u) {
		return persister.saveUser(u);
	}
	
	@DeleteMapping("{name}")
	public UserProjectDTO deleteUser(@PathVariable("name") String name) {
		UserProjectDTO dto = query.findUserByUsername(name);
		persister.deleteUser(name);
		return dto;
	}
	
	@PostMapping("/project")
	public UserProjectDTO connectUserAndProject(@RequestBody UserSubscribeDTO userProject) {
		return persister.subscribeUser(userProject);
	}

}
