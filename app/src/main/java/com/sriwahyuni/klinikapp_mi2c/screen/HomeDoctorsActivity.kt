package com.sriwahyuni.klinikapp_mi2c.screen

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.GridLayoutManager
import com.sriwahyuni.klinikapp_mi2c.R
import com.sriwahyuni.klinikapp_mi2c.adapter.ListDoctorsAdapter
import com.sriwahyuni.klinikapp_mi2c.model.ModelListDoctors
import java.util.ArrayList


class HomeDoctorsActivity : AppCompatActivity() {

    private var rv_list_doctors: RecyclerView? = null
    private var homeDoctorsAdapter : ListDoctorsAdapter? =null

    private var doctorsList = mutableListOf<ModelListDoctors>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home_doctors)

        rv_list_doctors = findViewById(R.id.rv_list_doctors)
        doctorsList = ArrayList()
        homeDoctorsAdapter = ListDoctorsAdapter(this,doctorsList);
        val layoutManager: RecyclerView.LayoutManager = GridLayoutManager(this,1)
        rv_list_doctors!!.layoutManager = layoutManager
        rv_list_doctors!!.adapter = homeDoctorsAdapter

        prepareDataDoctors()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    private fun prepareDataDoctors(){
        var itemDoctors = ModelListDoctors(
            R.drawable.dokter1,
            NamaDoctor = "Rizki Syaputra",
            SpecsDoctor = "Dentist",
            JumlahReview = "120",
            JumlahRating = "5.0"
        )
        doctorsList.add(itemDoctors)
        itemDoctors = ModelListDoctors(
            R.drawable.dokter6,
            NamaDoctor = "Sri Wahyuni",
            SpecsDoctor = "Dokter Hewan",
            JumlahReview = "100",
            JumlahRating = "5.0"
        )
        doctorsList.add(itemDoctors)
        itemDoctors = ModelListDoctors(
            R.drawable.dokter3,
            NamaDoctor = "Dr.Khory",
            SpecsDoctor = "Obgxo",
            JumlahReview = "100",
            JumlahRating = "5.0"
        )
        doctorsList.add(itemDoctors)
        itemDoctors = ModelListDoctors(
            R.drawable.dokter4,
            NamaDoctor = "Dr Sintia",
            SpecsDoctor = "Dokter Gigi",
            JumlahReview = "120",
            JumlahRating = "5.0"
        )
        doctorsList.add(itemDoctors)
        itemDoctors = ModelListDoctors(
            R.drawable.dokter5,
            NamaDoctor = "Sri Wahyuni",
            SpecsDoctor = "Dokter Beda",
            JumlahReview = "120",
            JumlahRating = "5.0"
        )
        doctorsList.add(itemDoctors)

        homeDoctorsAdapter!!.notifyDataSetChanged()
    }
}