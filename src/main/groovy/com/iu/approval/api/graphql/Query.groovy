package com.iu.approval.api.graphql

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import com.iu.approval.api.models.Employee
import com.iu.approval.api.models.Project
import com.iu.approval.api.models.Task
import com.iu.approval.api.repositories.EmployeeRepository
import com.iu.approval.api.repositories.ProjectRepository
import com.iu.approval.api.repositories.TaskRepository

@Component
class Query implements GraphQLQueryResolver{
	
	@Autowired
	ProjectRepository projectRepository;
	
	@Autowired
	TaskRepository taskRepository;
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	List<Project>allProjects(){
		projectRepository.findAll()
	}
	
	List<Task>allTasks(){
		taskRepository.findAll()
	}
	
	List<Employee>allEmployee(){
		employeeRepository.findAll()
	}
}
