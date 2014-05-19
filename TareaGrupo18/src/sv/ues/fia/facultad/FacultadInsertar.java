package sv.ues.fia.facultad;

import sv.ues.fia.R;
import sv.ues.fia.ControladorBDG18;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class FacultadInsertar extends Activity {

	ControladorBDG18 helper;
	EditText editIdfacu;
	EditText editNfacu;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_facultad_insertar);
		helper = new ControladorBDG18(this);
		editIdfacu = (EditText) findViewById(R.id.editIFacultad);
		editNfacu = (EditText) findViewById(R.id.editIFNomb);
	}

	public void insertarfacultad(View v) 
	{
		String CFacultad= editIdfacu.getText().toString();
		String NFacultad= editNfacu.getText().toString();
		String regInsertados;
		Facultad facultad=new Facultad();
		facultad.setIDfacultad(CFacultad);
		facultad.setNombFacultad(NFacultad);
		helper.abrir();
		regInsertados=helper.insertar(facultad);
		helper.cerrar();
		Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
	}
	public void limpiarTexto(View v) 
	{
		editIdfacu.setText("");
		editNfacu.setText("");
	}

}
