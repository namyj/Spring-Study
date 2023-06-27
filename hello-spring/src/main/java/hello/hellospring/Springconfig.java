package hello.hellospring;

import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.repository.*;
import hello.hellospring.service.MemberService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

// 직접 스프링 Bean 등록하기
// 스프링을 띄울 때 아래 나열된 내용을 스프링 bean에 등록함
@Configuration
public class Springconfig {

    private final MemberRepository memberRepository;

    @Autowired
    public Springconfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

    // @Bean
    // public MemberRepository memberRepository() {
        // return new MemoryMemberRepository();
        // return new JdbcMemberRepository(dataSource);
        // return new JdbcTemplageMemberRepository(dataSource);
        // return new JpaMemberRepository(em);
    //
    // }


}
