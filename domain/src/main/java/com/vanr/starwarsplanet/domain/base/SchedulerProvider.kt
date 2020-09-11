package com.vanr.starwarsplanet.domain.base

import io.reactivex.Scheduler

interface SchedulerProvider {
    fun io(): Scheduler
    fun computation(): Scheduler
    fun main(): Scheduler
    fun single(): Scheduler
}