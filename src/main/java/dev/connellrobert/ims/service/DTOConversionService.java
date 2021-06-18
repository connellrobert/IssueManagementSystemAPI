package dev.connellrobert.ims.service;

import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import dev.connellrobert.ims.dto.IssueDTO;
import dev.connellrobert.ims.dto.ProjectDTO;
import dev.connellrobert.ims.dto.UserProjectDTO;
import dev.connellrobert.ims.model.Issue;
import dev.connellrobert.ims.model.Project;
import dev.connellrobert.ims.model.IMSUser;
import dev.connellrobert.ims.model.UserProjectMap;
import lombok.Data;

@Data
@Service
public class DTOConversionService {
	
	private Function<UserProjectMap, ProjectDTO> userProjectMapDtoConversion = (UserProjectMap p) -> {
		Project project = p.getProject();
		ProjectDTO dto = new ProjectDTO(project.getProjectName(), project.getProjectDescription(),
				project.getCurrentReleaseVersion(), project.getCurrentDevelopmentVersion());
		return dto;
	};

	private Function<IMSUser, UserProjectDTO> userProjectConversion = u -> {
		UserProjectDTO dto = new UserProjectDTO();
		dto.setUsername(u.getUsername());
		dto.setProjects(u.getProjects().stream().map(userProjectMapDtoConversion).collect(Collectors.toSet()));
		return dto;
	};

	private Function<Project, ProjectDTO> projectDtoConversion = p -> {
		ProjectDTO dto = new ProjectDTO(p.getProjectName(), p.getProjectDescription(), p.getCurrentReleaseVersion(),
				p.getCurrentDevelopmentVersion());
		return dto;
	};

	Function<Issue, IssueDTO> issueDTOConversion = i -> {
		IssueDTO dto = new IssueDTO();
		dto.setContents(i.getContents());
		dto.setTitle(i.getTitle());
		dto.setProjectName(i.getProject().getProjectName());
		return dto;
	};


}
