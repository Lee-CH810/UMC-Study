package com.example.umcstudy

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.umcstudy.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 바인딩 객체 획득
        val binding = ActivityMainBinding.inflate(layoutInflater)

        // 액티비티 화면(activity_main.xml) 출력
        setContentView(binding.root)

        /**
         * 버튼 이벤트 처리
         * */
        // 더없이 행복한 하루였어요
        binding.imageButton.setOnClickListener{
            val intent = Intent(this, lv4Activity::class.java)
            startActivity(intent)
        }

        binding.imageButton2.setOnClickListener{
            val intent = Intent(this, lv3Activity::class.java)
            startActivity(intent)
        }

        binding.imageButton3.setOnClickListener{
            val intent = Intent(this, lv2Activity::class.java)
            startActivity(intent)
        }

        binding.imageButton4.setOnClickListener{
            val intent = Intent(this, lv1Activity::class.java)
            startActivity(intent)
        }

        binding.imageButton5.setOnClickListener{
            val intent = Intent(this, lv0Activity::class.java)
            startActivity(intent)
        }

/*        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

 */
    }
}
