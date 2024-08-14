package ru.zatsoft.lifecycle

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import ru.zatsoft.lifecycle.databinding.ActivityIndexBodyBinding
import java.lang.Exception

class IndexBody : AppCompatActivity() {
    private lateinit var binding: ActivityIndexBodyBinding
    private val infoText = Advices()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIndexBodyBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val height = intent.getDoubleExtra("height", 0.0) / 100.0
        val weight = intent.getDoubleExtra("weight", 0.0)
        val indexBody = weight / height / height
        binding.textView.text = "Ваш индекс тела ${"%.${2}f".format(indexBody)}"
        val imageResource = when {
            indexBody <= 8.0 -> {
                binding.listText.text = infoText.text[0]
                R.drawable.ic_invalide_foreground
            }

            indexBody <= 15.0 -> {
                binding.listText.text = infoText.text[1]
                R.drawable.body_mass_index_dn
            }

            indexBody <= 25.0 -> {
                binding.listText.text = infoText.text[2]
                R.drawable.body_mass_index_n
            }

            indexBody <= 30.0 -> {
                binding.listText.text = infoText.text[3]
                R.drawable.body_mass_index_un
            }

            indexBody <= 35.0 -> {
                binding.listText.text = infoText.text[4]
                R.drawable.body_mass_index_o1
            }

            indexBody <= 39.0 -> {
                binding.listText.text = infoText.text[5]
                R.drawable.body_mass_index_o2
            }

            indexBody > 39.0 -> {
                binding.listText.text = infoText.text[6]
                R.drawable.body_mass_index_o3
            }
            else -> { throw Exception("Ошибка расчета индекса тела в IndexBody")
            }
        }
        binding.imageView.setImageResource(imageResource)
    }

    fun onClickButton(view: View) {
        finish()
    }
}