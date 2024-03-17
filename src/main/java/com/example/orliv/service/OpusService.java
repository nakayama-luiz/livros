package com.example.orliv.service;

import com.example.orliv.model.author;
import com.example.orliv.model.opus;
import com.example.orliv.repository.AuthorRepository;
import com.example.orliv.repository.OpusRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OpusService {


    @Autowired
    private OpusRepository opusRepository;

    @Autowired
    private AuthorRepository authorRepository;


    public opus getOpusById(Long id){
       opus opus = opusRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Obra não encontrada")
       );
       return opus;
    }

    public opus createOpus(opus opus){
        return opusRepository.save(opus);
    }
    public opus CreateOpus(opus _opus, Long author_id) {
        author author = authorRepository.findById(author_id).orElseThrow(
                () -> new EntityNotFoundException("Author not found")
        );
        System.out.println(author.getName());
        author.getOpus().add(_opus);

        _opus.getAuthor().add(author);

        return opusRepository.save(_opus);

    }
    public List<opus> getAllOpus(){
        return opusRepository.findAll();
    }

}
