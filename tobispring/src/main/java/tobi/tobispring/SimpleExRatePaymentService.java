package tobi.tobispring;

import java.io.IOException;
import java.math.BigDecimal;

public class SimpleExRatePaymentService extends PaymentService{
    @Override
    BigDecimal getKRWexRate(String currency) throws IOException {
        if (currency.equals("USD")) return BigDecimal.valueOf(1100);

        throw new IllegalArgumentException("지원되지 않는 통화 입니다.");
    }
}
