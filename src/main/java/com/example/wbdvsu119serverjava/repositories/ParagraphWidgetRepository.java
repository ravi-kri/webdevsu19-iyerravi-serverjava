package com.example.wbdvsu119serverjava.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.wbdvsu119serverjava.models.*;

public interface ParagraphWidgetRepository extends WidgetBaseRepository<ParagraphWidget>{
	@Query("SELECT widget FROM ParagraphWidget widget WHERE widget.topic.id=:topicId")
	public List<Widget> findAllWidgetsForTopic(@Param("topicId") Integer topicId);
}
