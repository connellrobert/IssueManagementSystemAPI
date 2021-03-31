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
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long projectId;

    @NotNull
    private String projectName;

    //@Pattern for #.#
    private double currentReleaseVersion;

    private double currentDevelopmentVersion;

    @OneToMany(mappedBy = "project", fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "project_issues")
    private Set<Issue> issues;


    @ManyToMany(mappedBy = "projects", fetch = FetchType.LAZY)
    private Set<User> workers;
}
