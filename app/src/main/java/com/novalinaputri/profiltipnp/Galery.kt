package com.novalinaputri.profiltipnp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.GridView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.novalinaputri.profiltipnp.Adapter.GaleryAdapter

class Galery : AppCompatActivity() {
    private val imageList = arrayOf(
        R.drawable.pkmpnp,
        R.drawable.programstudi,
        R.drawable.ti,
        R.drawable.labor,
        R.drawable.lomba,
        R.drawable.lomba3,
        R.drawable.lomba2,
        R.drawable.lomba3,
        R.drawable.lomba4,
        R.drawable.lomba5,

    )
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_galery)

        val gridView = findViewById<GridView>(R.id.gridView)
        val adapter =GaleryAdapter(this, imageList)
        gridView.adapter = adapter

        // Set up onClickListener for grid items
        gridView.setOnItemClickListener { _, _, position, _ ->
            val Intent = Intent(this, PhotoDetail::class.java)
            Intent.putExtra("imageResId", imageList[position]) // Pass the selected image ID to detail activity
            startActivity(Intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}