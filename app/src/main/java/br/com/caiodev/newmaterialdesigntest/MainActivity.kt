package br.com.caiodev.newmaterialdesigntest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import br.com.caiodev.newmaterialdesigntest.databinding.ActivityMainBinding
import com.google.android.material.chip.Chip

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupView()
    }

    private fun setupView() {
        setChipListener(binding.firstChip)
        setChipListener(binding.chip)

        binding.chipList.apply {
            setHasFixedSize(true)
        }
    }

    private fun setChipListener(chip: Chip) {
        chip.apply {
            setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    setTextColor(ContextCompat.getColor(applicationContext, android.R.color.white))
                } else {
                    setTextColor(ContextCompat.getColor(applicationContext, android.R.color.black))
                }
            }
        }
    }
}
