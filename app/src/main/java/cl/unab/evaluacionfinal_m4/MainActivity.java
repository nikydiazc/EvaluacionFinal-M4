package cl.unab.evaluacionfinal_m4;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity implements Detalle.Listener {

    private BottomNavigationView bottomNavigationView;
    private Fragment fragment_inicio, fragment_integrantes, fragment_listado_de_libros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        fragment_inicio = new Inicio();
        fragment_integrantes = new Integrantes();
        fragment_listado_de_libros = new ListadoDeLibros();

        bottomNavigationView = findViewById(R.id.footer);

        loadFragment(fragment_inicio);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.inicio) {
                    loadFragment(fragment_inicio);
                } else if (id == R.id.libros) {
                    loadFragment(fragment_listado_de_libros);
                } else if (id == R.id.integrantes) {
                    loadFragment(fragment_integrantes);
                }
                return true;  // <-- Cambié esto a true para indicar que se manejó el seleccion
            }
        });
    }

    private void loadFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        ft.setCustomAnimations(
                R.anim.slide_in_right,
                R.anim.slide_out_left,
                R.anim.slide_in_left,
                R.anim.slide_out_right
        );

        ft.replace(R.id.navegation_fragment, fragment);
        ft.addToBackStack(null);
        ft.commit();
    }

    // Implementación de la interfaz
    @Override
    public void onDetalleRequested(String titulo, String autor, int imagenResId, String descripcion) {
        Detalle detalle = Detalle.newInstance(titulo, autor, imagenResId, descripcion);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.navegation_fragment, detalle);
        ft.addToBackStack(null);
        ft.commit();
    }
}
