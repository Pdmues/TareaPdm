package sv.ues.fia.evaluacionetapa;

import java.util.ResourceBundle.Control;

import sv.ues.fia.ControladorBDG18;
import sv.ues.fia.R;
import sv.ues.fia.R.layout;
import sv.ues.fia.R.menu;
import android.os.Bundle;
import android.app.Activity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EvaluacionEtapaConsultar extends Activity {
  EditText consultarevaluacionetapanumero;
  EditText consultarevaluacionetapacarnet;
  EditText consultarevaluacionetapanota;
  ControladorBDG18 controlhelper;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_evaluacion_etapa_consultar);
		consultarevaluacionetapanumero=(EditText)findViewById(R.id.editNumeroEtapaEvaluacioEtapaConsultar);
		consultarevaluacionetapacarnet=(EditText)findViewById(R.id.editCarnetEvaluacionEtapaConsultar);
		consultarevaluacionetapanota=(EditText)findViewById(R.id.editNotaEvaluacionEtapaConsultar);
		controlhelper=new ControladorBDG18 (this);
	}

	public void consultarEvaluacionEtapa(View v)
	{
		if(TextUtils.isEmpty(consultarevaluacionetapanumero.getText().toString())||TextUtils.isEmpty(consultarevaluacionetapacarnet.getText().toString()))
		{Toast.makeText(this, "Existe Campo vacio", Toast.LENGTH_SHORT).show();}
		else{
		controlhelper.abrir();
		EvaluacionEtapa evaluacione=controlhelper.consultarEvaluacionEtapa(consultarevaluacionetapanumero.getText().toString(), consultarevaluacionetapacarnet.getText().toString());
		controlhelper.cerrar();
		if(evaluacione==null)
		{
			Toast.makeText(this, "La etapa con numero " +
					consultarevaluacionetapanumero.getText().toString() +
			"y carnet"+consultarevaluacionetapacarnet.getText().toString()+"no existe", Toast.LENGTH_LONG).show();
		}
		else{
			consultarevaluacionetapanota.setText(""+evaluacione.getNota());
		}
	}
	}
}
