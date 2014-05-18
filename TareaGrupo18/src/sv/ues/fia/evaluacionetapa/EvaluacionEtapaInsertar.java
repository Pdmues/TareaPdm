package sv.ues.fia.evaluacionetapa;

import sv.ues.fia.R;
import sv.ues.fia.R.layout;
import sv.ues.fia.R.menu;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import sv.ues.fia.ControladorBDG18;
import android.widget.EditText;
import android.widget.Toast;

public class EvaluacionEtapaInsertar extends Activity {
 ControladorBDG18 helper;
 EditText numeroetapainsertar;
 EditText carnetinsertar;
 EditText notaetapainsertar;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_evaluacion_etapa_insertar);
		helper=new ControladorBDG18(this);
		numeroetapainsertar=(EditText)findViewById(R.id.netapa);
		carnetinsertar= (EditText)findViewById(R.id.editEvaluacionEtapaCarnet);
		notaetapainsertar=(EditText)findViewById(R.id.editNotaEvaluacionEtapaInsertar);
	}

	public void InsertarEvaluacionEtapa(View v){
		String numeroetapa=numeroetapainsertar.getText().toString();
		String carnet=carnetinsertar.getText().toString();
		String nota=notaetapainsertar.getText().toString();
		String insertados;
		EvaluacionEtapa eva=new EvaluacionEtapa();
		eva.setNetapa(Integer.parseInt(numeroetapa));
		eva.setCarnet(carnet);
		eva.setNota(Integer.parseInt(nota));
		helper.abrir();
		//insertados=helper.in
		
	}
	public void limpiarEvaluacionEtapaInsertar(){
		numeroetapainsertar.setText("");
		carnetinsertar.setText("");
		notaetapainsertar.setText("");
		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.evaluacion_etapa_insertar, menu);
		return true;
	}

}
