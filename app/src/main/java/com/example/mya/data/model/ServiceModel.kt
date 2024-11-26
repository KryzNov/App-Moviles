package com.example.mya.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

data class ServiceModel(
    var id: Int=0,
    var name: String="",
    var username:String="",
    var password:String="",
    var description: String="",
    var imageURL:String? = null
)
@Entity
data class ServiceEntity(
    @PrimaryKey var id: Int,
    @ColumnInfo (name= "name") var name: String,
    @ColumnInfo (name= "username") var username:String,
    @ColumnInfo (name= "password") var password:String,
    @ColumnInfo (name= "description") var description: String,
    @ColumnInfo (name= "imageURL") var imageURL:String?
)
fun ServiceModel.toServiceEntity(): ServiceEntity{
    return ServiceEntity (
        id= this.id,
        name = this.name,
        username = this.username,
        password = this.password,
        description = this.description,
        imageURL = this.imageURL
    )
}
fun List<ServiceModel>.toServiceEntityList(): List<ServiceEntity>{
    return this.map { it.toServiceEntity() }
}