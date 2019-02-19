// Entity 클래스와 거의 유사한 형태임에도 DTO 클래스를 추가로 생성함
    // 절대로 테이블과 매핑되는 Entity 클래스를 Request/Response 클래스로 사용해서는 안됨
    // Entity 클래스는 가장 Core한 클래스
        // 수많은 서비스 클래스나 비지니스 로직들이 Entity 클래스를 기준으로 동작함
        // Entity 클래스가 변경되면 여러 클래스에 영향을 끼치게 되는 반면 Request와 Response용 DTO는 View를 위한 클래스라 정말 자주 변경이 필요함
    // View Layer와 DB Layer를 철저하게 역할 분리를 하는 것이 좋음
    // 실제로 Controller에서 결과값으로 여러 테이블을 조인해서 줘야하는 경우가 빈번하기 때문에 Entity 클래스만으로는 표현하기가 어려운 경우가 많음

package com.jojoldu.webservice.dto.posts;

import com.jojoldu.webservice.domain.posts.Posts;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
    // Setter를 허용하는 이유 : Controller에서 @RequestBody로 외부에서 데이터를 받는 경우에는 기본생성자 + set 메소드를 통해서만 값이 할당됨
@NoArgsConstructor
public class PostsSaveRequestDto {

    private String title;
    private String content;
    private String author;

    public Posts toEntity(){
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }

}
