package com.ecommerce.backend.search.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter @Setter
@NoArgsConstructor
public class ResultQuery {

    private Float timeTook;
    private Integer numberOfResults;
    private String elements;
}