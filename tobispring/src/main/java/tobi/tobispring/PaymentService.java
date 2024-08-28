package tobi.tobispring;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PaymentService {

    // 주문 번호, 외국 통화 종류, 외국 통화 기준 결제 금액을 전달 받고 몇개의 정보를 추가해 리턴 하는 메서드
    public Payment prepare (Long orderId, String currency, BigDecimal foreignCurrencyAmount) {
        return new Payment(orderId,currency, foreignCurrencyAmount, BigDecimal.ZERO, BigDecimal.ZERO, LocalDateTime.now());
    }

    public static void main(String[] args) {

        PaymentService paymentService = new PaymentService();
        Payment payment = paymentService.prepare(100L, "USD", BigDecimal.valueOf(50.7) );
        System.out.println(payment);

    }



}
