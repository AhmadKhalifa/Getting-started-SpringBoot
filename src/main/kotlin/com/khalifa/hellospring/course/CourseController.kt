package com.khalifa.hellospring.course

import com.khalifa.hellospring.topic.Topic
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/topics/{topicId}/courses")
class CourseController {

    @Autowired
    private lateinit var courseService: CourseService

    @RequestMapping(method = [RequestMethod.GET], value = ["", "/"])
    fun getAllCourses(@PathVariable topicId: String) = courseService.getAllCourses(topicId)

    @RequestMapping(method = [RequestMethod.GET], value = ["/{courseId}"])
    fun getCourse(@PathVariable courseId: String) = courseService.getCourse(courseId)

    @RequestMapping(method = [RequestMethod.POST], value = ["", "/"])
    fun addCourse(@PathVariable topicId: String, @RequestBody course: Course?) =
            course?.apply { topic = Topic(topicId, null, null) }?.run(courseService::addCourse)

    @RequestMapping(method = [RequestMethod.PUT], value = ["/{courseId}"])
    fun updateCourse(@PathVariable topicId: String, @PathVariable courseId: String, @RequestBody course: Course?) =
            course?.apply { topic = Topic(topicId, null, null) }?.run(courseService::updateCourse)

    @RequestMapping(method = [RequestMethod.DELETE], value = ["/{courseId}"])
    fun deleteCourse(@PathVariable courseId: String) = courseService.deleteCourse(courseId)
}