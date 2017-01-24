package com.mpc.DAOImplementation;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mpc.DAOInterFace.ConversationDAOInterFace;
import com.mpc.Entity.Conversation;
import com.mpc.Entity.Subtopic;
import com.mpc.Entity.Topic;
@Repository
public class ConversationDAOImplemaintaion implements ConversationDAOInterFace{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Conversation> findAllConversionInfoOrderByDate() {
		return null;
	}

	@Override
	public List<Topic> findAllConversionTopicInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Subtopic> findAllConversionSubTopicInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	 
	
	
	
}
