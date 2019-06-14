package com.example.wbdvsu119serverjava.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.wbdvsu119serverjava.models.*;

public interface ImageWidgetRepository extends WidgetBaseRepository<ImageWidget>{
	@Query("SELECT widget FROM ImageWidget widget WHERE widget.topic.id=:topicId")
	public List<Widget> findAllWidgetsForTopic(@Param("topicId") Integer topicId);
}
