package com.example.appphone;

public class HelperClass {
    public HelperClass() {
    }

    String username ,email,password;
    String name,phone,specialty;
    int numpat;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public int getNumpat() {
        return numpat;
    }

    public void setNumpat(int numpat) {
        this.numpat = numpat;
    }




    public HelperClass(String username, String name, String specialty, String phone,int numpat, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.specialty = specialty;
        this.numpat = numpat;
    }



}
