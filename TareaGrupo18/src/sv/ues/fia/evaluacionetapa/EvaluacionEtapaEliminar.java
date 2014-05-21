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

public class EvaluacionEtapaEliminar extends Activity {
	EditText numeroetapaeliminarevaluacionetapa;
	EditText carneteliminarevaluacionetapa;
	ControladorBDG18 controlhelper;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_evaluacion_etapa_eliminar);
		numeroetapaeliminarevaluacionetapa=(EditText)findViewById(R.id.editEvaluacionEtapaEliminarNumeroEtapa);
		carneteliminarevaluacionetapa=(EditText)findViewById(R.id.editEvaluacionEtapaEliminarCarnet);
		controlhelper=new ControladorBDG18 (this);
	}

	public void eliminarEvaluacionEtapa(View v)
	{
		String regEliminadas;
		EvaluacionEtapa evea=new EvaluacionEtapa();
		evea.setNetapa(Integer.parseInt(numeroetapaeliminarevaluacionetapa.getText().toString()));
		evea.setCarnet(carneteliminarevaluacionetapa.getText().toString());
		Toast.makeText(this, " "+evea.getNetapa(), Toast.LENGTH_SHORT).show();
		Toast.makeText(this, evea.getCarnet(), Toast.LENGTH_SHORT).show();
		controlhelper.abrir();
		regEliminadas=controlhelper.eliminar(evea);
		controlhelper.cerrar();
		Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
		
	}

}
