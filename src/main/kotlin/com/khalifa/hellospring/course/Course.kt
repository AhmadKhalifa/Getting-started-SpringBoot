package com.khalifa.hellospring.course

import com.khalifa.hellospring.topic.Topic
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity
class Course (@Id var id: String?, var name: String?, var description: String?, topicId: String?) {

    constructor() : this(null, null, null, null)

    @ManyToOne
    var topic: Topic? = null

    init {
        topic = Topic(topicId, null, null)
    }
}