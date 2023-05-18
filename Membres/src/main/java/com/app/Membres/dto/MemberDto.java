package com.app.Membres.dto;

import com.app.Membres.enums.Post;
import lombok.Data;

import java.util.Date;

@Data
public class MemberDto {

    private Long id;
    private String firstName;
    private String lastName;
    private Date birthDay;
    private Post post;
    private Date hiringDate;

}
