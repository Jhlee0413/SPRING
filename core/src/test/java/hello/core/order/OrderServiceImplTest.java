package hello.core.order;

import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemoryMemberRepository;
import org.junit.jupiter.api.Test;

public class OrderServiceImplTest {

    @Test
    void createOrder(){

        MemoryMemberRepository mr = new MemoryMemberRepository();
        mr.save(new Member(1L, "ljh", Grade.VIP));

        OrderServiceImpl orderService = new OrderServiceImpl(mr, new FixDiscountPolicy());
        orderService.createOrder(1L, "a", 10000);
    }
}
