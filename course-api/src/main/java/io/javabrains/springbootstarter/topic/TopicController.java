package io.javabrains.springbootstarter.topic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TopicController {

	
	@Autowired
	private TopicService topicservice;
	
	@RequestMapping("/index")
	public String getHtml() {
		createTopic();
		return "<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"<head>\r\n" + 
				"<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\r\n" + 
				"<script>\r\n" + 
				"$(document).ready(function(){\r\n" + 
				"  $(\"button\").click(function(){\r\n" + 
				"    $.post(\"http://localhost:8080/index\",\r\n" + 
				"    {\r\n" + 
				"	\"id\": \"a\",\r\n" + 
				"	\"name:\":\"mulham\",\r\n" + 
				"	\"description\":\"programming\"\r\n" + 
				"	\r\n" + 
				"	},\r\n" + 
				"    function(data,status){\r\n" + 
				"      alert(\"Data: \" + data + \"\\nStatus: \" + status);\r\n" + 
				"    });\r\n" + 
				"  });\r\n" + 
				"});\r\n" + 
				"</script>\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n" + 
				"\r\n" + 
				"<button>Send an HTTP POST request to a page and get the result back</button>\r\n" + 
				"\r\n" + 
				"</body>\r\n" + 
				"</html>\r\n" + 
				"";
		
	}
	
	@RequestMapping("/topics")
	public List<Topic> getAllTopics() {
		return topicservice.getAllTopics();
	}
	
	@RequestMapping("/topics/{id}")
	public Topic getTopic(@PathVariable String id) {
		return topicservice.getTopic(id);
	}
	
	
	
	@RequestMapping(method=RequestMethod.POST,value="/index")
	public String addTopic(@RequestBody Topic topic) {
		topicservice.addTopic(topic);
		return "{\"hello\":\"hello2\"}";
	}
	
	
	
	@RequestMapping(value = "/test", method = RequestMethod.POST)
	public ResponseEntity<String> createEmployee(@RequestBody Topic t)
	{
	    System.out.println(t);
	    return new ResponseEntity(HttpStatus.CREATED);
	}

	 
	@RequestMapping(value = "/mulham", method = RequestMethod.POST)
	public ResponseEntity<String> Topic (@RequestBody Topic topic)
	{
		//ResponseEntity re = new ResponseEntity()
	    System.out.println(topic);
	    //return new ResponseEntity(HttpStatus.CREATED);
	    HttpHeaders responseHeaders = new HttpHeaders();
	    responseHeaders.set("MyResponseHeader", "MyValue");
	    return new ResponseEntity<String>("Hi World", responseHeaders, HttpStatus.CREATED);
	}
	 
	
	private static void createTopic()
	{
	    final String uri = "http://localhost:8080/mulham";
	    Topic newTopic = new Topic("tId","tName","tDescription");
	    RestTemplate restTemplate = new RestTemplate();
	    Object result = restTemplate.postForObject( uri, newTopic, Topic.class);
	 
	    System.out.println(result);
	}
	
}
