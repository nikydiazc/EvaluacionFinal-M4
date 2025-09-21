package cl.unab.evaluacionfinal_m4;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ListadoDeLibros extends Fragment {

    private Detalle.Listener listener;

    public ListadoDeLibros() {
        // Required empty public constructor
    }

    public static ListadoDeLibros newInstance() {
        return new ListadoDeLibros();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof Detalle.Listener) {
            listener = (Detalle.Listener) context;
        } else {
            throw new ClassCastException(context.toString()
                    + " must implement Detalle.Listener");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.listado_de_libros, container, false);

        // Primer botón
        Button btn1 = view.findViewById(R.id.detalles01);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String titulo = "Juego de Tronos: Canción de Hielo y Fuego 1";
                String autor = "George R.R. Martin";
                int imagen = R.drawable.juegodetronos1;
                String descripcion = "Cuando se juega al juego de tronos, solo se puede ganar o morir." +
                        " No hay puntos intermedios.» En un mundo diferente al nuestro, en el que los veranos y" +
                        " los inviernos duran generaciones, un gran conflicto está a punto de estallar." +
                        " Robert Baratheon ocupa el Trono de Hierro en el cálido y opulento sur de Poniente." +
                        " Se lo arrebató tras una sangrienta guerra al último rey loco de la dinastía Targaryen," +
                        " señores de dragones. Sin embargo, ahora su poder se ve amenazado: en el norte," +
                        " el Muro erigido para proteger el reino de las bestias y de los extraños se tambalea." +
                        " Hace siglos que nadie ve a los caminantes blancos, pero ¿quiénes son entonces esos seres" +
                        " de ojos azules y fríos que se ocultan en las sombras de los bosques y que les arrebatan" +
                        " la vida y la mente a aquellos desafortunados que se cruzan en su camino?" +
                        " El final del verano está próximo, se acerca el invierno y solo un milagro" +
                        " podrá disipar las tinieblas.";
                listener.onDetalleRequested(titulo, autor, imagen, descripcion);
            }
        });

        // Segundo botón
        Button btn2 = view.findViewById(R.id.detalles02);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String titulo = "IT (Eso)";
                String autor = "Stephen King";
                int imagen = R.drawable.it;
                String descripcion = "¿Quién o qué mutila y mata a los niños de un pequeño pueblo" +
                        " norteamericano?¿Por qué llega cíclicamente el horror a Derry en forma de" +
                        " un payaso siniestro que va sembrando la destrucción a su paso? Esto es lo" +
                        " que se proponen averiguar los protagonistas de esta novela." +
                        " Tras veintisiete años de tranquilidad y lejanía, una antigua promesa" +
                        " infantil les hace volver al lugar en el que vivieron su infancia y" +
                        " juventud como una terrible pesadilla. Regresan a Derry para enfrentarse" +
                        " con su pasado y enterrar definitivamente la amenaza que los amargó durante" +
                        " su niñez. Saben que pueden morir, pero son conscientes de que no conocerán" +
                        " la paz hasta que aquella cosa sea destruida para siempre. It es una de las" +
                        "novelas más ambiciosas de Stephen King, con la que ha logrado perfeccionar" +
                        " de un modo muy personal las claves del género de terror.";
                listener.onDetalleRequested(titulo, autor, imagen, descripcion);
            }
        });

        // Tercer botón
        Button btn3 = view.findViewById(R.id.detalles03);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String titulo = "Yo antes de ti";
                String autor = "Jojo Moyes";
                int imagen = R.drawable.yoantesdeti;
                String descripcion = "La novela en la que se basa una de las películas de amor más bonitas." +
                        " Una historia que necesitas experimentar. Louisa Clark sabe muchas cosas." +
                        " Sabe cuántos pasos hay entre la parada del autobús y su casa. Sabe que le" +
                        " gusta trabajar en el café Buttered Bun y sabe que quizá no quiera a su novio Patrick." +
                        " Lo que Lou no sabe es que está a punto de perder su trabajo o que son sus" +
                        " pequeñas rutinas las que la mantienen en su sano juicio." +
                        " Will Traynor sabe que un accidente de moto se llevó sus ganas de vivir." +
                        " Sabe que ahora todo le parece insignificante y triste y sabe exactamente" +
                        " cómo va a solucionarlo. Lo que Will no sabe es que Lou está a punto de" +
                        " irrumpir en su mundo con una explosión de color. Y ninguno de los dos" +
                        " sabe que va a cambiar al otro para siempre. Yo antes de ti reúne a dos" +
                        " personas que no podrían tener menos en común en una novela conmovedoramente" +
                        " romántica con una pregunta: ¿Qué decidirías cuando hacer feliz a la persona" +
                        " a la que amas significa también destrozarte el corazón?";
                listener.onDetalleRequested(titulo, autor, imagen, descripcion);
            }
        });

        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}
