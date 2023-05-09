package com.example.clase6;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.clase6.databinding.FragmentBBinding;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;


public class FragmentB extends Fragment {

    FragmentBBinding binding;
    private GoogleMap map;
    private CountDownTimer countDownTimer;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentBBinding.inflate(inflater,container,false);
        Spinner mySpinner = binding.spinner2;
        String[] items = {"Lince", "San Isidro","Magdalena","Jesús María"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(),android.R.layout.simple_spinner_dropdown_item,items);
        mySpinner.setAdapter(adapter);
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map_fragment);
        mapFragment.getMapAsync(googleMap -> {

            // Add a marker in Sydney and move the camera
            LatLng inicio = new LatLng(-12.084538, -77.031396);
            googleMap.addMarker(new MarkerOptions().position(inicio).title("Ambulancia"));
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(inicio));
            CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(inicio,10);
            googleMap.animateCamera(cameraUpdate);
        });



        binding.button5.setOnClickListener((view)->{
            String valorSpinner = binding.spinner2.getSelectedItem().toString();
            int tiempo = 0;
            double lat = 0;
            double lon = 0;
            if(valorSpinner.equals("Lince")){
                tiempo=10;
                lat = -12.090303;
                lon = -77.037239;
            }else if(valorSpinner.equals("San Isidro")){
                tiempo=15;
                lat = -12.102717;
                lon = -77.037358;
            }
            else if(valorSpinner.equals("Magdalena")){
                tiempo=20;
                lat = -12.089891;
                lon = -77.074231;
            }
            else if(valorSpinner.equals("Jesús María")){
                tiempo=25;
                lat = -12.078455;
                lon = -77.051310;
            }else{}
           if(countDownTimer !=null){
               countDownTimer.cancel();
           }
            double finalLat = lat;
            double finalLon = lon;
            mapFragment.getMapAsync(googleMap -> {

                // Add a marker in Sydney and move the camera
                LatLng destino = new LatLng(finalLat, finalLon);
                LatLng inicio = new LatLng(-12.084538, -77.031396);
                googleMap.clear();
                googleMap.addMarker(new MarkerOptions().position(inicio).title("Ambulancia"));
                googleMap.addMarker(new MarkerOptions().position(destino).title("destino"));
                googleMap.moveCamera(CameraUpdateFactory.newLatLng(destino));
                CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(destino,12);
                googleMap.animateCamera(cameraUpdate);
            });
            countDownTimer = new CountDownTimer(tiempo*60*1000, 1000) { // 60 segundos en milisegundos
                public void onTick(long millisUntilFinished) {
                    // Actualiza el tiempo restante en la interfaz de usuario
                    long minutosRestantes = TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished);
                    long segundosRestantes = TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(minutosRestantes);

                    // Mostrar el tiempo restante en formato minutos:segundos
                    String tiempoRestanteFormateado = String.format("%02d:%02d",
                            minutosRestantes, segundosRestantes);
                    binding.textView9.setText(tiempoRestanteFormateado);
                }

                public void onFinish() {
                    // Ejecuta algo cuando el cronómetro finalice
                    binding.textView9.setText("00:00");
                }
            };

            countDownTimer.start();
        });


        return binding.getRoot();
    }

}