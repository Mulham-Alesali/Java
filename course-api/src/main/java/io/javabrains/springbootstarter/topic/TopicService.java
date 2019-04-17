package io.javabrains.springbootstarter.topic;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

//when the Application start up Spring create an instance of the Service


@Service
public class TopicService {

	List<Topic> topicslist = new LinkedList<Topic>(
			Arrays.asList(
					new Topic("Spring","Spring Framework","Spring Framework Description"),
					new Topic("java","jdk","jdk Description"),
					new Topic("csharp",".net Framework",".net Framework Description"),
					new Topic("javascript","no Framework","no Framework Description")
					)
			);
	
	public List<Topic> getAllTopics(){
		return topicslist;
	}
	
	public Topic getTopic(String id) {
		return topicslist.stream().filter(t -> t.getId().contentEquals(id)).findFirst().get();
		
	}

	public void addTopic(Topic topic) {
		topicslist.add(topic);
		
		
	}
	
	
}
