package sv.ues.fia.evaluacionetapa;

import android.os.Bundle;
import android.app.ListActivity;
import android.content.Intent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class EvaluacionEtapaMenu extends ListActivity {
	String []menu={"Insertar Etapa","Consultar Etapa","Eliminar Etapa","Modificar Etapa"};
	String []valores={"EvaluacionEtapaInsertar","EvaluacionEtapaConsultar","EvaluacionEtapaEliminar","EvaluacionEtapaModificar"};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,menu));
		
	}

	@Override
	protected void onListItemClick(ListView l,View v,int position,long id)
	{
		super.onListItemClick(l, v, position, id);
		String valor=valores[position];
		try
		{
			Class<?>
			clase=Class.forName("sv.ues.fia.evaluacionetapa."+valor);
			Intent inte = new Intent(this,clase);
			this.startActivity(inte);
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}

}
