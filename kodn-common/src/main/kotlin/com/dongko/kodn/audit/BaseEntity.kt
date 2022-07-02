package com.dongko.kodn.audit

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.domain.AbstractAggregateRoot
import java.time.Instant
import javax.persistence.Column
import javax.persistence.MappedSuperclass

@MappedSuperclass
open class BaseEntity<T>: AbstractAggregateRoot<BaseEntity<T>>() {
    @CreatedDate
    @Column(updatable = false)
    var createdAt: Instant = Instant.now()

    @LastModifiedDate
    var modifiedAt: Instant? = null
}
