package ru.zatsoft.lifecycle

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import ru.zatsoft.lifecycle.databinding.ActivityIndexBodyBinding

class IndexBody : AppCompatActivity() {
    private lateinit var binding: ActivityIndexBodyBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIndexBodyBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val height = intent.getDoubleExtra("height", 0.0) / 100.0
        val weight = intent.getDoubleExtra("weight", 0.0)
        val indexBody = weight / height / height
        println(indexBody)
        binding.textView.text = "Ваш индекс тела ${indexBody}"
        val imageResource = when {
            indexBody <= 8.0 -> R.drawable.ic_invalide_foreground
            indexBody <= 12.0 -> R.drawable.body_mass_index_s
            indexBody <= 15.0 -> R.drawable.body_mass_index_dn
            indexBody <= 20.0 -> R.drawable.body_mass_index_n
            indexBody <= 25.0 -> R.drawable.body_mass_index_un
            indexBody <= 30.0 -> R.drawable.body_mass_index_o1
            indexBody <= 35.0 -> R.drawable.body_mass_index_o2
            indexBody > 35.0 -> R.drawable.body_mass_index_o3
            else -> R.drawable.ic_invalide_foreground
        }
        binding.imageView.setImageResource(imageResource)
    }

    fun onClickButton(view: View) {
        finish()
    }
}