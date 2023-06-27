package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member,Long>, MemberRepository {

    // JPA 가 자동으로 쿼리를 짠다 > select m from member m where m.name = ?
    @Override
    Optional<Member> findByName(String name);
}
