package com.khalifa.hellospring.topic

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/topics")
class TopicController {

    @Autowired
    private lateinit var topicService: TopicService

    @RequestMapping(method = [RequestMethod.GET], value = ["", "/"])
    fun getAllTopics() = topicService.getAllTopics()

    @RequestMapping(method = [RequestMethod.GET], value = ["/{topicId}"])
    fun getTopic(@PathVariable topicId: String) = topicService.getTopic(topicId)

    @RequestMapping(method = [RequestMethod.POST], value = ["", "/"])
    fun addTopic(@RequestBody topic: Topic?) = topic?.run(topicService::addTopic)

    @RequestMapping(method = [RequestMethod.PUT], value = ["/{topicId}"])
    fun updateTopic(@PathVariable topicId: String, @RequestBody topic: Topic?) = topic?.run(topicService::updateTopic)

    @RequestMapping(method = [RequestMethod.DELETE], value = ["/{topicId}"])
    fun deleteTopic(@PathVariable topicId: String) = topicService.deleteTopic(topicId)
}