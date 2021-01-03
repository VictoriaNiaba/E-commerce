package com.ecommerce.backend.users.services;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.ecommerce.backend.users.model.SearchableUser;

@Repository @RepositoryRestResource(exported = false)
public interface UserSearchRepository extends ElasticsearchRepository<SearchableUser, Long> {
}
