package com.example.umcstudy

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.umcstudy.databinding.ActivityLv4Binding

class lv4Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /**
         * 화면 출력*/
        // 바인딩 객체 획득
        val b4 = ActivityLv4Binding.inflate(layoutInflater)
        // 화면에 콘텐츠: b4 객체의 루트 요소 출력
        setContentView(b4.root)

        /**
         * 버튼 이벤트 처리: 다시 뒤로 돌아가기
         */
        b4.back4.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
        }

        /*
        enableEdgeToEdge()
        setContentView(R.layout.activity_lv4)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

         */
    }
}