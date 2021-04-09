package dev.connellrobert.ims.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.connellrobert.ims.IssueManagementApiApplication;
import dev.connellrobert.ims.model.Issue;
import dev.connellrobert.ims.model.Project;
import dev.connellrobert.ims.model.User;
import dev.connellrobert.ims.model.UserProjectMap;
import dev.connellrobert.ims.model.UserProjectRelationship;
import dev.connellrobert.ims.model.UserRole;
import dev.connellrobert.ims.repo.UserRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.util.HashSet;

@ExtendWith({SpringExtension.class, RestDocumentationExtension.class})
@SpringBootTest(classes = IssueManagementApiApplication.class)
public class UserControllerTest {

    private MockMvc mock;

    @Autowired
    private ObjectMapper om;
    
    @Autowired
    UserRepository userRepo;

    @BeforeEach
    public void setup(WebApplicationContext ctx, RestDocumentationContextProvider provider){
        this.mock = MockMvcBuilders.webAppContextSetup(ctx)
                .apply(documentationConfiguration(provider))
                .build();
        
        User u = new User(1, "admin", new HashSet<UserProjectMap>());
//        u.getProjects().add(new UserProjectMap(new UserProjectRelationship(1, 1), u, new Project(1, "marketing proj", 1, 1, new HashSet<Issue>(), new HashSet<UserProjectMap>()), UserRole.ADMIN));
        
        User newU = userRepo.save(u);
    }

    @Test
    public void whenGetUserByIdThenSuccessful() throws Exception {
        this.mock.perform(get("/user")).andDo(print());
    }


}
