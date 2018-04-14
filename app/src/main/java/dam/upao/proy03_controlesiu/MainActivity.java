package dam.upao.proy03_controlesiu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText edtNombre;
    private Button btnAceptar;
    private Button btnSalir;
    private CheckBox chkRegistrado;
    private RadioButton rbtSoltero,rbtCasado,rbtDivorciado,rbtViudo;
    private Spinner spnEscuela;
    private ListView lstvSede;
    String[] dataEscuela = {"ICSI","INSO"};
    String[] dataSede= {"Trujillo", "Piura","Lima"};
    private ArrayAdapter<String> adapEscuelas;
    private ArrayAdapter<String> adapSede;
    private String  sSede;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNombre = (EditText) findViewById(R.id.edtNombre);
        btnAceptar = (Button) findViewById(R.id.btnAceptar);
        btnSalir = (Button) findViewById(R.id.btnSalir);
        rbtCasado = (RadioButton) findViewById(R.id.rbtCasado);
        rbtSoltero = (RadioButton) findViewById(R.id.rbtSoltero);
        rbtDivorciado = (RadioButton) findViewById(R.id.rbtDivorciado);
        rbtViudo = (RadioButton) findViewById(R.id.rbtViudo);
        chkRegistrado = (CheckBox) findViewById(R.id.chkRegistrado);
        spnEscuela = (Spinner) findViewById(R.id.spnEscuela);
        lstvSede = (ListView) findViewById(R.id.lstvSede);

        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sMsg = "Hola " + edtNombre.getText().toString();
                if(chkRegistrado.isChecked()) sMsg +="\n" + "Estás Registrado";
                if(rbtSoltero.isChecked()) sMsg +="\n"+ "Estado Civil: " + rbtSoltero.getText().toString();
                if(rbtCasado.isChecked()) sMsg +="\n"+ "Estado Civil: " + rbtCasado.getText().toString();
                if(rbtDivorciado.isChecked()) sMsg +="\n"+ "Estado Civil: " + rbtDivorciado.getText().toString();
                if(rbtViudo.isChecked()) sMsg +="\n"+ "Estado Civil: " + rbtViudo.getText().toString();
                sMsg+="\n" +"Escuela: "+spnEscuela.getSelectedItem().toString();
                //if(lstvSede.getItemsCanFocus())
                    sMsg +="\n"+"Sede: "+ sSede;
                Toast.makeText(MainActivity.this, sMsg,Toast.LENGTH_LONG).show();

            }
        });
        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        adapEscuelas = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,dataEscuela);
        adapEscuelas.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnEscuela.setAdapter(adapEscuelas);
        adapSede= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,dataSede);
        lstvSede.setAdapter(adapSede);
        lstvSede.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                sSede= dataSede[i];
            }
        });
    }
}
