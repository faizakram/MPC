package com.mpc.Entity;


import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
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
@Table(name = "conversation", catalog = "mpc")
public class Conversation implements java.io.Serializable {

 
	private static final long serialVersionUID = 1L;
	private Integer conversationId;
	private Subtopic subtopic;
	private Topic topic;
	private User user;
	private String contentText;
	private String startedDate;
	private String followedDate;
	private Integer noOfCon;
	private Set<Conversationcomment> conversationcomments = new HashSet<Conversationcomment>(0);

	public Conversation() {
	}

	public Conversation(Subtopic subtopic, Topic topic, User user,
			String contentText, String startedDate, String followedDate,
			Integer noOfCon, Set<Conversationcomment> conversationcomments) {
		this.subtopic = subtopic;
		this.topic = topic;
		this.user = user;
		this.contentText = contentText;
		this.startedDate = startedDate;
		this.followedDate = followedDate;
		this.noOfCon = noOfCon;
		this.conversationcomments = conversationcomments;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "conversationId", unique = true, nullable = false)
	public Integer getConversationId() {
		return this.conversationId;
	}

	public void setConversationId(Integer conversationId) {
		this.conversationId = conversationId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SubTopicId")
	public Subtopic getSubtopic() {
		return this.subtopic;
	}

	public void setSubtopic(Subtopic subtopic) {
		this.subtopic = subtopic;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TopicId")
	public Topic getTopic() {
		return this.topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UserId")
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "ContentText", length = 65535)
	public String getContentText() {
		return this.contentText;
	}

	public void setContentText(String contentText) {
		this.contentText = contentText;
	}

	@Column(name = "StartedDate", length = 60)
	public String getStartedDate() {
		return this.startedDate;
	}

	public void setStartedDate(String startedDate) {
		this.startedDate = startedDate;
	}

	@Column(name = "FollowedDate", length = 60)
	public String getFollowedDate() {
		return this.followedDate;
	}

	public void setFollowedDate(String followedDate) {
		this.followedDate = followedDate;
	}

	@Column(name = "NoOfCon")
	public Integer getNoOfCon() {
		return this.noOfCon;
	}

	public void setNoOfCon(Integer noOfCon) {
		this.noOfCon = noOfCon;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "conversation")
	public Set<Conversationcomment> getConversationcomments() {
		return this.conversationcomments;
	}

	public void setConversationcomments(Set<Conversationcomment> conversationcomments) {
		this.conversationcomments = conversationcomments;
	}

}
