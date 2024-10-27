package com.sriwahyuni.klinikapp_mi2c.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.sriwahyuni.klinikapp_mi2c.DetailDoctors
import com.sriwahyuni.klinikapp_mi2c.R
import com.sriwahyuni.klinikapp_mi2c.model.ModelListDoctors
import com.sriwahyuni.klinikapp_mi2c.screen.HomeDoctorsActivity


class ListDoctorsAdapter (
    val getActivityDetail : HomeDoctorsActivity,
    val itemDoctorList: List<ModelListDoctors>
) : RecyclerView.Adapter<ListDoctorsAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgItemDoctors: ImageView = itemView.findViewById(R.id.imgDoctor)
        var txtNamaDoctors: TextView = itemView.findViewById(R.id.txtNamaDoctor)
        var txtSpesDoctors: TextView = itemView.findViewById(R.id.txtSpesDoctor)
        var txtReviewDoctors: TextView = itemView.findViewById(R.id.txtReviewDoctor)
        var txtJumlahRanting: TextView = itemView.findViewById(R.id.txtJumlahRanting)
        var cardDoctor: CardView = itemView.findViewById(R.id.cardDoctor)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val nView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list_doctors, parent, false)
        return MyViewHolder(nView)
    }

    override fun getItemCount(): Int {
        return itemDoctorList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = itemDoctorList[position]
        holder.txtNamaDoctors.text = currentItem.NamaDoctor
        holder.txtSpesDoctors.text = currentItem.SpecsDoctor
        holder.txtReviewDoctors.text = currentItem.JumlahReview
        holder.txtJumlahRanting.text = currentItem.JumlahRating
        holder.imgItemDoctors.setImageResource(currentItem.ImgDoctor)

        holder.cardDoctor.setOnClickListener(){

            //deklarasi intent
            val intent = Intent(getActivityDetail, DetailDoctors::class.java)
            //put Extra
            intent.putExtra("ImgDoctor", itemDoctorList[position].ImgDoctor)
            intent.putExtra("NamaDoctor",itemDoctorList[position].NamaDoctor)
            intent.putExtra("Spesdoctors",itemDoctorList[position].SpecsDoctor)
            intent.putExtra("JumlahReview",itemDoctorList[position].JumlahReview)
            intent.putExtra("JumlahRating",itemDoctorList[position].JumlahRating)
            //intent.putExtra("judul",itemList[position].judul)
            // start pindah ke detail
            getActivityDetail.startActivity(intent)

            Toast.makeText(getActivityDetail,itemDoctorList[position].NamaDoctor, Toast.LENGTH_SHORT).show()

        }
    }
}