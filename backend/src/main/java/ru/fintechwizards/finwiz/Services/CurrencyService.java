package ru.fintechwizards.finwiz.Services;


import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import org.springframework.stereotype.Service;

@Service
public class CurrencyService {
  private static final String apiUrl = "https://www.cbr.ru/scripts/XML_daily.asp";

  public CurrencyService()  {
  }

  public static float getExchangeRate(String currency) throws IOException {
    URL url = new URL(apiUrl);
    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    connection.setRequestMethod("GET");
    connection.setRequestProperty("accept", "application/json");
    InputStream responseStream = connection.getInputStream();

    String json = new String(responseStream.readAllBytes(), StandardCharsets.UTF_8);
    String[] json_arr = json.split("name=\"Foreign Currency Market\">")[1].split("</Valute>");


    for (int i = 0; i < json_arr.length - 1; i++) {
      String str = json_arr[i];
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

    return 0f;
  }
}
