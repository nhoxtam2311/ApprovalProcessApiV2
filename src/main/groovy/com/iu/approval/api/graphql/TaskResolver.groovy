package com.iu.approval.api.graphql

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import com.coxautodev.graphql.tools.GraphQLResolver
import com.iu.approval.api.models.Employee
import com.iu.approval.api.models.Project
import com.iu.approval.api.models.Task
import com.iu.approval.api.repositories.EmployeeRepository
import com.iu.approval.api.repositories.ProjectRepository
import com.iu.approval.api.repositories.TaskRepository

@Component
class TaskResolver implements GraphQLResolver<Task>{
	
	@Autowired
	ProjectRepository projectRepository
		
	@Autowired
	EmployeeRepository employeeRepository
	
	Project getProject(Task task) {
		Optional<Project> optional = projectRepository.findById(task.project)
		if(optional.isEmpty()) {
			return null
		}
		optional.get()
	}
	
	Employee getAssignedTo(Task task) {
		Optional<Employee> optional = employeeRepository.findById(task.assignedTo)
		if(optional.isEmpty()) {
			return null
		}
		optional.get()
	}
}
