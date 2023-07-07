package com.aw.api.security.mapping.mappers;

import com.aw.api.api.resource.create.CreateMemberResource;
import com.aw.api.api.resource.show.MemberResource;
import com.aw.api.api.resource.update.UpdateMemberResource;
import com.aw.api.security.domain.model.entity.Member;
import com.aw.api.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MemberMapper {
    @Autowired
    EnhancedModelMapper mapper;

    public MemberResource toResource(Member membermodel) {
        return mapper.map(membermodel, MemberResource.class);
    }

    public List<MemberResource> toListResource(List<Member> stores) {
        return mapper.mapList(stores, MemberResource.class);
    }

    public Member createResourceToModel(CreateMemberResource createMemberResource) {
        return mapper.map(createMemberResource, Member.class);
    }

    public Member updateResourceToModel(UpdateMemberResource updateMemberResource) {
        return mapper.map(updateMemberResource, Member.class);
    }
}
