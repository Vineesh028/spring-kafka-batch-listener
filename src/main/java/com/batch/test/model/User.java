package com.batch.test.model;

import java.io.Serializable;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Users")
public class User implements Serializable {

	@Id
	private UUID id;
	private String name;
	private String nickName;
	private String email;

	@Override
	public String toString() {
		
		return id+" "+name+" "+nickName+" "+email;
	}

}