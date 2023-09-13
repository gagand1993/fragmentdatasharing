package com.task.view.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.task.databinding.FragmentFirstBinding
import com.task.model.DataShareModel
import com.task.view.activity.MainActivity.Companion.binding
import com.task.view.adapter.FirstAdapter
import com.task.viewmodel.DataShareViewMode


class FirstFragment(val viewModel: DataShareViewMode) : Fragment() {


    private lateinit var bindings:FragmentFirstBinding
    var list=ArrayList<DataShareModel>()
    lateinit var adapter:FirstAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        bindings = FragmentFirstBinding.inflate(inflater, container, false)
        return bindings.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        list=generateList()
        with(bindings){

            adapter=FirstAdapter(list)
            rvItem.adapter=adapter

        }


        viewModel.rightToLeft.observe(viewLifecycleOwner) {
            it.let {

                it.forEach {
                    list.add(it.apply {
                        it.isSelected=false
                    })
                }
                adapter.updateList(list)

            }

        }
        binding.btLeftToRight.setOnClickListener {


            val (selected, unselected) = list.partition { it.isSelected }

            selected.forEach { it.isSelected = false }

            list = ArrayList(unselected)
            adapter.updateList(list)

            viewModel.dataSharingViewModel.value=ArrayList(selected)

        }
    }


    fun generateList():ArrayList<DataShareModel>{

        val list=ArrayList<DataShareModel>()
        list.add(DataShareModel(title = "Gagan", isSelected = false))
        list.add(DataShareModel(title = "Jaskirat", isSelected = false))
        list.add(DataShareModel(title = "Sahej", isSelected = false))
        list.add(DataShareModel(title = "Rayen", isSelected = false))
        list.add(DataShareModel(title = "Raman", isSelected = false))
        list.add(DataShareModel(title = "Raghav", isSelected = false))
        list.add(DataShareModel(title = "Android", isSelected = false))
        list.add(DataShareModel(title = "Google", isSelected = false))
        return list

    }
}