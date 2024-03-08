package com.teste_selenium;

import com.teste_selenium.model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AutomatedRegistration {
  private static final String URL = "https://selenium-ifnmg.mailchimpsites.com/contact";
  private static final String FILE_PATH = "data.txt";

  public static void main(String[] args) throws InterruptedException {

    WebDriver driver = new ChromeDriver();
    List<User> users = readDataFile(FILE_PATH);
    driver.get(URL);
    Thread.sleep(5000);

    // Cadastrar cada usuário
    for (User user : users) {
      try {

        WebElement inputEmail = driver.findElement(By.id("mce136i9_EMAIL"));
        inputEmail.sendKeys(user.getEmail());

        WebElement inputNome = driver.findElement(By.id("mce136i9_FNAME"));
        inputNome.sendKeys(user.getNome());

        WebElement inputSobrenome = driver.findElement(By.id("mce136i9_LNAME"));
        inputSobrenome.sendKeys(User.getSobrenome());

        WebElement inputEndereco = driver.findElement(By.id("mce136i9_ADDRESS-addr1"));
        inputEndereco.sendKeys(user.getAddress());

        WebElement inputAddressLine2 = driver.findElement(By.id("mce136i9_ADDRESS-addr2"));
        inputAddressLine2.sendKeys(user.getAddress2());

        WebElement inputCity = driver.findElement(By.id("mce136i9_ADDRESS-city"));
        inputCity.sendKeys(user.getCity());

        WebElement inputState = driver.findElement(By.id("mce136i9_ADDRESS-state"));
        inputState.sendKeys(user.getState());

        WebElement inputZipCode = driver.findElement(By.id("mce136i9_ADDRESS-zip"));
        inputZipCode.sendKeys(user.getZipcode());

        WebElement inputCountry = driver.findElement(By.id("mce136i9_ADDRESS-country"));
        Select optionCountry = new Select(inputCountry);
        optionCountry.selectByVisibleText("Brazil");

        WebElement inputTelefone = driver.findElement(By.id("mce136i9_PHONE"));
        inputTelefone.sendKeys(user.getTelefone());

        WebElement inputBirthday = driver.findElement(By.id("mce136i9_BIRTHDAY"));
        inputBirthday.sendKeys(user.getBirthday());

        WebElement buttonSubscribe = driver.findElement(By.cssSelector("[type='submit']"));
        buttonSubscribe.click();

        driver.navigate().refresh();
        Thread.sleep(5000);

      } catch (Exception ex) {
        ex.printStackTrace();
        break;
      }
    }

    driver.quit();
  }

  private static List<User> readDataFile(String path) {
    List<User> users = new ArrayList<>();

    try {
      BufferedReader br = new BufferedReader(new FileReader(new File(path)));
      String line;
      while ((line = br.readLine()) != null) {
        String[] data = line.split(",");
        System.err.println(data);
        User user = new User(data[0], data[1], data[2], data[3], data[4],
            data[5], data[6], data[7], data[8], data[9]);
        users.add(user);
      }
    } catch (IOException ex) {
      ex.printStackTrace();
    }
    return users;
  }

}