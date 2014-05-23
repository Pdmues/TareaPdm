package sv.ues.fia.etapa;

import sv.ues.fia.ControladorBDG18;
import sv.ues.fia.R;
import android.os.Bundle;
import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EtapaEliminar extends Activity {
	ControladorBDG18 helper;
	EditText numeroetapaeliminar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_etapa_eliminar);
		helper=new ControladorBDG18(this);
		numeroetapaeliminar=(EditText)findViewById(R.id.editNumeroEtapaEliminar);
	}

	public void eliminaretapa(View v)
	{
		if(TextUtils.isEmpty(numeroetapaeliminar.getText().toString()))
		{Toast.makeText(this, "Existe Campo vacio", Toast.LENGTH_SHORT).show();}
		else{
		Etapa e=new Etapa();
		e.setNumeroetapa(Integer.parseInt(numeroetapaeliminar.getText().toString()));
		helper.abrir();
		String eliminados=helper.eliminar(e);
		helper.cerrar();
		Toast.makeText(this, eliminados, Toast.LENGTH_SHORT).show();}
	}
}
