package dev.connellrobert.ims.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserProjectRelationship implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 403534125994125628L;

	@Column(name = "user_id")
    private long userId;

    @Column(name = "project_id")
    private long projectId;
}
