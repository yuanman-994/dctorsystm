package com.dctor.beans;


public class estimate {
    private int estimate_id;
    private int estimate_doctor;
    private int estimate_oldman;
    private String estimate_healthy;
    private String estimate_content;
    private String estimate_suggest;
    private String estimate_datetime;


    public int getEstimate_id() { return estimate_id; }

    public void setEstimate_id(int estimate_id) { this.estimate_id = estimate_id; }

    public int getEstimate_doctor() { return estimate_doctor; }

    public void setEstimate_doctor(int estimate_doctor) { this.estimate_doctor = estimate_doctor; }

    public int getEstimate_oldman() { return estimate_oldman; }

    public void setEstimate_oldman(int estimate_oldman) { this.estimate_oldman = estimate_oldman; }

    public String getEstimate_healthy() { return estimate_healthy; }

    public void setEstimate_healthy(String estimate_healthy) { this.estimate_healthy = estimate_healthy; }

    public String getEstimate_content() { return estimate_content; }

    public void setEstimate_content(String estimate_content) { this.estimate_content = estimate_content; }

    public String getEstimate_suggest() { return estimate_suggest; }

    public void setEstimate_suggest(String estimate_suggest) { this.estimate_suggest = estimate_suggest; }

    public String getEstimate_datetime() { return estimate_datetime; }

    public void setEstimate_datetime(String estimate_datetime) { this.estimate_datetime = estimate_datetime; }

    @Override
    public String toString() {
        return "Estimate{" +
                "estimate_id=" + estimate_id +
                ", estimate_doctor='" + estimate_doctor + '\'' +
                ", estimate_oldman='" + estimate_oldman + '\'' +
                ", estimate_healthy='" + estimate_healthy + '\'' +
                ", estimate_content='" + estimate_content + '\'' +
                ", estimate_suggest='" + estimate_suggest + '\'' +
                ", estimate_datetime='" + estimate_datetime + '\'' +
                '}';
    }
}
