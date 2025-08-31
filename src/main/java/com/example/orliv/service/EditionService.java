package com.example.orliv.service;


import com.example.orliv.domain.Edition;
import com.example.orliv.repository.EditionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class EditionService extends GenericCrudService<Edition, Long> {

    public EditionService(EditionRepository editionRepository) {
        super(editionRepository);
    }

    public EditionRepository getRepository() {
        return getRepository(EditionRepository.class);
    }

    public List<Map<String, Object>> findAllEditionsByAuthor(Long id) {
        return getRepository().findAllByAuthorId(id);
    }

}
