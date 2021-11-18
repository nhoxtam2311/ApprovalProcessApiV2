package com.iu.approval.api.models

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

import com.iu.approval.api.enums.Priority
import com.iu.approval.api.enums.Status

@Entity
class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id
	long project
	String title
	String description
	long assignedTo
	String startDate
	String endDate
	Priority priority
	Status status
	double percentComplete
	double cost
	double costInDays
}
