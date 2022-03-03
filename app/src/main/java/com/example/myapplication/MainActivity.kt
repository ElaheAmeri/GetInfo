package com.example.myapplication

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val infoSharedPreferences="info"
        var sharedPreferences: SharedPreferences =getSharedPreferences(infoSharedPreferences,0)
        binding.submitInformation.setOnClickListener(){
            var shareEditore :SharedPreferences.Editor = sharedPreferences.edit()
            shareEditore.putString("Name",binding.editTextName.text.toString())
            shareEditore.putInt("NationalCode",binding.editTextNationalCode.text.toString().toInt())
            shareEditore.putString("PlaceOfBirth",binding.editTextTextPlaceOfBirth.text.toString())
            shareEditore.putString("Adress",binding.editTextTextAdress.text.toString())
            shareEditore.putInt("PostalCode",binding.editTextPostalCode.text.toString().toInt())
            shareEditore.apply()
            shareEditore.commit()
            Toast.makeText(this,"اطلاعات با موفقیت ذخیره شد",Toast.LENGTH_LONG).show()
            var name = sharedPreferences.getString("Name","")
            if (name.isNullOrBlank()){
                binding.editTextName.error="نام را وارد کنید"
            }
            var nationalCode=sharedPreferences.getInt("NationalCode",-1)
            var placeOfBirth=sharedPreferences.getString("PlaceOfBirth","")
            if (placeOfBirth.isNullOrBlank()){
                binding.editTextName.error="محل تولد را وارد کنید"
            }
            var adress= sharedPreferences.getString("Adress","")
            if (adress.isNullOrBlank()){
                binding.editTextName.error="محل تولد را وارد کنید"
            }
            var postalCode=sharedPreferences.getInt("PostalCode",-1)
        }
    }
}