package com.example.basic.order;

import com.example.basic.discount.DiscountPolicy;
import com.example.basic.discount.FixDiscountPolicy;
import com.example.basic.member.Member;
import com.example.basic.member.MemberRepository;
import com.example.basic.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        // TODO
        // 1. 회원 등급 체크
        // 2. discount policy 체크
        // 3. 주문 생성

        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discountPrice(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
