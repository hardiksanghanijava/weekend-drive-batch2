package com.miniproject.backend_course.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Round_Table")
public class Round {

	@Id
	@GeneratedValue
	private int id;
	@NotNull(message = "Not empty")
	private String name;
	private int sequence;

	public Round(int id, String name, int sequence) {
		super();
		this.id = id;
		this.name = name;
		this.sequence = sequence;
	}

	public Round() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSequence() {
		return sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

	@Override
	public String toString() {
		return "Round [id=" + id + ", name=" + name + ", sequence=" + sequence + "]";
	}

}
