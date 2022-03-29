package uk.ac.tees.MAD.W9560777.coviddiary;

import java.util.ArrayList;

public class Class_Main_News {

    private String totalResults;
    private String status;
    private ArrayList<Class_Model> articles;

    public Class_Main_News(String totalResults, String status, ArrayList<Class_Model> articles) {
        this.totalResults = totalResults;
        this.status = status;
        this.articles = articles;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<Class_Model> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<Class_Model> articles) {
        this.articles = articles;
    }
}
