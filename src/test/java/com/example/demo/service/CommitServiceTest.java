package com.example.demo.service;

import com.example.demo.services.CommitService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class CommitServiceTest {
    @Autowired
    private CommitService commitService;

    @Test
    @DisplayName("Get Commits")
    public void getCommits() {
        String repo = "spring-boot";
        String user = "spring-projects";
        var commits = commitService.getCommits(repo, user);
        assertNotNull(commits, "Commits list is null");
        assertFalse(commits.isEmpty(), "Commits list is empty");
        //System.out.println("Commits: " + commits);
    }
}
