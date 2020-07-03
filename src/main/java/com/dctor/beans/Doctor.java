package com.dctor.beans;

public class Doctor {
    private int doctor_id;
    private int doctor_age;
    private String doctor_name;
    private String doctor_phone;
    private String doctor_address;
    private String doctor_password;

    public int getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(int doctor_id) {
        this.doctor_id = doctor_id;
    }

    public int getDoctor_age() {
        return doctor_age;
    }

    public void setDoctor_age(int doctor_age) {
        this.doctor_age = doctor_age;
    }

    public String getDoctor_name() { return doctor_name; }

    public void setDoctor_name(String doctor_name) {
        this.doctor_name = doctor_name;
    }

    public String getDoctor_phone() { return doctor_phone; }

    public void setDoctor_phone(String doctor_phone) { this.doctor_phone = doctor_phone; }

    public String getDoctor_address() { return doctor_address; }

    public void setDoctor_address(String doctor_address) {
        this.doctor_address = doctor_address;
    }

    public String getDoctor_password() { return doctor_password; }

    public void setDoctor_password(String doctor_password) {
        this.doctor_password = doctor_password;
    }
}
