package com.iu.approval.api.graphql

import org.springframework.stereotype.Component

import com.coxautodev.graphql.tools.GraphQLResolver
import com.iu.approval.api.models.Employee

@Component
class EmployeeResolver implements GraphQLResolver<Employee>{
}
