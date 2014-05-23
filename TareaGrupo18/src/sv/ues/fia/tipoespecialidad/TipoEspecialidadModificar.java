package sv.ues.fia.tipoespecialidad;

import sv.ues.fia.ControladorBDG18;
import sv.ues.fia.R;
import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class TipoEspecialidadModificar extends Activity {
	ControladorBDG18 helper;
	EditText editIDEspecialidad;
	EditText editnomespecialidad;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tipo_especialidad_modificar);
		helper = new ControladorBDG18(this);
		editIDEspecialidad = (EditText) findViewById(R.id.editIDEspecialidad);
		editnomespecialidad = (EditText) findViewById(R.id.editnomespecialidad);
	}

	public void modificarTipoEspecialidad(View v) {
		//verificar que los campos no esten vacios
		if(TextUtils.isEmpty(editIDEspecialidad.getText().toString()) ||
				TextUtils.isEmpty(editnomespecialidad.getText().toString())){
			Toast.makeText(this, "Existe Campo vacio", Toast.LENGTH_SHORT).show();
		}
		else{//si no estan vacios ejecuta el metodo
		TipoEspecialidad tespecialidad = new TipoEspecialidad();
		tespecialidad.setIDespecialidad(Integer.parseInt(editIDEspecialidad.getText().toString()));
		tespecialidad.setNombreEspecialidad(editnomespecialidad.getText().toString());
		helper.abrir();
		String estado = helper.actualizar(tespecialidad);
		helper.cerrar();
		Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();
		}
	}
	
		public void limpiarTexto(View v) {
		editIDEspecialidad.setText("");
		editnomespecialidad.setText("");
		}
}
