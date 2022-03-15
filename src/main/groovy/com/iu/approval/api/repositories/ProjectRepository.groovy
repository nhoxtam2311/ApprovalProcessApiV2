package com.iu.approval.api.repositories

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import org.springframework.format.annotation.DateTimeFormat

import com.iu.approval.api.enums.Status
import com.iu.approval.api.models.Project
import com.iu.approval.api.models.ProjectData

@RepositoryRestResource(excerptProjection = ProjectData.class)
interface ProjectRepository extends JpaRepository<Project, Long>{
	
	Page<Project> findByStatus(Status status,Pageable pageable)
	Page<Project> findByOwner(long owner,Pageable pageable)
	Page<Project> findAll(Pageable pageable)
	Page<Project> findByCreatedDateBetween(@DateTimeFormat(pattern = "yyyy-MM-dd") Date after, @DateTimeFormat(pattern = "yyyy-MM-dd") Date before,Pageable pageable)
	
}
