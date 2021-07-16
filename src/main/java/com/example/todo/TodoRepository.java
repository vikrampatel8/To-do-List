package com.example.todo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TodoRepository extends JpaRepository < Todo, Long > {
    
	@Query("SELECT t FROM Todo t WHERE t.email = ?1")
	List < Todo > findByEmail(String email);
}