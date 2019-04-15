package com.bla;

import java.io.IOException;

public class Main {

  public static void main(String[] args) {
    JsonFromAPI json = new JsonFromAPI();
    try {
      String[] paragraphs = json.jsonGetRequest("https://baconipsum.com/api/?type=meat-and-filler");
      PDFwriter pdFwriter = new PDFwriter();
      try {
        pdFwriter.createPDF(paragraphs);
      } catch (Exception e) {
        System.out.println("An error occured during PDF creation...");
      }
    } catch (IOException e) {
      System.out.println("An error occured when tried to get JSON from API...");
    }
  }

}
