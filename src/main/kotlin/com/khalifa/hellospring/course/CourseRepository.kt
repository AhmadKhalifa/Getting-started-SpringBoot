package com.khalifa.hellospring.course

import org.springframework.data.repository.CrudRepository

interface CourseRepository : CrudRepository<Course, String> {

    fun findAllByTopicId(topicId: String): List<Course>
}