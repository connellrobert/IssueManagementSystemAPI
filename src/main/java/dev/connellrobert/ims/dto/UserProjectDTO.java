package dev.connellrobert.ims.dto;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserProjectDTO {

	private String username;
	private Set<ProjectDTO> projects;
}
