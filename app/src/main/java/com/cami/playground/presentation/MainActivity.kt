package com.cami.playground.presentation

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.cami.playground.R
import com.cami.playground.databinding.ActivityMainBinding
import timber.log.Timber
import kotlin.time.TimeSource.Monotonic.markNow

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.buttonFirst.setOnClickListener {
            val mark = markNow()
            Timber.d("Launching FirstActivity at $mark")

            Intent(this, FirstActivity::class.java).also {
                val bundle = Bundle().apply {
                    putString("time", mark.toString())
                }

                it.putExtras(bundle)
                startActivity(it)
            }
        }
    }
}
