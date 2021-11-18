package com.iu.approval.api.repositories

import org.springframework.data.jpa.repository.JpaRepository

import com.iu.approval.api.models.Task

interface TaskRepository extends JpaRepository<Task, Long>{
}
