package com.newlecture.app.entity;

import java.util.Date;

public class Notice {
   private int id;
   private String writerld;
   private Date regDate;
   private String title;
   private   String content;
   private int hit;
   private String files;

    public Notice() {
    }

    public Notice(int id, String writerld, Date regDate, String title, String content, int hit ,String files) {
        this.id = id;
        this.writerld = writerld;
        this.regDate = regDate;
        this.title = title;
        this.content = content;
        this.hit = hit;
        this.files=files;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWriterld() {
        return writerld;
    }

    public void setWriterld(String writerld) {
        this.writerld = writerld;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getHit() {
        return hit;
    }

    public void setHit(int hit) {
        this.hit = hit;
    }

    public String getFiles() {
        return files;
    }

    public void setFiles(String files) {
        this.files = files;
    }
}
