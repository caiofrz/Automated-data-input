package com.teste_selenium;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import java.io.File;
import java.util.Locale;

public class GenerateFakeData {

  //email
  //nome
  //sobrenome = nomes dupla
  //address
  //address
  //city
  //state
  //zipcode
  //country
  //telefone
  //Birthday


  public static void main(String[] args) {


    FakeValuesService fakeValuesService = new FakeValuesService(
            new Locale("pt-BR"), new RandomService());

    Faker faker = new Faker(new Locale("pt-BR"));

    File data = new File("data.txt");

    String nome;
    final String sobrenome = "Caio_Ikaro";
    String email;
    String address;
    String address2;
    String city;
    String state;
    String zipcode;
    String country;

    nome = String.valueOf(faker.name().firstName());
    System.out.println(nome);
    int i = 100;
//    while (i >= 0) {
//
//      email = fakeValuesService.bothify("????##@gmail.com");
//
//      i--;
//      System.out.println(email);
//    }


  }
}
