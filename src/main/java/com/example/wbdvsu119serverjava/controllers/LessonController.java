package com.example.wbdvsu119serverjava.controllers;

import com.example.wbdvsu119serverjava.models.Lesson;
import com.example.wbdvsu119serverjava.models.Module;
import com.example.wbdvsu119serverjava.repositories.LessonRepository;
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
public class LessonController {
	
	@Autowired
	private ModuleController ModuleController;
	
    @Autowired
    private LessonRepository lessonRepo;

    @PostMapping("/api/module/{moduleId}/lesson")
	public Lesson createLesson(@PathVariable("moduleId") Integer moduleId, 
								@RequestBody Lesson lesson) {
		
		Module m = ModuleController.findModuleById(moduleId);
		lesson.setModule(m);
		Lesson updatedLesson =  lessonRepo.save(lesson);
		m.addToLessons(updatedLesson);
		return updatedLesson;
	}
	
	@GetMapping("/api/module/{mid}/lesson")
	public List<Lesson> findAllLesson(@PathVariable("mid") Integer mid){
		Module m = ModuleController.findModuleById(mid);
		if(m!=null)
			return new ArrayList<Lesson>(m.getLessons());
		else 
			return null;
	}
	
	@GetMapping("/api/lesson/{lessonId}")
	public Lesson findLessonById(@PathVariable("lessonId") Integer lessonId) {
		Optional<Lesson> opt = lessonRepo.findById(lessonId);
		if(opt.isPresent())
			return opt.get();
		else 
			return null;
	}
	
	@PutMapping("/api/lesson/{lessonId}")
	public Lesson updateLesson(@PathVariable("lessonId") Integer lessonId, @RequestBody Lesson lesson) {
		Optional<Lesson> opt = lessonRepo.findById(lessonId);
		if(opt.isPresent())
		{
			Lesson old = opt.get();
			lesson.setId(old.getId());
			lesson.setModule(old.getModule());
			lesson.setTopics(old.getTopics());
			
			Lesson updatedLesson = lessonRepo.save(lesson);
			
			updatedLesson.getModule().getLessons().remove(old);
			updatedLesson.getModule().getLessons().add(updatedLesson);
			
			return updatedLesson;
		}
		else 
			return null;
	}
	
	@DeleteMapping("/api/lesson/{lessonId}")
	public void deleteLesson(@PathVariable("lessonId") Integer lessonId) {
		if(lessonRepo.existsById(lessonId))
			lessonRepo.deleteById(lessonId);
	}
}
