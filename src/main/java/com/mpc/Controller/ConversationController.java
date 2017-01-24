package com.mpc.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mpc.JsonEntity.Response;
import com.mpc.ServiceInterFace.ConversationServiceInterFace;

 
@Controller
public class ConversationController {
	
	@Autowired
	private ConversationServiceInterFace conversationServiceInterFace;
	@Autowired
	private ModelAndView model;
	
	@Autowired
	private Response response;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView firstPage() {
		model.setViewName("Conversation/index");
		/*model.addObject("conversationInfo", 
				conversationServiceInterFace.findAllConversionInfoOrderByDate());
		model.addObject("conversationTopicInfo", 
				conversationServiceInterFace.findAllConversionTopicInfo());
		model.addObject("conversationTopicInfo", 
				conversationServiceInterFace.findAllConversionSubTopicInfo());*/
		return model;
	}
	
	@RequestMapping(value = "/addConversation", method = RequestMethod.POST)
	public @ResponseBody Response addConversation(
			@RequestParam(value = "topicName", required = true) String topicName,
			@RequestParam(value = "subTopicName", required = false) String subTopicName, 
			@RequestParam(value = "userlist", required = true) String userlist,
			@RequestParam(value = "conversationContent", required = true) String conversationContent){
		try{
			response.setStatus(conversationServiceInterFace.addConversation(topicName,
					subTopicName,userlist,conversationContent));
			response.setMessage("Successfully Added Wait 5 Sec .....");
		}catch(Exception e)
		{
			response.setStatus("Try Again!");
			response.setMessage("Try Again!");
		}
		return response;
	}
	
	@RequestMapping(value = "/commentConversation", method = RequestMethod.POST)
	public @ResponseBody Response addCommentConversation(
			@RequestParam(value = "ConversationId", required = true) Integer ConversationId,
			@RequestParam(value = "userlist", required = true) String userlist,
			@RequestParam(value = "conversationcommentContent", required = true) String conversationcommentContent){
		try{
			response.setStatus(conversationServiceInterFace.addCommentConversation(ConversationId,
					userlist,conversationcommentContent));
			response.setMessage("Successfully Commented Wait 5 Sec ..... To Reflect");
		}catch(Exception e)
		{
			response.setStatus("Try Again!");
			response.setMessage("Try Again!");
		}
		return response;
	}
	
	@RequestMapping(value = "/findAllCommentById", method = RequestMethod.POST)
	public ModelAndView findAllConversationById(
			@RequestParam(value = "ConversationId", required = true) 
			Integer ConversationId){
		model.setViewName("ConversationComment/Single/index");
		model.addObject("commentInfoByConversationId",
				conversationServiceInterFace.findAllCommentById(ConversationId));
		return model;
	}
	
	
}
