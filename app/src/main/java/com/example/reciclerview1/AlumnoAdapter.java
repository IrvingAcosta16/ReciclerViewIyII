package com.example.reciclerview1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;


public class AlumnoAdapter extends RecyclerView.Adapter<AlumnoAdapter.ViewHolder> implements View.OnClickListener{
    protected ArrayList<AlumnoItem> listaAlumnos;
    private View.OnClickListener listener;
    private Context context;
    private LayoutInflater inflater;

    public AlumnoAdapter(ArrayList<AlumnoItem> listaAlumnos, Context context) {
        this.listaAlumnos = listaAlumnos;
        this.context = context;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public void onClick(View v) {
        if (listener != null){
            listener.onClick(v);
        }
    }

    @NonNull
    @Override
    public AlumnoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.alumno_items, null);
        view.setOnClickListener(this);

        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull AlumnoAdapter.ViewHolder holder, int position) {
        AlumnoItem alumno = listaAlumnos.get(position);
        holder.txtMatricula.setText(alumno.getMatricula());
        holder.txtNombre.setText(alumno.getNombre());
        holder.idImagen.setImageResource(alumno.getImageID());
    }

    @Override
    public int getItemCount() {
        return listaAlumnos.size();
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private LayoutInflater inflater;
        private TextView txtNombre;
        private TextView txtMatricula;
        private TextView txtCarrera;

        private ImageView idImagen;

        public ViewHolder(View itemView) {
            super(itemView);
            txtNombre = (TextView) itemView.findViewById(R.id.txtAlumnoNombre);
            txtMatricula = (TextView) itemView.findViewById(R.id.txtMatricula);
            txtCarrera = (TextView) itemView.findViewById(R.id.txtCarrera);

            idImagen = (ImageView) itemView.findViewById(R.id.foto);

        }
    }
}
