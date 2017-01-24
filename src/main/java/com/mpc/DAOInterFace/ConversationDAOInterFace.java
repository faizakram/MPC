 
package com.mpc.DAOInterFace;
import java.util.List;

import com.mpc.Entity.Conversation;
import com.mpc.Entity.Conversationcomment;
import com.mpc.Entity.Subtopic;
import com.mpc.Entity.Topic;
import com.mpc.Entity.User;
public interface ConversationDAOInterFace {
	List<Conversation> findAllConversionInfoOrderByDate();
	List<Topic> findAllConversionTopicInfo();
	List<Subtopic> findAllConversionSubTopicInfo();
	Topic findTopicByName(String topicName);
	Subtopic findSubTopicByName(String subTopicName);
	String addConversation(Conversation conversation);
	Conversation findConversationById(Integer conversationId);
	User findConversationUserByName(String userlist);
	String addCommentConversation(Conversationcomment conversationcomment);
	List<Conversationcomment> findAllCommentById(Integer conversationId);
}
