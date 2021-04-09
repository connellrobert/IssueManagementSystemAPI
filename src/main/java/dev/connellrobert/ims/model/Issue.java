package dev.connellrobert.ims.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Issue {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long issueId;

    @NotNull
    private String title;

    private String contents;

    @NotNull
    @Enumerated(EnumType.STRING)
    private IssueStatus status;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "project_issues")
    private Project project;
}
