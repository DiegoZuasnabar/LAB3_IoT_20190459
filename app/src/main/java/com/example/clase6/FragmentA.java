package com.example.clase6;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.clase6.databinding.FragmentABinding;

import java.util.ArrayList;

public class FragmentA extends Fragment {

    FragmentABinding binding;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentABinding.inflate(inflater,container,false);
        Spinner mySpinner = binding.spinner;
        String[] items = {"Masculino", "Femenino"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(),android.R.layout.simple_spinner_dropdown_item,items);
        mySpinner.setAdapter(adapter);

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText1 = binding.editTextText;
                String texto1 = editText1.getText().toString();
                EditText editText2 = binding.editTextText2;
                String texto2 = editText2.getText().toString();
                EditText editText3 = binding.editTextText3;
                String texto3 = editText3.getText().toString();
                EditText editText4 = binding.editTextNumber;
                String texto4 = editText4.getText().toString();

                if(texto1.length()!=0 && texto2.length()!=0&& texto3.length()!=0&& texto4.length()==8){
                    MascotaViewModel mascotaViewModel = new ViewModelProvider(requireActivity()).get(MascotaViewModel.class);
                    ArrayList<Mascota> lista = new ArrayList<>();
                    lista = mascotaViewModel.getListaMascotas().getValue();
                    Mascota mascota = new Mascota();
                    mascota.setMascota(texto1);
                    mascota.setGenero(binding.spinner.getSelectedItem().toString());
                    mascota.setDueno(texto2);
                    mascota.setDni(texto4);
                    mascota.setDescripcion(texto3);
                    lista.add(mascota);
                    mascotaViewModel.getListaMascotas().postValue(lista);
                    Context context = requireContext();
                    Toast toast = Toast.makeText(context, "Se registró correctamente", Toast.LENGTH_SHORT);
                    toast.show();
                    Fragment fragmentById = getActivity().getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView);
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .remove(fragmentById)
                            .commit();
                    getActivity().getSupportFragmentManager().popBackStack();
                }else{
                    Context context = requireContext();
                    Toast toast = Toast.makeText(context, "Rellena todos los campos correctamente", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });


        return binding.getRoot();
    }
}