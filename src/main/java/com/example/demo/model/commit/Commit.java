
package com.example.demo.model.commit;

import java.util.List;

import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Commit {

    @JsonProperty("sha")
    private String sha;
    @JsonProperty("node_id")
    private String nodeId;
    @JsonProperty("commit")
    private CommitData commit;
    @JsonProperty("url")
    private String url;
    @JsonProperty("html_url")
    private String htmlUrl;
    @JsonProperty("comments_url")
    private String commentsUrl;
    @JsonProperty("author")
    private AuthorData author;
    @JsonProperty("committer")
    private CommitterData committer;
    @JsonProperty("parents")
    private List<Parent> parents;

    @JsonProperty("sha")
    public String getSha() {
        return sha;
    }

    @JsonProperty("sha")
    public void setSha(String sha) {
        this.sha = sha;
    }

    @JsonProperty("node_id")
    public String getNodeId() {
        return nodeId;
    }

    @JsonProperty("node_id")
    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    @JsonProperty("commit")
    public CommitData getCommit() {
        return commit;
    }

    @JsonProperty("commit")
    public void setCommit(CommitData commit) {
        this.commit = commit;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("html_url")
    public String getHtmlUrl() {
        return htmlUrl;
    }

    @JsonProperty("html_url")
    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    @JsonProperty("comments_url")
    public String getCommentsUrl() {
        return commentsUrl;
    }

    @JsonProperty("comments_url")
    public void setCommentsUrl(String commentsUrl) {
        this.commentsUrl = commentsUrl;
    }

    @JsonProperty("author")
    public AuthorData getAuthor() {
        return author;
    }

    @JsonProperty("author")
    public void setAuthor(AuthorData author) {
        this.author = author;
    }

    @JsonProperty("committer")
    public CommitterData getCommitter() {
        return committer;
    }

    @JsonProperty("committer")
    public void setCommitter(CommitterData committer) {
        this.committer = committer;
    }

    @JsonProperty("parents")
    public List<Parent> getParents() {
        return parents;
    }

    @JsonProperty("parents")
    public void setParents(List<Parent> parents) {
        this.parents = parents;
    }
}
