package com.ecommerce.backend.users.services;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.backend.users.model.SearchableUser;

@Repository
public interface UserSearchRepository extends ElasticsearchRepository<SearchableUser, Long> {
}
