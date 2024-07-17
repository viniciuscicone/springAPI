package com.aplicacaoException.api.domain.repository;

import com.aplicacaoException.api.domain.myTask.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, String> {

}
