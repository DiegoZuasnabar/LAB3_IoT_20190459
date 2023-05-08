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

    ArrayList<Mascota> listaMascotas = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener((view)->{
            if (savedInstanceState == null) {
                MascotaViewModel mascotaViewModel = new ViewModelProvider(this).get(MascotaViewModel.class);
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

                getSupportFragmentManager().beginTransaction()
                        .setReorderingAllowed(true)
                        .addToBackStack(null)
                        .add(R.id.fragmentContainerView, FragmentC.class, null)
                        .commit();
            }

        });
/*

        if (savedInstanceState == null) {

            //Bundle bundle = new Bundle();
            //bundle.putString("nombre", "Jex");

            ArrayList<Estudiante> lista = new ArrayList<>();
            lista.add(new Estudiante("Jex", false));
            lista.add(new Estudiante("Niurka", true));
            lista.add(new Estudiante("Carlos", false));
            lista.add(new Estudiante("Angelo", false));
            lista.add(new Estudiante("Diego", false));
            lista.add(new Estudiante("David", false));

            EstudiantesViewModel viewModel = new ViewModelProvider(this).get(EstudiantesViewModel.class);
            viewModel.getListaEstudiantes().setValue(lista);

            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.fragmentContainerView, FragmentB.class, null)
                    .commit();
        }

*/
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