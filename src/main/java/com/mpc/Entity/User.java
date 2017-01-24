package com.mpc.Entity;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

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
	private Set<Conversationcomment> conversationcomments = new HashSet<Conversationcomment>(0);

	public User() {
	}

	public User(String userName, Set<Conversation> conversations, Set<Conversationcomment> conversationcomments) {
		this.userName = userName;
		this.conversations = conversations;
		this.conversationcomments = conversationcomments;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Conversationcomment> getConversationcomments() {
		return this.conversationcomments;
	}

	public void setConversationcomments(Set<Conversationcomment> conversationcomments) {
		this.conversationcomments = conversationcomments;
	}

}
