package com.aw.api.api.api.rest;

import com.aw.api.api.resource.create.CreatePaymentResource;
import com.aw.api.api.resource.show.PaymentResource;
import com.aw.api.api.resource.update.UpdatePaymentResource;
import com.aw.api.api.domain.service.PaymentService;
import com.aw.api.api.mapping.mappers.PaymentMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/payments",produces = "application/json")
public class PaymentController {
    private final PaymentService paymentService;
    private final PaymentMapper paymentMapper;

    public PaymentController(PaymentService paymentService, PaymentMapper paymentMapper){
        this.paymentService = paymentService;
        this.paymentMapper = paymentMapper;
    }

    @GetMapping("all")
    public List<PaymentResource> getAllUser(){
        return paymentMapper.toListResource(paymentService.getAll());
    }

    @GetMapping("{id}")
    public PaymentResource getById(@PathVariable long id){
        return paymentMapper.toResource(paymentService.getById(id));
    }

    @PostMapping
    public PaymentResource createUser(@RequestBody CreatePaymentResource userResource) {
        return paymentMapper.toResource(paymentService.create(paymentMapper.createResourceToModel(userResource)));
    }

    @PutMapping("{id}")
    public PaymentResource updateUser(@PathVariable Long id, @RequestBody UpdatePaymentResource userResource){
        return paymentMapper.toResource(paymentService.update(id,paymentMapper.updateResourceToModel(userResource)));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        return paymentService.delete(id);
    }
}
