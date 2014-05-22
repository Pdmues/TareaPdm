package sv.ues.fia.registrobitacora;

import sv.ues.fia.ControladorBDG18;
import sv.ues.fia.R;
import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegistroBitacoraModificar extends Activity {
	ControladorBDG18 helper;
	EditText editIdBitacora;
	EditText editcarnet;
	EditText edittiporeunion;
	EditText editfecha;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_registro_bitacora_modificar);
		helper =new ControladorBDG18(this);
		editIdBitacora = (EditText) findViewById(R.id.editIdBitacora);
		editcarnet =(EditText) findViewById(R.id.editcarnet);
		edittiporeunion = (EditText) findViewById(R.id.edittiporeunion);
		editfecha = (EditText) findViewById(R.id.editfecha);
	}
	public void actualizarRegistroBitacora(View v) {
		//verificar que los campos no esten vacios
		if(TextUtils.isEmpty(editcarnet.getText().toString()) ||
				TextUtils.isEmpty(editIdBitacora.getText().toString()) ||
				TextUtils.isEmpty(edittiporeunion.getText().toString()) ||
				TextUtils.isEmpty(editfecha.getText().toString())){
			Toast.makeText(this, "Existe Campo vacio", Toast.LENGTH_SHORT).show();
		}
		else{//si no estan vacios ejecuta el metodo
			RegistroBitacora regBit = new RegistroBitacora();
			regBit.setIdbitacora(Integer.parseInt(editIdBitacora.getText().toString()));
			regBit.setCarnet(editcarnet.getText().toString());
			regBit.setTipoReunion(edittiporeunion.getText().toString());
			regBit.setFecha(editfecha.getText().toString());
			helper.abrir();
			String estado = helper.actualizar(regBit);
			helper.cerrar();
			Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();
		}
	}

	public void limpiarTexto(View v){
		editIdBitacora.setText("");
		editcarnet.setText("");
		edittiporeunion.setText("");
		editfecha.setText("");
	}
}
