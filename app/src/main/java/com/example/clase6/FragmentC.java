package com.example.clase6;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.clase6.databinding.FragmentABinding;
import com.example.clase6.databinding.FragmentCBinding;

import java.util.ArrayList;
import java.util.Arrays;


public class FragmentC extends Fragment {
    FragmentCBinding binding;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentCBinding.inflate(inflater,container,false);


        MascotaViewModel mascotaViewModel = new ViewModelProvider(requireActivity()).get(MascotaViewModel.class);

        ListaMascotasAdapter adapter = new ListaMascotasAdapter();
        adapter.setContext(getContext());
        adapter.setListaMascotas(mascotaViewModel.getListaMascotas().getValue());

        binding.recycler1.setAdapter(adapter);

        binding.recycler1.setLayoutManager(new LinearLayoutManager(requireContext()));
        return binding.getRoot();
    }
}