package com.example.orliv.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class bookcases {

    private Long id;

    private List<edition> editions = new ArrayList<>();

    private String name;

    private user owner;



}
