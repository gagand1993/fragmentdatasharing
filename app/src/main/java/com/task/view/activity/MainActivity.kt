package com.task.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.task.databinding.ActivityMainBinding
import com.task.model.DataShareModel
import com.task.view.fragment.FirstFragment
import com.task.view.fragment.SecondFragment
import com.task.viewmodel.DataShareViewMode

class MainActivity : AppCompatActivity() {
    companion object{

          lateinit var binding:ActivityMainBinding
    }

    lateinit var viewModel: DataShareViewMode



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel=ViewModelProvider(this)[DataShareViewMode::class.java]

        replaceFragment(binding.flFirst.id,FirstFragment(viewModel),"first")
        replaceFragment(binding.flSecond.id,SecondFragment(viewModel),"second")


        with(binding){

        }
    }


    private fun replaceFragment(containerId:Int, fragment: Fragment, tag:String){
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(containerId, fragment, tag)
        ft.commit()
    }
}