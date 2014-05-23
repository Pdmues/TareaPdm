package sv.ues.fia.bitacora;

import sv.ues.fia.BitacoraActualizar;
import sv.ues.fia.ControladorBDG18;
import sv.ues.fia.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class BitacoraModificar extends Activity {
	ControladorBDG18 helper;
	EditText editIdBitacora;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bitacora_modificar);
		helper=new ControladorBDG18(this);
		editIdBitacora=(EditText) findViewById(R.id.editIdBitacora);
	}

	public void actualizarBitacora(View v){
		//verificar que los campos no esten vacios
		if(TextUtils.isEmpty(editIdBitacora.getText().toString())){
			Toast.makeText(this, "Existe Campo vacio", Toast.LENGTH_SHORT).show();
		}
		else{//si no estan vacios ejecuta el metodo
			helper.abrir();
			Bitacora bitacora = helper.consultarBitacora(editIdBitacora.getText().toString());
			helper.cerrar();
			if(bitacora == null){
				Toast.makeText(this, "Bitacora con ID "+editIdBitacora.getText().toString()+
					" no encontrada",Toast.LENGTH_LONG).show();
			}else{
				Intent i = new Intent(this, BitacoraActualizar.class);
	            startActivity(i);
			}
		}
	}
	public void limpiarTexto(View v) {
		editIdBitacora.setText("");
		}

}
