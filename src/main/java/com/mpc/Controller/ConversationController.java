package com.mpc.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mpc.ServiceInterFace.ConversationServiceInterFace;

 
@Controller
public class ConversationController {
	
	/*@Autowired
	private ConversationServiceInterFace conversationServiceInterFace;*/
	@Autowired
	private ModelAndView model;
	
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
	
	
	
	
}
