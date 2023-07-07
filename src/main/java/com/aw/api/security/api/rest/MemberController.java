package com.aw.api.security.api.rest;

import com.aw.api.api.resource.create.CreateMemberResource;
import com.aw.api.api.resource.show.MemberResource;
import com.aw.api.api.resource.update.UpdateMemberResource;
import com.aw.api.security.domain.service.MemberService;
import com.aw.api.security.mapping.mappers.MemberMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/members",produces = "application/json")
public class MemberController {
    private final MemberService memberService;
    private final MemberMapper memberMapper;

    public MemberController(MemberService memberService,MemberMapper memberMapper){
        this.memberService = memberService;
        this.memberMapper = memberMapper;
    }

    @GetMapping("all")
    public List<MemberResource> getAllUser(){
        return memberMapper.toListResource(memberService.getAll());
    }

    @GetMapping("{id}")
    public MemberResource getById(@PathVariable long id){
        return memberMapper.toResource(memberService.getById(id));
    }

    @PostMapping
    public MemberResource createUser(@RequestBody CreateMemberResource userResource) {
        return memberMapper.toResource(memberService.create(memberMapper.createResourceToModel(userResource)));
    }

    @PutMapping("{id}")
    public MemberResource updateUser(@PathVariable Long id, @RequestBody UpdateMemberResource userResource){
        return memberMapper.toResource(memberService.update(id,memberMapper.updateResourceToModel(userResource)));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        return memberService.delete(id);
    }
}
