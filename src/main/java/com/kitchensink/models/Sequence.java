package com.kitchensink.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "sequences")
@Data
@NoArgsConstructor
public class Sequence {
    @Id
    private String id;
    private Long sequenceNumber;

}

