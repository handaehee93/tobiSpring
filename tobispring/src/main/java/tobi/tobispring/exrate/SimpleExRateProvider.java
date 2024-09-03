package tobi.tobispring.exrate;

import org.springframework.stereotype.Component;
import tobi.tobispring.payment.ExRateProvider;

import java.io.IOException;
import java.math.BigDecimal;

@Component
public class SimpleExRateProvider implements ExRateProvider {

    @Override
    public BigDecimal getExRate(String currency) throws IOException {
        if (currency.equals("USD")) return BigDecimal.valueOf(1100);

        throw new IllegalArgumentException("지원되지 않는 통화 입니다.");
    }
}
