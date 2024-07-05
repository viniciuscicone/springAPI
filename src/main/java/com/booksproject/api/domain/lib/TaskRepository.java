package com.booksproject.api.domain.lib;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<TaskClass, String> {


}
