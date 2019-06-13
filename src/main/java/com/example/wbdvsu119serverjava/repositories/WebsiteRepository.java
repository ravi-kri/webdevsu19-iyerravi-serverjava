package com.example.wbdvsu119serverjava.repositories;

import com.example.wbdvsu119serverjava.models.content.Website;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WebsiteRepository extends CrudRepository<Website, Integer> {
    @Query("select website from Website website")
    public List<Website> findAllWebsites();
}
