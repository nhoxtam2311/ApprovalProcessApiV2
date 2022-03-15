package com.iu.approval.api.repositories

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import org.springframework.format.annotation.DateTimeFormat

import com.iu.approval.api.enums.Status
import com.iu.approval.api.models.Project
import com.iu.approval.api.models.Task
import com.iu.approval.api.models.TaskData

@RepositoryRestResource(excerptProjection = TaskData.class)
interface TaskRepository extends JpaRepository<Task, Long>{
	
	Page<Task> findByProject(long project,Pageable pageable)
	Page<Task> findByParent(long parent,Pageable pageable)
	Page<Task> findByAssignedTo(long assignedTo,Pageable pageable)
	Page<Task> findAll(Pageable pageable)
	Page<Task> findByStatus(Status status,Pageable pageable)
	Page<Task> findByCreatedDateBetween(@DateTimeFormat(pattern = "yyyy-MM-dd") Date after, @DateTimeFormat(pattern = "yyyy-MM-dd") Date before,Pageable pageable)
	
}

