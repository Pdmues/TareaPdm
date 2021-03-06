package sv.ues.fia.perfil;
import sv.ues.fia.ControladorBDG18;
import sv.ues.fia.R;
import sv.ues.fia.perfil.Perfil;
import android.os.Bundle;
import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class PerfilEliminar extends Activity {
	EditText editEper;
	ControladorBDG18 controlhelper;
	@Override

protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_perfil_elimiar);
		controlhelper=new ControladorBDG18 (this);
		editEper=(EditText)findViewById(R.id.editEPerfil);
}

public void eliminarPerfil(View v)
{
	if(TextUtils.isEmpty(editEper.getText().toString()))
		Toast.makeText(this, "El Campo esta vacio", Toast.LENGTH_SHORT).show();
	else{
		String regEliminadas;
		Perfil perfil = new Perfil();
		perfil.setNperfil1(Integer.parseInt(editEper.getText().toString()));
		controlhelper.abrir();
		regEliminadas=controlhelper.eliminar(perfil);
		controlhelper.cerrar();
		Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();}
	}
}