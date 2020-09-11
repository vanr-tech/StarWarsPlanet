package com.vanr.starwarsplanet.ui.main.residentDetails

import androidx.lifecycle.MutableLiveData
import com.vanr.starwarsplanet.base.ui.BaseViewModel
import com.vanr.starwarsplanet.domain.repositories.model.resident.Resident
import com.vanr.starwarsplanet.domain.usecases.resident.getresident.GetResidentUseCase
import javax.inject.Inject

class ResidentDetailsViewModel @Inject constructor(val getResidentUseCase: GetResidentUseCase) : BaseViewModel() {

    val residentLiveData: MutableLiveData<Resident> = MutableLiveData();

    fun getResidentDetails(residentId: Int) {
        addDisposable(getResidentUseCase.asSingle(residentId).subscribe(
            this::setResidentLiveData,
            this::handleError
        ))
    }

    private fun setResidentLiveData(resident: Resident) {
        this.residentLiveData.postValue(resident);
    }

}