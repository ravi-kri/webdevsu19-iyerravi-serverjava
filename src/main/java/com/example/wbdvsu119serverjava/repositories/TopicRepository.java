package com.example.wbdvsu119serverjava.repositories;

import com.example.wbdvsu119serverjava.models.Topic;
import org.springframework.data.repository.CrudRepository;

public interface TopicRepository
    extends CrudRepository<Topic, Integer> {
}
