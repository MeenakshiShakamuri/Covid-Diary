package uk.ac.tees.MAD.W9560777.coviddiary;

public class Class_Model {

    private String title;
    private String url;
    private String description;
    private String author;
    private String publishedAt;
    private String urlToImage;

    public Class_Model(String title, String url, String description, String author, String publishedAt, String urlToImage) {
        this.title = title;
        this.url = url;
        this.description = description;
        this.author = author;
        this.publishedAt = publishedAt;
        this.urlToImage = urlToImage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }
}
