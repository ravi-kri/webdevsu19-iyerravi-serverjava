package com.example.wbdvsu119serverjava.repositories;

import com.example.wbdvsu119serverjava.models.Lesson;
import org.springframework.data.repository.CrudRepository;

public interface LessonRepository
    extends CrudRepository<Lesson, Integer> {
}
