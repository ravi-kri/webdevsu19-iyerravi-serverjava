package com.example.wbdvsu119serverjava.repositories;

import com.example.wbdvsu119serverjava.models.Widget;
import org.springframework.data.repository.CrudRepository;

public interface WidgetRepository
    extends CrudRepository<Widget, Integer> {
}
