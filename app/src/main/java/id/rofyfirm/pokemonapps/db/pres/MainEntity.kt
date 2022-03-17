package id.rofyfirm.pokemonapps.db.pres

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tableMain")
data class MainEntity (
    @PrimaryKey(autoGenerate = false)
    val name: String,
)