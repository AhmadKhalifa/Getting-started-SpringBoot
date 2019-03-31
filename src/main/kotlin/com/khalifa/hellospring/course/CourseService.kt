package com.khalifa.hellospring.course

import javassist.NotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CourseService {

    @Autowired
    private lateinit var courseRepository: CourseRepository

    fun getAllCourses(topicId: String) = courseRepository.findAllByTopicId(topicId).toList()

    fun getCourse(courseId: String) = courseRepository.findById(courseId).let { result ->
        if (result.isPresent) {
            result.get()
        } else {
            throw NotFoundException("No such course")
        }
    }

    fun addCourse(course: Course) = courseRepository.save(course)

    fun updateCourse(course: Course) = courseRepository.save(course)

    fun deleteCourse(id: String) = courseRepository.deleteById(id)
}