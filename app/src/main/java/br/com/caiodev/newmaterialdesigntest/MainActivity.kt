package br.com.caiodev.newmaterialdesigntest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.material.chip.Chip
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setChipListener(firstChip)
        setChipListener(chip)
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
