package sv.ues.fia.registrobitacora;

import sv.ues.fia.ControladorBDG18;
import sv.ues.fia.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegistroBitacoraInsertar extends Activity {
	ControladorBDG18 helper;
	EditText editIdBitacora;
	EditText editcarnet;
	EditText edittiporeunion;
	EditText editfecha;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_registro_bitacora_insertar);
		helper =new ControladorBDG18(this);
		editIdBitacora = (EditText) findViewById(R.id.editIdBitacora);
		editcarnet =(EditText) findViewById(R.id.editcarnet);
		edittiporeunion = (EditText) findViewById(R.id.edittiporeunion);
		editfecha = (EditText) findViewById(R.id.editfecha);
	}

	public void insertarRegistroBitacora(View v){
		String regInsertados;
		String idBitacora=editIdBitacora.getText().toString();
		String carnet=editcarnet.getText().toString();
		String tiporeunion=edittiporeunion.getText().toString();
		String fecha=editfecha.getText().toString();
		RegistroBitacora bit= new RegistroBitacora();
		bit.setIdbitacora(Integer.parseInt(idBitacora));
		bit.setCarnet(carnet);
		bit.setTipoReunion(tiporeunion);
		bit.setFecha(fecha);
		helper.abrir();
		regInsertados=helper.insertar(bit);
		helper.cerrar();
		Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
	}
	public void limpiarTexto(View v){
		editIdBitacora.setText("");
		editcarnet.setText("");
		edittiporeunion.setText("");
		editfecha.setText("");
	}

}
