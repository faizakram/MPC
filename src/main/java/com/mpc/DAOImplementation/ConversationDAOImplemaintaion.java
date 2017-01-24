package com.mpc.DAOImplementation;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mpc.DAOInterFace.ConversationDAOInterFace;
import com.mpc.Entity.Conversation;
import com.mpc.Entity.Conversationcomment;
import com.mpc.Entity.Subtopic;
import com.mpc.Entity.Topic;
import com.mpc.Entity.User;
@Repository
public class ConversationDAOImplemaintaion implements ConversationDAOInterFace{

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Conversation> findAllConversionInfoOrderByDate() {
		try {
			Criteria cr = sessionFactory.getCurrentSession().createCriteria(Conversation.class);
			cr.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			if (cr.list() == null || cr.list().isEmpty()) {
				return null;
			}
			return cr.list();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Topic> findAllConversionTopicInfo() {
		try {
			Criteria cr = sessionFactory.getCurrentSession().createCriteria(Topic.class);
			cr.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			if (cr.list() == null || cr.list().isEmpty()) {
				return null;
			}
			return cr.list();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Subtopic> findAllConversionSubTopicInfo() {
		try {
			Criteria cr = sessionFactory.getCurrentSession().createCriteria(Subtopic.class);
			cr.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			if (cr.list() == null || cr.list().isEmpty()) {
				return null;
			}
			return cr.list();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Topic findTopicByName(String topicName) {
		try {
			Criteria cr = sessionFactory.getCurrentSession().createCriteria(Topic.class);
			cr.add(Restrictions.eq("topicName", topicName));
			cr.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			if (cr.list() == null || cr.list().isEmpty()) {
				return null;
			}
			return (Topic) cr.list().get(0);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Subtopic findSubTopicByName(String subTopicName) {
		try {
			Criteria cr = sessionFactory.getCurrentSession().createCriteria(Subtopic.class);
			cr.add(Restrictions.eq("subTopicName", subTopicName));
			cr.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			if (cr.list() == null || cr.list().isEmpty()) {
				return null;
			}
			return (Subtopic) cr.list().get(0);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String addConversation(Conversation conversation) {
		try {
		    sessionFactory.getCurrentSession().
		    saveOrUpdate(Conversation.class.getName(), conversation);
			return "Success";
		} catch (Exception e) {
			return "Try Again!";

		}
	}

	@Override
	public Conversation findConversationById(Integer conversationId) {
		try {
			Criteria cr = sessionFactory.getCurrentSession().createCriteria(Conversation.class);
			cr.add(Restrictions.eq("conversationId", conversationId));
			cr.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			if (cr.list() == null || cr.list().isEmpty()) {
				return null;
			}
			return (Conversation) cr.list().get(0);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public User findConversationUserByName(String userlist) {
		try {
			Criteria cr = sessionFactory.getCurrentSession().createCriteria(User.class);
			cr.add(Restrictions.eq("userName", userlist));
			cr.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			if (cr.list() == null || cr.list().isEmpty()) {
				return null;
			}
			return (User) cr.list().get(0);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String addCommentConversation(Conversationcomment conversationcomment) {
		try {
		    sessionFactory.getCurrentSession().
		    saveOrUpdate(Conversationcomment.class.getName(), conversationcomment);
			return "Success";
		} catch (Exception e) {
			return "Try Again!";

		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Conversationcomment> findAllCommentById(Integer conversationId) {
		try {
			Criteria cr = sessionFactory.getCurrentSession().createCriteria(Conversationcomment.class);
			cr.add(Restrictions.eq("conversation.conversationId", conversationId));
			cr.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			if (cr.list() == null || cr.list().isEmpty()) {
				return null;
			}
			return  cr.list();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Subtopic> findSubTopicsByTopicId(Integer topicId) {
		try {
			Criteria cr = sessionFactory.getCurrentSession().createCriteria(Subtopic.class);
			cr.add(Restrictions.eq("topic.topicId", topicId));
			cr.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			if (cr.list() == null || cr.list().isEmpty()) {
				return null;
			}
			return cr.list();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	 

	 
	
	
	
}
