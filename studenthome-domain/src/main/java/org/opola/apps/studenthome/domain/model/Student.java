package org.opola.apps.studenthome.domain.model;

import java.io.Serializable;

public class Student {
	private long id;
	private String name;

	public Student() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
