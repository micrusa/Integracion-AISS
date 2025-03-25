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
        var commits = commitService.getCommits("Hello-World", "octocat");
        assertNotNull(commits, "Commits list is null");
        assertFalse(commits.isEmpty(), "Commits list is empty");
        System.out.println("Commit count: " + commits.size());

        commits = commitService.getCommits("spring-framework", "spring-projects");
        assertNotNull(commits, "Commits list is null");
        assertFalse(commits.isEmpty(), "Commits list is empty");
        System.out.println("Commit count: " + commits.size());
    }

    @Test
    @DisplayName("Get Paginated Commits")
    public void getPaginatedCommits() {
        for(int i = 1; i <= 3; i++) {
            var commits = commitService.getPaginatedCommits("spring-framework", "spring-projects", i, 5);
            assertNotNull(commits, "Commits list is null");
            assertFalse(commits.isEmpty(), "Commits list is empty");
            System.out.println("Page " + i + " Commit count: " + commits.size());
        }
    }

    @Test
    @DisplayName("Get All Commits")
    public void getAllCommits() {
        var commits = commitService.getAllCommits("Talk2GPT", "0ut0flin3");
        assertNotNull(commits, "Commits list is null");
        assertFalse(commits.isEmpty(), "Commits list is empty");
        System.out.println("All Commit count (Talk2GPT): " + commits.size());
        commits = commitService.getAllCommits("zotcard", "018");
        assertNotNull(commits, "Commits list is null");
        assertFalse(commits.isEmpty(), "Commits list is empty");
        System.out.println("All Commit count (zotcard): " + commits.size());
    }
}
