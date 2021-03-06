package com.sac.spring.demo.rest.user;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

//@ApiModel(description="All details about the user.")
@Entity
@NamedQuery(name = "User.findByEmailAddress",
	query = "select u from User u where u.email = ?1")
public class User {

	@Id
	@GeneratedValue
	private Integer id;

	@Size(min=2, message="Name should have atleast 2 characters")
	//@ApiModelProperty(notes="Name should have atleast 2 characters")
	private String name;

	@Email
	private String email;
	
	@Past
	//@ApiModelProperty(notes="Birth date should be in the past")
	private Date birthDate;
	
	@OneToMany(mappedBy="user")
	private List<Post> posts;

	protected User() {

	}

	public User(Integer id, String name, String email, Date birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.birthDate = birthDate;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	@Override
	public String toString() {
		return String.format("User [id=%s, name=%s, birthDate=%s]", id, name, birthDate);
	}

}
