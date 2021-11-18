package com.iu.approval.api.graphql

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import com.coxautodev.graphql.tools.GraphQLResolver
import com.iu.approval.api.models.Employee
import com.iu.approval.api.models.Project
import com.iu.approval.api.repositories.EmployeeRepository

@Component
class ProjectResolver implements GraphQLResolver<Project>{
	@Autowired
	EmployeeRepository employeeRepository
	
	Employee getProjectOwner(Project project){
		Optional<Employee> optional = employeeRepository.findById(project.owner)
		if(optional.isEmpty()) {
			return null
		}
		optional.get()
	}
}
