package com.example.orliv.model;


import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class user {

    private Long id;

    private String displayName;

    private String password;

    private String username;

    private List<bookcases> bookcasesList = new ArrayList<>();

    private String profilePic;

}
