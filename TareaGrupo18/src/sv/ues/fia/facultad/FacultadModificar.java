 package sv.ues.fia.facultad;
import sv.ues.fia.ControladorBDG18;
import sv.ues.fia.R;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class FacultadModificar extends Activity {
 ControladorBDG18 helper;
 EditText editIDfacu;
 EditText editNMfacu;
	@Override

	protected void onCreate(Bundle savedInstanceState) {
 		super.onCreate(savedInstanceState);
 		setContentView(R.layout.activity_facultad_modificar);
		helper = new ControladorBDG18(this);
		editIDfacu = (EditText) findViewById(R.id.editNFacultad);
		editNMfacu = (EditText) findViewById(R.id.editNFacu);
 }

public void actualizarCarrera(View v) 
	{
		Facultad facultad = new Facultad();
		facultad.setIDfacultad(editIDfacu.getText().toString());
		facultad.setNombFacultad(editNMfacu.getText().toString());
		helper.abrir();
		String estado = helper.actualizar(facultad);
		helper.cerrar();
		Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();
}

	public void limpiarTexto(View v) 
	{
		editIDfacu.setText("");
		editNMfacu.setText("");
 	}
}