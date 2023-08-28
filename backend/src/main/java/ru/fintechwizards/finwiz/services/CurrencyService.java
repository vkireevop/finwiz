package ru.fintechwizards.finwiz.services;


import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import org.springframework.stereotype.Service;
import ru.fintechwizards.finwiz.exceptions.NotFoundException;

@Service
public class CurrencyService {

  private CurrencyService() {
  }

  private static final String API_URL = "https://www.cbr.ru/scripts/XML_daily.asp";


  public static float getExchangeRate(String currency) throws IOException {
    URL url = new URL(API_URL);
    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    connection.setRequestMethod("GET");
    connection.setRequestProperty("accept", "application/json");
    InputStream responseStream = connection.getInputStream();

    String json = new String(responseStream.readAllBytes(), StandardCharsets.UTF_8);
    String[] jsonArr = json.split("name=\"Foreign Currency Market\">")[1].split("</Valute>");

    for (int i = 0; i < jsonArr.length - 1; i++) {
      String str = jsonArr[i];
      // Get CharCode
      String charCode = str.split("</CharCode>")[0].split("<CharCode>")[1];
      // Get Nominal
      String nominal = str.split("</Nominal>")[0].split("<Nominal>")[1];

      String kurs = str.split("</Value>")[0].split("<Value>")[1];
      kurs = kurs.replace(',', '.');
      float rate = Float.parseFloat(kurs) / Integer.parseInt(nominal);
      if (Objects.equals(currency, charCode)) {
        return rate;
      }
    }

    throw new NotFoundException("Currency not found");
  }

  public static Map<String, Float> getAllRates() throws IOException {
    Map<String, Float> result = new TreeMap<>();
    URL url = new URL(API_URL);
    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    connection.setRequestMethod("GET");
    connection.setRequestProperty("accept", "application/json");
    InputStream responseStream = connection.getInputStream();

    String json = new String(responseStream.readAllBytes(), StandardCharsets.UTF_8);
    String[] jsonArr = json.split("name=\"Foreign Currency Market\">")[1].split("</Valute>");

    for (int i = 0; i < jsonArr.length - 1; i++) {
      String str = jsonArr[i];
      // Get CharCode
      String charCode = str.split("</CharCode>")[0].split("<CharCode>")[1];
      // Get Nominal
      String nominal = str.split("</Nominal>")[0].split("<Nominal>")[1];

      String kurs = str.split("</Value>")[0].split("<Value>")[1];
      kurs = kurs.replace(',', '.');
      float rate = Float.parseFloat(kurs) / Integer.parseInt(nominal);

      result.put(charCode, rate);

    }
    return result;
  }
}
