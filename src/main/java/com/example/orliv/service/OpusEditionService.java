package com.example.orliv.service;


import com.example.orliv.config.SolrJConfig;
import com.example.orliv.domain.OpusEdition;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class OpusEditionService extends GenericCrudService<OpusEdition, Long> {

    private final SolrJConfig solrJConfig;

    public OpusEditionService(CrudRepository<OpusEdition, Long> repository, SolrJConfig solrJConfig) {
        super(repository);
        this.solrJConfig = solrJConfig;
    }

    @Override
    public OpusEdition create(OpusEdition opusEdition) {
        return getCrudRepository().save(opusEdition);
    }

//    public List<Map<String, Object>> find() {
//        try {
//            SolrQuery query = new SolrQuery();
//            query.setQuery("*:*");
//            query.setRows(10);
//
//            QueryResponse response = solrJConfig.solrConnect().query("techproducts", query);
//            SolrDocumentList documents = response.getResults();
//
//            List<Map<String, Object>> results = new ArrayList<>();
//
//            for (SolrDocument doc : documents) {
//                Map<String, Object> documentMap = new HashMap<>(doc);
//                results.add(documentMap);
//            }
//
//            return results;
//
//        } catch (SolrServerException | IOException e) {
//            throw new RuntimeException("Erro ao executar query no Solr: " + e.getMessage(), e);
//        }
//    }

}
