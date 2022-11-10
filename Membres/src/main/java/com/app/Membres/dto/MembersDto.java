package com.app.Membres.dto;

import com.app.Membres.Post;
import lombok.Data;

import java.util.Date;

@Data
public class MembersDto {

    private Long ID;
    private String FirstName;
    private String LastName;
    private Date BirthDay;
    private Post post;
    private Date Hiring_Date;

}
