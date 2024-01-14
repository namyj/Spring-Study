package com.example.basic;

import com.example.basic.member.Grade;
import com.example.basic.member.Member;
import com.example.basic.member.MemberService;
import com.example.basic.member.MemberServiceImpl;
import com.example.basic.order.Order;
import com.example.basic.order.OrderService;
import com.example.basic.order.OrderServiceImpl;

public class OrderServiceApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(member.getId(), "Samsung Galaxy Book", 1000000);

        System.out.println(order);
        System.out.println(order.calculatePrice());

    }
}
