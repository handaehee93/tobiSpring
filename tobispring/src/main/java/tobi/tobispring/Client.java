package tobi.tobispring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import tobi.tobispring.payment.Payment;
import tobi.tobispring.payment.PaymentService;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;


public class Client {
    public static void main(String[] args) throws IOException, InterruptedException {
        BeanFactory beanFactory = new AnnotationConfigApplicationContext(ObjectFactory.class);
        PaymentService paymentService = beanFactory.getBean(PaymentService.class);
        PaymentService paymentService2 = beanFactory.getBean(PaymentService.class);

        System.out.println(paymentService);
        System.out.println(paymentService2);
        System.out.println(paymentService == paymentService2);

        Payment payment = paymentService.prepare(100L, "USD", BigDecimal.valueOf(50.7) );
        System.out.println("Payment 첫번쩨 호출 = " + payment );
        TimeUnit.SECONDS.sleep(1);
        Payment payment2 = paymentService.prepare(100L, "USD", BigDecimal.valueOf(50.7) );
        System.out.println("Payment 두번째 호출 = " + payment2);
        TimeUnit.SECONDS.sleep(2);
        Payment payment3 = paymentService.prepare(100L, "USD", BigDecimal.valueOf(50.7) );
        System.out.println("Payment 세 번째 호출 = " + payment3);

    }
}
