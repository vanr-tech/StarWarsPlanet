package com.vanr.starwarsplanet.domain.base

import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.FlowableTransformer
import io.reactivex.Single

abstract class BaseUseCase<ARG, RESULT> {

    var schedulerProvider: SchedulerProvider

    constructor(schedulerProvider: SchedulerProvider) {
        this.schedulerProvider = schedulerProvider
    }

    abstract fun buildUseCase(arg: ARG): Flowable<RESULT>

    fun asSingle(arg: ARG): Single<RESULT> {
       return asFlowable(arg).singleOrError()
    }

    fun asCompletable(arg: ARG): Completable {
        return asFlowable(arg).flatMapCompletable { Completable.complete() }
    }

    private fun asFlowable(arg: ARG): Flowable<RESULT> {
        return buildUseCase(arg)
            .compose(applySchedulers())
    }

    private fun <T> applySchedulers(): FlowableTransformer<T, T> {
        return FlowableTransformer { observable ->
            observable
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.main())
        }
    }
}