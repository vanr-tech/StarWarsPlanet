package com.vanr.starwarsplanet.base.scheduling

import com.vanr.starwarsplanet.domain.base.SchedulerProvider
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class AndroidSchedulerProvider @Inject constructor() : SchedulerProvider {
    override fun io(): Scheduler {
        return Schedulers.io()
    }

    override fun computation(): Scheduler {
        return Schedulers.computation()
    }

    override fun main(): Scheduler {
        return AndroidSchedulers.mainThread()
    }

    override fun single(): Scheduler {
        return Schedulers.single()
    }
}