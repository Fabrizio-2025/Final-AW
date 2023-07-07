package com.aw.api.api.resource.update;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class UpdatePaymentResource {


    private String month;

    private String year;

    private Double amount;

    private boolean status;
}
