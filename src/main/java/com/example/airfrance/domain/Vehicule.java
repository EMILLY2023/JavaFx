package com.example.airfrance.domain;

public class Vehicule {

    private String name;
    private String licence;



    public Vehicule(String name, String licence) {
       this.name=name;
       this.licence=licence;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLicence() {
        return licence;
    }

    public void setLicence(String licence) {
        this.licence = licence;
    }

    @Override
    public String toString() {

        return name + " - "+ licence;
    }
}
