package com.aw.api.security.service;

import com.aw.api.security.domain.model.entity.Member;
import com.aw.api.security.domain.persistence.MemberRepository;
import com.aw.api.security.domain.service.MemberService;
import com.aw.api.shared.exception.ResourceNotFoundException;
import com.aw.api.shared.exception.ResourceValidationException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
@Service
public class MemberServiceImpl implements MemberService {
    private static final String entity = "Member";
    private final MemberRepository memberRepository;
    private final Validator validator;

    public MemberServiceImpl(MemberRepository memberRepository,Validator validator){
        this.memberRepository = memberRepository;
        this.validator = validator;
    }

    @Override
    public List<Member> getAll(){
        return memberRepository.findAll();
    }

    @Override
    public Member getById(Long memberId) {
        return memberRepository.findById(memberId).orElseThrow(() -> new ResourceNotFoundException(entity, memberId));
    }

    @Override
    public Member create(Member member) {
        Set<ConstraintViolation<Member>> violations = validator.validate(member);
        if(!violations.isEmpty())
            throw new ResourceValidationException(entity, violations);
        return memberRepository.save(member);
    }

    public Member update(Long memberId, Member updatedmember) {
        Set<ConstraintViolation<Member>> violations = validator.validate(updatedmember);
        if(!violations.isEmpty())
            throw new ResourceValidationException(entity, violations);
        if(!memberRepository.existsById(memberId))
            throw new ResourceValidationException("member does not exist.");

        Member existingmember = memberRepository.findById(memberId).get();



        return memberRepository.save(existingmember
                .withName(updatedmember.getName())
                .withMember_code(updatedmember.getMember_code())
        );
    }

    @Override
    public ResponseEntity<?> delete(Long memberId) {
        return memberRepository.findById(memberId).map(member -> {
            memberRepository.delete(member);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(entity, memberId));
    }
}
