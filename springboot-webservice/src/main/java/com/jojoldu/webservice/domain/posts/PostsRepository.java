// 보통 ibatis/MyBatis 등에서 DAO라고 불리는 DB Layer 접근자. JPA에서는 Repository라고 부름.
// 인터페이스로 생성함
// 단순히 인터페이스를 생성한 후, JpaRepository<Entity 클래스, PK타입>를 상속하면 기본적인 CRUD 메소드가 자동 생성됨
    // 특별히 @Repository를 추가할 필요도 없음

package com.jojoldu.webservice.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long> {
}
