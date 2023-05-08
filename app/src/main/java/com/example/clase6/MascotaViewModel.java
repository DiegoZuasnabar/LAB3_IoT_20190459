package com.example.clase6;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class MascotaViewModel extends ViewModel {
    private MutableLiveData<ArrayList<Mascota>> listaMascotas = new MutableLiveData<>();
    public MutableLiveData<ArrayList<Mascota>> getListaMascotas() {
        return listaMascotas;
    }


}
