package com.example.wbdvsu119serverjava.repositories;

import com.example.wbdvsu119serverjava.models.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository
    extends CrudRepository<Course, Integer> {
}
