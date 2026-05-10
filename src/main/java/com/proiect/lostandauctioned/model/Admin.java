package com.proiect.lostandauctioned.model;

public class Admin {
    private String id;
    private String nume;
    private String email;
    private String parola;

    public Admin(String id, String nume, String email, String parola) {
        this.id = id;
        this.nume = nume;
        this.email = email;
        this.parola = parola;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }
}
