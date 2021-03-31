package dev.connellrobert.ims.controller;

import dev.connellrobert.ims.model.Issue;
import dev.connellrobert.ims.repo.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/issue")
public class IssueController {

    @Autowired
    private IssueRepository issueRepo;

    @GetMapping
    public List<Issue> findAllIssues(){return issueRepo.findAll();}

    @GetMapping(value = "/${id}")
    public Issue findIssueById(@RequestParam("id") long id){return issueRepo.findById(id).get();}

    @PostMapping
    public Issue createIssue(@RequestBody Issue issue){return issueRepo.save(issue);}
}
