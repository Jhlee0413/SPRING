package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class ConfigSingletonTest {

    @Test
    void configTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl ms = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl os = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository mr = ac.getBean("memberRepository", MemberRepository.class);

        MemberRepository mr1 = ms.getMemberRepository();
        MemberRepository mr2 = os.getMemberRepository();

        System.out.println("memberService -> memberRepository = " + mr1);
        System.out.println("orderService -> memberRepository = " + mr2);
        System.out.println("memberRepository = " + mr);

        assertThat(ms.getMemberRepository()).isSameAs(mr);
        assertThat(os.getMemberRepository()).isSameAs(mr);

    }

    @Test
    void configDeep() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig bean = ac.getBean(AppConfig.class);

        System.out.println("bean = " + bean.getClass());
    }

}
