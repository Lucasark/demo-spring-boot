package com.example.demo.repository.document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaisHistoricalPK implements Entity {

    @Builder.Default
    private ObjectId id = new ObjectId();

    @Builder.Default
    private Long version = 1L;

}
