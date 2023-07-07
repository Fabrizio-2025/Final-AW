package com.aw.api.api.resource.update;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class UpdateMemberResource {

    private String name;

    private Long member_code;
}
