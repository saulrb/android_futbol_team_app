package mx.itesm.m6_srb_ejer_futbol;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.HashMap;
import java.util.Map;

public class ConfigurarJugadorActivity extends AppCompatActivity implements View.OnClickListener , AdapterView.OnItemSelectedListener{

    EditText edNombreJugador,edNacionalidad;
    String[] posicionSelected = { "Portero","Defenza","Mediocampista","Volante","Puntero","Extremo","Delantero"};
    Button btnGuardar;
    Spinner spPosicion;
    static Equipo equipo = null;
    Map<Integer, Integer> imageSelected = null;
    int posicionSel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configurar_jugador);
        edNombreJugador = (EditText) findViewById(R.id.edNombreJugador);
        edNacionalidad = (EditText) findViewById(R.id.edNacionalidad);
        btnGuardar = (Button) findViewById(R.id.btn_guargar_jugador);
        btnGuardar.setOnClickListener(this);
        ArrayAdapter<CharSequence> adapter =  ArrayAdapter.createFromResource(this,
                R.array.posiciones,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spPosicion = (Spinner) findViewById(R.id.spinner_posicion);
        spPosicion.setAdapter(adapter);
        spPosicion.setOnItemSelectedListener(this);
        equipo = (Equipo) getIntent().getExtras().get("equipo");
        imageSelected = new HashMap<Integer, Integer>();
        imageSelected.put(0,R.drawable.portero);
        imageSelected.put(1,R.drawable.defensa);
        imageSelected.put(2,R.drawable.mediocampista);
        imageSelected.put(3,R.drawable.volante);
        imageSelected.put(4,R.drawable.puntero);
        imageSelected.put(5,R.drawable.extremo);
        imageSelected.put(6,R.drawable.delantero);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_guargar_jugador:
                Jugador jugador = new Jugador(edNombreJugador.getText().toString(),
                                                posicionSelected[posicionSel],
                                                edNacionalidad.getText().toString(),
                                                imageSelected.get(posicionSel));
                equipo.getJugadores().add(jugador);
                Intent intent = new Intent();
                intent.putExtra("equipo",equipo);
                setResult(RESULT_OK,intent);
                finish();
            break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        posicionSel = position;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        posicionSel = -1;
    }
}
