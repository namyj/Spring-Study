package com.example.basic;

import com.example.basic.member.Grade;
import com.example.basic.member.Member;
import com.example.basic.member.MemberService;
import com.example.basic.member.MemberServiceImpl;

public class MeberServiceApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member newMember = new Member(1L, "A", Grade.VIP);
        memberService.join(newMember);

        Member findMember = memberService.findMember(1L);
        System.out.println("newMember = " + newMember.getName());
        System.out.println("findMember = " + findMember.getName());
    }
}
