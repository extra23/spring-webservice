// Lombok (장점) : 서비스 구축단계에서 테이블 설계(or Entity 설계)가 빈번하게 변경되는데,
    // Lombok의 어노테이션들은 코드 변경량을 최소화시켜주기 때문에 아주 강력 추천하는 라이브러리

package com.jojoldu.webservice.domain.posts;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
    // 기본 생성자 자동 추가
    // access = AccessLevel.PROTECTED : 기본생성자의 접근 권한을 protected로 제한
    // (따라서) protected Posts() {}와 같은 효과
    // Entity 클래스를 프로젝트 코드 상에서 기본 생성자로 생성하는 것은 막되, JPA에서 Entity 클래스를 생성하는 것은 허용하기 위해 추가
@Getter
    // 클래스 내 모든 필드의 Getter 메소드를 자동생성
@Entity
    // DB의 테이브로가 링크될 클래스임을 나타냄
    // 언더스코어 네이밍(_)으로 이름을 매칭함
public class Posts {

    @Id     // 해당 테이블의 PK 필드를 나타냄
    @GeneratedValue
        // PK의 생성 규칙을 나타냄
        // 기본값은 AUTO로, MySQL의 auto_increment와 같이 자동증가하는 정수형 값
        // spring boot 2.0에선 옵션을 추가해야만 auto_increment가 됨
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable=false)
    private String content;

    private String author;

    @Builder
        // 해당 클래스의 빌더 패턴 클래스를 생성
        // 생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

}
