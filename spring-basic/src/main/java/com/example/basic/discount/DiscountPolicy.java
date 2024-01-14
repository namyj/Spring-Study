package com.example.basic.discount;

import com.example.basic.member.Member;

public interface DiscountPolicy {

    /**
     * @param member
     * @param price
     * @return 할인 대상 금액
     */
    int discountPrice(Member member, int price);
    
}
