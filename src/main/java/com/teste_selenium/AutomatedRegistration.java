package com.teste_selenium;

import com.teste_selenium.model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AutomatedRegistration {
  private static final String URL = "https://selenium-ifnmg.mailchimpsites.com/contact";
  private static final String FILE_PATH = "test.txt";

  public static void main(String[] args) throws InterruptedException {

    WebDriver driver = new ChromeDriver();
    List<User> users = readDataFile(FILE_PATH);
    driver.get(URL);
    Thread.sleep(2000);

    // Cadastrar cada usuário
    for (User user : users) {
      WebElement inputEmail = driver.findElement(By.id("mce136i9_EMAIL"));
      inputEmail.sendKeys(user.getEmail());

      WebElement inputNome = driver.findElement(By.id("mce136i9_FNAME"));
      inputNome.sendKeys(user.getNome());

      WebElement inputSobrenome = driver.findElement(By.id("mce136i9_LNAME"));
      inputNome.sendKeys(User.getSobrenome());

      WebElement inputEndereco = driver.findElement(By.id("mce136i9_ADDRESS-addr1"));
      inputNome.sendKeys(user.getAddress());

      WebElement inputAddressLine2 = driver.findElement(By.id("mce136i9_ADDRESS-addr2"));
      inputNome.sendKeys(user.getAddress2());

      WebElement inputCity = driver.findElement(By.id("mce136i9_ADDRESS-city"));
      inputNome.sendKeys(user.getCity());

      WebElement inputState = driver.findElement(By.id("mce136i9_ADDRESS-state"));
      inputNome.sendKeys(user.getState());

      WebElement inputZipCode = driver.findElement(By.id("mce136i9_ADDRESS-zip"));
      inputNome.sendKeys(user.getZipcode());

      WebElement inputCountry = driver.findElement(By.id("mce136i9_ADDRESS-country"));
      inputNome.sendKeys(user.getCountry());

      WebElement inputTelefone = driver.findElement(By.id("mce136i9_PHONE"));
      inputNome.sendKeys(user.getTelefone());

      WebElement inputBirthday = driver.findElement(By.id("mce136i9_BIRTHDAY"));
      inputNome.sendKeys(user.getBirthday());


      WebElement buttonSubscribe = driver.findElement(By.cssSelector("input[type='submit']"));
      buttonSubscribe.click();
    }
  }

  private static List<User> readDataFile(String path) {
    List<User> users = new ArrayList<>();

    try {
      BufferedReader br = new BufferedReader(new FileReader(new File(path)));
      String line;
      while ((line = br.readLine()) != null) {
        String[] data = line.split(",");
        System.err.println(data);
        User user =
                new User(data[0], data[1], data[2], data[3], data[4],
                        data[5], data[6], data[7], data[8], data[9], data[10]);
        users.add(user);
      }
    } catch (IOException ex) {
      ex.printStackTrace();
    }
    return users;
  }

}