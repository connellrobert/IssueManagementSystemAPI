package dev.connellrobert.ims.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"projectName"})})
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long projectId;

    @NotNull
    private String projectName;
    
    private String projectDescription;

    //@Pattern for #.#
    private double currentReleaseVersion;

    private double currentDevelopmentVersion;

    @OneToMany(mappedBy = "project", fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<Issue> issues;


    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    Set<UserProjectMap> users;
}
