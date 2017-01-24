package com.mpc.Entity;

 

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("request") 
@Entity
@Table(name = "conversationcomment", catalog = "mpc")
public class Conversationcomment implements java.io.Serializable {
 
	private static final long serialVersionUID = 1L;
	private Integer commentId;
	private Conversation conversation;
	private String commentText;
	private Date dateTime;

	public Conversationcomment() {
	}

	public Conversationcomment(Conversation conversation, String commentText,
			Date dateTime) {
		this.conversation = conversation;
		this.commentText = commentText;
		this.dateTime = dateTime;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "CommentId", unique = true, nullable = false)
	public Integer getCommentId() {
		return this.commentId;
	}

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "conversationId")
	public Conversation getConversation() {
		return this.conversation;
	}

	public void setConversation(Conversation conversation) {
		this.conversation = conversation;
	}

	@Column(name = "CommentText", length = 65535)
	public String getCommentText() {
		return this.commentText;
	}

	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DateTime", length = 0)
	public Date getDateTime() {
		return this.dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

}
