package com.example.basic.order;

import com.example.basic.member.Grade;
import com.example.basic.member.Member;
import com.example.basic.member.MemberService;
import com.example.basic.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder() {

        Member member = new Member(1L, "basic member", Grade.BASIC);
        memberService.join(member);
        Order order = orderService.createOrder(member.getId(), "Ipad", 700000);

        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(0);

        member = new Member(2L, "vip member", Grade.VIP);
        memberService.join(member);

        Order order2 = orderService.createOrder(member.getId(), "Ipad", 700000);

        Assertions.assertThat(order2.getDiscountPrice()).isEqualTo(1000);

    }
}
