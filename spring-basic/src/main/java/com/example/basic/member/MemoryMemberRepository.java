package com.example.basic.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository {

    // 동시성 이슈 -> ConcurrenctHashMap 사용
    private static Map<Long, Member> storage = new HashMap<>();

    @Override
    public void save(Member member) {
        storage.put(member.getId(), member);
    }

    @Override
    public Member findById(Long id) {
        return storage.get(id);
    }
}
