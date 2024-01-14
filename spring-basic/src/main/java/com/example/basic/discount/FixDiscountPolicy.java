package com.example.basic.discount;

import com.example.basic.member.Grade;
import com.example.basic.member.Member;

public class FixDiscountPolicy implements DiscountPolicy{

    private final int fixAmount = 1000;
    @Override
    public int discountPrice(Member member, int price) {
        // enum의 경우 == 으로 비교
        if (member.getGrade() == Grade.VIP) {
            return fixAmount;
        } else {
            return 0;
        }
    }
}
