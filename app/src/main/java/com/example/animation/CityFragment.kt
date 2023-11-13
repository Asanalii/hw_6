package com.example.animation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.animation.databinding.FragmentCityBinding
import com.example.recyclerview.decoration.OffsetDecoration

class CityFragment: Fragment() {
    private lateinit var binding: FragmentCityBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCityBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listActions = listOf(
            ActionListDTO("Улица", R.drawable.ic_street, "Что что что что"),
            ActionListDTO("Реклама", R.drawable.ic_advertisement, "Что что что что что"),
            ActionListDTO(
                "Статуя свободы1",
                R.drawable.ic_freedom1,
                "Ста́туя Свобо́ды1 — колоссальная скульптура, расположенная в США на острове Свободы, находящемся в Верхней Нью-Йоркской бухте, примерно в трёх километрах к юго-западу от южной окраины острова Манхэттен"
            ),
            ActionListDTO(
                "Статуя свободы2",
                R.drawable.ic_freedom2,
                "Ста́туя Свобо́ды2 — колоссальная скульптура, расположенная в США на острове Свободы, находящемся в Верхней Нью-Йоркской бухте, примерно в трёх километрах к юго-западу от южной окраины острова Манхэттен"
            ),
            ActionListDTO("Пёсик", R.drawable.ic_dog, "Что что что что что"),
            ActionListDTO("Мост", R.drawable.ic_bridge, "Что что что что что"),
        )

        val adapter = CityAdapter(listActions)

        binding.listAction.adapter = adapter
        binding.listAction.layoutManager =
            GridLayoutManager(requireContext(), 2, GridLayoutManager.VERTICAL, false)


        adapter.itemClick = { _, extras ->

//            Log.d("ExtraCallsProvider")

            findNavController().navigate(
                CityFragmentDirections.actionCityFragmentToCityInfoFragment(), extras
            )
        }
    }
//        binding.listAction.addItemDecoration(OffsetDecoration(0,3,10,3))
}


