package id.rofyfirm.pokemonapps.db.pres

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface MainDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(mainEntity: MainEntity)

    @Query("SELECT * FROM tableMain")
    fun select(): LiveData<List<MainEntity>>
}