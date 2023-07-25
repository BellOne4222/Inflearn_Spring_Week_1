package hello.hellospring.repository;


import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id); // Optional : null을 반환할 수도 있기 때문에 null 처리를 해서 감싸서 반환
    Optional<Member> findByName(String name);
    List<Member> findAll();

}
