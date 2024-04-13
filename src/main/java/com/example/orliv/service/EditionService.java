package com.example.orliv.service;


import com.example.orliv.model.edition;
import com.example.orliv.model.opus;
import com.example.orliv.repository.EditionRepository;
import com.example.orliv.repository.OpusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class EditionService {


    @Autowired
    private EditionRepository editionRepository;

    @Autowired
    private OpusRepository opusRepository;

    public edition createEdition(edition edition){

        return editionRepository.save(edition);

    }

    public List<edition> all(){
        return editionRepository.findAll();
    }


}
