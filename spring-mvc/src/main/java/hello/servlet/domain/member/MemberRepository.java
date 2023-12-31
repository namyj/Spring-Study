package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 동시성 문제가 고려되어 있지 않음, 실무에서는 ConcurrentHashMap, AtomicLong 사용 고려
 */
public class MemberRepository {

    // static : MemberRepository가 new로 여러번 생성되도, 아래 필드들은 하나만 생성됨
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;
    
    // 싱글톤
    // > private으로 생성자를 아무나 호출할 수 없게 막아줘야 함
    private static final MemberRepository instance = new MemberRepository(); 

    public static MemberRepository getInstance() {
        return instance;
    }

    private MemberRepository() {
    }

    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id) {
        return store.get(id);
    }

    public List<Member> findAll() {
        // new ArrayList()<> 로 전달하는 이유?
        // ArrayList를 조작해도 store에 영향이 없도록
        return new ArrayList<>(store.values()); 
    }

    public void clearStore() {
        store.clear();
    }
}
