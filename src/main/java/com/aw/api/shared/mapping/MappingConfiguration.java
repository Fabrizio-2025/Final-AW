package com.aw.api.shared.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("SharedMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public EnhancedModelMapper enhancedModelMapper() {
        return new EnhancedModelMapper();
    }
}
