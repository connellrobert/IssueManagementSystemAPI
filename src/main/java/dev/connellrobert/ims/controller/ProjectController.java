package dev.connellrobert.ims.controller;

import dev.connellrobert.ims.model.Project;
import dev.connellrobert.ims.repo.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectRepository projectRepo;

    @GetMapping
    public List<Project> getAllProjects(){
        return projectRepo.findAll();
    }

    @GetMapping(value = "/${id}")
    public Project findProjectById(@RequestParam("id") long id){return projectRepo.findById(id).get();}

    @PostMapping
    public Project createProject(@RequestBody Project project){return projectRepo.save(project);}


}
