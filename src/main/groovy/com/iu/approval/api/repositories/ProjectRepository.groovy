package com.iu.approval.api.repositories

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

import com.iu.approval.api.enums.Status
import com.iu.approval.api.models.Project
import com.iu.approval.api.models.ProjectData

@RepositoryRestResource(excerptProjection = ProjectData.class)
interface ProjectRepository extends JpaRepository<Project, Long>{
	
	List<Project> findByStatus(Status status)
	List<Project> findByOwner(long owner)
}
