package com.mpc.ServiceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mpc.DAOInterFace.ConversationDAOInterFace;
import com.mpc.Entity.Conversation;
import com.mpc.Entity.Subtopic;
import com.mpc.Entity.Topic;
import com.mpc.ServiceInterFace.ConversationServiceInterFace;

@Service
public class ConversationServiceImplemaintation implements ConversationServiceInterFace{

	@Autowired
	private ConversationDAOInterFace conversationDAOInterFace;
	
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
	
	
	

}
