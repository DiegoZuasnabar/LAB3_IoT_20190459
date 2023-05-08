package com.example.clase6;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.clase6.databinding.FragmentABinding;
import com.example.clase6.databinding.FragmentBBinding;

import java.util.ArrayList;


public class FragmentB extends Fragment {

    FragmentBBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentBBinding.inflate(inflater,container,false);

        String nombre = requireArguments().getString("nombre");
        binding.nombreUsuario.setText("Nombre recibido: " + nombre);
         /*
        EstudiantesViewModel viewModel = new ViewModelProvider(requireActivity()).get(EstudiantesViewModel.class);

        viewModel.getListaEstudiantes().observe(getViewLifecycleOwner(), new Observer<ArrayList<Estudiante>>() {
            @Override
            public void onChanged(ArrayList<Estudiante> estudiantes) {
                for(Estudiante e: estudiantes){
                    Log.d("msg-test","nombre: " + e.getNombre() + " | es delegado? " + e.isDelegado());
                }
            }
        });

*/

        return binding.getRoot();
    }
}