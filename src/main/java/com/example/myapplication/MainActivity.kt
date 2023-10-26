package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val animalList = listOf(
            Animal("Chuck", "A cat.", "Chuck is a clever cat.", R.drawable.cat1, R.drawable.cat1_full),
            Animal("Fantik", "A cat.", "Fantik is an observant cat.", R.drawable.cat2, R.drawable.cat2_full),
            Animal("Persik", "Also a cat.", "Persik is a sleepy cat.", R.drawable.cat3, R.drawable.cat3_full)
        )

        val button1 = findViewById<Button>(R.id.detailsButton1)
        val button2 = findViewById<Button>(R.id.detailsButton2)
        val button3 = findViewById<Button>(R.id.detailsButton3)

        findViewById<ImageView>(R.id.imageView1).setImageResource(animalList[0].imageSmall)
        findViewById<ImageView>(R.id.imageView2).setImageResource(animalList[1].imageSmall)
        findViewById<ImageView>(R.id.imageView3).setImageResource(animalList[2].imageSmall)

        findViewById<TextView>(R.id.name1).text = animalList[0].name
        findViewById<TextView>(R.id.name2).text = animalList[1].name
        findViewById<TextView>(R.id.name3).text = animalList[2].name

        findViewById<TextView>(R.id.description1).text = animalList[0].shortDescription
        findViewById<TextView>(R.id.description2).text = animalList[1].shortDescription
        findViewById<TextView>(R.id.description3).text = animalList[2].shortDescription



        button1.setOnClickListener {
            navigateToDetail(animalList[0])
        }

        button2.setOnClickListener {
            navigateToDetail(animalList[1])
        }

        button3.setOnClickListener {
            navigateToDetail(animalList[2])
        }
    }

    private fun navigateToDetail(animal: Animal) {
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("name", animal.name)
        intent.putExtra("description", animal.longDescription)
        intent.putExtra("imageResource", animal.imageBig)
        startActivity(intent)
    }
}