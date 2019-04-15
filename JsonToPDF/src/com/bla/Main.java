package com.bla;

public class Main {

  public static void main(String[] args) {
    JsonFromAPI json = new JsonFromAPI();
    System.out.println(json.jsonGetRequest("http://dummy.restapiexample.com/api/v1/employee/1"));
    PDFwriter pdFwriter = new PDFwriter();
    try {
      pdFwriter.createPDF();
    } catch (Exception e) {
      System.out.println("An error occured during PDF creation...");
    }
  }

}
