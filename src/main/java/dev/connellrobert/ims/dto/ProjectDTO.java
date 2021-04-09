package dev.connellrobert.ims.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDTO {

	private String projectName;
	private String projectDescription;
	private double currentReleaseVersion;
	private double currentDevelopmentVersion;

}
