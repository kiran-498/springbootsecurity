package com.config.main;

import org.springframework.data.couchbase.repository.CouchbaseRepository;

public interface UserRepository extends CouchbaseRepository<User, String>{

	void deleteAll();

	User save(User user);

	char[] findById(String id);

}
