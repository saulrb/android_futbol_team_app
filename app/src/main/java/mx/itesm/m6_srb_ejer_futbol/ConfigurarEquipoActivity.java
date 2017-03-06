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
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class ConfigurarEquipoActivity extends AppCompatActivity implements View.OnClickListener , AdapterView.OnItemSelectedListener{

    EditText edNombreEquipo,edEntrenador;
    String[] ligaSelected = { "Premier League - Inglesa","LaLiga - Española","Bundesliga - Alemana","Liga Mx - Mexicana","Serie A - Italiana"};
    Button btnGuardar;
    Spinner spLiga;
    static Equipo equipo = null;
    Map<Integer, Integer> imageSelected = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cofigurar_equipo);
        edEntrenador = (EditText) findViewById(R.id.edEntrenador);
        edNombreEquipo = (EditText) findViewById(R.id.edNombreEquipo);
        btnGuardar = (Button) findViewById(R.id.btn_guargar_equipo);
        btnGuardar.setOnClickListener(this);
        ArrayAdapter<CharSequence> adapter =  ArrayAdapter.createFromResource(this,
                                                            R.array.ligas_futbol,
                                                            android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spLiga = (Spinner) findViewById(R.id.spinner_liga);
        spLiga.setAdapter(adapter);
        spLiga.setOnItemSelectedListener(this);
        equipo = (Equipo) getIntent().getExtras().get("equipo");
        if (equipo == null) {
            equipo = new Equipo("","","",0);
        } else {
            edEntrenador.setText(equipo.getDirectorTecnico());
            edNombreEquipo.setText(equipo.getNombreEquipo());
            spLiga.setSelection(equipo.getIntLiga());
        }
        imageSelected = new HashMap<Integer, Integer>();
        imageSelected.put(0,R.drawable.premier_league);
        imageSelected.put(1,R.drawable.laliga);
        imageSelected.put(2,R.drawable.bundesliga);
        imageSelected.put(3,R.drawable.ligamx);
        imageSelected.put(4,R.drawable.seriea);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_guargar_equipo:
                equipo.setDirectorTecnico(edEntrenador.getText().toString());
                equipo.setNombreEquipo(edNombreEquipo.getText().toString());
                Intent intent = new Intent();
                intent.putExtra("equipo",equipo);
                setResult(RESULT_OK,intent);
                finish();
                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        equipo.setIdImagen(imageSelected.get(position));
        equipo.setLiga(ligaSelected[position]);
        equipo.setIntLiga(position);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        equipo.setIdImagen(0);
        equipo.setLiga("");
        equipo.setIntLiga(0);
    }


}
