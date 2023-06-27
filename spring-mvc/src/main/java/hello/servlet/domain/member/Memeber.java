package hello.servlet.domain.member;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Memeber {

    private Long id;
    private String username;
    private int age;

    public Memeber() {
    }

    public Memeber(String username, int age) {
        this.username = username;
        this.age = age;
    }
}
