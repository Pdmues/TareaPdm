package sv.ues.fia.bitacora;

import sv.ues.fia.ControladorBDG18;
import sv.ues.fia.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class BitacoraConsultar extends Activity {
	ControladorBDG18 helper;
	EditText editIdBitacora;
	EditText editntg;
	EditText editQuien;
	EditText editLugar;
	EditText editEtapaDesarrollada;
	EditText edithorainicio;
	EditText edithorafin;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bitacora_consultar);
		helper = new ControladorBDG18(this);
		editIdBitacora = (EditText) findViewById(R.id.editIdBitacora);
		editntg = (EditText) findViewById(R.id.editntg);
		editQuien = (EditText) findViewById(R.id.editQuien);
		editLugar = (EditText) findViewById(R.id.editLugar);
		editEtapaDesarrollada = (EditText) findViewById(R.id.editEtapaDesarrollada);
		edithorainicio = (EditText) findViewById(R.id.edithorainicio);
		edithorafin = (EditText) findViewById(R.id.edithorafin);
	}

	public void ConsultarBitacora(View v) {
		helper.abrir();
		Bitacora bitacora = helper.consultarBitacora(editIdBitacora.getText().toString());
		helper.cerrar();
		if(bitacora == null){
			Toast.makeText(this, "Bitacora con ID "+editIdBitacora.getText().toString()+
				" no encontrada",Toast.LENGTH_LONG).show();
		}else{
		editntg.setText(bitacora.getNtg());
		editQuien.setText(bitacora.getQuien());
		editLugar.setText(bitacora.getLugar());
		editEtapaDesarrollada.setText(String.valueOf(bitacora.getEtapadesarrollada()));
		edithorainicio.setText(bitacora.getHorainicio());
		edithorafin.setText(bitacora.getHorafin());
		}
	}
	public void limpiarTexto(View v){
		editIdBitacora.setText("");
		editntg.setText("");
		editQuien.setText("");
		editLugar.setText("");
		editEtapaDesarrollada.setText("");
		edithorainicio.setText("");
		edithorafin.setText("");
	}

}
