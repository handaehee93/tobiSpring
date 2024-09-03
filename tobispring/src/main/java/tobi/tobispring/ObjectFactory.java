package tobi.tobispring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import tobi.tobispring.exrate.CachedExRateProvider;
import tobi.tobispring.payment.ExRateProvider;
import tobi.tobispring.exrate.WebApiExRateProvider;
import tobi.tobispring.payment.PaymentService;

@Configuration
@ComponentScan
public class ObjectFactory {

    @Bean
    public PaymentService paymentService () {
        return new PaymentService(cachedExRateProvider());
    }

    @Bean
    public ExRateProvider cachedExRateProvider() {
        return new CachedExRateProvider(exRateProvider());
    }

    @Bean
    public ExRateProvider exRateProvider() {
        return new WebApiExRateProvider();
    }
}
