package com.iu.approval.api.repositories

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

import com.iu.approval.api.models.Employee
import com.iu.approval.api.models.EmployeeData

@RepositoryRestResource(excerptProjection = EmployeeData.class)
interface EmployeeRepository extends JpaRepository<Employee, Long>{
	Page<Employee> findAll(Pageable pageable)
	Page<Employee> findByUserName(String userName,Pageable pageable)
}
