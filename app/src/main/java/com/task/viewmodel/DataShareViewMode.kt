package com.task.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.task.model.DataShareModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class DataShareViewMode :ViewModel(){



    val dataSharingViewModel = MutableLiveData<ArrayList<DataShareModel>>()
    val leftToRight: LiveData<ArrayList<DataShareModel>> = dataSharingViewModel

    val dataSharingViewModel2 = MutableLiveData<ArrayList<DataShareModel>>()

    val rightToLeft: LiveData<ArrayList<DataShareModel>> = dataSharingViewModel2







}