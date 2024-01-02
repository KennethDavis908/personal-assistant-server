package com.davis.todolist;

import com.davis.models.ToDoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface ToDoListRepository extends JpaRepository<ToDoList, Integer> {
    Optional<ToDoList> findByCreatedOnAndUserId(LocalDate date, String userId);
}
