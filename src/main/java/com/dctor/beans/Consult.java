package com.dctor.beans;

public class Consult {
    private Integer ask_id;
    private String ask_test;
    private String ask_state;
    private String ask_doctor;
    private String ask_oldman;
    private String ask_answer;
    private String ask_question;
    private String ask_datetime;


    public Integer getAsk_id() {
        return ask_id;
    }

    public void setAsk_id(Integer ask_id) {
        this.ask_id = ask_id;
    }

    public String getAsk_test() {
        return ask_test;
    }

    public void setAsk_test(String ask_test) {
        this.ask_test = ask_test;
    }

    public String getAsk_state() {
        return ask_state;
    }

    public void setAsk_state(String ask_state) {
        this.ask_state = ask_state;
    }

    public String getAsk_doctor() {
        return ask_doctor;
    }

    public void setAsk_doctor(String ask_doctor) {
        this.ask_doctor = ask_doctor;
    }

    public String getAsk_oldman() {
        return ask_oldman;
    }

    public void setAsk_oldman(String ask_oldman) {
        this.ask_oldman = ask_oldman;
    }

    public String getAsk_answer() {
        return ask_answer;
    }

    public void setAsk_answer(String ask_answer) {
        this.ask_answer = ask_answer;
    }

    public String getAsk_question() {
        return ask_question;
    }

    public void setAsk_question(String ask_question) {
        this.ask_question = ask_question;
    }

    public String getAsk_datetime() {
        return ask_datetime;
    }

    public void setAsk_datetime(String ask_datetime) {
        this.ask_datetime = ask_datetime;
    }

    @Override
    public String toString() {
        return "Consult{" +
                "ask_id=" + ask_id +
                ", ask_test='" + ask_test + '\'' +
                ", ask_state='" + ask_state + '\'' +
                ", ask_doctor='" + ask_doctor + '\'' +
                ", ask_oldman='" + ask_oldman + '\'' +
                ", ask_answer='" + ask_answer + '\'' +
                ", ask_question='" + ask_question + '\'' +
                ", ask_datetime='" + ask_datetime + '\'' +
                '}';
    }
}
