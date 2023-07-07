package com.aw.api.security.domain.service;

import com.aw.api.security.domain.model.entity.Member;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MemberService {
    List<Member> getAll();

    Member getById(Long id);

    Member create(Member saveMember);

    ResponseEntity<?> delete(Long id);

    Member update(Long id,Member updatedMember);
}
