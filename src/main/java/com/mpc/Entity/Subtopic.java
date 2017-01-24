package com.mpc.Entity;

 

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("request") 
@Entity
@Table(name = "subtopic", catalog = "mpc")
public class Subtopic implements java.io.Serializable {

 
	private static final long serialVersionUID = 1L;
	private Integer subTopicId;
	private Topic topic;
	private String subTopicName;
	private Set<Conversation> conversations = new HashSet<Conversation>(0);

	public Subtopic() {
	}

	public Subtopic(Topic topic, String subTopicName, Set<Conversation> conversations) {
		this.topic = topic;
		this.subTopicName = subTopicName;
		this.conversations = conversations;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "SubTopicId", unique = true, nullable = false)
	public Integer getSubTopicId() {
		return this.subTopicId;
	}

	public void setSubTopicId(Integer subTopicId) {
		this.subTopicId = subTopicId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TopicId")
	public Topic getTopic() {
		return this.topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	@Column(name = "SubTopicName", length = 60)
	public String getSubTopicName() {
		return this.subTopicName;
	}

	public void setSubTopicName(String subTopicName) {
		this.subTopicName = subTopicName;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "subtopic")
	public Set<Conversation> getConversations() {
		return this.conversations;
	}

	public void setConversations(Set<Conversation> conversations) {
		this.conversations = conversations;
	}

}
