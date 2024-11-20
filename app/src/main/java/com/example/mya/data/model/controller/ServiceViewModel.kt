package com.example.mya.data.model.controller

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.volley.Response
import com.example.mya.data.model.ServiceModel
import com.example.mya.data.model.network.RetrofitClient
import kotlinx.coroutines.launch


class ServiceViewModel: ViewModel() {
    val api = RetrofitClient.api
    fun getServices(onResult: (Response<List<ServiceModel>>)->Unit) {
        viewModelScope.launch {
            try{
                val response = api.getServices()
                onResult(response)
            }catch(exception:Exception){
                print(exception)
            }
        }
    }
    fun showServices(id: Int, onResult: (Response<ServiceModel>)->Unit) {
        viewModelScope.launch {
            try{
                val response = api.getService(id)
                onResult(response)
            }catch(exception:Exception){
                print(exception)
            }
        }
    }
    fun createServices(service: ServiceModel,onResult: (Response<List<ServiceModel>>)->Unit) {
        viewModelScope.launch {
            try{
                val response = api.createService(service)
                onResult(response)
            }catch(exception:Exception){
                print(exception)
            }
        }
    }
    fun putServices(id: Int, service: ServiceModel,  onResult: (Response<ServiceModel>)->Unit) {
        viewModelScope.launch {
            try{
                val response = api.updateService(id, service)
                onResult(response)
            }catch(exception:Exception){
                print(exception)
            }
        }
    }
    fun deleteServices(id: Int,  onResult: (Response<ServiceModel>)->Unit) {
        viewModelScope.launch {
            try{
                val response = api.deleteService(id)
                onResult(response)
            }catch(exception:Exception){
                print(exception)
            }
        }
    }
}
