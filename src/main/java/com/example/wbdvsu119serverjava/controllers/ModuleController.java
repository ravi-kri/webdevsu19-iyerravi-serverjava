package com.example.wbdvsu119serverjava.controllers;

import com.example.wbdvsu119serverjava.models.Course;
import com.example.wbdvsu119serverjava.models.Module;
import com.example.wbdvsu119serverjava.repositories.ModuleRepository;
import com.example.wbdvsu119serverjava.controllers.CourseController;
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
public class ModuleController {
	
	@Autowired
	private CourseController CourseController;
	
    @Autowired
    private ModuleRepository moduleRepo;

    @GetMapping("/api/course/{cid}/module")
	public List<Module> findAllModule(@PathVariable("cid") Integer cid){
		Course c = CourseController.findCourseById(cid);
		if(c!=null)
			return new ArrayList<Module>(c.getModules());
		return null;
	}
    
    @PostMapping("/api/course/{courseId}/module")
	public Module createModule(@PathVariable("courseId") Integer courseId, 
								@RequestBody Module module) {
			
		Course c = CourseController.findCourseById(courseId);
		module.setCourse(c);
		Module updatedModule =  moduleRepo.save(module);
		c.addToModules(updatedModule);
		return updatedModule;
	}
    @GetMapping("/api/module/{moduleId}")
	public Module findModuleById(@PathVariable("moduleId") Integer moduleId) {
		Optional<Module> opt = moduleRepo.findById(moduleId);
		if(opt.isPresent())
			return opt.get();
		else 
			return null;
	}
	
	@PutMapping("/api/module/{moduleId}")
	public Module updateModule(@PathVariable("moduleId") Integer moduleId, @RequestBody Module module) {
		Optional<Module> opt = moduleRepo.findById(moduleId);
		if(opt.isPresent())
		{
			Module old = opt.get();
			module.setId(old.getId());
			module.setCourse(old.getCourse());
			module.setLessons(old.getLessons());
			Module updatedModule = moduleRepo.save(module);
			
			updatedModule.getCourse().getModules().remove(old);
			updatedModule.getCourse().getModules().add(updatedModule);
			
			return updatedModule;
		}
		else 
			return null;
	}
	
	@DeleteMapping("/api/module/{moduleId}")
	public void deleteModule(@PathVariable("moduleId") Integer moduleId) {
		if(moduleRepo.existsById(moduleId))
			moduleRepo.deleteById(moduleId);
	}
}
