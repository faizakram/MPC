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
@Table(name = "topic", catalog = "mpc")
public class Topic implements java.io.Serializable {

	 
	private static final long serialVersionUID = 1L;
	private Integer topicId;
	private String topicName;
	private String vesselName;
	private Integer qcno;
	private Integer alertNo;
	private Set<Conversation> conversations = new HashSet<Conversation>(0);
	private Set<Conversation> subtopics = new HashSet<Conversation>(0);

	public Topic() {
	}

	public Topic(String topicName, String vesselName, Integer qcno,
			Integer alertNo, Set<Conversation> conversations, Set<Conversation> subtopics) {
		this.topicName = topicName;
		this.vesselName = vesselName;
		this.qcno = qcno;
		this.alertNo = alertNo;
		this.conversations = conversations;
		this.subtopics = subtopics;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "TopicId", unique = true, nullable = false)
	public Integer getTopicId() {
		return this.topicId;
	}

	public void setTopicId(Integer topicId) {
		this.topicId = topicId;
	}

	@Column(name = "TopicName", length = 60)
	public String getTopicName() {
		return this.topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	@Column(name = "VesselName", length = 60)
	public String getVesselName() {
		return this.vesselName;
	}

	public void setVesselName(String vesselName) {
		this.vesselName = vesselName;
	}

	@Column(name = "QCNO")
	public Integer getQcno() {
		return this.qcno;
	}

	public void setQcno(Integer qcno) {
		this.qcno = qcno;
	}

	@Column(name = "alertNo")
	public Integer getAlertNo() {
		return this.alertNo;
	}

	public void setAlertNo(Integer alertNo) {
		this.alertNo = alertNo;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "topic")
	public Set<Conversation> getConversations() {
		return this.conversations;
	}

	public void setConversations(Set<Conversation> conversations) {
		this.conversations = conversations;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "topic")
	public Set<Conversation> getSubtopics() {
		return this.subtopics;
	}

	public void setSubtopics(Set<Conversation> subtopics) {
		this.subtopics = subtopics;
	}

}
