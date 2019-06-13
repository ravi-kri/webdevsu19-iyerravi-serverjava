package com.example.wbdvsu119serverjava.controllers;

import com.example.wbdvsu119serverjava.models.Course;
import com.example.wbdvsu119serverjava.models.Module;
import com.example.wbdvsu119serverjava.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

@RestController
@CrossOrigin("*")
public class CourseController {
    @Autowired
    CourseRepository repository;

    @GetMapping("/api/course")
    public List<Course> findAllCourses() {
        return (List<Course>)repository.findAll();
    }
    
    @GetMapping("/api/course/{courseId}")
	public Course findCourseById(@PathVariable("courseId") Integer courseId) {
		Optional<Course> opt = repository.findById(courseId);
		if(opt.isPresent())
			return opt.get();
		else 
			return null;
	}
    
    @PostMapping("/api/course")
	public Course createCourse(@RequestBody Course course, HttpSession session) {
		if(course.getModules() != null)
		{
			for(Module m : course.getModules())
				course.addToModules(m);
		}
		return repository.save(course);
	}
    
    @PutMapping("/api/course/{courseId}")
	public Course updateCourse(@PathVariable("courseId") Integer courseId, @RequestBody Course course) {
		Optional<Course> opt = repository.findById(courseId);
		if(opt.isPresent())
		{
			Course old = opt.get();
			course.setModules(old.getModules());
			course.setId(old.getId());
			return repository.save(course);
		}
		else 
			return null;
	}
	
	@DeleteMapping("/api/course/{courseId}")
	public void deleteCourse(@PathVariable("courseId") Integer courseId) {
		if(repository.existsById(courseId))
			repository.deleteById(courseId);
	}
    
}
