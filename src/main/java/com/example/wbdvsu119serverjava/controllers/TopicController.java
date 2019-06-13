package com.example.wbdvsu119serverjava.controllers;

import com.example.wbdvsu119serverjava.models.Lesson;
import com.example.wbdvsu119serverjava.models.Module;
import com.example.wbdvsu119serverjava.models.Topic;
import com.example.wbdvsu119serverjava.repositories.LessonRepository;
import com.example.wbdvsu119serverjava.repositories.TopicRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin("*")
public class TopicController {
	
	@Autowired
	private LessonController LessonController;
	@Autowired
	private TopicRepository topicRepo;
	@PostMapping("/api/lesson/{lessonId}/topic")
	public Topic createTopic(@PathVariable("lessonId") Integer lessonId, 
								@RequestBody Topic topic) {
			
		Lesson l = LessonController.findLessonById(lessonId);
		if(l==null) return null;
		topic.setLesson(l);
		Topic updatedTopic = topicRepo.save(topic);
		l.addToTopics(updatedTopic);
		return updatedTopic;
	}
	
	@GetMapping("/api/lesson/{lessonId}/topic")
	public List<Topic> findAllTopic(@PathVariable("lessonId") Integer lessonId){
		Lesson l = LessonController.findLessonById(lessonId);
		if(l != null)
			return new ArrayList<Topic>(l.getTopics());
		else 
			return null;
	}
	
	@GetMapping("/api/topic/{topicId}")
	public Topic findTopicById(@PathVariable("topicId") Integer topicId) {
		Optional<Topic> opt = topicRepo.findById(topicId);
		if(opt.isPresent())
			return opt.get();
		else 
			return null;
	}
	
	@PutMapping("/api/topic/{topicId}")
	public Topic updateTopic(@PathVariable("topicId") Integer topicId, @RequestBody Topic topic) {
		Optional<Topic> opt = topicRepo.findById(topicId);
		if(opt.isPresent())
		{
			Topic old = opt.get();
			topic.setId(old.getId());
			topic.setLesson(old.getLesson());
			topic.setWidgets(old.getWidgets());
			Topic updatedTopic = topicRepo.save(topic);
			
			updatedTopic.getLesson().getTopics().remove(old);
			updatedTopic.getLesson().getTopics().add(updatedTopic);
			
			return updatedTopic;
		}
		else 
			return null;
	}
	
	@DeleteMapping("/api/topic/{topicId}")
	public void deleteCourse(@PathVariable("topicId") Integer topicId) {
		if(topicRepo.existsById(topicId))
			topicRepo.deleteById(topicId);
	}
}
