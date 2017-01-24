 
package com.mpc.DAOInterFace;
import java.util.List;

import com.mpc.Entity.Conversation;
import com.mpc.Entity.Subtopic;
import com.mpc.Entity.Topic;
public interface ConversationDAOInterFace {
	List<Conversation> findAllConversionInfoOrderByDate();
	List<Topic> findAllConversionTopicInfo();
	List<Subtopic> findAllConversionSubTopicInfo();
}
