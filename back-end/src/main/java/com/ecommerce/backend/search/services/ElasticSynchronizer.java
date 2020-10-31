package com.ecommerce.backend.search.services;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.ecommerce.backend.users.model.User;
import com.ecommerce.backend.users.services.UserMapper;
import com.ecommerce.backend.users.services.UserRepository;
import com.ecommerce.backend.users.services.UserSearchRepository;
import com.ecommerce.backend.utils.Constants;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ElasticSynchronizer {

	private UserRepository userRepository;
	private UserSearchRepository userESRepo;
	private UserMapper userMapper;

	@Autowired
	public ElasticSynchronizer(UserRepository userDAO, UserSearchRepository userESRepo, UserMapper userMapper) {
		this.userRepository = userDAO;
		this.userESRepo = userESRepo;
		this.userMapper = userMapper;
	}

	@Scheduled(cron = "0 */3 * * * *")
	@Transactional
	public void sync() {
		log.info("Start Syncing");
		this.syncUsers();
		log.info("End Syncing");
	}

	private void syncUsers() {

		Specification<User> userSpecification = (root, criteriaQuery,
				criteriaBuilder) -> getModificationDatePredicate(criteriaBuilder, root);
				
		Iterable<User> userList;
		if (userESRepo.count() == 0) {
			userList = userRepository.findAll();
		} else {
			userList = userRepository.findAll(userSpecification);
		}
		for (User user : userList) {
			log.info("Syncing User - {}", user.getId());
			userESRepo.save(this.userMapper.toSearch(user));
		}
	}

	private static Predicate getModificationDatePredicate(CriteriaBuilder cb, Root<?> root) {
		Expression<Timestamp> currentTime;
		currentTime = cb.currentTimestamp();
		Expression<Timestamp> currentTimeMinus = cb.literal(
				new Timestamp(System.currentTimeMillis() -
						(Constants.INTERVAL_IN_MILLISECONDS)));
		return cb.between(root.<Date>get(Constants.MODIFICATION_DATE),
				currentTimeMinus,
				currentTime);
	}
}