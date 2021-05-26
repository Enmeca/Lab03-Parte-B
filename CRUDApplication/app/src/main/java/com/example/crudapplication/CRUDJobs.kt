package com.example.crudapplication

import android.graphics.Canvas
import android.graphics.Color
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import it.xabaras.android.recyclerview.swipedecorator.RecyclerViewSwipeDecorator
import java.util.*
import kotlin.collections.ArrayList

class CRUDJobs : AppCompatActivity() {

    var jobs: JobApplications = JobApplications.instance

    lateinit var lista: RecyclerView
    lateinit var adaptador:RecyclerView_Adapter
    lateinit var aplication:JobApplication
    var archived = ArrayList<JobApplication>()
    var position: Int = 0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crud_jobs)


        val searchIcon = findViewById<ImageView>(R.id.search_mag_icon)
        searchIcon.setColorFilter(Color.BLACK)


        val cancelIcon = findViewById<ImageView>(R.id.search_close_btn)
        cancelIcon.setColorFilter(Color.BLACK)


        val textView = findViewById<TextView>(R.id.search_src_text)
        textView.setTextColor(Color.BLACK)

        lista = findViewById(R.id.lista)
        lista.layoutManager = LinearLayoutManager(lista.context)
        lista.setHasFixedSize(true)

        findViewById<SearchView>(R.id.jobs_search).setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adaptador.filter.filter(newText)
                return false
            }
        })

        getListOfApplications()

        val itemTouchHelperCallback = object : ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP or ItemTouchHelper.DOWN or ItemTouchHelper.START or ItemTouchHelper.END, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {
            override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {
                val fromPosition: Int = viewHolder.adapterPosition
                val toPosition: Int = target.adapterPosition

                Collections.swap(jobs.getApplications(), fromPosition, toPosition)

                lista.adapter?.notifyItemMoved(fromPosition, toPosition)

                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {

                position = viewHolder.adapterPosition
                var quien: String = ""

                if(direction == ItemTouchHelper.LEFT){
                    aplication = JobApplication(jobs.getApplications()[position].firstName, jobs.getApplications()[position].lastName, jobs.getApplications()[position].streetAddress1, jobs.getApplications()[position].streetAddress2, jobs.getApplications()[position].city, jobs.getApplications()[position].state, jobs.getApplications()[position].postal, jobs.getApplications()[position].country, jobs.getApplications()[position].email, jobs.getApplications()[position].areaCode, jobs.getApplications()[position].phone, jobs.getApplications()[position].position, jobs.getApplications()[position].date)
                    jobs.deletePerson(position)
                    lista.adapter?.notifyItemRemoved(position)

                    Snackbar.make(lista, aplication.firstName + "Se eliminaría...", Snackbar.LENGTH_LONG).setAction("Undo") {
                        jobs.getApplications().add(position, aplication)
                        lista.adapter?.notifyItemInserted(position)
                    }.show()
                    adaptador = RecyclerView_Adapter(jobs.getPersonas())
                    lista.adapter = adaptador
                }else{
                    aplication = JobApplication(jobs.getApplications()[position].firstName, jobs.getApplications()[position].lastName, jobs.getApplications()[position].streetAddress1, jobs.getApplications()[position].streetAddress2, jobs.getApplications()[position].city, jobs.getApplications()[position].state, jobs.getApplications()[position].postal, jobs.getApplications()[position].country, jobs.getApplications()[position].email, jobs.getApplications()[position].areaCode, jobs.getApplications()[position].phone, jobs.getApplications()[position].position, jobs.getApplications()[position].date)
                    archived.add(aplication)

                    jobs.deletePerson(position)
                    lista.adapter?.notifyItemRemoved(position)

                    Snackbar.make(lista, aplication.firstName + "Se editaría...", Snackbar.LENGTH_LONG).setAction("Undo") {
                        archived.removeAt(archived.lastIndexOf(aplication))
                        jobs.getApplications().add(position, aplication)
                        lista.adapter?.notifyItemInserted(position)
                    }.show()
                    adaptador = RecyclerView_Adapter(jobs.getApplications())
                    lista.adapter = adaptador
                    //getListOfPersons()
                }
            }

            override fun onChildDraw(c: Canvas, recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, dX: Float, dY: Float, actionState: Int, isCurrentlyActive: Boolean) {

                RecyclerViewSwipeDecorator.Builder(this@CRUDJobs, c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
                    .addSwipeLeftBackgroundColor(ContextCompat.getColor(this@CRUDJobs, R.color.red))
                    .addSwipeLeftActionIcon(R.drawable.ic_baseline_delete_24)
                    .addSwipeRightBackgroundColor(ContextCompat.getColor(this@CRUDJobs, R.color.green))
                    .addSwipeRightActionIcon(R.drawable.ic_baseline_edit_24)
                    .create()
                    .decorate()
                super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
            }

        }



        val itemTouchHelper = ItemTouchHelper(itemTouchHelperCallback)
        itemTouchHelper.attachToRecyclerView(lista)


    }



    private fun getListOfApplications() {
        val Njobs = ArrayList<JobApplication>()
        for (p in jobs.getApplications()) {
            Njobs.add(p)
        }
        adaptador = RecyclerView_Adapter(Njobs)
        lista.adapter = adaptador
    }
}