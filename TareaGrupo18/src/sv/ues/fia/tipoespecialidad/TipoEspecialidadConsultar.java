package sv.ues.fia.tipoespecialidad;

import sv.ues.fia.ControladorBDG18;
import sv.ues.fia.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class TipoEspecialidadConsultar extends Activity {
	ControladorBDG18 helper;
	EditText editIdTipoEspecialidad;
	EditText editNombreEspecialidad;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tipo_especialidad_consultar);
		helper = new ControladorBDG18(this);
		editIdTipoEspecialidad = (EditText) findViewById(R.id.editIdTEspecialidad);
		editNombreEspecialidad = (EditText) findViewById(R.id.editNombreEspecialidad);
	}
	public void consultarTipoEspecialidad(View v){
		helper.abrir();
		TipoEspecialidad tespecialidad =helper.consultarTipoEspecialidad(editIdTipoEspecialidad.getText().toString());
		helper.cerrar();
		if(tespecialidad==null){
			Toast.makeText(this, "Especialidad con codigo "+editIdTipoEspecialidad.getText().toString()+" no encontrada", Toast.LENGTH_LONG).show();
		}else{
			editNombreEspecialidad.setText(tespecialidad.getNombreEspecialidad());
		}
		
	}
	public void limpiarTexto(View v){
		editIdTipoEspecialidad.setText("");
		editNombreEspecialidad.setText("");
	}

}
