package com.aw.api.security.mapping;

import com.aw.api.security.mapping.mappers.MemberMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("SecurityMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public MemberMapper memberMapper() {
        return new MemberMapper();
    }
}
