package com.bla;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class JsonFromAPI {

  private String streamToString(InputStream inputStream) {
    String text = new Scanner(inputStream, "UTF-8").useDelimiter("\\Z").next();
    return text;
  }

  public String[] jsonGetRequest(String urlQueryString) throws IOException {
    String json = null;
    URL url = new URL(urlQueryString);
    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    connection.setDoOutput(true);
    connection.setInstanceFollowRedirects(false);
    connection.setRequestMethod("GET");
    connection.setRequestProperty("Content-Type", "application/json");
    connection.setRequestProperty("charset", "utf-8");
    connection.connect();
    InputStream inStream = connection.getInputStream();
    json = streamToString(inStream);
    return jsonToListOfStrings(json);
  }

  public String[] jsonToListOfStrings(String json) {
    json = json.substring(2, json.length() - 2);
    return json.split("\\W{1},\\W{1}");
  }

}
