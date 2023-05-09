package com.example.clase6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.clase6.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<Mascota> listaMascotas = new ArrayList<>();
        MascotaViewModel mascotaViewModel = new ViewModelProvider(this).get(MascotaViewModel.class);
        Mascota mascota1 = new Mascota();
        mascota1.setDescripcion("Intoxicación");
        mascota1.setMascota("Peluche");
        mascota1.setDni("25865489");
        mascota1.setDueno("Alonso");
        mascota1.setRuta("Lince-Lince");
        mascota1.setGenero("masculino");
        listaMascotas.add(mascota1);

        Mascota mascota2 = new Mascota();
        mascota2.setDescripcion("Parto");
        mascota2.setMascota("Maria Antonieta");
        mascota2.setDni("08104081");
        mascota2.setDueno("María");
        mascota2.setRuta("Jesus Maria-Lince");
        mascota2.setGenero("femenino");
        listaMascotas.add(mascota2);

        Mascota mascota3 = new Mascota();
        mascota3.setDescripcion("Dolor cadera");
        mascota3.setMascota("Candy");
        mascota3.setDni("46285087");
        mascota3.setDueno("Aracelli");
        mascota3.setRuta("San Isidro-Lince");
        mascota3.setGenero("femenino");
        listaMascotas.add(mascota3);


        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener((view)->{
            if (savedInstanceState == null) {
                mascotaViewModel.getListaMascotas().setValue(listaMascotas);
                getSupportFragmentManager().beginTransaction()
                        .setReorderingAllowed(true)
                        .add(R.id.fragmentContainerView, FragmentA.class, null)
                        .addToBackStack(null)
                        .commit();
            }

        });
        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener((view)->{
            if (savedInstanceState == null) {
                //mascotaViewModel.getListaMascotas().setValue(listaMascotas);
                getSupportFragmentManager().beginTransaction()
                        .setReorderingAllowed(true)
                        .addToBackStack(null)
                        .add(R.id.fragmentContainerView, FragmentB.class, null)
                        .commit();
            }

        });
        Button button4 = findViewById(R.id.button4);
        button4.setOnClickListener((view)->{
            if (savedInstanceState == null) {
                mascotaViewModel.getListaMascotas().setValue(listaMascotas);
                getSupportFragmentManager().beginTransaction()
                        .setReorderingAllowed(true)
                        .addToBackStack(null)
                        .add(R.id.fragmentContainerView, FragmentC.class, null)
                        .commit();
            }

        });
        binding.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Fragment fragmentById = getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView);

                getSupportFragmentManager().beginTransaction()
                        .remove(fragmentById)
                        .commit();
                getSupportFragmentManager().popBackStack();

            }
        });
    }
}