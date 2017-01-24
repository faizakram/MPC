package com.mpc.ServiceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mpc.DAOInterFace.ConversationDAOInterFace;
import com.mpc.Entity.Conversation;
import com.mpc.Entity.Conversationcomment;
import com.mpc.Entity.Subtopic;
import com.mpc.Entity.Topic;
import com.mpc.Entity.User;
import com.mpc.GetCurrentDateTime.GetCurrentDateTime;
import com.mpc.ServiceInterFace.ConversationServiceInterFace;

@Service
public class ConversationServiceImplemaintation implements ConversationServiceInterFace{

	@Autowired
	private ConversationDAOInterFace conversationDAOInterFace;
	@Autowired
	private Conversation conversation;
	@Autowired
	private GetCurrentDateTime getCurrentDateTime;
	@Autowired
	private Conversationcomment conversationcomment;
	@Override
	@Transactional
	public List<Conversation> findAllConversionInfoOrderByDate() {
		return conversationDAOInterFace.findAllConversionInfoOrderByDate();
	}

	@Override
	@Transactional
	public List<Topic> findAllConversionTopicInfo() {
		return conversationDAOInterFace.findAllConversionTopicInfo();
	}

	@Override
	@Transactional
	public List<Subtopic> findAllConversionSubTopicInfo() {
		return conversationDAOInterFace.findAllConversionSubTopicInfo();
	}

	@Override
	@Transactional
	public String addConversation(String topicName, String subTopicName,
			String userlist, String conversationContent) {
		Topic topic = conversationDAOInterFace.findTopicByName(topicName);
		Subtopic subTopic = conversationDAOInterFace.findSubTopicByName(subTopicName);
		User user = conversationDAOInterFace.findConversationUserByName(userlist);
		conversation.setContentText(conversationContent);
		conversation.setTopic(topic);
		conversation.setSubtopic(subTopic);
		conversation.setUser(user);
		conversation.setStartedDate(getCurrentDateTime.getCurrentDate());
		return conversationDAOInterFace.addConversation(conversation);
	}

	@Override
	@Transactional
	public String addCommentConversation(Integer conversationId,
			String userlist, String conversationcommentContent) {
		Conversation conversation = conversationDAOInterFace.
				findConversationById(conversationId);
		User user = conversationDAOInterFace.findConversationUserByName(userlist);
		conversationcomment.setConversation(conversation);
		conversationcomment.setCommentText(conversationcommentContent);
		conversationcomment.setUser(user);
		conversationcomment.setDateTime(getCurrentDateTime.getCurrentDate());
		return conversationDAOInterFace.addCommentConversation(conversationcomment);
	}

	@Override
	@Transactional
	public List<Conversationcomment> findAllCommentById(Integer conversationId) {
		return conversationDAOInterFace.findAllCommentById(conversationId);
	}

	@Override
	@Transactional
	public List<Subtopic> findSubTopicsByTopicId(Integer topicId) {		
		return conversationDAOInterFace.findSubTopicsByTopicId(topicId);
	}


	 
	
	

}
