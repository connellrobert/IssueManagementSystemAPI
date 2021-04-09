package dev.connellrobert.ims.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.connellrobert.ims.dto.IssueDTO;
import dev.connellrobert.ims.dto.ProjectDTO;
import dev.connellrobert.ims.dto.UserProjectDTO;
import dev.connellrobert.ims.dto.UserSubscribeDTO;
import dev.connellrobert.ims.model.Issue;
import dev.connellrobert.ims.model.Project;
import dev.connellrobert.ims.model.User;
import dev.connellrobert.ims.model.UserProjectMap;
import dev.connellrobert.ims.model.UserProjectRelationship;
import dev.connellrobert.ims.repo.IssueRepository;
import dev.connellrobert.ims.repo.ProjectRepository;
import dev.connellrobert.ims.repo.UserProjectJunctionRepository;
import dev.connellrobert.ims.repo.UserRepository;

@Service
public class PersistenceService {
	
	@Autowired
	private DTOConversionService conversion;

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private IssueRepository issueRepo;
	
	@Autowired
	private ProjectRepository projectRepo;
	
	@Autowired
	private UserProjectJunctionRepository uPRepo;
	
	public User saveUser(User u) {
	return userRepo.save(u);	
	}
	
	
	public UserProjectDTO SaveUser(User u) {
		if(u.getProjects() != null) {
			User user = uPRepo.save(u.getProjects().iterator().next()).getUser();
			return conversion.getUserProjectConversion().apply(user);
		}
		return conversion.getUserProjectConversion().apply(userRepo.save(u));		
	}
	
	public void deleteUser(String name) {
		userRepo.deleteByUsername(name);
	}


	public ProjectDTO saveProject(Project project) {
		return conversion.getProjectDtoConversion().apply(projectRepo.save(project));
	}


	public void deleteProject(String id) {
		projectRepo.deleteByProjectName(id);
	}
	
	public IssueDTO saveIssue(IssueDTO i) {
		Issue issue = new Issue();
		issue.setTitle(i.getTitle());
		issue.setContents(i.getContents());
		issue.setProject(projectRepo.findByProjectName(i.getProjectName()));
		return conversion.getIssueDTOConversion().apply(issueRepo.save(issue));
	}
	
	public void deleteIssue(int id) {
		issueRepo.deleteById((long)id);
	}
	
	public UserProjectDTO subscribeUser(UserSubscribeDTO dto) {
		User u = userRepo.findByUsername(dto.getUsername()).orElseThrow(() -> new IllegalArgumentException());
		Project p = projectRepo.findByProjectName(dto.getProjectName());
		UserProjectMap map = new UserProjectMap(new UserProjectRelationship(u.getUserId(), p.getProjectId()), u, p, dto.getRole());	
		u.getProjects().add(map);
		return conversion.getUserProjectConversion().apply(userRepo.save(u));
	}
}
