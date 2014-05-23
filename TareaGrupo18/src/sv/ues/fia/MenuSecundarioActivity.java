package sv.ues.fia;


import sv.ues.fia.R;
import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class MenuSecundarioActivity extends Activity implements OnClickListener{

	ImageView selectedImage;
			String[]
			activities={"alumno.AlumnoMenu","grupo.GrupoMenu","docente.DocenteMenu","perfil.PerfilMenu","trabajograduacion.TrabajoGraduacionMenu","especialidad.EspecialidadMenu","institucion.InstitucionMenu","facultad.FacultadMenu","carrera.CarreraMenu"
					,"registrobitacora.RegistroBitacoraMenu","tipoespecialidad.TipoEspecialidadMenu","bitacora.BitacoraMenu","etapa.EtapaMenu","evaluacionetapa.EvaluacionEtapaMenu"};
			ControladorBDG18 BDhelper;
			private Integer[] mImageIds = {
		    		R.drawable.img2,
		            R.drawable.grupo,
		            R.drawable.profesor,
		            R.drawable.perfil,
		            R.drawable.graduacion,
		            R.drawable.especialidad,
		            R.drawable.institucion,
		            R.drawable.facultad,
		            R.drawable.img1,
		    		R.drawable.registrobitacora,
		    		R.drawable.tipoespecialidad,
		    		R.drawable.bitacora,
		    		R.drawable.etapa,
		    		R.drawable.evaluacionetapa
		       };
			private String[] notas = {
		    		"Tabla Alumno",
		    		"Tabla Grupo",
		    		"Tabla Docente",
		    		"Tabla Pefil",
		    		"Tabla Trabajo de Graduacion",
		    		"Tabla Especialidad",
		    		"Tabla Institucion",
		    		"Tabla Facultad",
		    		"Tabla Carrera",
		    		"Tabla Registro de Bitacora",
		    		"Tabla Tipo de Especialidad",
		    		"Tabla de apertura Bitacora",
		    		"Tabla Etapa",
		    		"Tabla Evaluacion Etapa"
		       };
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	       setContentView(R.layout.activity_menu_secundario);
	       ImageView iv =(ImageView) findViewById(R.id.imageView1);
	       iv.setOnClickListener(this);
	            Gallery gallery = (Gallery) findViewById(R.id.gallery1);
	       selectedImage=(ImageView)findViewById(R.id.imageView1);
	       gallery.setSpacing(1);
	       gallery.setAdapter(new GalleryImageAdapter(this));

	        // clicklistener for Gallery
	       gallery.setOnItemClickListener(new OnItemClickListener() {
	           public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
	               Toast.makeText(MenuSecundarioActivity.this, "Para acceder a " + notas[position], Toast.LENGTH_SHORT).show();
	               // show the selected Image
	               selectedImage.setImageResource(mImageIds[position]);
	           }
	       });
	}

	public class GalleryImageAdapter extends BaseAdapter{
	    private Context mContext;

	    private Integer[] mImageIds = {
	    		R.drawable.img2,
	            R.drawable.grupo,
	            R.drawable.profesor,
	            R.drawable.perfil,
	            R.drawable.graduacion,
	            R.drawable.especialidad,
	            R.drawable.institucion,
	            R.drawable.facultad,
	            R.drawable.img1,
	    		R.drawable.registrobitacora,
	    		R.drawable.tipoespecialidad,
	    		R.drawable.bitacora,
	    		R.drawable.etapa,
	    		R.drawable.evaluacionetapa
	       };

	    public GalleryImageAdapter(Context context)
	    {
	        mContext = context;
	    }

	    public int getCount() {
	        return mImageIds.length;
	    }

	    public Object getItem(int position) {
	        return position;
	    }

	    public long getItemId(int position) {
	        return position;
	    }


	    // Override this method according to your need
	    public View getView(int index, View view, ViewGroup viewGroup)
	    {
	        // TODO Auto-generated method stub
	        ImageView i = new ImageView(mContext);

	        i.setImageResource(mImageIds[index]);
	        i.setLayoutParams(new Gallery.LayoutParams(100, 100));
	   
	        i.setScaleType(ImageView.ScaleType.FIT_XY);

	        return i;
	    }
	}



@Override
public void onClick(View v) {
	// TODO Auto-generated method stub
	Gallery gallery = (Gallery) findViewById(R.id.gallery1);
	int posicion=gallery.getSelectedItemPosition();
	//Toast.makeText(GalleryActivity.this, "Posicion seleccionada "+posicion , Toast.LENGTH_SHORT).show();
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
