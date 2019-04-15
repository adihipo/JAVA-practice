package com.bla;

public class Main {

  public static void main(String[] args) {
    JsonFromAPI json = new JsonFromAPI();
    String[] paragraphs = json.jsonGetRequest("https://baconipsum.com/api/?type=meat-and-filler");
 
    PDFwriter pdFwriter = new PDFwriter();
    try {
      pdFwriter.createPDF();
    } catch (Exception e) {
      System.out.println("An error occured during PDF creation...");
    }
  }

}
