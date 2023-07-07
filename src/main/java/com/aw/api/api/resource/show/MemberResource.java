package com.aw.api.api.resource.show;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class MemberResource {
    private Long id;

    private String name;

    private Long member_code;
}
