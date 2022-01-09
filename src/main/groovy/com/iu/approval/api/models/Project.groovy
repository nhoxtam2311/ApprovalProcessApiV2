package com.iu.approval.api.models

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

import com.iu.approval.api.enums.Priority
import com.iu.approval.api.enums.Status

@Entity
class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id
	String projectName
	long owner
	String category
	Priority priority
	Status status
	Date startDate
	Date endDate
	double budget
	double budgetInDays
	String notes
}

public interface ProjectData{
	long getId()
	String getProjectName()
	long getOwner()
	String getCategory()
	Priority getPriority()
	Status getStatus()
	Date getStartDate()
	Date getEndDate()
	double getBudget()
	double getBudgetInDays()
	String getNotes()
}