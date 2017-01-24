package com.mpc.Entity;

 

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("request")
@Entity
@Table(name = "user", catalog = "mpc")
public class User implements java.io.Serializable {
 
	private static final long serialVersionUID = 1L;
	private Integer userId;
	private String userName;
	private Set<Conversation> conversations = new HashSet<Conversation>(0);

	public User() {
	}

	public User(String userName, Set<Conversation> conversations) {
		this.userName = userName;
		this.conversations = conversations;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "UserId", unique = true, nullable = false)
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "UserName", length = 60)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Conversation> getConversations() {
		return this.conversations;
	}

	public void setConversations(Set<Conversation> conversations) {
		this.conversations = conversations;
	}

}
