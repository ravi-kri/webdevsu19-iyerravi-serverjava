package com.example.wbdvsu119serverjava.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;


import com.example.wbdvsu119serverjava.models.*;;

@NoRepositoryBean
public interface WidgetBaseRepository<T extends Widget> extends CrudRepository<T, Integer>{
	
}
