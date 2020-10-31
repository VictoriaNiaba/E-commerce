package com.ecommerce.backend.search.api;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.backend.search.model.ResultQuery;
import com.ecommerce.backend.search.services.SearchService;
import com.ecommerce.backend.utils.*;

@RestController
@RequestMapping(PathResources.SEARCH_CONTROLLER)
public class SearchController {

    private SearchService searchService;

    @Autowired
    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping(Constants.SEARCH_QUERY + "/{" + Constants.QUERY + "}")
    public ResponseEntity<ResultQuery> searchQuery(@PathVariable String query)
        throws IOException {
        return new ResponseEntity<> (
            searchService.searchFromQuery(query.trim().toLowerCase()), HttpStatus.OK);
    }
}