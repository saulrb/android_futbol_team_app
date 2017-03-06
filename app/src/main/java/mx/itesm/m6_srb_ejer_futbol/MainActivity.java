package mx.itesm.m6_srb_ejer_futbol;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ListActivity implements View.OnClickListener {

    TextView tvNombreEquipo;
    ImageView ivLigaEquipo;
    Equipo equipo;
    Button btnConfigurarEquipo, btnAgregarJugador;
    static final int REQUEST_CODE_CONFIGURAR = 1;
    static final int REQUEST_CODE_AGREGAR_JUGADOR = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        equipo = null;
        tvNombreEquipo = (TextView) findViewById(R.id.textNombreEquipo);
        ivLigaEquipo = (ImageView) findViewById(R.id.ivLigaEquipo);
        btnAgregarJugador = (Button) findViewById(R.id.button_agregar_jugador);
        btnAgregarJugador.setOnClickListener(this);
        btnConfigurarEquipo = (Button) findViewById(R.id.button_config_equipo);
        btnConfigurarEquipo.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.button_config_equipo:
                intent = new Intent(this, ConfigurarEquipoActivity.class);
                intent.putExtra("equipo",equipo);
                startActivityForResult(intent,REQUEST_CODE_CONFIGURAR);
                break;
            case R.id.button_agregar_jugador:
                intent = new Intent(this, ConfigurarJugadorActivity.class);
                intent.putExtra("equipo",equipo);
                startActivityForResult(intent,REQUEST_CODE_AGREGAR_JUGADOR);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK){
            Bundle dataReturned = data.getExtras();
            if(requestCode == REQUEST_CODE_CONFIGURAR) {
                equipo = (Equipo) dataReturned.getSerializable("equipo");
                updateScreen(equipo);
            }else if (requestCode == REQUEST_CODE_AGREGAR_JUGADOR){
                equipo = (Equipo) dataReturned.getSerializable("equipo");
                JugadorAdapter jugadorAdapter = new JugadorAdapter(this,equipo.getJugadores());
                setListAdapter(jugadorAdapter);
            }
        }
    }

    private void updateScreen(Equipo equipo){
        tvNombreEquipo.setText(equipo.getNombreEquipo());
        ivLigaEquipo.setImageResource(equipo.getIdImagen());
        JugadorAdapter adapterJugador = new JugadorAdapter(this, equipo.getJugadores());
        setListAdapter(adapterJugador);
    }
}
