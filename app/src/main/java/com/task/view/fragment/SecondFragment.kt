package com.task.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.task.R
import com.task.databinding.FragmentFirstBinding
import com.task.databinding.FragmentSecondBinding
import com.task.model.DataShareModel
import com.task.view.activity.MainActivity.Companion.binding
import com.task.view.adapter.FirstAdapter
import com.task.view.adapter.SecondAdapter
import com.task.viewmodel.DataShareViewMode


class SecondFragment(val viewModel: DataShareViewMode) : Fragment() {


    private lateinit var bindings: FragmentSecondBinding
    lateinit var adapter:SecondAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        bindings = FragmentSecondBinding.inflate(inflater, container, false)
        return bindings.root
    }

    var list=ArrayList<DataShareModel>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        with(bindings){

            adapter= SecondAdapter(list)
            rvItem.adapter=adapter

        }
        viewModel.leftToRight.observe(viewLifecycleOwner) {
            it.let {

                it.forEach {
                    list.add(it.apply {
                        it.isSelected=false
                    })
                }
                adapter.updateList(list)
            }


        }

        binding.btRightToLeft.setOnClickListener {
            val (selected, unselected) = list.partition { it.isSelected }

            selected.forEach { it.isSelected = false }

            list = ArrayList(unselected)
            adapter.updateList(list)

            viewModel.dataSharingViewModel2.value=ArrayList(selected)

        }

    }
}