package sv.ues.fia.tipoespecialidad;

import sv.ues.fia.ControladorBDG18;
import sv.ues.fia.R;
import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class TipoEspecialidadEliminar extends Activity {
	EditText editIdEspecialidad;
	ControladorBDG18 controlhelper;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tipo_especialidad_eliminar);
		controlhelper= new ControladorBDG18(this);
		editIdEspecialidad=(EditText)findViewById(R.id.editIdEspecialidad);
	}

public void eliminarTipoEspecialidad(View v){
	//verificar que los campos no esten vacios
	if(TextUtils.isEmpty(editIdEspecialidad.getText().toString())){
		Toast.makeText(this, "Existe Campo vacio", Toast.LENGTH_SHORT).show();
	}
	else{//si no estan vacios ejecuta el metodo
		String regEliminadas;
		TipoEspecialidad tespecialidad= new TipoEspecialidad();
		tespecialidad.setIDespecialidad(Integer.parseInt(editIdEspecialidad.getText().toString()));
		controlhelper.abrir();
		regEliminadas=controlhelper.eliminar(tespecialidad);
		controlhelper.cerrar();
		Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
	}
}

}
