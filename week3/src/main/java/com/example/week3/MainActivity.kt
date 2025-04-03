package com.example.week3

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.week3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 뷰 바인딩 객체 생성 및 출력
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initBottomNavigation()

        // data class에 미니플레이어로 재생 중인 곡의 제목과 가수명을 저장
        val song = Song(binding.mainMiniplayerTitleTv.text.toString(), binding.mainMiniplayerSingerTv.text.toString())

        // 미니 플레이어 이벤트 처리
        // 인텐트로 재생 중인 음악 제목과 가수명 전달
        // 인텐트로 현재 재생 중인 음악 화면으로 전환
        binding.mainPlayerC1.setOnClickListener {
            val intent = Intent(this, SongActivity::class.java)
            intent.putExtra("title", song.title)
            intent.putExtra("singer", song.singer)
            startActivity(intent)
        }
    }

    private fun initBottomNavigation() {
        // supportFragmentManager: 현재 액티비티의 fragmentmanager을 가져옴.
        // fragment trasaction: 프래그먼트의 추가, 제거, 교체 등의 작업으로 발생한 변경 사항들을 트랜잭션이라 함.
        // beginTransaction(): 새로운 FragmentTransaction 클래스의 인스턴스 생성
        // replace(A, B): 컨테이너(A)에 지정한 프래그먼트(B)를 담음. 이외의 남은 모든 프래그먼트는 제거됨.
        // commitAllowingStateLoss(): 트랜잭션의 수행 후 commit이 진행되는데, commit 시기와 restore 시기가 적절치 않아서
        // restore을 통해 예상되는 상태와 실제로 저장된 상태가 달라 생기는 상태 손실을 대응하기 위한 메서드.
        // 상태 손실이 발생하더라도 FragmentTransaction을 커밋하는 메서드가 commitAllowingStateLoss().
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_frm, HomeFragment())
            .commitAllowingStateLoss()

        // 선택된 BottomNavigationView의 항목의 ID에 따라 동작 수행
        // return@setOnItemSelectedListener true: 항목 선택 이벤트 처리 후 true 반환. 이를 통해 Fragment 변경이 완료됨.
        // false: 항목 선택 이벤트가 소비되지 않도록 하여 다른 코드나 리스너에서 추가적으로 처리할 수 있도록 함. 여기서는 when의 문법의 else 부분 작성을 위해 사용.
        binding.mainBnv.setOnItemSelectedListener { item ->
            when(item.itemId) {

                R.id.homeFragment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frm, HomeFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
                R.id.lookFragment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frm, LookFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
                R.id.searchFragment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frm, SearchFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
                R.id.lockerFragment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frm, LockerFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
            }
            // else의 경우
            false
        }
    }
}