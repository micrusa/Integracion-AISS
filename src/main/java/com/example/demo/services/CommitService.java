package com.example.demo.services;

import com.example.demo.model.commit.Commit;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

@Service
public class CommitService {
    private final RestTemplate restTemplate;

    @Value("${github.token}")
    private String githubToken;

    public CommitService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public <T> ResponseEntity<T> getForAuthenticated(String url, Class<T> className) {
        HttpHeaders headers = new HttpHeaders();
        if(githubToken != null && !githubToken.isBlank()) {
            headers.set("Authorization", "Bearer " + githubToken);
        }
        HttpEntity<Commit[]> entity = new HttpEntity<>(headers);
        return restTemplate.exchange(url, HttpMethod.GET, entity, className);
    }

    public List<Commit> getCommits(String repo, String user) {
        String url = "https://api.github.com/repos/" + user + "/" + repo + "/commits";

        Commit[] commits = getForAuthenticated(url, Commit[].class).getBody();
        return commits == null ? null : List.of(commits);
    }

    public List<Commit> getPaginatedCommits(String repo, String user, int page, int perPage) {
        String url = "https://api.github.com/repos/" + user + "/" + repo + "/commits?page=" + page + "&per_page=" + perPage;

        Commit[] commits = getForAuthenticated(url, Commit[].class).getBody();
        return commits == null ? null : List.of(commits);
    }

    public List<Commit> getAllCommits(String repo, String user) {
        String url = "https://api.github.com/repos/" + user + "/" + repo + "/commits?page=1";
        ResponseEntity<Commit[]> response = getForAuthenticated(url, Commit[].class);
        if(response == null || response.getBody() == null)
            return null;
        List<Commit> commits = new ArrayList<>(List.of(response.getBody()));
        while(true) {
            String next = getNextPageUrl(response.getHeaders());
            if(next == null) break;
            response = getForAuthenticated(next, Commit[].class);
            if(response == null || response.getBody() == null)
                break;
            commits.addAll(List.of(response.getBody()));
        }
        return commits;
    }

    // Source: https://github.com/hub4j/github-api/blob/bc132521ddec315f845131358e559930451db1ac/src/main/java/org/kohsuke/github/GitHubPageIterator.java
    public static String getNextPageUrl(HttpHeaders headers) {
        String result = null;

        // If there is no link header, return null
        List<String> linkHeader = headers.get("Link");
        if (linkHeader == null)
            return null;

        // If the header contains no links, return null
        String links = linkHeader.get(0);
        if (links == null || links.isEmpty())
            return null;

        // Return the next page URL or null if none.
        for (String token : links.split(", ")) {
            if (token.endsWith("rel=\"next\"")) {
                // Found the next page. This should look something like
                // <https://api.github.com/repos?page=3&per_page=100>; rel="next"
                int idx = token.indexOf('>');
                result = token.substring(1, idx);
                break;
            }
        }

        return result;
    }


    public static LocalDateTime StringToLocalDateTime(String dateToParse) {

        Instant instant = Instant.parse(dateToParse);
        LocalDateTime parsedDate = LocalDateTime.ofInstant(instant, ZoneOffset.UTC);

        return parsedDate;
    }
}
