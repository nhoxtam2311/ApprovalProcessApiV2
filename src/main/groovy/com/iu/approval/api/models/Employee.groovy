package com.iu.approval.api.models

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

import com.iu.approval.api.enums.Priority
import com.iu.approval.api.enums.Status

@Entity
class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id
	String company
	String lastName
	String firstName
	String emailAddress
	String jobTitle
	String bussinessPhone
	String homePhone
	String mobilePhone
	String faxNumber
	String address
	String city
	String state
	String zip
	String country
	String webPage
	String Notes
	String userName
}

public interface EmployeeData{
	long getId()
	String getFirstName()
	String getLastName()
	String getEmailAddress()
	String getBussinessPhone()
	String getHomePhone()
	String getMobilePhone()
	String getFaxNumber()
	String getAddress()
	String getUserName()
	
	
}