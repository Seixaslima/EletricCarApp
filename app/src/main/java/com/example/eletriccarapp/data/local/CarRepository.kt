package com.example.eletriccarapp.data.local

import android.content.ContentValues
import android.content.Context
import android.provider.BaseColumns
import android.util.Log
import com.example.eletriccarapp.data.local.carrosContract.CarEntry.COLLUMN_NAME_CAR_ID
import com.example.eletriccarapp.data.local.carrosContract.CarEntry.COLUMN_NAME_BATERIA
import com.example.eletriccarapp.data.local.carrosContract.CarEntry.COLUMN_NAME_POTENCIA
import com.example.eletriccarapp.data.local.carrosContract.CarEntry.COLUMN_NAME_PRECO
import com.example.eletriccarapp.data.local.carrosContract.CarEntry.COLUMN_NAME_RECARGA
import com.example.eletriccarapp.data.local.carrosContract.CarEntry.COLUMN_NAME_URL_PHOTO
import com.example.eletriccarapp.data.local.carrosContract.CarEntry.TABLE_NAME
import com.example.eletriccarapp.domain.Carro

class CarRepository(private val context: Context) {
    fun save(carro: Carro): Boolean {
        var isSaved = false
        try {
            val dbHelper = CarsDbHelper(context)
            val db = dbHelper.writableDatabase
            val values = ContentValues().apply {
                put(COLLUMN_NAME_CAR_ID, carro.id)
                put(COLUMN_NAME_PRECO, carro.preco)
                put(COLUMN_NAME_POTENCIA, carro.potencia)
                put(COLUMN_NAME_BATERIA, carro.bateria)
                put(COLUMN_NAME_RECARGA, carro.recarga)
                put(COLUMN_NAME_URL_PHOTO, carro.urlPhoto)

            }
            val newRegister = db?.insert(carrosContract.CarEntry.TABLE_NAME, null, values)
            if (newRegister != null) isSaved = true
        } catch (ex: Exception) {
            ex.message?.let {
                Log.e("error ao inserir dado", it)
            }

        }

        return isSaved


    }

    fun findCarById(id: Int) {
        val dbHelper = CarsDbHelper(context)
        val db = dbHelper.readableDatabase

        val columns = arrayOf(
            BaseColumns._ID,
            COLLUMN_NAME_CAR_ID,
            COLUMN_NAME_PRECO,
            COLUMN_NAME_POTENCIA,
            COLUMN_NAME_BATERIA,
            COLUMN_NAME_RECARGA,
            COLUMN_NAME_URL_PHOTO
        )

        val filter = "$COLLUMN_NAME_CAR_ID = ?"
        val filterValues = arrayOf(id.toString())
        val cursor = db.query(
            TABLE_NAME,
            columns,
            filter,
            filterValues,
            null,
            null,
            null
        )

        val carList = mutableListOf<Carro>()
        with(cursor) {
            while (moveToNext()) {
                val itemId = getLong(getColumnIndexOrThrow(COLLUMN_NAME_CAR_ID))
                val preco = getString(getColumnIndexOrThrow(COLUMN_NAME_PRECO))
                val potencia = getString(getColumnIndexOrThrow(COLUMN_NAME_POTENCIA))
                val bateria = getString(getColumnIndexOrThrow(COLUMN_NAME_BATERIA))
                val recarga = getString(getColumnIndexOrThrow(COLUMN_NAME_RECARGA))
                val urlPhoto = getString(getColumnIndexOrThrow(COLUMN_NAME_URL_PHOTO))
                carList.add(
                    Carro(
                        id = itemId.toInt(),
                        preco = preco,
                        bateria = bateria,
                        potencia = potencia,
                        recarga = recarga,
                        urlPhoto = urlPhoto,
                        isFavorite = true
                    )
                )

            }
            cursor.close()
        }
    }
}