package com.iu.approval.api.repositories

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

import com.iu.approval.api.models.Task
import com.iu.approval.api.models.TaskData

@RepositoryRestResource(excerptProjection = TaskData.class)
interface TaskRepository extends JpaRepository<Task, Long>{
	
	List<Task> findByProject(long project)
	List<Task> findByParent(long parent)
}

