package sv.ues.fia.registrobitacora;

import sv.ues.fia.ControladorBDG18;
import sv.ues.fia.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegistroBitacoraConsultar extends Activity {
	ControladorBDG18 helper;
	EditText editIdBitacora;
	EditText editcarnet;
	EditText edittiporeunion;
	EditText editfecha;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_registro_bitacora_consultar);
		helper =new ControladorBDG18(this);
		editIdBitacora= (EditText) findViewById(R.id.editIdBitacora);
		editcarnet=(EditText) findViewById(R.id.editcarnet);
		edittiporeunion=(EditText) findViewById(R.id.edittiporeunion);
		editfecha=(EditText) findViewById(R.id.editfecha);
	}

	public void consultarRegistroBitacora(View v) {
		helper.abrir();
		RegistroBitacora Rbitacora = helper.consultarRegistroBitacora(editIdBitacora.getText().toString(),
		editcarnet.getText().toString());
		helper.cerrar();
		if(Rbitacora == null){
			Toast.makeText(this, "Registor de Bitacora no realizada",Toast.LENGTH_LONG).show();
		}else{
			editIdBitacora.setText(String.valueOf(Rbitacora.getIdbitacora()));
			editcarnet.setText(Rbitacora.getCarnet());
			edittiporeunion.setText(Rbitacora.getTipoReunion());
			editfecha.setText(Rbitacora.getFecha());
		}
	}
	public void limpiarTexto(View v){
		editIdBitacora.setText("");
		editcarnet.setText("");
		edittiporeunion.setText("");
		editfecha.setText("");
	}

}
