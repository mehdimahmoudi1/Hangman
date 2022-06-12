package com.example.hangmangame

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

import android.content.Intent
import android.util.Log
import java.util.*


class MainActivity : AppCompatActivity() {
    private lateinit var txt_word:TextView
    private lateinit var img_face:ImageView
    private lateinit var txt_a:TextView
    private lateinit var txt_b:TextView
    private lateinit var txt_c:TextView
    private lateinit var txt_d:TextView
    private lateinit var txt_e:TextView
    private lateinit var txt_f:TextView
    private lateinit var txt_g:TextView
    private lateinit var txt_h:TextView
    private lateinit var txt_i:TextView
    private lateinit var txt_j:TextView
    private lateinit var txt_k:TextView
    private lateinit var txt_l:TextView
    private lateinit var txt_m:TextView
    private lateinit var txt_n:TextView
    private lateinit var txt_o:TextView
    private lateinit var txt_p:TextView
    private lateinit var txt_q:TextView
    private lateinit var txt_r:TextView
    private lateinit var txt_s:TextView
    private lateinit var txt_t:TextView
    private lateinit var txt_u:TextView
    private lateinit var txt_v:TextView
    private lateinit var txt_w:TextView
    private lateinit var txt_x:TextView
    private lateinit var txt_y:TextView
    private lateinit var txt_z:TextView



    private var wordDashd = ""
    private var failCount = 0
    private fun selectdword(): String? {
        val words = arrayOf(
            "Iran",
            "Lorestan",
            "Shiraz",
            "Gilan",
            "Khoram Abad",
            "KermanShah",
            "Yazd",
            "Tehran",
            "Azarbayjan",
            "Esfhan",
            "Abadan"
        )
        val randomIndex = (Math.random() * words.size).toInt()
        return words[randomIndex]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()

    }
    private fun init(){
        bindView()
        val word = selectdword()
        for (i in 0 until word!!.length) {
            wordDashd += if (word[i] != ' ') {
                "-"
            } else {
                " "
            }
        }

        txt_word =  findViewById(R.id.txt_word)
        img_face =  findViewById(R.id.img_face)

        txt_word.text = wordDashd

        val listener =
            View.OnClickListener { view -> //تعریف یک متغیر از جنس تکست ویوو و کست کردن ان ویوو به تکست ویوو
                val textView = view as TextView
                val id = textView.resources.getResourceEntryName(textView.id)
                val letter = id.replace("txt_", "")
                val letterChar = letter[0]
                Log.i("Test", "TextView Clikced $letter")
                val wordLowerCase = word.lowercase(Locale.getDefault())
                if (wordLowerCase.contains(letter)) {
                    Log.i("Test", "Word Contains $letter")
                    for (i in wordLowerCase.indices) {
                        if (wordLowerCase[i] == letterChar) {
                            val wordDashedCharArray = wordDashd.toCharArray()
                            wordDashedCharArray[i] = word[i]
                            wordDashd = String(wordDashedCharArray)
                            Log.i("Test", "Found at Index $i")
                            txt_word.text = wordDashd
                            if (!wordDashd.contains("-")) {
                                val intent = Intent(this@MainActivity, FinishActivity::class.java)
                                intent.putExtra("RESULT", "Won")
                                this@MainActivity.startActivity(intent)
                                finish()
                                Log.i("Test", "You Won ")
                                return@OnClickListener
                            }
                        }
                    }
                } else {
                    Log.i("Test", "Word not Contains $letter")
                    failCount++
                    if (failCount > 7) {
                        img_face.setImageResource(R.drawable.face_9)
                        val intent = Intent(this@MainActivity, FinishActivity::class.java)
                        intent.putExtra("RESULT", "Game Over")
                        this@MainActivity.startActivity(intent)
                        finish()
                        Log.i("Test", "Game Over")
                        return@OnClickListener
                    }
                    var imageId: Int = R.drawable.face_1
                    when (failCount) {
                        1 -> imageId = R.drawable.face_2
                        2 -> imageId = R.drawable.face_3
                        3 -> imageId = R.drawable.face_4
                        4 -> imageId = R.drawable.face_5
                        5 -> imageId = R.drawable.face_6
                        6 -> imageId = R.drawable.face_7
                        7 -> imageId = R.drawable.face_8
                        8 -> imageId = R.drawable.face_9
                    }
                    img_face.setImageResource(imageId)
                }
                textView.visibility = View.INVISIBLE
            }

        txt_a.setOnClickListener { listener }
        txt_b.setOnClickListener { listener }
        txt_c.setOnClickListener { listener }
        txt_d.setOnClickListener { listener }
        txt_e.setOnClickListener { listener }
        txt_f.setOnClickListener { listener }
        txt_g.setOnClickListener { listener }
        txt_h.setOnClickListener { listener }
        txt_i.setOnClickListener { listener }
        txt_j.setOnClickListener { listener }
        txt_k.setOnClickListener { listener }
        txt_l.setOnClickListener { listener }
        txt_m.setOnClickListener { listener }
        txt_n.setOnClickListener { listener }
        txt_o.setOnClickListener { listener }
        txt_p.setOnClickListener { listener }
        txt_q.setOnClickListener { listener }
        txt_r.setOnClickListener { listener }
        txt_s.setOnClickListener { listener }
        txt_t.setOnClickListener { listener }
        txt_u.setOnClickListener { listener }
        txt_v.setOnClickListener { listener }
        txt_x.setOnClickListener { listener }
        txt_y.setOnClickListener { listener }
        txt_z.setOnClickListener { listener }

    }

    private fun bindView(){
        txt_a = findViewById(R.id.txt_a)
        txt_b = findViewById(R.id.txt_b)
        txt_c = findViewById(R.id.txt_c)
        txt_d = findViewById(R.id.txt_d)
        txt_e = findViewById(R.id.txt_e)
        txt_f = findViewById(R.id.txt_f)
        txt_g = findViewById(R.id.txt_g)
        txt_h = findViewById(R.id.txt_h)
        txt_i = findViewById(R.id.txt_i)
        txt_j = findViewById(R.id.txt_j)
        txt_k = findViewById(R.id.txt_k)
        txt_l = findViewById(R.id.txt_l)
        txt_m = findViewById(R.id.txt_m)
        txt_n = findViewById(R.id.txt_n)
        txt_o = findViewById(R.id.txt_o)
        txt_p = findViewById(R.id.txt_p)
        txt_q = findViewById(R.id.txt_q)
        txt_r = findViewById(R.id.txt_r)
        txt_s = findViewById(R.id.txt_s)
        txt_t = findViewById(R.id.txt_t)
        txt_u = findViewById(R.id.txt_u)
        txt_v = findViewById(R.id.txt_v)
        txt_w = findViewById(R.id.txt_w)
        txt_x = findViewById(R.id.txt_x)
        txt_y = findViewById(R.id.txt_y)
        txt_z = findViewById(R.id.txt_z)
    }
}