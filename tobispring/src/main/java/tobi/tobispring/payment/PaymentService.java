package tobi.tobispring.payment;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Component
 public class PaymentService {

    // 추상화에 의존 ( ExRateProvicer라는 interface에 의존 )
    // ExRateProvider에 의존하고 있기 때문에 추후에 ExRateProvider라는 인터페이스를 구현하는 구현체가 추가되거나 수정되어도
    // PaymentSercive의 코드는 수정할 필요가 없다.
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
