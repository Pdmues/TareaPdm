package sv.ues.fia.bitacora;

import sv.ues.fia.ControladorBDG18;
import sv.ues.fia.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class BitacoraEliminar extends Activity {
	ControladorBDG18 helper;
	EditText editIdBitacora;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bitacora_eliminar);
		helper = new ControladorBDG18(this);
		editIdBitacora=(EditText) findViewById(R.id.editIdBitacora);
	}

	public void eliminarBitacora(View v){
		String regEliminadas;
		Bitacora bitacora = new Bitacora();
		bitacora.setIdbitacora(Integer.parseInt(editIdBitacora.getText().toString()));
		helper.abrir();
		regEliminadas=helper.eliminar(bitacora);
		helper.cerrar();
		Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
	}
}