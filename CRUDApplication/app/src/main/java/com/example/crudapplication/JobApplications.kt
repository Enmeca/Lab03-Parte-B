package com.example.crudapplication

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.util.Predicate

class JobApplications {

    private var applications : ArrayList<JobApplication> = ArrayList<JobApplication>()

    init{
        addApplication(JobApplication("Philippe", "Gairaud", "Addres1","Addres2",
                                       "Moravia", "San Jose", "001", "Costa Rica", "philippegq@gmail.com",
                                        "506", "89430876", "Intern", "09/12/2021" ))
        addApplication(JobApplication("Huberth", "Gonzales", "Addres1","Addres2",
            "Guadalupe", "San Jose", "002", "Costa Rica", "huberth@gmail.com",
            "506", "88888888", "Intern", "15/09/2021" ))
    }

    private object HOLDER {
        val INSTANCE = JobApplications()
    }

    companion object {
        val instance: JobApplications by lazy{
            HOLDER.INSTANCE
        }
    }

    fun addApplication(app: JobApplication){
        applications?.add(app)
    }



    fun getApplications(): ArrayList<JobApplication>{
        return this.applications!!
    }
    fun deleteJob(position: Int){
        applications!!.removeAt(position)
    }

    fun editJob(position: Int, job: JobApplication){
        applications!![position] = job

    }
    fun getJob(position: Int) : JobApplication{
        return this.applications!![position]
    }
}