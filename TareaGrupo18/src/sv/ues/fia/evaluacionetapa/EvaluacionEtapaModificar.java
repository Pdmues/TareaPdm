package sv.ues.fia.evaluacionetapa;

import sv.ues.fia.ControladorBDG18;
import sv.ues.fia.R;
import sv.ues.fia.R.layout;
import sv.ues.fia.R.menu;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EvaluacionEtapaModificar extends Activity {
	ControladorBDG18 helper;
	EditText numeroetapaevaluacionmodificar;
	EditText carnetetapaevaluacionmodificcar;
	EditText notaetapaevaluacionmodificar;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_evaluacion_etapa_modificar);
		helper=new ControladorBDG18(this);
		numeroetapaevaluacionmodificar=(EditText)findViewById(R.id.editNumeroEtapaEvaluacioEtapaModificar);
		carnetetapaevaluacionmodificcar=(EditText)findViewById(R.id.editCarnetEvaluacionEtapaModificar);
		notaetapaevaluacionmodificar=(EditText)findViewById(R.id.editNotaEvaluacionEtapaModificar);
	}

	public void actualizarevaluacionetapa(View v)
	{
		EvaluacionEtapa eve=new EvaluacionEtapa();
		eve.setNetapa(Integer.parseInt(numeroetapaevaluacionmodificar.getText().toString()));
		eve.setCarnet(carnetetapaevaluacionmodificcar.getText().toString() );
	    eve.setNota(Double.parseDouble(notaetapaevaluacionmodificar.getText().toString()));
	    helper.abrir();
	    String regActualizados=helper.actualizar(eve);
	    Toast.makeText(this, regActualizados, Toast.LENGTH_SHORT).show();
	}
	public void limpiaractualizarevaluacionetapa(View v)
	{
		numeroetapaevaluacionmodificar.setText("");
		carnetetapaevaluacionmodificcar.setText("");
		notaetapaevaluacionmodificar.setText("");
	}
}
