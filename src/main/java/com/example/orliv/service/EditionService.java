package com.example.orliv.service;


import com.example.orliv.domain.Edition;
import com.example.orliv.domain.Opus;
import com.example.orliv.domain.OpusEdition;
import com.example.orliv.dto.EditionRequestDTO;
import com.example.orliv.dto.EditionResponseDTO;
import com.example.orliv.repository.EditionRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EditionService extends GenericCrudService<Edition, Long> {

    private final OpusService opusService;
    private final PublisherService publisherService;
    private final OpusEditionService opusEditionService;

    public EditionService(EditionRepository repository, OpusService opusService,
                          PublisherService publisherService, OpusEditionService opusEditionService) {
        super(repository);
        this.opusService = opusService;
        this.publisherService = publisherService;
        this.opusEditionService = opusEditionService;
    }

    public List<EditionResponseDTO> findAllEditionsByAuthor(Long id) {
        return getRepository(EditionRepository.class).findAllByAuthorId(id);
    }

    @Override
    public Edition create(Edition entity) {
        return super.create(entity);
    }

    public void afterCreate(Edition edition, Opus opus) {
        opusEditionService.create(new OpusEdition(edition, opus));
    }

    public Edition createEdition(EditionRequestDTO editionDTO) {
        if (!publisherService.existsById(editionDTO.getPublisher().getId())) {
            throw new EntityNotFoundException("No publisher found for giving id.");
        }

        Edition edition = new Edition(editionDTO);

        Opus opus = opusService.findById(editionDTO.getOpus().getId()).orElseThrow(() ->
                new EntityNotFoundException("No Opus found for giving id.")
        );

        Edition savedEdition = create(edition);

        afterCreate(savedEdition, opus);
        return savedEdition;
    }
}
