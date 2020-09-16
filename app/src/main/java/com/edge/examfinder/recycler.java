package com.edge.examfinder;

public class recycler {
    private String stream;
    private String eligibility;
    private String selection;
    private String area;
    private String job;
    private String package1;
    private String duration;
    private String examination;
    private String url;
    private String note;

    public recycler(){


    }

    public recycler(String stream, String eligibility, String selection, String area, String job, String package1, String duration, String examination, String url, String note) {
        this.stream = stream;
        this.eligibility = eligibility;
        this.selection = selection;
        this.area = area;
        this.job = job;
        this.package1 = package1;
        this.duration = duration;
        this.examination = examination;
        this.url = url;
        this.note = note;
    }

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public String getEligibility() {
        return eligibility;
    }

    public void setEligibility(String eligibility) {
        this.eligibility = eligibility;
    }

    public String getSelection() {
        return selection;
    }

    public void setSelection(String selection) {
        this.selection = selection;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getPackage1() {
        return package1;
    }

    public void setPackage1(String package1) {
        this.package1 = package1;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getExamination() {
        return examination;
    }

    public void setExamination(String examination) {
        this.examination = examination;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
