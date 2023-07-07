package com.aw.api.security.domain.persistence;

import com.aw.api.security.domain.model.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    List<Member> findAll();
    Optional<Member> findById(Long memberId);

    boolean existsById(Long memberId);

}
