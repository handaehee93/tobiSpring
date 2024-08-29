package tobi.tobispring;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cglib.core.Local;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

 public class PaymentService {

     private final ExRateProvider exRateProvider;

    public PaymentService (ExRateProvider exRateProvider) {
        this.exRateProvider = exRateProvider;
    }

    // 주문 번호, 외국 통화 종류, 외국 통화 기준 결제 금액을 전달 받고 몇개의 정보를 추가해 리턴 하는 메서드
    public Payment prepare (Long orderId, String currency, BigDecimal foreignCurrencyAmount) throws IOException {
        BigDecimal exRate = exRateProvider.getExRate(currency);
        BigDecimal convertedAmount = foreignCurrencyAmount.multiply(exRate);
        LocalDateTime validUntil = LocalDateTime.now().plusMinutes(30);

        return new Payment(orderId,currency, foreignCurrencyAmount, exRate, convertedAmount, validUntil);
    }




}
