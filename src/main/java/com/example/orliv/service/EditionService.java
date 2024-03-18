package com.example.orliv.service;


import com.example.orliv.model.edition;
import com.example.orliv.repository.EditionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EditionService {


    @Autowired
    private EditionRepository editionRepository;


    public edition createEdition(edition edition){
        return editionRepository.save(edition);
    }

    public List<edition> all(){
        return editionRepository.findAll();
    }


}
