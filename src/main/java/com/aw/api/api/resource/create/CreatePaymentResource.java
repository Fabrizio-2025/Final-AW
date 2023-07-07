package com.aw.api.api.resource.create;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreatePaymentResource {

    private String month;

    private String year;

    private Double amount;

    private boolean status;
}
