package com.example.screentester

import android.graphics.Color
import android.os.Bundle
import android.view.MotionEvent
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.MotionEventCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private var touchcount = 0
    override fun onTouchEvent(event: MotionEvent): Boolean {
        return when (MotionEventCompat.getActionMasked(event)) {
            MotionEvent.ACTION_MOVE -> {
                touchcount += 1
                changecolor(touchcount)
                //Toast.makeText(this,"pressed $touchcount times",Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onTouchEvent(event)
        }
    }

    private fun changecolor(datain:Int){
        val backgroundcolor:ConstraintLayout  = findViewById(R.id.timetochange)
        when(datain){
            1 -> backgroundcolor.setBackgroundColor(Color.argb(255,0,0,255))
            2 -> backgroundcolor.setBackgroundColor(Color.argb(255,0,255,0))
            3 -> backgroundcolor.setBackgroundColor(Color.argb(255,255,0,0))
            else -> backgroundcolor.setBackgroundColor(Color.argb(255,(0..255).random(),(0..255).random(),(0..255).random()))
        }
    }
}