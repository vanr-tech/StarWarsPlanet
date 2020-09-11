package com.vanr.starwarsplanet.domain.usecases.resident.getresident

import com.vanr.starwarsplanet.domain.base.BaseUseCase
import com.vanr.starwarsplanet.domain.base.SchedulerProvider
import com.vanr.starwarsplanet.domain.repositories.ResidentRepository
import com.vanr.starwarsplanet.domain.repositories.model.resident.Resident
import io.reactivex.Flowable
import javax.inject.Inject

class DefaultGetResidentUseCase @Inject constructor(
    schedulerProvider: SchedulerProvider,
    var repository: ResidentRepository
) : BaseUseCase<Int, Resident>(schedulerProvider), GetResidentUseCase {

    override fun buildUseCase(arg: Int): Flowable<Resident> {
        return repository.getResidentInfo(arg).toFlowable()
    }
}