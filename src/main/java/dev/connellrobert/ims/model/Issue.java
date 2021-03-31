package dev.connellrobert.ims.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.sql.DataSourceDefinitions;
import javax.persistence.*;

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
    private Project project;
}
