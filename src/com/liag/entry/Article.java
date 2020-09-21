package com.liag.entry;

public class Article {
    private int id;
    private String a_text;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getA_text() {
        return a_text;
    }

    public void setA_text(String a_text) {
        this.a_text = a_text;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", a_text='" + a_text + '\'' +
                '}';
    }
}
