package dev.connellrobert.ims.dto;

import dev.connellrobert.ims.model.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserSubscribeDTO {

	private String username;
	private String projectName;
	private UserRole role;
}
