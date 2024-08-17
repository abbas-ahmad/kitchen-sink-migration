package com.kitchensink.services;

import com.kitchensink.models.Sequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import org.springframework.stereotype.Service;


@Service
public class SequenceGeneratorService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public Long generateSequence(String seqName) {
        Query query = new Query(Criteria.where("id").is(seqName));
        Update update = new Update().inc("sequenceNumber", 1);

        FindAndModifyOptions options = new FindAndModifyOptions().returnNew(true).upsert(true);
        Sequence sequence = mongoTemplate.findAndModify(query, update, options, Sequence.class);
        return sequence != null ? sequence.getSequenceNumber() : 1;
    }
}
