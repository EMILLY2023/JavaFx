package com.example.airfrance.domain;

public class Booking {

    private String firstname;
    private String lastname;
    private String startAt;
    private String endAt;
    private String email;
    private String phone;
   private Vehicule vehicule;

    public Booking(String firstname, String lastname, String startAt, String endAt, String email, String phone,Vehicule vehicule) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.startAt = startAt;
        this.endAt = endAt;
        this.email = email;
        this.phone = phone;
        this.vehicule=vehicule;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getStartAt() {
        return startAt;
    }

    public void setStartAt(String startAt) {
        this.startAt = startAt;
    }

    public String getEndAt() {
        return endAt;
    }

    public void setEndAt(String endAt) {
        this.endAt = endAt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Vehicule getVehicule() {
        return vehicule;
    }

    public void setVehicule(Vehicule vehicule) {
        this.vehicule = vehicule;
    }

    @Override
    public String toString() {
        return  email+", "+ vehicule+" de " + startAt +" à "+endAt;

    }
}
