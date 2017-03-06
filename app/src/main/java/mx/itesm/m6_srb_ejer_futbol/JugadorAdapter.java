package mx.itesm.m6_srb_ejer_futbol;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by saul on 12/2/2017.
 */

public class JugadorAdapter extends ArrayAdapter<Jugador> {
    public JugadorAdapter(Context context, List<Jugador> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Jugador jugador = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row,parent,false);
        }
        ImageView ivPosicion = (ImageView) convertView.findViewById(R.id.imv_v_position);
        TextView tvNombre = (TextView) convertView.findViewById(R.id.text_nombre);
        TextView tvPosicion = (TextView) convertView.findViewById(R.id.text_posicion);
        TextView tvNacionalidad = (TextView) convertView.findViewById(R.id.text_nacionalidad);

        ivPosicion.setImageResource(jugador.getIdImagen());
        tvNacionalidad.setText(jugador.getNacionalidad());
        tvNombre.setText(jugador.getNombre());
        tvPosicion.setText(jugador.getPosicion());

        return convertView;
    }
}
