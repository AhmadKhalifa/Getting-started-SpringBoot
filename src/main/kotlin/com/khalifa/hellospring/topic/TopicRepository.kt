package com.khalifa.hellospring.topic

import org.springframework.data.repository.CrudRepository

interface TopicRepository : CrudRepository<Topic, String>