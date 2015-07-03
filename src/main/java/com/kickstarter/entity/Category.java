package com.kickstarter.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.data.annotation.PersistenceConstructor;

@Entity
public class Category {

	@Id
	@GeneratedValue
	private Integer id;

	@Column(nullable = false, length = 250)
	private String name;

	@OneToMany
	private List<Project> projects;

	public Category() {
	}

	@PersistenceConstructor
	public Category(String name) {
		this.name = name;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
