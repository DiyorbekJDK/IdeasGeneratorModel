package com.example.ideasgeneratormodel

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ideasgeneratormodel.databinding.ActivityMainBinding
import java.io.IOException
import java.io.InputStream
import java.util.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            randomWord()
        }

    }

    private fun randomWord() {
        val myOutput: String
        val myInputStream: InputStream

        try {
            myInputStream = assets.open("words.txt")
            val size: Int = myInputStream.available()
            val buffer = ByteArray(size)
            myInputStream.read(buffer)
            myOutput = String(buffer)

            // Split the string into an array of words.
            val words = myOutput.split(" ")

            // Get a random word from the array.
            val randomWord = words.random()

            // Display the random word in the text view.
            binding.textView.text = randomWord
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}