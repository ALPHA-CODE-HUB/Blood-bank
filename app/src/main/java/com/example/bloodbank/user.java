package com.example.bloodbank;

public class user {
    String uid;
    public String e_mail;
    public String phonenumber;
    public String gender1;
    public String name;
    public String bloodtype;
    public String btu;

    public user() {
    }

    public user(String uid, String e_mail, String phonenumber, String gender1, String name, String bloodtype, String btu) {
        this.uid = uid;
        this.e_mail = e_mail;
        this.phonenumber = phonenumber;
        this.gender1 = gender1;
        this.name = name;
        this.bloodtype = bloodtype;
        this.btu = btu;
    }

    public String getBtu() {
        return btu;
    }

    public void setBtu(String btu) {
        this.btu = btu;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getGender1() {
        return gender1;
    }

    public void setGender1(String gender1) {
        this.gender1 = gender1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBloodtype() {
        return bloodtype;
    }

    public void setBloodtype(String bloodtype) {
        this.bloodtype = bloodtype;
    }
}