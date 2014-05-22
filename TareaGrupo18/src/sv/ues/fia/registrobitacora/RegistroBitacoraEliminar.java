package sv.ues.fia.registrobitacora;

import sv.ues.fia.ControladorBDG18;
import sv.ues.fia.R;
import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegistroBitacoraEliminar extends Activity {
	EditText editIdBitacora,editcarnet;
	ControladorBDG18 helper;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_registro_bitacora_eliminar);
		helper=new ControladorBDG18(this);
		editIdBitacora=(EditText)findViewById(R.id.editIdBitacora);
		editcarnet=(EditText)findViewById(R.id.editcarnet);
	}

	public void eliminarRegistroBitacora(View v){
		//verificar que los campos no esten vacios
				if(TextUtils.isEmpty(editcarnet.getText().toString()) ||
						TextUtils.isEmpty(editIdBitacora.getText().toString())){
					Toast.makeText(this, "Campo vacio", Toast.LENGTH_SHORT).show();
				}
				else{//si no estan vacios ejecuta el metodo
					String regEliminadas;
					RegistroBitacora rbit =new RegistroBitacora();
					rbit.setIdbitacora(Integer.parseInt(editIdBitacora.getText().toString()));
					rbit.setCarnet(editcarnet.getText().toString());
					helper.abrir();
					regEliminadas=helper.eliminar(rbit);
					helper.cerrar();
					Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
				}
	}

}
