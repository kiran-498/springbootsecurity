package com.config.main;

import org.springframework.data.couchbase.core.mapping.Document;

import com.couchbase.client.java.repository.annotation.Field;
import com.couchbase.client.java.repository.annotation.Id;

@Document
public class User {

	@Id
	private String id;

	@Field
	private String firstName;

	@Field
	private String lastName;

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "User{" + "id='" + this.id + '\'' + ", firstName='" + this.firstName + '\''
				+ ", lastName='" + this.lastName + '\'' + '}';
	}


}
