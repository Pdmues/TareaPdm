package sv.ues.fia.etapa;

import sv.ues.fia.ControladorBDG18;
import sv.ues.fia.R;
import android.os.Bundle;
import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EtapaConsultar extends Activity {
	ControladorBDG18 helper;
	EditText numeroetapamodificar;
	EditText numerotgmodificar;
	EditText fechamodificar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_etapa_consultar);
		helper=new ControladorBDG18(this);
		numeroetapamodificar=(EditText)findViewById(R.id.editnumeroetapaconsultaretapa);
		numerotgmodificar=(EditText)findViewById(R.id.editntgraduacionconsultaretapa);
		fechamodificar=(EditText)findViewById(R.id.editfechaconsultaretapa);
	}

	public void consultaretapa(View v)
	{
		if(TextUtils.isEmpty((numeroetapamodificar.getText().toString()))||TextUtils.isEmpty(numerotgmodificar.getText().toString())||TextUtils.isEmpty(fechamodificar.getText().toString()))
		{Toast.makeText(this, "Existe Campo vacio", Toast.LENGTH_SHORT).show();}
		else{	
		helper.abrir();
		Etapa e=helper.consultaretapa(numeroetapamodificar.getText().toString());
		helper.cerrar();
		if(e==null)
		{
			Toast.makeText(this,"La etapa con numero"+numeroetapamodificar.getText().toString()+" no se ha encontrado", Toast.LENGTH_LONG).show();
		}
		else{
		numerotgmodificar.setText(e.getNTG().toString());
		fechamodificar.setText(e.getFecha().toString());
		}}
	}
public void limpiarconsultaretapa(View v)
{
	numeroetapamodificar.setText("");
	numerotgmodificar.setText("");
	fechamodificar.setText("");
}

}
