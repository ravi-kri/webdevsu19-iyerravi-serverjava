package com.example.wbdvsu119serverjava.controllers;

import com.example.wbdvsu119serverjava.models.Topic;
import com.example.wbdvsu119serverjava.models.Widget;
import com.example.wbdvsu119serverjava.repositories.TopicRepository;
import com.example.wbdvsu119serverjava.repositories.WidgetRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@CrossOrigin(origins = "*")
@RestController
public class WidgetController {
	@Autowired
	private TopicController TopicController;
	@Autowired
	private WidgetRepository widgetRepo;
	
	@Autowired
	private TopicRepository  topicRepo;
	
	@PostMapping("/api/topic/{topicId}/widget")
	public Widget createTopic(@PathVariable("topicId") Integer topicId, 
								@RequestBody Widget widget) {
			
		Topic t = TopicController.findTopicById(topicId);
		if(t==null) return null;
		widget.setTopic(t);
		Widget updatedWidget = widgetRepo.save(widget);
		t.addToWidgets(updatedWidget);
		return updatedWidget;
	}
	
	@GetMapping("/api/topic/{topicId}/widget")
	public List<Widget> findAllWidgetForTopic(@PathVariable("topicId") Integer topicId){
		Topic t = TopicController.findTopicById(topicId);
		if(t != null)
			return new ArrayList<Widget>(t.getWidgets());
		else 
			return null;
	}
	
	@GetMapping("/api/widget/{widgetId}")
	public Widget findTopicById(@PathVariable("widgetId") Integer widgetId) {
		Optional<Widget> opt = widgetRepo.findById(widgetId);
		if(opt.isPresent())
			return opt.get();
		else 
			return null;
	}
	
	@PutMapping("/api/widget/{widgetId}")
	public Widget updateTopic(@PathVariable("widgetId") Integer widgetId, @RequestBody Widget widget) {
		Optional<Widget> opt = widgetRepo.findById(widgetId);
		if(opt.isPresent())
		{
			Widget old = opt.get();
			widget.setId(old.getId());
			widget.setTopic(old.getTopic());
			
			Widget updatedWidget = widgetRepo.save(widget);
			updatedWidget.getTopic().getWidgets().remove(old);
			updatedWidget.getTopic().getWidgets().add(updatedWidget);
			
			return updatedWidget;
		}
		else 
			return null;
	}
	
	@PutMapping("/api/topic/{topicId}/widgets")
	public List<Widget> saveWidgets(@PathVariable("topicId") Integer topicId, @RequestBody List<Widget> widgets) {
		Topic topic = TopicController.findTopicById(topicId);
		if(topic != null)
		{
			topic.getWidgets().clear();
			for(Widget w: widgets) {
				topic.addToWidgets(w);
			}
			Topic updatedTopic = topicRepo.save(topic);
			topic.getLesson().getTopics().remove(topic);
			topic.getLesson().getTopics().add(updatedTopic);
			return updatedTopic.getWidgets();
		}
		else 
			return null;
	}
	
	
	@DeleteMapping("/api/widget/{widgetId}")
	public void deleteCourse(@PathVariable("widgetId") Integer widgetId) {
		if(widgetRepo.existsById(widgetId))
			widgetRepo.deleteById(widgetId);
	}
}
