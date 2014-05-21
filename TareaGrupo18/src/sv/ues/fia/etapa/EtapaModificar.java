package sv.ues.fia.etapa;

import sv.ues.fia.ControladorBDG18;
import sv.ues.fia.R;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EtapaModificar extends Activity {

	ControladorBDG18 helper;
	EditText numeroetapamodificar;
	EditText ntgetapamodificar;
	EditText fechaetapamodificar;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_etapa_modificar);
	    helper= new ControladorBDG18(this);
	    numeroetapamodificar=(EditText)findViewById(R.id.editnumeroetapamodificaretapa);
	    ntgetapamodificar=(EditText)findViewById(R.id.editntgetapamodificar);
	    fechaetapamodificar=(EditText)findViewById(R.id.editfechamodificaretapa);
	}

public void actualizaretapa(View v)
{
	Etapa e= new Etapa();
	e.setNumeroetapa(Integer.parseInt(numeroetapamodificar.getText().toString()));
	e.setNTG(ntgetapamodificar.getText().toString());
	e.setFecha(fechaetapamodificar.getText().toString());
	helper.abrir();
	String actualizacion=helper.actualizar(e);
	helper.cerrar();
	Toast.makeText(this, actualizacion, Toast.LENGTH_LONG).show();
}

}
