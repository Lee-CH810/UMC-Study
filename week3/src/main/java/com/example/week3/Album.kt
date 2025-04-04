package com.example.week3

import androidx.room.Entity
import androidx.room.PrimaryKey

// roomDB : (key,value)의 쌍으로 저장하는 것이 아니라, 방대한 데이터를 위해 사용하는 DB
// Entity : 데이터베이스의 테이블과 같은 개념.
// 데이터베이스의 테이블로 삼고 싶은 data class를 선언
// 해당 data class에 @Entity를 붙이고, 테이블의 이름을 지정
// PrimayKey : 테이블의 key. 유일한 값.
@Entity(tableName = "AlbumTable")
data class Album(
    // album의 pk는 임의로 지정해 줄 것이므로, autoGenerate 하지 않음.
    @PrimaryKey(autoGenerate = false) var id: Int = 0,
    var title: String? = "",
    var singer: String? = "",
    var coverImage: Int? = null
)
