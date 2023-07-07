package com.aw.api.api.resource.show;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class PaymentResource {
    private Long id;

    private String month;

    private String year;

    private Double amount;

    private boolean status;
}
