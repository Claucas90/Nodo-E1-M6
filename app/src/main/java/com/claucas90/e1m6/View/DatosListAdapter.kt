package com.claucas90.e1m6.View

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.claucas90.e1m6.R
import com.claucas90.e1m6.Model.UserGame

class DatosListAdapter(private var datos: List<UserGame>) :
    RecyclerView.Adapter<DatosListAdapter.DatosViewHolder>() {

    // Declaración de la variable para el listener del botón de eliminación
    private var deleteButtonClickListener: ((String) -> Unit)? = null

    fun setDeleteButtonClickListener(listener: (String) -> Unit) {
        deleteButtonClickListener = listener
    }

    // Crea una nueva vista para cada elemento del RecyclerView
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DatosViewHolder {
        // Infla el layout del elemento de lista desde el archivo de diseño 'article_item.xml'
        val view = LayoutInflater.from(parent.context).inflate(R.layout.article_item, parent, false)
        return DatosViewHolder(view)
    }

    // Vincula los datos del elemento en la posición dada con la vista
    override fun onBindViewHolder(holder: DatosViewHolder, position: Int) {
        // Obtiene los datos actuales en la posición dada
        val currentDatos = datos[position]
        // Vincula los datos con la vista del titular de los datos
        holder.bind(currentDatos)
    }

    // Devuelve la cantidad total de elementos en la lista de datos
    override fun getItemCount(): Int = datos.size

    // Define la clase ViewHolder que representa cada elemento de la lista
    inner class DatosViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private var idEliminar: String = ""
        private val nombreTextView: TextView = view.findViewById(R.id.username)
        private val precioTextView: TextView = view.findViewById(R.id.realname)
        private val cantidadTextView: TextView = view.findViewById(R.id.age)
        private val idEliminarTextView: TextView = view.findViewById(R.id.idEliminar)
        private val deleteButton: Button = view.findViewById(R.id.deleteButton)

        fun bind(datos: UserGame) {
            // Establecer los valores de los campos de texto con los datos correspondientes
            nombreTextView.text = datos.gameName
            precioTextView.text = datos.realName
            cantidadTextView.text = datos.age.toString()
            idEliminar = datos.id.toString()

            deleteButton.setOnClickListener {
                // Aquí puedes llamar a la función deleteButtonClickListener y pasar el valor de idEliminar
                deleteButtonClickListener?.invoke(idEliminar)
            }
        }
    }
}