package com.teste_selenium;

import com.github.javafaker.Faker;

import com.teste_selenium.model.User;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

public class GenerateFakeData {

    public static void main(String[] args) {

        Faker faker = new Faker(new Locale("en-US"));

        File data = new File("data.txt");

        try {
            FileWriter writer = new FileWriter(data);
            PrintWriter printWriter = new PrintWriter(writer);
            final String birthday = "12/08";
            final String country = "USA";

            for (int i = 0; i < 100; i++) {
                String nome = faker.name().firstName();
                String email = "caio_ikaro" + i + 1 + "@gmail.com";
                String address = faker.address().streetAddress();
                String address2 = faker.address().secondaryAddress();
                String city = faker.address().city();
                String state = faker.address().state();
                String zipcode = faker.address().zipCode();
                String telefone = faker.phoneNumber().cellPhone();

                User user = new User(nome, email, address, address2, city, state, zipcode, country, telefone, birthday);
                printWriter.println(user.toString());
            }

            printWriter.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Dados gerados e salvos em data.txt");
    }
}
