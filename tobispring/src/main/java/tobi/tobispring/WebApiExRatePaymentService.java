package tobi.tobispring;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.stream.Collectors;

public class WebApiExRatePaymentService extends PaymentService{

    @Override
    BigDecimal getKRWexRate(String currency) throws IOException {

        URL url = new URL("https://open.er-api.com/v6/latest/" + currency);
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        String response = bufferedReader.lines().collect(Collectors.joining());
        bufferedReader.close();

        ObjectMapper mapper = new ObjectMapper();
        ExrateData exrateData = mapper.readValue(response, ExrateData.class);
        BigDecimal exRate = exrateData.rates().get("KRW");

        return exRate;
    }
}
