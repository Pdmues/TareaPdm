package sv.ues.fia.etapa;

import sv.ues.fia.ControladorBDG18;
import sv.ues.fia.R;
import android.os.Bundle;
import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EtapaInsertar extends Activity {

	ControladorBDG18 helper;
	EditText numeroetapainsertar;
	EditText NTGinsertar;
	EditText fechainsertar;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_etapa_insertar);
		helper= new ControladorBDG18(this);
		numeroetapainsertar=(EditText)findViewById(R.id.editEtapaNumeroEtapaInsertar);
		NTGinsertar=(EditText)findViewById(R.id.editEtapaNTGInsertar);
		fechainsertar=(EditText)findViewById(R.id.editEtapaFechaInsertar);
		
		
	}

	public void insertaretapa(View v)
	{
		if(TextUtils.isEmpty(numeroetapainsertar.getText().toString())||TextUtils.isEmpty(NTGinsertar.getText().toString())||TextUtils.isEmpty(fechainsertar.getText().toString()))
		{Toast.makeText(this, "Existe Campo vacio", Toast.LENGTH_SHORT).show();}
		else 
		{
		String numero=numeroetapainsertar.getText().toString();
		String NTG= NTGinsertar.getText().toString();
		String fecha= fechainsertar.getText().toString();
		Etapa et=new Etapa();
		et.setNumeroetapa(Integer.parseInt(numero));
		et.setNTG(NTG);
		et.setFecha(fecha);
		helper.abrir();
		String regInsertados=helper.insertar(et);
		helper.cerrar();
		Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();}
			 
	}
public void limpiaretapa(View v)
{
	numeroetapainsertar.setText("");
	NTGinsertar.setText("");
	fechainsertar.setText("");
}
}
