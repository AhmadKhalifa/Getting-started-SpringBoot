package com.khalifa.hellospring.topic

import javassist.NotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TopicService {

    @Autowired
    private lateinit var topicRepository: TopicRepository

    fun getAllTopics() = topicRepository.findAll().toList()

    fun getTopic(id: String) = topicRepository.findById(id).let { result ->
        if (result.isPresent) {
            result.get()
        } else {
            throw NotFoundException("No such topic")
        }
    }

    fun addTopic(topic: Topic) = topicRepository.save(topic)

    fun updateTopic(topic: Topic) = topicRepository.save(topic)

    fun deleteTopic(id: String) = topicRepository.deleteById(id)
}