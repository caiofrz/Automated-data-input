package com.teste_selenium.model;

public class User {

    public User(String nome, String email, String address, String address2, String city, String state, String zipcode,
            String country, String telefone, String birthday) {
        this.nome = nome;
        this.email = email;
        this.address = address;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.country = country;
        this.telefone = telefone;
        this.birthday = birthday;
    }

    static final String sobrenome = "Caio Ikaro";
    String nome;
    String email;
    String address;
    String address2;
    String city;
    String state;
    String zipcode;
    String country;
    String telefone;
    String birthday;

    public static String getSobrenome() {
        return sobrenome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return nome + "," + email + "," + address + "," + address2 + ","
                + city + "," + state + "," + zipcode + "," + country + "," + telefone
                + "," + birthday;
    }

}
