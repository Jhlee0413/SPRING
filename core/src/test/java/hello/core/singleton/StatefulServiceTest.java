package hello.core.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService st1 = ac.getBean(StatefulService.class);
        StatefulService st2 = ac.getBean(StatefulService.class);

        //ThreadA : A user order 10000
        int userAPrice = st1.order("userA", 10000);

        //ThreadB : B user order 20000
        int userBPrice = st2.order("userB", 20000);

        //Thread A: A user Check order
        //int price = st1.getPrice();
        System.out.println(userAPrice);
        System.out.println(userBPrice);

    }

    static class TestConfig {
        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }
}