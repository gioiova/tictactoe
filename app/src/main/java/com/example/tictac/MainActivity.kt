package com.example.tictac


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    var player = "p1"
    var score = 1
    var score1 = 1
    private lateinit var btn1: Button
    private lateinit var btn2: Button
    private lateinit var btn3: Button
    private lateinit var btn4: Button
    private lateinit var btn5: Button
    private lateinit var btn6: Button
    private lateinit var btn7: Button
    private lateinit var btn8: Button
    private lateinit var btn9: Button
    private lateinit var btnReset: Button
    private lateinit var txtResult: TextView
    private lateinit var Xscore: TextView
    private lateinit var Oscore: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn1 = findViewById(R.id.b1)
        btn2 = findViewById(R.id.b2)
        btn3 = findViewById(R.id.b3)
        btn4 = findViewById(R.id.b4)
        btn5 = findViewById(R.id.b5)
        btn6 = findViewById(R.id.b6)
        btn7 = findViewById(R.id.b7)
        btn8 = findViewById(R.id.b8)
        btn9 = findViewById(R.id.b9)
        btnReset = findViewById(R.id.btnReset)
        txtResult = findViewById(R.id.txtResult)
        Xscore = findViewById(R.id.score)
        Oscore = findViewById(R.id.score1)

        btn1.setOnClickListener {
            buttonClicked(btn1)
        }
        btn2.setOnClickListener {
            buttonClicked(btn2)
        }
        btn3.setOnClickListener {
            buttonClicked(btn3)
        }
        btn4.setOnClickListener {
            buttonClicked(btn4)
        }
        btn5.setOnClickListener {
            buttonClicked(btn5)
        }
        btn6.setOnClickListener {
            buttonClicked(btn6)
        }
        btn7.setOnClickListener {
            buttonClicked(btn7)
        }
        btn8.setOnClickListener {
            buttonClicked(btn8)
        }
        btn9.setOnClickListener {
            buttonClicked(btn9)
        }
        btnReset.setOnClickListener {
            reset()
            txtResult.text = ""
        }


    }

    fun buttonClicked(btn: Button){
        if(btn.text == ""){
            if (player=="p1"){
                player = "p2"
                btn.text = "X"
            }else {
                player = "p1"
                btn.text = "O"
            }
        }
        win()
    }


    fun win(){
        if((btn1.text == "X" && btn2.text == "X" && btn3.text == "X")||
            (btn4.text == "X" && btn5.text == "X" && btn6.text == "X")||
            (btn7.text == "X" && btn8.text == "X" && btn9.text == "X")||
            (btn1.text == "X" && btn5.text == "X" && btn9.text == "X")||
            (btn3.text == "X" && btn5.text == "X" && btn7.text == "X")||
            (btn1.text == "X" && btn4.text == "X" && btn7.text == "X")||
            (btn2.text == "X" && btn5.text == "X" && btn8.text == "X")||
            (btn3.text == "X" && btn6.text == "X" && btn9.text == "X")){
            txtResult.text = "X is Winner"
            Xscore.text = "$score"
            score+=1
            disable()
        }
        else if((btn1.text == "O" && btn2.text == "O" && btn3.text == "O")||
            (btn4.text == "O" && btn5.text == "O" && btn6.text == "O")||
            (btn7.text == "O" && btn8.text == "O" && btn9.text == "O")||
            (btn1.text == "O" && btn5.text == "O" && btn9.text == "O")||
            (btn3.text == "O" && btn5.text == "O" && btn7.text == "O")||
            (btn1.text == "O" && btn4.text == "O" && btn7.text == "O")||
            (btn2.text == "O" && btn5.text == "O" && btn8.text == "O")||
            (btn3.text == "O" && btn6.text == "O" && btn9.text == "O")){
            txtResult.text = "O is Winner"
            Oscore.text = "$score1"
            score1+=1
            disable()
        }
        else if (btn1.text != ""&& btn2.text != "" && btn3.text != ""
            && btn4.text != "" && btn5.text != "" && btn6.text != ""
            && btn7.text != "" && btn8.text != "" && btn9.text != ""){
            txtResult.text = "Tie"
            disable()
        }


    }

    fun reset(){
        btn1.text = ""
        btn2.text = ""
        btn3.text = ""
        btn4.text = ""
        btn5.text = ""
        btn6.text = ""
        btn7.text = ""
        btn8.text = ""
        btn9.text = ""
        btn1.isEnabled = true
        btn2.isEnabled = true
        btn3.isEnabled = true
        btn4.isEnabled = true
        btn5.isEnabled = true
        btn6.isEnabled = true
        btn7.isEnabled = true
        btn8.isEnabled = true
        btn9.isEnabled = true
    }

    fun disable(){
        btn1.isEnabled = false
        btn2.isEnabled = false
        btn3.isEnabled = false
        btn4.isEnabled = false
        btn5.isEnabled = false
        btn6.isEnabled = false
        btn7.isEnabled = false
        btn8.isEnabled = false
        btn9.isEnabled = false

    }
}
