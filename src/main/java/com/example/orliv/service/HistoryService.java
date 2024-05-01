package com.example.orliv.service;

import com.example.orliv.model.ReadingHistory;
import com.example.orliv.model.bookcases;
import com.example.orliv.model.edition;
import com.example.orliv.repository.BookcaseRepository;
import com.example.orliv.repository.EditionRepository;
import com.example.orliv.repository.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoryService {

    @Autowired
    private HistoryRepository historyRepository;

    @Autowired
    private BookcaseRepository bookcaseRepository;

    @Autowired
    private EditionRepository editionRepository;

    public ReadingHistory create(ReadingHistory readingHistory){
       bookcases bookcase = bookcaseRepository.findById(readingHistory.getBookcase().getId()).orElseThrow();

       edition edition = editionRepository.findById(bookcase.getEditions().getId()).orElseThrow();

       if(readingHistory.getPages()> edition.getPages()){
          throw new RuntimeException();
       }else{

           return historyRepository.save(readingHistory);
       }


    }

}
