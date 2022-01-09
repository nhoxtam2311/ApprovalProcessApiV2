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
	long parent
}

interface TaskData{
	long getId()
	long getProject()
	String getTitle()
	String getDescription()
	long getAssignedTo()
	String getStartDate()
	String getEndDate()
	Priority getPriority()
	Status getStatus()
	double getPercentComplete()
	double getCost()
	double getCostInDays()
	long getParent()
}
