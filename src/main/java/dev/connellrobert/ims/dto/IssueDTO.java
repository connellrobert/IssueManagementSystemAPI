package dev.connellrobert.ims.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IssueDTO {

	private String title;
	
	private String contents;
	
	private String projectName;
}
