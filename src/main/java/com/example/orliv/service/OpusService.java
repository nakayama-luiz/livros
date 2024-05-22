package com.example.orliv.service;

import com.example.orliv.model.author;
import com.example.orliv.model.opus;
import com.example.orliv.repository.AuthorRepository;
import com.example.orliv.repository.OpusRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class OpusService {


    @Autowired
    private OpusRepository opusRepository;

    @Autowired
    private AuthorRepository authorRepository;


    public opus getOpusById(Long id){
        return opusRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Obra não encontrada")
       );
    }

    public opus CreateOpus(opus _opus, List<Long> author_ids) {
        if(_opus.getTime() > LocalDate.now().getYear()){
            throw new RuntimeException("Invalid date.");
        }

        List<author> authores = new ArrayList<>();

        int n = 0;
        for (Long authorId : author_ids) {

            author author =  authorRepository.findById(authorId).orElseThrow();
            authores.add(author);
            authores.get(n).getOpus().add(_opus);
            n++;
        }
        _opus.setAuthor(authores);
        return opusRepository.save(_opus);

    }
    public List<opus> getAllOpus(){
        return opusRepository.findAll();
    }

}
