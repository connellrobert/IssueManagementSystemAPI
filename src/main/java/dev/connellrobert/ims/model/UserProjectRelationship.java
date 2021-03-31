package dev.connellrobert.ims.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Data
public class UserProjectRelationship {

    @Column(name = "user_id")
    private long userId;

    @Column(name = "project_id")
    private long projectId;
}
