package com.example.basic.member;

public interface MemberRepository {

    void save(Member member);
    Member findByIs(Long id);
}
