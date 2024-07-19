package com.cami.playground.presentation

import android.content.Intent
import android.net.Uri
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
            Timber.d("Launching FirstActivity at ${mark.elapsedNow()}")

            Intent(this, FirstActivity::class.java).also {
                val bundle = Bundle().apply {
                    putString("time", mark.toString())
                }

                it.putExtras(bundle)
                startActivity(it)
            }
        }

        binding.buttonDeeplink.setOnClickListener {
            val explicitIntent = Uri.parse(
                "https://www.mercadopago.com.br/payments/82625702755/ticket?caller_id=86100721&payment_me[%E2%80%A6]_id=10377982843&hash=bf225f33-c8b7-46e5-ab2b-6e105a19f965"
            ).let { link ->
                Intent(Intent.ACTION_VIEW, link)
            }

            startActivity(explicitIntent)
        }
    }
}
