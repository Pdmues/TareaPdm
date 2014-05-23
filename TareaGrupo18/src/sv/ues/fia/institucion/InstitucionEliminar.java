package sv.ues.fia.institucion;

import sv.ues.fia.R;
import sv.ues.fia.ControladorBDG18;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class InstitucionEliminar extends Activity {
	EditText editECInst;
	ControladorBDG18 controlhelper;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_institucion_eliminar);
		controlhelper=new ControladorBDG18 (this);
		editECInst=(EditText)findViewById(R.id.editECInstitucion);
	}


	public void eliminarInstitucion(View v)
	{
		if(editECInst.getText().toString().equals(""))
		{
			Toast.makeText(this, "Campos vacios", Toast.LENGTH_LONG).show();
			editECInst.setText("");
		}
		else
		{
			String regEliminadas;
			Institucion institucion=new Institucion();
			institucion.setIdindtitucion(Integer.parseInt(editECInst.getText().toString()));
			controlhelper.abrir();
			regEliminadas=controlhelper.eliminar(institucion);
			controlhelper.cerrar();
			Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
		}
	}
}
