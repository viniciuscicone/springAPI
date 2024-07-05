package com.booksproject.api.domain.repository;

import com.booksproject.api.domain.lib.TaskClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<TaskClass, String> {


}
