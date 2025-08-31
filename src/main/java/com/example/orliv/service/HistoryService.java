package com.example.orliv.service;

import com.example.orliv.domain.Bookcases;
import com.example.orliv.domain.Edition;
import com.example.orliv.domain.ReadingHistory;
import com.example.orliv.domain.enums.Status;
import com.example.orliv.repository.BookcaseRepository;
import com.example.orliv.repository.EditionRepository;
import com.example.orliv.repository.HistoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class HistoryService {

    private HistoryRepository historyRepository;
    private BookcaseRepository bookcaseRepository;
    private EditionRepository editionRepository;

    public ReadingHistory create(ReadingHistory readingHistory){
        Bookcases bookcase = bookcaseRepository.findById(readingHistory.getBookcase().getId()).orElseThrow();

        Edition edition = editionRepository.findById(bookcase.getEditions().getId()).orElseThrow();

        if (readingHistory.getPages() > edition.getPages()) {
          throw new RuntimeException("Pages read could not excced the number of pages.");
        } else if (readingHistory.getPages().equals(edition.getPages())) {
           bookcase.setStatus(Status.LIDOS);
           bookcaseRepository.save(bookcase);
           return historyRepository.save(readingHistory);
        } else{
           return historyRepository.save(readingHistory);
       }

    }

}
