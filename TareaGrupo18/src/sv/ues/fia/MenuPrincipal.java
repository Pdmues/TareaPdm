package sv.ues.fia;


import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class MenuPrincipal extends Activity{
	ControladorBDG18 BDhelper;
	EditText editusuario;
	EditText editcontrasena;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu_principal);
		BDhelper=new ControladorBDG18(this);
		editusuario=(EditText) findViewById(R.id.editusuario);
		editcontrasena=(EditText) findViewById(R.id.editcontrasena);
	}

	public void Ingresar(View v){
		String[] activities={"MenuSecundarioActivity","CrearUsuarioActivity"};
		int posicion;
		if(editusuario.getText().toString().equals("root") && editcontrasena.getText().toString().equals("root")){
			posicion=0;
		}else{
			posicion=1;
		}
		String nombreValue=activities[posicion];
		try{
			Class<?> clase=Class.forName("sv.ues.fia."+nombreValue);
			Intent inte = new Intent(this,clase);
			this.startActivity(inte);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}

}
