package com.ecommerce.backend.search.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@NoArgsConstructor
@ToString(of= {"timeTook", "numberOfResults", "elements"})
public class ResultQuery {

    private Float timeTook;
    private Integer numberOfResults;
    private String elements;
}