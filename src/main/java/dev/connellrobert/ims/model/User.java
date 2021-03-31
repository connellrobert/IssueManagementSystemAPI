package dev.connellrobert.ims.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"username"}))
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userId;

    private String username;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_projects",
            joinColumns = {
                    @JoinColumn(name = "userId")},
            inverseJoinColumns = {
                    @JoinColumn(name = "projectId")}
    )
    private Set<Project> projects;


}
