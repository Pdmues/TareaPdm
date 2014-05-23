package sv.ues.fia;

import sv.ues.fia.bitacora.Bitacora;
import android.os.Bundle;
import android.app.Activity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class BitacoraActualizar extends Activity {

	ControladorBDG18 helper;
	EditText editIdBitacora;
	EditText editNTG;
	EditText editQuien;
	EditText editLugar;
	EditText editEtdesarrollada;
	EditText edithorainicio;
	EditText edithorafin;
	Bitacora bitacora;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bitacora_actualizar);
		helper=new ControladorBDG18(this);
		editIdBitacora=(EditText) findViewById(R.id.editIdBitacora);
		editNTG=(EditText) findViewById(R.id.editntg);
		editQuien=(EditText) findViewById(R.id.editQuien);
		editLugar=(EditText) findViewById(R.id.editLugar);
		editEtdesarrollada=(EditText) findViewById(R.id.editEtapaDesarrollada);
		edithorainicio=(EditText) findViewById(R.id.edithorainicio);
		edithorafin=(EditText) findViewById(R.id.edithorafin);
		editNTG.setText(bitacora.getNtg());
		editQuien.setText(bitacora.getQuien());
		editLugar.setText(bitacora.getLugar());
		editEtdesarrollada.setText(String.valueOf(bitacora.getEtapadesarrollada()));
		edithorainicio.setText(bitacora.getHorainicio());
		edithorafin.setText(bitacora.getHorafin());
	}

	public void actualizarBitacora(View v){
		//verificar que los campos no esten vacios
		if(TextUtils.isEmpty(editIdBitacora.getText().toString()) ||
				TextUtils.isEmpty(editNTG.getText().toString()) ||
				TextUtils.isEmpty(editQuien.getText().toString()) ||
				TextUtils.isEmpty(editLugar.getText().toString()) ||
				TextUtils.isEmpty(editEtdesarrollada.getText().toString()) ||
				TextUtils.isEmpty(edithorainicio.getText().toString()) ||
				TextUtils.isEmpty(edithorafin.getText().toString())){
			Toast.makeText(this, "Existe Campo vacio", Toast.LENGTH_SHORT).show();
		}
		else{//si no estan vacios ejecuta el metodo
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
