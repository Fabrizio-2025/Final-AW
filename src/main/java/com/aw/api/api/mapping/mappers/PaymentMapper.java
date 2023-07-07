package com.aw.api.api.mapping.mappers;

import com.aw.api.api.resource.create.CreatePaymentResource;
import com.aw.api.api.resource.show.PaymentResource;
import com.aw.api.api.resource.update.UpdatePaymentResource;
import com.aw.api.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.aw.api.api.domain.model.entity.Payment;

import java.util.List;

public class PaymentMapper {
    @Autowired
    EnhancedModelMapper mapper;

    public PaymentResource toResource(Payment paymentmodel) {
        return mapper.map(paymentmodel, PaymentResource.class);
    }

    public List<PaymentResource> toListResource(List<Payment> payments) {
        return mapper.mapList(payments, PaymentResource.class);
    }

    public Payment createResourceToModel(CreatePaymentResource createPaymentResource) {
        return mapper.map(createPaymentResource, Payment.class);
    }

    public Payment updateResourceToModel(UpdatePaymentResource updatePaymentResource) {
        return mapper.map(updatePaymentResource, Payment.class);
    }
}
