package sv.ues.fia.etapa;

import sv.ues.fia.R;
import sv.ues.fia.R.layout;
import sv.ues.fia.R.menu;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class EtapaEliminar extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_etapa_eliminar);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.etapa_eliminar, menu);
		return true;
	}

}
