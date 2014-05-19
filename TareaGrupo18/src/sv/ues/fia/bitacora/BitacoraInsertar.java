package sv.ues.fia.bitacora;

import sv.ues.fia.ControladorBDG18;
import sv.ues.fia.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class BitacoraInsertar extends Activity {
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
		setContentView(R.layout.activity_bitacora_insertar);
		helper=new ControladorBDG18(this);
		editIdBitacora=(EditText) findViewById(R.id.editIdBitacora);
		editNTG=(EditText) findViewById(R.id.editNTG);
		editQuien=(EditText) findViewById(R.id.editQuien);
		editLugar=(EditText) findViewById(R.id.editLugar);
		editEtdesarrollada=(EditText) findViewById(R.id.editEtdesarrollada);
		edithorainicio=(EditText) findViewById(R.id.edithorainicio);
		edithorafin=(EditText) findViewById(R.id.edithorafin);
	}

	public void insertarBitacora(View v){
		String idbitacora=editIdBitacora.getText().toString();
		String ntg=editNTG.getText().toString();
		String quien=editQuien.getText().toString();
		String lugar=editLugar.getText().toString();
		String etapadesarrollada=editEtdesarrollada.getText().toString();
		String horainicio=edithorainicio.getText().toString();
		String horafin=edithorafin.getText().toString();
		String regInsertados;
		Bitacora bitacora=new Bitacora();
		bitacora.setIdbitacora(Integer.parseInt(idbitacora));
		bitacora.setNtg(ntg);
		bitacora.setQuien(quien);
		bitacora.setLugar(lugar);
		bitacora.setEtapadesarrollada(Integer.parseInt(etapadesarrollada));
		bitacora.setHorainicio(horainicio);
		bitacora.setHorafin(horafin);
		helper.abrir();
		regInsertados=helper.insertar(bitacora);
		helper.cerrar();
		Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
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
