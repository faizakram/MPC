package com.mpc.Entity;

 
import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
	private User user;
	private String commentText;
	private String dateTime;

	public Conversationcomment() {
	}

	public Conversationcomment(Conversation conversation, User user,
			String commentText, String dateTime) {
		this.conversation = conversation;
		this.user = user;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UserId")
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "CommentText", length = 65535)
	public String getCommentText() {
		return this.commentText;
	}

	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}
 
	@Column(name = "DateTime", length = 0)
	public String getDateTime() {
		return this.dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

}
