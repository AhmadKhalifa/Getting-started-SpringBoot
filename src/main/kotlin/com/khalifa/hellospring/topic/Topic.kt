package com.khalifa.hellospring.topic

import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Topic (@Id var id: String?, var name: String?, var description: String?) {

    constructor() : this(null, null, null)
}