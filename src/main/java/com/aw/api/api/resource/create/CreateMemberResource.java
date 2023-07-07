package com.aw.api.api.resource.create;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreateMemberResource {

    private String name;

    private Long member_code;
}
