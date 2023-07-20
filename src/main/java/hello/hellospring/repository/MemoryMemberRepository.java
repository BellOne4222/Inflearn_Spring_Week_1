package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;


public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;
    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); // id를 꺼낼때 null이 있을수도 있으므로 Optional로 null 처리
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name)) // equals : 파라미터로 넘어온 name이 같은지 확인
                .findAny(); // 하나라도 찾는것 loop돌면서 찾으면 반환

    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values()); // values: Map<Long, Member> 반환
    }
    
    // test 후 clear 해주는 코드
    public void clearStore() {
        store.clear();
    }
}
