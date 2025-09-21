package cl.unab.evaluacionfinal_m4;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Detalle extends Fragment {

    public interface Listener {
        void onDetalleRequested(String titulo, String autor, int imagenResId, String descripcion);
    }

    public static final String ARG_TITULO = "arg_titulo";
    public static final String ARG_AUTOR = "arg_autor";
    public static final String ARG_IMAGEN = "arg_imagen";
    public static final String ARG_DESCRIPCION = "arg_descripcion";

    public static Detalle newInstance(String titulo, String autor, int imagenResId, String descripcion) {
        Detalle fragment = new Detalle();
        Bundle args = new Bundle();
        args.putString(ARG_TITULO, titulo);
        args.putString(ARG_AUTOR, autor);
        args.putInt(ARG_IMAGEN, imagenResId);
        args.putString(ARG_DESCRIPCION, descripcion);
        fragment.setArguments(args);
        return fragment;
    }

    private Listener listener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof Listener) {
            listener = (Listener) context;
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
        View view = inflater.inflate(R.layout.fragment_detalle, container, false);

        ImageView img = view.findViewById(R.id.imgDetalle);
        TextView tvTitulo = view.findViewById(R.id.tituloDetalle);
        TextView tvAutor = view.findViewById(R.id.autorDetalle);
        TextView tvDescripcion = view.findViewById(R.id.descripcionDetalle);

        if (getArguments() != null) {
            String titulo = getArguments().getString(ARG_TITULO);
            String autor = getArguments().getString(ARG_AUTOR);
            int imagen = getArguments().getInt(ARG_IMAGEN);
            String descripcion = getArguments().getString(ARG_DESCRIPCION);

            if (tvTitulo != null) tvTitulo.setText(titulo);
            if (tvAutor != null) tvAutor.setText(autor);
            if (img != null) img.setImageResource(imagen);
            if (tvDescripcion != null) tvDescripcion.setText(descripcion);
        }

        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}
