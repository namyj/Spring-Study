package hello.servlet.basic;

import lombok.Getter;
import lombok.Setter;

// lombok의 어노테이션으로 Getter, Setter 자동 생성
@Getter
@Setter
public class HelloData {

    private String username;
    private Integer age;

}
