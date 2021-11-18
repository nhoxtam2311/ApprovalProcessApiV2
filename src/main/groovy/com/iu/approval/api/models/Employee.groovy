package com.iu.approval.api.models

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

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
}
