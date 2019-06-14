package com.example.wbdvsu119serverjava.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.wbdvsu119serverjava.models.*;
import com.example.wbdvsu119serverjava.repositories.*;

@Service
@RestController
@CrossOrigin("*")
public class ListWidgetController {
	@Autowired
	private TopicController topicService;
	@Autowired
	private ListWidgetRepository widgetRepo;
	
	@PostMapping("/api/topic/{topicId}/list/widget")
	public ListWidget createWidget(@PathVariable("topicId") Integer topicId, 
								@RequestBody ListWidget widget) {
			
		Topic t = topicService.findTopicById(topicId);
		if(t==null) return null;
		widget.setTopic(t);
		ListWidget updatedWidget = widgetRepo.save(widget);
		t.addToWidgets(updatedWidget);
		return updatedWidget;
	}
	
	@GetMapping("/api/topic/{topicId}/list/widget")
	public List<Widget> findAllWidget(@PathVariable("topicId") Integer topicId){
		return widgetRepo.findAllWidgetsForTopic(topicId);
	}
	
	@GetMapping("/api/list/widget/{widgetId}")
	public ListWidget findWidgetById(@PathVariable("widgetId") Integer widgetId) {
		Optional<ListWidget> opt = widgetRepo.findById(widgetId);
		if(opt.isPresent())
			return opt.get();
		else 
			return null;
	}
	
	@PutMapping("/api/list/widget/{widgetId}")
	public ListWidget updateWidget(@PathVariable("widgetId") Integer widgetId, @RequestBody ListWidget widget) {
		Optional<ListWidget> opt = widgetRepo.findById(widgetId);
		if(opt.isPresent())
		{
			Widget old = opt.get();
			widget.setId(old.getId());
			widget.setTopic(old.getTopic());
			
			ListWidget updatedWidget = widgetRepo.save(widget);
			updatedWidget.getTopic().getWidgets().remove(old);
			updatedWidget.getTopic().getWidgets().add(updatedWidget);
			
			return updatedWidget;
		}
		else 
			return null;
	}
	
	
	@DeleteMapping("/api/list/widget/{widgetId}")
	public void deleteWidget(@PathVariable("widgetId") Integer widgetId) {
		if(widgetRepo.existsById(widgetId))
			widgetRepo.deleteById(widgetId);
	}
}