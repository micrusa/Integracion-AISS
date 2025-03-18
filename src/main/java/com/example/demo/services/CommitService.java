package com.example.demo.services;

import com.example.demo.model.commit.Commit;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CommitService {
    private final RestTemplate restTemplate;

    public CommitService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Commit> getCommits(String repo, String user) {
        String url = "https://api.github.com/repos/" + user + "/" + repo + "/commits";
        Commit[] commits = restTemplate.getForObject(url, Commit[].class);
        return commits == null ? null : List.of(commits);
    }
}
