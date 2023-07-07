package com.aw.api.api.mapping;

import com.aw.api.api.mapping.mappers.PaymentMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("ApiMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public PaymentMapper paymentMapper() {
        return new PaymentMapper();
    }
}
