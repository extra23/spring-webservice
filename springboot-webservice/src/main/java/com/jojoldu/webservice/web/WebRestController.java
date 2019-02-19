package com.jojoldu.webservice.web;

import com.jojoldu.webservice.domain.posts.PostsRepository;
import com.jojoldu.webservice.dto.posts.PostsSaveRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
    // 스프링 프레임워크에서 Bean을 주입받는 방식들 : @Autowired, Setter, 생성자
        // 가장 권장하는 방식 : 생성자로 주입받는 방식 (@Autowired : 비권장 방식)
    // @AllArgsConstructor : 모든 필드를 인자값으로 하는 생성자를 생성해줌 (Lombok의 annotation)
        // 사용 이유 : 해당 클래스의 의존성 관계가 변경될때마다 생성자 코드를 계속해서 수정하는 번거로움을 해결하기 위함
public class WebRestController {

    private PostsRepository postsRepository;

    @GetMapping("/hello")
    public String hello(){
        return "Hello World!";
    }

    @PostMapping("/posts")
    public void savePosts(@RequestBody PostsSaveRequestDto dto){
        postsRepository.save(dto.toEntity());
    }

}
