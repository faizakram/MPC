package com.mpc.ServiceInterFace;

import java.util.List;

import com.mpc.Entity.Conversation;
import com.mpc.Entity.Conversationcomment;
import com.mpc.Entity.Subtopic;
import com.mpc.Entity.Topic;

public interface ConversationServiceInterFace {

	List<Conversation> findAllConversionInfoOrderByDate();

	List<Topic> findAllConversionTopicInfo();

	List<Subtopic> findAllConversionSubTopicInfo();

	String addConversation(String topicName, String subTopicName,
			String userlist, String conversationContent);

	String addCommentConversation(Integer conversationId, String userlist,
			String conversationcommentContent);

	List<Conversationcomment> findAllCommentById(Integer conversationId);

	List<Subtopic> findSubTopicsByTopicId(Integer topicId);


	 

}
