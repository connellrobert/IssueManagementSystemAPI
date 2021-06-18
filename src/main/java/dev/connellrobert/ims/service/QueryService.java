package dev.connellrobert.ims.service;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import dev.connellrobert.ims.dto.IssueDTO;
import dev.connellrobert.ims.dto.ProjectDTO;
import dev.connellrobert.ims.dto.UserProjectDTO;
import dev.connellrobert.ims.model.Issue;
import dev.connellrobert.ims.model.Project;
import dev.connellrobert.ims.model.IMSUser;
import dev.connellrobert.ims.repo.IssueRepository;
import dev.connellrobert.ims.repo.ProjectRepository;
import dev.connellrobert.ims.repo.UserRepository;

@Service
public class QueryService {
	
	@Autowired
	private DTOConversionService dtoConversion;

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private ProjectRepository projectRepo;
	
	@Autowired
	private IssueRepository issueRepo;

	
	public Page<UserProjectDTO> findAllUsers(int page, int offset) {
		Page<IMSUser> users = userRepo.findAll(PageRequest.of(page, offset));
		Page<UserProjectDTO> dtos = users.map(dtoConversion.getUserProjectConversion());
		return dtos;
	}

	public UserProjectDTO findUserByUsername(String name) {
		IMSUser u = userRepo.findByUsername(name).orElseGet(() -> new IMSUser());
		UserProjectDTO dto = new UserProjectDTO();
		dto.setUsername(u.getUsername());
		dto.setProjects(u.getProjects().stream().map(dtoConversion.getUserProjectMapDtoConversion()).collect(Collectors.toSet()));
		return dto;
	}

	public Page<ProjectDTO> findAllProjects(int page, int offset) {
		Page<ProjectDTO> dto = projectRepo.findAll(PageRequest.of(page, offset)).map(dtoConversion.getProjectDtoConversion());
		return dto;
	}

	public ProjectDTO findProjectById(long id) {
		return dtoConversion.getProjectDtoConversion().apply(projectRepo.findById(id).orElse(new Project()));
	}

	public ProjectDTO findProjectByName(String name) {
		return dtoConversion.getProjectDtoConversion().apply(projectRepo.findByProjectName(name));
	}
	
	public IssueDTO findIssueById(long id) {
		return dtoConversion.getIssueDTOConversion().apply(issueRepo.findById(id).orElse(new Issue()));
	}
	
	public Page<IssueDTO> findAllIssues(int page, int offset){
		return issueRepo.findAll(PageRequest.of(page, offset)).map(dtoConversion.getIssueDTOConversion());
	}

}
