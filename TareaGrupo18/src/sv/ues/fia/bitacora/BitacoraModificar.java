package sv.ues.fia.bitacora;

import sv.ues.fia.ControladorBDG18;
import sv.ues.fia.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class BitacoraModificar extends Activity {
	ControladorBDG18 helper;
	EditText editIdBitacora;
	EditText editNTG;
	EditText editQuien;
	EditText editLugar;
	EditText editEtdesarrollada;
	EditText edithorainicio;
	EditText edithorafin;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bitacora_modificar);
		helper=new ControladorBDG18(this);
		editIdBitacora=(EditText) findViewById(R.id.editIdBitacora);
		editNTG=(EditText) findViewById(R.id.editNTG);
		editQuien=(EditText) findViewById(R.id.editQuien);
		editLugar=(EditText) findViewById(R.id.editLugar);
		editEtdesarrollada=(EditText) findViewById(R.id.editEtdesarrollada);
		edithorainicio=(EditText) findViewById(R.id.edithorainicio);
		edithorafin=(EditText) findViewById(R.id.edithorafin);
	}

	public void actualizarBitacora(View v){
		Bitacora bita = new Bitacora();
		bita.setIdbitacora(Integer.parseInt(editIdBitacora.getText().toString()));
		bita.setNtg(editNTG.getText().toString());
		bita.setQuien(editQuien.getText().toString());
		bita.setLugar(editLugar.getText().toString());
		bita.setEtapadesarrollada(Integer.parseInt(editEtdesarrollada.getText().toString()));
		bita.setHorainicio(edithorainicio.getText().toString());
		bita.setHorafin(edithorafin.getText().toString());
		
		helper.abrir();
		String estado = helper.actualizar(bita);
		helper.cerrar();
		Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();
	}
	public void limpiarTexto(View v) {
		editIdBitacora.setText("");
		editNTG.setText("");
		editQuien.setText("");
		editLugar.setText("");
		editEtdesarrollada.setText("");
		edithorainicio.setText("");
		edithorafin.setText("");
		}

}
