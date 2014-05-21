package sv.ues.fia.evaluacionetapa;

import sv.ues.fia.R;
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
		numeroetapainsertar=(EditText)findViewById(R.id.editNEtapa);
		carnetinsertar= (EditText)findViewById(R.id.editEvaluacionEtapaCarnet);
	    notaetapainsertar=(EditText)findViewById(R.id.editNotaEvaluacionEtapaInsertar);
	}

	public void InsertarEvaluacionEtapa(View v){
		String numeroetapa=numeroetapainsertar.getText().toString();
		String carnet=carnetinsertar.getText().toString();
		String nota=notaetapainsertar.getText().toString();
		Toast.makeText(this, numeroetapa, Toast.LENGTH_SHORT).show();
		Toast.makeText(this, carnet, Toast.LENGTH_SHORT).show();
		Toast.makeText(this, nota, Toast.LENGTH_SHORT).show();
		String insertados;
		EvaluacionEtapa eva=new EvaluacionEtapa();
		eva.setNetapa(Integer.parseInt(numeroetapa));
		eva.setCarnet(carnet);
		eva.setNota(Double.parseDouble(nota));
		helper.abrir();
		insertados=helper.insertar(eva);
		helper.cerrar();
		Toast.makeText(this, insertados, Toast.LENGTH_SHORT).show();
		
	}
	public void limpiarEvaluacionEtapaInsertar(View v){
		numeroetapainsertar.setText("");
		carnetinsertar.setText("");
		notaetapainsertar.setText("");
		
	}


}
