package com.teste_selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
  public static void main(String[] args) {


    WebDriver driver = new ChromeDriver();
    final String url = "https://selenium-ifnmg.mailchimpsites.com/contact";

    driver.get(url);
  }
}