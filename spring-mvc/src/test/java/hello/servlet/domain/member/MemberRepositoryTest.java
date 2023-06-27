package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.TestExecutionListeners;

import java.nio.channels.FileChannel;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemberRepositoryTest {
    MemberRepository memberRepository = MemberRepository.getInstance(); // 싱글톤이기 때문에

    @AfterEach // 테스트가 끝나면
    void afterEach() {
        // 테스트가 끝날 때마다 store를 초기화해주기 위해
        memberRepository.clearStore();
    }

    @Test
    void save() {
        // given
        Memeber member = new Memeber("hello", 20);

        // when
        Memeber savedMember = memberRepository.save(member);

        // then
        Memeber findMember = memberRepository.findById(savedMember.getId());
        assertThat(findMember).isEqualTo(savedMember);
    }

    @Test
    void findAll() {
        // given
        Memeber member1 = new Memeber("member1", 20);
        Memeber member2 = new Memeber("member2", 30);

        memberRepository.save(member1);
        memberRepository.save(member2);

        // when
        List<Memeber> result = memberRepository.findAll();

        // then
        // Alt + Enter > static import 가능
        assertThat(result.size()).isEqualTo(2);
        assertThat(result).contains(member1, member2);
    }

    
}
