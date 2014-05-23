package sv.ues.fia;


import sv.ues.fia.institucion.Institucion;
import sv.ues.fia.bitacora.Bitacora;
import sv.ues.fia.carrera.Carrera;
import sv.ues.fia.especialidad.Especialidad;
import sv.ues.fia.etapa.Etapa;
import sv.ues.fia.evaluacionetapa.EvaluacionEtapa;
import sv.ues.fia.facultad.Facultad;
import sv.ues.fia.grupo.Grupo;
import sv.ues.fia.perfil.Perfil;
import sv.ues.fia.registrobitacora.RegistroBitacora;
import sv.ues.fia.tipoespecialidad.TipoEspecialidad;
import sv.ues.fia.trabajograduacion.TrabajoGraduacion;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ControladorBDG18 
{	
	private final Context context;
	private DatabaseHelper DBHelper;
	private SQLiteDatabase db;
	private static final String[]camposInstitucion = new String []
			{"IDISTITUCION","NOMBREINSTITUCION"};
	private static final String[]camposEspecialidad = new String []
			{"IDESPECIALIDAD","IDDOCENTE"};
	private static final String[]camposTrabajoGraduacion = new String []
			{"NTG","NPERFIL","PORCENAVANCE"};
	private static final String[]camposTipoEspecialidad = new String []
			{"IDTIPOESPECIALIDAD","NOMBREESPECIALIDAD"};
	private static final String[] camposBitacora = new String []
			{"IDBITACORA","NTG","QUIEN","LUGAR","ETAPADESARROLLADA","HORAINICIO","HORAFIN"};
	private static final String[] camposRBitacora =new String []
			{"IDBITACORA","CARNET","TIPOREUNION","FECHA"};
    private static final String[]camposEvaluacionEtapa=new String[]
    		{"NETAPA","CARNET","NOTA"};
    private static final String[]camposgrupo=new String[]
    		{"NGRUPO","IDDOCENTE"};	
    private static final String[]camposetapa=new String[]
    		{"NETAPA","NTG","FECHA"};
    private static final String[]camposCarrera = new String []
			{"IDCARRERA","NOMBCARRERA","IDFACULTAD"};
	private static final String[]camposPerfil = new String []
			{"NPERFIL,ESTADO,OBSERVACIONES","NGRUPO","IDINSTITUCION"};
    private static final String[]camposFacultad = new String []
			{"IDFACULTAD,NOMBCARRERA"};
    
	public ControladorBDG18(Context ctx) 
	{
		this.context = ctx;
		DBHelper = new DatabaseHelper(context);
	}
	//Clase para crear la base de datos
	private static class DatabaseHelper extends SQLiteOpenHelper 
	{
		private static final String BASE_DATOS = "tesis.s3db";
		private static final int VERSION = 1;
		private static final String TABLA_TIPOESPECIALIDAD = "CREATE TABLE TIPOESPECIALIDAD" +  
            "(IDTIPOESPECIALIDAD INT PRIMARY KEY, NOMBREESPECIALIDAD TEXT)";
		//constructor de la clase DatabaseHelper
		public DatabaseHelper(Context context) 
		{
			super(context, BASE_DATOS, null, VERSION);
		}
		
		@Override
		public void onCreate(SQLiteDatabase db) 
		{
			try
			{
				db.execSQL("create table INSTITUCION" +
				"("+
				   "IDISTITUCION         NUMBER(6)            not null PRIMARY KEY,"+
				   "NOMBREINSTITUCION    VARCHAR2(50)         not null"+
				");");
				
				db.execSQL("create table ESPECIALIDAD"+ 
				"("+
				   "IDESPECIALIDAD       INTEGER              not null PRIMARY KEY,"+
				   "IDDOCENTE            VARCHAR2(20)         not null"+
				");");
				
				db.execSQL(TABLA_TIPOESPECIALIDAD);
				
				db.execSQL("create table TRABAJOGRADUACION"+ 
				"("+
				   "NTG                  VARCHAR2(10)         not null PRIMARY KEY,"+
				   "NPERFIL              INTEGER not null,"+
				   "PORCENAVANCE         NUMBER(3,2)          not null"+
				");");
				
				db.execSQL("create table BITACORA"+
						"("+
						   "IDBITACORA      	INTEGER             not null PRIMARY KEY,"+
						   "NTG             	VARCHAR2(20)        not null,"+
						   "QUIEN				VARCHAR2(50)		NOT NULL,"+
						   "LUGAR				VARCHAR(50)			NOT NULL,"+
						   "ETAPADESARROLLADA	INTEGER				NOT NULL,"+
						   "HORAINICIO			VARCHAR(20)			NOT NULL,"+
						   "HORAFIN				VARCHAR(20)			NOT NULL"+
						");");
				//Registro de bitacora
				db.execSQL("create table REGISTROBITACORA"+
						"("+
						   "IDBITACORA      	INTEGER             not null,"+
						   "CARNET				VARCHAR(20)			NOT NULL,"+
						   "TIPOREUNION			VARCHAR(20)			NOT NULL,"+
						   "FECHA				VARCHAR(20)			NOT NULL,"+
						   "PRIMARY KEY (IDBITACORA,CARNET)"+
						");");
				//Registro Evaluacion Etapa 
				db.execSQL("create table EVALUACIONETAPA"+
				        "("+
						   "NETAPA               INTEGER             NOT NULL,"+
						   "CARNET               VARCHAR2(7)         NOT NULL,"+
						   "NOTA                 NUMERIC             NOT NULL,"+
						   "PRIMARY KEY (NETAPA,CARNET) );"
						   );

				//Registro de carrera	
				db.execSQL("create table CARRERA"+ 
						"("+
						   "IDCARRERA  		       VARCHAR2(15)              not null PRIMARY KEY,"+
						   "NOMBCARRERA            VARCHAR2(50)         not null"+
						   "IDFACULTAD				VARCHAR2(50)		not null"+				
						");");
				
				//Registro de perfil
				db.execSQL("create table PERFIL"+ 
						"("+
						   "NPERFIL  		 INTEGER           not null PRIMARY KEY,"+
						   "NGRUPO			 VARCHAR2(10)			not null"+		
						   "ESTADO            	VARCHAR2(10)         not null,"+
						   "OBSERVACIONES		VARCHAR2(50)		 not null"+
						   "IDINSTITUCION		INTEGER					not null"+	
						");");
				
				//Registro de facultad
				db.execSQL("create table FACULTAD"+ 
						"("+
						   "IDFACULTAD  		    VARCHAR2(50)          not null PRIMARY KEY,"+
						   "NOMBFACULTAD            VARCHAR2(50)         not null"+
						 ");");


				db.execSQL("CREATE TABLE GRUPO"+
						"("+
						"NGRUPO                    INTEGER                    NOT NULL PRIMARY KEY,"+
						"IDDOCENTE                 VARCHAR2(7)                 NOT NULL"+
						");"
						);
				db.execSQL("CREATE TABLE ETAPA"+
						"("+
                        "NETAPA                     INTEGER                     NOT NULL PRIMARY KEY,"+
                        "NTG                        VARCHAR2(7)                 NOT NULL,"+
                        "FECHA                      VARCHAR2(10)                NOT NULL"+
                         ");"
                        );
			
			/////TRIGGERS
				//isertar en Etapa un NTG que exista
				db.execSQL("CREATE TRIGGER FK_NTG_TRABAJOGRADUACION "+

                        "BEFORE INSERT ON ETAPA "+
                        "FOR EACH ROW "+

                        "BEGIN "+
                               "SELECT CASE "+
                               "WHEN((SELECT NTG FROM TRABAJOGRADUACION WHERE NTG= NEW.NTG)IS NULL)"+
                               "THEN RAISE(ABORT, 'No existe ese numero el numero de trabajo de graduacion')"+
                               " END;"+
                         "END;");
				//insertar una evaluacion para una etapa que exista
				db.execSQL("CREATE TRIGGER FK_EVALUACIONETAPA_ETAPA "+

                           "BEFORE INSERT ON EVALUACIONETAPA "+
                           "FOR EACH ROW "+

                           "BEGIN "+
                                "SELECT CASE "+
                                "WHEN((SELECT NETAPA FROM ETAPA WHERE NETAPA= NEW.NETAPA)IS NULL)"+
                                "THEN RAISE(ABORT, 'No existe numero de etapa')"+
                                " END;"+
                            "END ;");
				//insertar un grupo para un docente que exista
				db.execSQL("CREATE TRIGGER FK_GRUPO_IDDOCENTE "+

                           "BEFORE INSERT ON GRUPO "+
                           "FOR EACH ROW "+

                           "BEGIN "+
                                "SELECT CASE "+
                                "WHEN((SELECT IDDOCENTE FROM DOCENTE WHERE IDDOCENTE= NEW.IDDOCENTE)IS NULL)"+
                                "THEN RAISE(ABORT, 'No existe ID de docente')"+
                                "END;"+
                           "END ;");
				
				//Borrar un grupo del que exista alumno
				db.execSQL("CREATE TRIGGER FK_GRUPO_ALUMNO "+

                           "BEFORE DELETE ON GRUPO "+
                           "FOR EACH ROW "+
                           
                           "BEGIN "+
                              "SELECT CASE "+
                              "WHEN((SELECT NGRUPO FROM ALUMNO WHERE OLD.NGRUPO=NGRUPO))"+
                              "THEN RAISE(ABORT,'No se puede eliminar grupo')"+
                              "END;"+
                           "END;");
	
				//Borrar evaluacion del que exista alumno
				db.execSQL("CREATE TRIGGER FK_EVALUACIONETAPA_ALUMNOELIMINAR "+

                           "BEFORE DELETE ON EVALUACIONETAPA "+
                           "FOR EACH ROW "+

                           "BEGIN "+
                               "SELECT CASE "+
                               "WHEN((SELECT CARNET FROM ALUMNO WHERE OLD.CARNET=CARNET)IS NULL)"+
                               "THEN RAISE(ABORT, 'No se puede eliminar')"+
                               "END;"+
                            "END");
				//Insertar una evaluacion del que exista alumno
				db.execSQL("CREATE TRIGGER FK_EVALUACIONETAPA_ALUMNO "+

                           "BEFORE INSERT ON EVALUACIONETAPA "+
                           "FOR EACH ROW "+

                           "BEGIN "+
                                "SELECT CASE "+
                                "WHEN((SELECT CARNET FROM ALUMNO WHERE CARNET= NEW.CARNET)IS NULL)"+
                                "THEN RAISE(ABORT, 'No existe carnet')"+
                                "END;"+
                            "END");
				//Insertar un RegistroBitacora del que exista Bitacora
				db.execSQL("CREATE TRIGGER FK_REGISTROBITACORA_BITACORA "+

                           "BEFORE INSERT ON REGISTROBITACORA "+
                           "FOR EACH ROW "+

                           "BEGIN "+
                                "SELECT CASE "+
                                "WHEN((SELECT IDBITACORA FROM BITACORA WHERE IDBITACORA= NEW.IDBITACORA)IS NULL)"+
                                "THEN RAISE(ABORT, 'No existe la bitacora')"+
                                "END;"+
                            "END");
				//Insertar un RegistroBitacora del que exista Alumno
				db.execSQL("CREATE TRIGGER FK_REGISTROBITACORA_ALUMNO "+

                           "BEFORE INSERT ON REGISTROBITACORA "+
                           "FOR EACH ROW "+

                           "BEGIN "+
                                "SELECT CASE "+
                                "WHEN((SELECT CARNET FROM ALUMNO WHERE CARNET= NEW.CARNET)IS NULL)"+
                                "THEN RAISE(ABORT, 'No existe el carnet del alumno')"+
                                "END;"+
                            "END");
				//Insertar unA Bitacora del que exista Un TrabajodeGraduacion
				db.execSQL("CREATE TRIGGER FK_BITACORA_TRABAJODEGRADUACION "+

                           "BEFORE INSERT ON BITACORA "+
                           "FOR EACH ROW "+

                           "BEGIN "+
                                "SELECT CASE "+
                                "WHEN((SELECT NTG FROM TRABAJOGRADUACION WHERE NTG= NEW.NTG)IS NULL)"+
                                "THEN RAISE(ABORT, 'No existe el N° de Trabajo de graduacion')"+
                                "END;"+
                            "END");

				//eliminar evaluacion que exista etapa
				db.execSQL("CREATE TRIGGER FK_EVALUACIONETAPA_ETAPAELIMINAR "+

                           "BEFORE DELETE ON EVALUACIONETAPA "+
                           "FOR EACH ROW "+

                           "BEGIN "+
                                 "SELECT CASE "+
                                 "WHEN((SELECT NETAPA FROM ETAPA WHERE OLD.NETAPA=NETAPA)IS NULL)"+
                                 "THEN RAISE(ABORT, 'No se puede eliminar la evaluacion')"+
                                 "END;"+
                           " END");
				

				//eliminar institucion verificando que no exixta un perfil
				db.execSQL("CREATE TRIGGER FK_INSTITUCION_INSTITUCIONELIMINAR "+

                           "BEFORE DELETE ON INSTITUCION "+
                           "FOR EACH ROW "+

                           "BEGIN "+
                                 "SELECT raise(rollback, 'No se puede eliminar Institucion')"+
                                 "WHERE" +
                                 	"(SELECT NPERFERFIL FROM PERFIL WHERE old.IDISTITUCION=NPERFERFIL )" +
                                 "IS NOT NULL;"+
                            "END;");
				
				
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) 
		{
		// TODO Auto-generated method stub
		}
	}
	public void abrir() throws SQLException
	{
		db = DBHelper.getWritableDatabase();
		return;
	}
	public void cerrar()
	{
		DBHelper.close();
	}
	
		
	//metodo para insertar carrera
public String insertar(Carrera carrera)
{
	String regInsertados="Registro Insertado Nº= ";
	long contador=0;
	ContentValues carr = new ContentValues();
	carr.put("IDCARRERA", carrera.getIdcarrera());
	carr.put("NOMBCARRERA",carrera.getNombcarrera());
	carr.put("IDFACULTAD",carrera.getIdfacultad());
	contador=db.insert("CARRERA", null, carr);
	if(contador==-1 || contador==0)
	{
		regInsertados= "Error al Insertar el registro, Registro Duplicado. Verificar inserción";
	}
	else 
	{
		regInsertados=regInsertados+contador;
	}
	return regInsertados;
}

//metodo para insertar perfil
public String insertar(Perfil perfil)
{
	String regInsertados="Registro Insertado Nº= ";
	long contador=0;
	ContentValues per = new ContentValues();
	per.put("NPERFERFIL", perfil.getNperfil());
	per.put("ESTADO", perfil.getEstado());
	per.put("OBSERVACIONES",perfil.getObservaciones());
	per.put("NGRUPO",perfil.getNgrupo());
	per.put("IDINSTITUCION",perfil.getIdinstitucion());
	contador=db.insert("PERFIL", null, per);
	if(contador==-1 || contador==0)
	{
		regInsertados= "Error al Insertar el registro, Registro Duplicado. Verificar inserción";
	}
	else 
	{
		regInsertados=regInsertados+contador;
	}
	return regInsertados;
}

//metodo para insertar facultad
public String insertar(Facultad facultad)
{
	String regInsertados="Registro Insertado Nº= ";
	long contador=0;
	ContentValues facu = new ContentValues();
	facu.put("IDFACULTAD", facultad.getIDfacultad());
	facu.put("NOMBFACULTAD", facultad.getNombFacultad());
	contador=db.insert("PERFIL", null, facu);
	if(contador==-1 || contador==0)
	{
		regInsertados= "Error al Insertar el registro, Registro Duplicado. Verificar inserción";
	}
	else 
	{
		regInsertados=regInsertados+contador;
	}
	return regInsertados;
}

	public String insertar(Institucion institucion)
	{
		String regInsertados="Registro Insertado Nº= ";
		long contador=0;
		ContentValues insti = new ContentValues();
		insti.put("IDISTITUCION", institucion.getIdindtitucion());
		insti.put("NOMBREINSTITUCION", institucion.getNombreinstitucion());
		contador=db.insert("INSTITUCION", null, insti);
		if(contador==-1 || contador==0)
		{
			regInsertados= "Error al Insertar el registro, Registro Duplicado. Verificar inserción";
		}
		else 
		{
			regInsertados=regInsertados+contador;
		}
		return regInsertados;
	}
	

	public String insertar(Especialidad especialidad)
	{
		String regInsertados="Registro Insertado Nº= ";
		long contador=0;
		ContentValues esp = new ContentValues();
		esp.put("IDESPECIALIDAD", especialidad.getIdEspecialidad());
		esp.put("IDDOCENTE", especialidad.getIdmaestro());
		contador=db.insert("ESPECIALIDAD", null, esp);
		if(contador==-1 || contador==0)
		{
			regInsertados= "Error al Insertar el registro, Registro Duplicado. Verificar inserción";
		}
		else 
		{
			regInsertados=regInsertados+contador;
		}
		return regInsertados;
	}
	
	public String insertar(TipoEspecialidad tespecialidad){
		String regInsertados="Registro Insertado N°= ";
		long contador=0;
		ContentValues tesp= new ContentValues();
		tesp.put("IDTIPOESPECIALIDAD", tespecialidad.getIDespecialidad());
		tesp.put("NOMBREESPECIALIDAD", tespecialidad.getNombreEspecialidad());
		contador=db.insert("TIPOESPECIALIDAD", null, tesp);
		if(contador==-1 || contador==0){
			regInsertados="Error al insertar el registro, Registro Duplicado. Verificar insercion";
		}
		else{
			regInsertados=regInsertados+contador;
		}
		return regInsertados;
	}
	public String insertar(Bitacora bitacora){
		String regInsertados="Registro Insertado N°= ";
		long contador=0;
		ContentValues btcr=new ContentValues();
		btcr.put("IDBITACORA", bitacora.getIdbitacora());
		btcr.put("NTG", bitacora.getNtg());
		btcr.put("QUIEN", bitacora.getQuien());
		btcr.put("LUGAR", bitacora.getLugar());
		btcr.put("ETAPADESARROLLADA", bitacora.getEtapadesarrollada());
		btcr.put("HORAINICIO", bitacora.getHorainicio());
		btcr.put("HORAFIN", bitacora.getHorafin());
		contador=db.insert("BITACORA", null, btcr);
		if(contador==-1 || contador==0){
			regInsertados="Error al insertar el registro, Registro Duplicado. Verificar insercion";
		}else{
			regInsertados=regInsertados+contador;
		}
		return regInsertados;
	}
	public String insertar(RegistroBitacora rbitacora){
		String regInsertados="RegistroInsertado N°= ";
		long contador=0;
		//if(verificarIntegridad(rbitacora,10)){
			ContentValues cvtb=new ContentValues();
			cvtb.put("IDBITACORA",rbitacora.getIdbitacora());
			cvtb.put("CARNET",rbitacora.getCarnet());
			cvtb.put("TIPOREUNION",rbitacora.getTipoReunion());
			cvtb.put("FECHA", rbitacora.getFecha());
			contador=db.insert("REGISTROBITACORA",null,cvtb);
		//}
		if(contador==-1 || contador==0){
			regInsertados="Error al insertar el registro. Verificar insercion";
		}else{
			regInsertados=regInsertados+contador;
		}
		return regInsertados;
	}
	

	public String insertar(TrabajoGraduacion tgraduacion)
	{
		String regInsertados="Registro Insertado Nº= ";
		long contador=0;
		ContentValues tg = new ContentValues();
		tg.put("NTG", tgraduacion.getNtg());
		tg.put("NPERFIL", tgraduacion.getNperfil());
		tg.put("PORCENAVANCE", tgraduacion.getPorcentajea());
		contador=db.insert("TRABAJOGRADUACION", null, tg);
		if(contador==-1 || contador==0)
		{
			regInsertados= "Error al Insertar el registro, Registro Duplicado. Verificar inserción";
		}
		else 
		{
			regInsertados=regInsertados+contador;
		}
		return regInsertados;
	}
	//insercion evaluacion etapa
	public String insertar(EvaluacionEtapa evetapa)
	{
		String regInsertados="Registro Insertado Nº= ";
		long contador=0;
		ContentValues evaluacione=new ContentValues();
		evaluacione.put("NETAPA",evetapa.getNetapa());
		evaluacione.put("CARNET", evetapa.getCarnet());
		evaluacione.put("NOTA", evetapa.getNota());
		contador=db.insert("EVALUACIONETAPA", null, evaluacione);
		if(contador==-1||contador==0)
		{
		regInsertados="Error al Insertar el registro, Registro Duplicado. Verificar inserción";	
		}
		else
		{
			regInsertados=regInsertados+contador;
		}
		return regInsertados;
	}
	//insercion de grupos
	public String insertar(Grupo grupo)
	{
		String regInsertados="Registro Insertado Nº= ";
		long contador=0;
		ContentValues grupos=new ContentValues();
		grupos.put("NGRUPO", grupo.getNgrupo());
		grupos.put("IDDOCENTE", grupo.getIddocente());
		contador=db.insert("GRUPO", null, grupos);
		if(contador==-1||contador==0)
		{
			regInsertados="Error al Insertar el registro, Registro Duplicado. Verificar inserción";	
			}
			else
			{
				regInsertados=regInsertados+contador;
			}
			return regInsertados;
	}
	//fin
	//Insertar etapa
	 public String insertar(Etapa etapa)
	 {
		 String regInsertados="Registro Insertado Nº= ";
			long contador=0;
			ContentValues etapas=new ContentValues(); 
			etapas.put("NETAPA", etapa.getNumeroetapa());
			etapas.put("NTG",etapa.getNTG() );
			etapas.put("FECHA",etapa.getFecha());
			contador=db.insert("ETAPA", null,etapas);
			if(contador==-1||contador==0)
			{
			regInsertados="Error al Insertar el registro, Registro Duplicado. Verificar inserción";	
			}
			else
			{
				regInsertados=regInsertados+contador;
			}
			return regInsertados;
	}
	//fin
	 
	//metodo para consultar carrera
		 public Carrera consultarCarrera(String idcarrera){
		 		
			 String[] id = {idcarrera};
			 Cursor cursor = db.query("CARRERA",camposCarrera,"IDCARRERA = ?",	id,null,null,null);
			 if(cursor.moveToFirst()){
				 Carrera tcarrera = new Carrera();
				 tcarrera.setIdcarrera(cursor.getString(0));
				 tcarrera.setNombcarrera(cursor.getString(1));
				 tcarrera.setIdfacultad(cursor.getString(2));
				 return tcarrera;
			 }else	return null;
		 	 }

	//metodo para consultar facultada
	public Facultad consultarFacultad(String idfacultad){
			String[] id = {idfacultad};
		Cursor cursor = db.query("FACULTAD",camposFacultad,"IDCARRERA = ?",	id,null,null,null);
		if(cursor.moveToFirst()){
			Facultad tfacultad = new Facultad();
			tfacultad.setIDfacultad(cursor.getString(0));
			tfacultad.setNombFacultad(cursor.getString(1));
			return tfacultad;
		}else return null;
	}

	//metodo para consultar perfil
	public Perfil consultarPerfil(String idperfil){
		String[] id = {idperfil};
		Cursor cursor = db.query("PERFIL",camposPerfil,"NPERFIL = ?",	id,null,null,null);
		if(cursor.moveToFirst()){
			Perfil tperfil = new Perfil();
			tperfil.setNperfil1(cursor.getInt(0));
			tperfil.setEstado(cursor.getString(1));
			tperfil.setObservaciones(cursor.getString(2));
			tperfil.setNgrupo(cursor.getInt(3));
			tperfil.setIdinstitucion(cursor.getInt(4));
			return tperfil;
		}else return null;
	}
		 
	 
	 //consultar institiucion
	public Institucion consultarInstitucion(String codigoinst)
	{
		String[] id = {codigoinst};
		Cursor cursor = db.query("INSTITUCION", camposInstitucion, "IDISTITUCION = ?", id,
		null, null, null);
		if(cursor.moveToFirst())
		{
			Institucion institucion = new Institucion();
			institucion.setIdindtitucion(cursor.getInt(0));
			institucion.setNombreinstitucion(cursor.getString(1));
			return institucion;
		}
		else
		{
			return null;
		}
	}
	//Consultar Grupo
public Grupo consultarGrupo(String numerogrupo)
{
	String[]id={numerogrupo};
	Cursor cursor=db.query("GRUPO", camposgrupo, "NGRUPO = ?", id, null, null,null);
	if(cursor.moveToFirst())
	{
		Grupo grupo=new Grupo();
		grupo.setNgrupo(cursor.getInt(0));
		grupo.setIddocente(cursor.getString(1));
		return grupo;
	}
	else
		return null;
}
//consultar etapa 
public Etapa consultaretapa(String numeroetapa)
{
	String []id={numeroetapa};
	Cursor cursor=db.query("ETAPA", camposetapa, "NETAPA =?", id, null, null, null);
	if(cursor.moveToFirst())
	{
		Etapa etapa=new Etapa();
		etapa.setNumeroetapa(cursor.getInt(0));
		etapa.setNTG(cursor.getString(1));
		etapa.setFecha(cursor.getString(2));
		return etapa;
	}
	else
		return null;
}
	public Especialidad consultarEspecialidad(String codigoesp)
	{
		String[] id = {codigoesp};
		Cursor cursor = db.query("ESPECIALIDAD", camposEspecialidad, "IDESPECIALIDAD = ?", id,
		null, null, null);
		if(cursor.moveToFirst())
		{
			Especialidad especialidad = new Especialidad();
			especialidad.setIdEspecialidad(cursor.getInt(0));
			especialidad.setIdmaestro(cursor.getString(1));
			return especialidad;
		}
		else
		{
			return null;
		}
	}
	public TipoEspecialidad consultarTipoEspecialidad(String idTEspecialidad){
		String[] id = {idTEspecialidad};
		Cursor cursor = db.query("TIPOESPECIALIDAD",camposTipoEspecialidad,"IDTIPOESPECIALIDAD = ?",
				id,null,null,null);
		if(cursor.moveToFirst()){
			TipoEspecialidad tespecialidad = new TipoEspecialidad();
			tespecialidad.setIDespecialidad(cursor.getInt(0));
			tespecialidad.setNombreEspecialidad(cursor.getString(1));
			return tespecialidad;
		}else{
			return null;
		}
	}
	public Bitacora consultarBitacora(String IdBitacora){
		String[] id={IdBitacora};
		Cursor cursor=db.query("BITACORA",camposBitacora,"IDBITACORA = ?",
				id,null,null,null);
		if(cursor.moveToFirst()){
			Bitacora b=new Bitacora();
			b.setIdbitacora(cursor.getInt(0));
			b.setNtg(cursor.getString(1));
			b.setQuien(cursor.getString(2));
			b.setLugar(cursor.getString(3));
			b.setEtapadesarrollada(cursor.getInt(4));
			b.setHorainicio(cursor.getString(5));
			b.setHorafin(cursor.getString(6));
			return b;
		}else{
			return null;
		}
	}
	public RegistroBitacora consultarRegistroBitacora(String IdBitacora,String carnet){
		String[] id = {IdBitacora,carnet};
		Cursor cursor = db.query("REGISTROBITACORA", camposRBitacora, "IDBITACORA = ? AND CARNET = ?", id, null, null, null);
		if(cursor.moveToFirst()){
			RegistroBitacora rBit= new RegistroBitacora();
			rBit.setIdbitacora(cursor.getInt(0));
			rBit.setCarnet(cursor.getString(1));
			rBit.setTipoReunion(cursor.getString(2));
			rBit.setFecha(cursor.getString(3));
			return rBit;
		}else{
			return null;
		}
	}

	public TrabajoGraduacion consultarTrabajoGraduacion(String codigotg)
	{
		String[] id = {codigotg};
		Cursor cursor = db.query("TRABAJOGRADUACION", camposTrabajoGraduacion, "NTG = ?", id,
		null, null, null);
		if(cursor.moveToFirst())
		{
			TrabajoGraduacion tgraduacion = new TrabajoGraduacion();
			tgraduacion.setNtg(cursor.getInt(0));
			tgraduacion.setNperfil(Integer.parseInt(cursor.getString(1)));
			tgraduacion.setPorcentajea(Float.parseFloat(cursor.getString(2)));
			return tgraduacion;
		}
		else
		{
			return null;
		}
	}
	//consultar EvaluacionEtapa
	public EvaluacionEtapa consultarEvaluacionEtapa(String codigo_netapa,String codigo_carnet)
	{

	String []id={codigo_netapa,codigo_carnet};
	Cursor cursor=db.query("EVALUACIONETAPA", camposEvaluacionEtapa, "NETAPA = ? AND CARNET = ?", id, null, null, null);
	if(cursor.moveToFirst())
	{
		EvaluacionEtapa evaetapa=new EvaluacionEtapa();
		evaetapa.setNetapa(cursor.getInt(0));
		evaetapa.setCarnet(cursor.getString(1));
		evaetapa.setNota(cursor.getDouble(2));
		return evaetapa;
		
	}else
	return null;
	}

	public String eliminar(Institucion institucion)
	{
		try
		{
			String regAfectados="filas afectadas= ";
			int contador=0;
			if (verificarIntegridad(institucion,1)) 
			{
				regAfectados="0";
				//aplica para cascada
				//borrar registros de notas
				//contador+=db.delete("nota","carnet='"+alumno.getCarnet()+"'", null); ¨
			}
			else
			{
				//borrar los registros de alumno
				contador+=db.delete("INSTITUCION", "IDISTITUCION='"+institucion.getIdindtitucion()+"'",null);
				regAfectados+=contador;
			}
			return regAfectados;
		}
		catch (Exception e)
		{
			
			return e.getMessage()+" Error de integridad";
		}
	}
	//eliminar grupo
	public String eliminar(Grupo grupo)
	{
		String regAfectados="filas afectadas= ";
		int contador=0;
		if(!(verificarIntegridad(grupo, 7)))
		{
			regAfectados="0";
		}
		else
		{
			//borra registros de grupo
			contador+=db.delete("GRUPO","NGRUPO='"+grupo.getNgrupo()+"'",null);
			regAfectados+=contador;
		}
		return regAfectados;
	}
	public String eliminar(Etapa etapa)
	{
	String regAfectados="filas afectadas = ";
	int contador=0;
	if(!(verificarIntegridad(etapa, 8)))
	{
		regAfectados="0";
	}
	else
	{
		//borra registros de etapa
		contador+=db.delete("ETAPA", "NETAPA='"+etapa.getNumeroetapa()+"'", null);
		regAfectados+=contador;
	}
	return regAfectados;
	}

	public String eliminar(Especialidad especialidad)
	{
		String regAfectados="filas afectadas= ";
		int contador=0;
		if (verificarIntegridad(especialidad,1)) 
		{
			regAfectados="0";
			//aplica para cascada
			//borrar registros de notas
			//contador+=db.delete("nota","carnet='"+alumno.getCarnet()+"'", null); ¨
		}
		else
		{
			//borrar los registros de alumno
			contador+=db.delete("ESPECIALIDAD", "IDESPECIALIDAD='"+especialidad.getIdEspecialidad()+"'",
			null);
			regAfectados+=contador;
		}
		return regAfectados;
	}
	public String eliminar(TipoEspecialidad tespecialidad){
		String regAfectados="filas afectadas= ";
		int contador=0;
		if(verificarIntegridad(tespecialidad,5)){
			//borrar los registros si existe tipo de especialidad
			contador+=db.delete("TIPOESPECIALIDAD", "IDTIPOESPECIALIDAD='"+tespecialidad.getIDespecialidad()+"'",
			null);
			regAfectados+=contador;
		}else{
			//si no existe no elimina.
			regAfectados="filas afectadas= 0";
		}
		return regAfectados;
	}
	public String eliminar(Bitacora bitacora){
		String regAfectados="filas afectadas= ";
		int contador=0;
		if(verificarIntegridad(bitacora,6)){
			//borrar si existe
			contador+=db.delete("BITACORA", "IDBITACORA='"+bitacora.getIdbitacora()+"'", null);
			regAfectados+=contador;
		}else{
			regAfectados="filas afectadas= 0";
		}
		return regAfectados;
	}
	public String eliminar(RegistroBitacora rbit){
		String regAfectados="filas afectadas= ";
		int contador=0;
		if(verificarIntegridad(rbit,11)){
			String where="IDBITACORA='"+rbit.getIdbitacora()+"'";
			where=where+" AND CARNET='"+rbit.getCarnet()+"'";
			contador+=db.delete("REGISTROBITACORA", where, null);
			regAfectados+=contador;
		}else{
			regAfectados="filas afectadas= 0";
		}
		return regAfectados;
	}

	public String eliminar(Carrera carrera)
	{
		String regAfectados="filas afectadas= ";
		int contador=0;
		if (verificarIntegridad(carrera,15)) 
		{
			regAfectados="0";
			//aplica para cascada
			//borrar registros de notas
			//contador+=db.delete("nota","carnet='"+alumno.getCarnet()+"'", null); ¨
		}
		else
		{
			//borrar los registros de alumno
			contador+=db.delete("CARRERA", "IDCARRERA='"+carrera.getIdcarrera()+"'",
			null);
			regAfectados+=contador;
		}
		return regAfectados;
	}
	
	public String eliminar(Facultad facultad)
	{
		String regAfectados="filas afectadas= ";
		int contador=0;
		if (verificarIntegridad(facultad,16)) 
		{
			regAfectados="0";
			//aplica para cascada
			//borrar registros de notas
			//contador+=db.delete("nota","carnet='"+alumno.getCarnet()+"'", null); ¨
		}
		else
		{
			//borrar los registros de alumno
			contador+=db.delete("FACULTAD", "IDFACULTAD='"+facultad.getNombFacultad()+"'",
			null);
			regAfectados+=contador;
		}
		return regAfectados;
	}
	
	public String eliminar(Perfil perfil)
	{
		String regAfectados="filas afectadas= ";
		int contador=0;
		if (verificarIntegridad(perfil,17)) 
		{
			regAfectados="0";
			//aplica para cascada
			//borrar registros de notas
			//contador+=db.delete("nota","carnet='"+alumno.getCarnet()+"'", null); ¨
		}
		else
		{
			//borrar los registros de alumno
			contador+=db.delete("PERFIL", "NPERFIL='"+perfil.getNperfil()+"'",
			null);
			regAfectados+=contador;
		}
		return regAfectados;
	}
	
	public String eliminar(TrabajoGraduacion tgraduacion)
	{
		String regAfectados="filas afectadas= ";
		int contador=0;
		if (verificarIntegridad(tgraduacion,1)) 
		{
			regAfectados="0";
			//aplica para cascada
			//borrar registros de notas
			//contador+=db.delete("nota","carnet='"+alumno.getCarnet()+"'", null); ¨
		}
		else
		{
			//borrar los registros de alumno
			contador+=db.delete("TRABAJOGRADUACION", "NTG='"+tgraduacion.getNtg()+"'",
			null);
			regAfectados+=contador;
		}
		return regAfectados;
	}
	
	public String eliminar(EvaluacionEtapa evaluacion)
	{
	String regAfectados="filas afectadas= ";
	int contador=0;
		if(!(verificarIntegridad(evaluacion, 9)))
		{
		regAfectados="0";	
		}
		else{
	    regAfectados="filas afectadas= ";
		contador+=db.delete("EVALUACIONETAPA","NETAPA='"+evaluacion.getNetapa()+"'"+" AND "+" CARNET = '"+evaluacion.getCarnet()+"'",null);
		regAfectados+=contador;
		return regAfectados;
		}
		return regAfectados;
	}
	
	public String actualizar(Institucion institucion)
	{
		if(verificarIntegridad(institucion, 2))
		{
			String[] id = {institucion.getIdindtitucion()+""};
			ContentValues cv = new ContentValues();
			cv.put("NOMBREINSTITUCION",institucion.getNombreinstitucion());
			db.update("INSTITUCION", cv, "IDISTITUCION = ?", id);
			return "Registro Actualizado Correctamente";
		}
		else
		{
			return "Registro con el codigo " + institucion.getIdindtitucion() + " no existe";
		}
	}
	//Actualizar grupo
	public String actualizar(Grupo grupo)
	{
		if(verificarIntegridad(grupo, 7))
		{
			String[] id={grupo.getNgrupo()+""};
			ContentValues cv =new ContentValues();
			cv.put("IDDOCENTE", grupo.getIddocente());
			db.update("GRUPO", cv, "NGRUPO =?", id);
			return "Registro Actualizado Correctamente";
		}
		else
		{
			return "Registro con el codigo " + grupo.getNgrupo() + " no existe";
		}
	}
	
	//actualizar carrera
	public String actualizar(Carrera carrera){
		if(verificarIntegridad(carrera, 15)){
			String[] id = {carrera.getIdcarrera()+""};
			ContentValues cv = new ContentValues();
			cv.put("IDCARRERA",carrera.getIdcarrera());
			cv.put("NOMBCARRERA", carrera.getNombcarrera());
			cv.put("IDFACULTAD",carrera.getIdfacultad());
			db.update("CARRERA", cv, "IDCARRERA = ?", id);
			return "Registro Actualizado Correctamente";
		}else	return "Registro con CODIGO de carrera " + carrera.getIdcarrera()+ " no existe";
}


	//actualizar facultad
	public String actualizar(Facultad facultad){
		if(verificarIntegridad(facultad, 16)){
			String[] id = {facultad.getIDfacultad()+""};
			ContentValues cv = new ContentValues();
			cv.put("IDFACULTAD",facultad.getIDfacultad());
			cv.put("NOMBFACULTAD", facultad.getNombFacultad());
			db.update("FACULTAD", cv, "IDFACULTAD = ?", id);
			return "Registro Actualizado Correctamente";
		}
		else return "Registro con CODIGO de especialidad " + facultad.getIDfacultad()+ " no existe";
}

	//actualizar perfil
	public String actualizar(Perfil perfil){
		if(verificarIntegridad(perfil, 17)){
			String[] id = {perfil.getNperfil()+""};
			ContentValues cv = new ContentValues();
			cv.put("NPERFIl",perfil.getNperfil());
			cv.put("ESTADO",perfil.getEstado());
			cv.put("OBSERVACIONES", perfil.getObservaciones());
			cv.put("NGRUPO",perfil.getNgrupo());
			cv.put("IDINSTITUCION",perfil.getIdinstitucion());
			db.update("PERFIL", cv, "NPERFIL = ?", id);
			return "Registro Actualizado Correctamente";
		}else return "Registro con CODIGO de especialidad " + perfil.getNperfil()	+ " no existe";
}
	
	
	//Actualizar etapa
	public String actualizar(Etapa etapa)
	{
		if(verificarIntegridad(etapa, 8))
		{
		String[] id={etapa.getNumeroetapa()+""};
		ContentValues cv=new ContentValues();
		cv.put("NTG", etapa.getNTG());
		cv.put("FECHA", etapa.getFecha());
		db.update("ETAPA", cv, "NETAPA= ?", id);
		return "Registro actualizado correctamente";
		}
		else
			return "Registro con codigo="+etapa.getNumeroetapa()+"no existe";
	}
	//Actualizar Evaluacion Etapa
	public String actualizar(EvaluacionEtapa eve)
	{
		if(verificarIntegridad(eve, 9))
		{
		String []id={eve.getNetapa()+"",eve.getCarnet()+""};
		ContentValues cv=new ContentValues();
		cv.put("NETAPA", eve.getNetapa());
		cv.put("CARNET", eve.getCarnet());
		cv.put("NOTA", eve.getNota());
	    db.update("EVALUACIONETAPA", cv, "NETAPA =? AND CARNET =?", id);
	    return "Registros actualizados correctamente";
		}
		else
			return "Etapa con numero "+eve.getNetapa()+"con carnet "+eve.getCarnet()+" no existe"; 
	}

	public String actualizar(Especialidad especialidad)
	{
		if(verificarIntegridad(especialidad, 3))
		{
			String[] id = {especialidad.getIdEspecialidad()+""};
			ContentValues cv = new ContentValues();
			cv.put("IDDOCENTE",especialidad.getIdmaestro());
			db.update("ESPECIALIDAD", cv, "IDESPECIALIDAD = ?", id);
			return "Registro Actualizado Correctamente";
		}
		else
		{
			return "Registro con el codigo " + especialidad.getIdEspecialidad() + " no existe";
		}
	}
	public String actualizar(TipoEspecialidad tespecialidad){
		if(verificarIntegridad(tespecialidad, 5)){
			String[] id = {tespecialidad.getIDespecialidad()+""};
			ContentValues cv = new ContentValues();
			cv.put("IDTIPOESPECIALIDAD",tespecialidad.getIDespecialidad());
			cv.put("NOMBREESPECIALIDAD", tespecialidad.getNombreEspecialidad());
			db.update("TIPOESPECIALIDAD", cv, "IDTIPOESPECIALIDAD = ?", id);
			return "Registro Actualizado Correctamente";
		}else{
			return "Registro con CODIGO de especialidad " + tespecialidad.getIDespecialidad()
					+ " no existe";
		}
	}
	public String actualizar(Bitacora bitacora){
		if(verificarIntegridad(bitacora,6)){
			String[] id = {bitacora.getIdbitacora()+""};
			ContentValues cv = new ContentValues();
			cv.put("IDBITACORA",bitacora.getIdbitacora());
			cv.put("NTG",bitacora.getNtg());
			cv.put("QUIEN",bitacora.getQuien());
			cv.put("LUGAR",bitacora.getLugar());
			cv.put("ETAPADESARROLLADA",bitacora.getEtapadesarrollada());
			cv.put("HORAINICIO",bitacora.getHorainicio());
			cv.put("HORAFIN",bitacora.getHorafin());
			db.update("BITACORA", cv, "IDBITACORA = ?", id);
			return "Registro actualizado correctamente";
		}else{
			return "Registro con codigo "+bitacora.getIdbitacora()+" no existe";
		}
	}
	public String actualizar(RegistroBitacora rbit){
		if(verificarIntegridad(rbit,11)){
			String[] id ={String.valueOf(rbit.getIdbitacora()),rbit.getCarnet()};
			ContentValues cv = new ContentValues();
			cv.put("IDBITACORA",rbit.getIdbitacora());
			cv.put("CARNET",rbit.getCarnet());
			cv.put("TIPOREUNION", rbit.getTipoReunion());
			cv.put("FECHA", rbit.getFecha());
			db.update("REGISTROBITACORA", cv, "IDBITACORA = ? AND CARNET = ?", id);
			return "Registro actualizado";
		}else{
			return "Registro no existe";
		}
	}
	
	public String actualizar(TrabajoGraduacion tgraduacion)
	{
		if(verificarIntegridad(tgraduacion, 4))
		{
			String[] id = {tgraduacion.getNtg()+""};
			ContentValues cv = new ContentValues();
			cv.put("NPERFIL",tgraduacion.getNperfil());
			cv.put("PORCENAVANCE",tgraduacion.getPorcentajea());
			db.update("TRABAJOGRADUACION", cv, "NTG = ?", id);
			return "Registro Actualizado Correctamente";
		}
		else
		{
			return "Registro con el codigo " + tgraduacion.getNtg() + " no existe";
		}
	}

	private boolean verificarIntegridad(Object dato, int relacion) throws SQLException
	{
		switch(relacion)
		{
			case 1:
			{
				/*Institucion institucion = (Institucion)dato;
				Cursor c=db.query(true, "nota", new String[] 
						{"IDISTITUCION" }, "IDISTITUCION='"+institucion.getIdindtitucion()+"'",null,
				null, null, null, null);
				if(c.moveToFirst())
					return true;
				else
					return false;*/
				return false;
			}

			case 2:
			{
				//verificar que exista alumno
				Institucion institucion2 = (Institucion)dato;
				String[] id = {institucion2.getIdindtitucion()+""};
				abrir();
				Cursor c2 = db.query("INSTITUCION", null, "IDISTITUCION = ?", id, null, null,
				null);
				if(c2.moveToFirst())
				{
					//Se encontro Alumno
					return true;
				}
				return false;
			}
			

			case 3:
			{
				//verificar que exista alumno
				Especialidad especialidad2 = (Especialidad)dato;
				String[] id = {especialidad2.getIdEspecialidad()+""};
				abrir();
				Cursor c2 = db.query("ESPECIALIDAD", null, "IDESPECIALIDAD = ?", id, null, null,
				null);
				if(c2.moveToFirst())
				{
					//Se encontro Alumno
					return true;
				}
				return false;
			}

			case 4:
			{
				//verificar que exista alumno
				TrabajoGraduacion tgrad = (TrabajoGraduacion)dato;
				String[] id = {tgrad.getNtg()+""};
				abrir();
				Cursor c2 = db.query("TRABAJOGRADUACION", null, "NTG = ?", id, null, null,
				null);
				if(c2.moveToFirst())
				{
					//Se encontro Alumno
					return true;
				}
				return false;
			}
			case 5:
			{
				//verificar que existe IDespecialidad
				TipoEspecialidad tespecialidad = (TipoEspecialidad)dato;
				String[] id={tespecialidad.getIDespecialidad()+""};
				abrir();
				Cursor c3=db.query("TIPOESPECIALIDAD",null,"IDTIPOESPECIALIDAD=?",id,null,null,null);
				if(c3.moveToFirst())
				{
					//Se encontro IDESPECIALIDAD
					return true;
				}
				else{
					return false;}
			}
			case 6:
			{
				//verificar que exista IDBitacora
				Bitacora bita=(Bitacora)dato;
				String[] id={bita.getIdbitacora()+""};
				abrir();
				Cursor c4=db.query("BITACORA", null, "IDBITACORA=?", id, null, null, null);
				if(c4.moveToFirst()){
					//Si existe
					return true;
				}else{
					return false;
				}
			}
			case 7:
			{
				//verfica que exista Ngrupo
				Grupo grup=(Grupo)dato;
				String[] id={grup.getNgrupo()+""};
				abrir();
				Cursor c5=db.query("GRUPO", null, "NGRUPO =?", id, null, null, null);
				if(c5.moveToFirst())
				{
					//Existe
					return true;
				}
				else{
					return false;
				}
			}
			case 8:
			{
				//verfifica que exista NEtapa
				Etapa e=(Etapa)dato;
				String[]id={e.getNumeroetapa()+""};
				abrir();
				Cursor c6=db.query("ETAPA", null, "NETAPA =?", id, null, null, null);
				if(c6.moveToFirst())
				{
					return true;
				}
				else
				{
					return false;
				}
			}
				
				case 9:
				{//verfica que exista evaluacion etapa
					EvaluacionEtapa evea=(EvaluacionEtapa)dato;
					String []id={evea.getNetapa()+"",evea.getCarnet()+""};
					abrir();
					Cursor c7=db.query("EVALUACIONETAPA", null, "NETAPA=? AND CARNET=?",id, null,null,null);
					if(c7.moveToFirst())
					{
						return true;
  			    	}
					else{
						return false;
					}
					
				}
				case 10:
				{
					//verificar que exista carnet y codigo de bitacora al insertar
					//el RegistroBitacora.
					RegistroBitacora rbitacora=(RegistroBitacora)dato;
					String[] id1={rbitacora.getCarnet()};
					String[] id2={String.valueOf(rbitacora.getIdbitacora())};
					Cursor cursor1=db.query("BITACORA",null,"IDBITACORA = ?",id2,null,
							null,null);
					Cursor cursor2=db.query("ALUMNO",null,"CARNET = ?",id1,null,
							null,null);
					if(cursor1.moveToFirst() && cursor2.moveToFirst()){
						//Se encontraron datos
						return true;
					}else{
						return false;
					}
				}
				case 11:
				{
					//verificar que exista carnet y idbitacora
					RegistroBitacora rbitacora=(RegistroBitacora)dato;
					String[] ids={String.valueOf(rbitacora.getIdbitacora()),rbitacora.getCarnet()};
					abrir();
					Cursor c= db.query("REGISTROBITACORA", null, "IDBITACORA = ? AND CARNET = ?",
							ids, null, null, null);
					if(c.moveToFirst()){
						//Se encontraron datos
						return true;
					}else{
						return false;
					}
				}
				
				case 16:
				{
					//verfiicar que exista facultad
					Facultad facultad2 = (Facultad)dato;
					String[] id = {facultad2.getIDfacultad()+""};
					abrir();
					Cursor facu = db.query("FACULTAD", null, "IDFACULTAD = ?", id, null, null,
					null);
					if(facu.moveToFirst())
					{
						//Se encontro Alumno
						return true;
					}
					else return false;
				}
					
				case 17:
				{
					//verfiicar que exista perfil
					Perfil perfil2 = (Perfil)dato;
					String[] id = {perfil2.getNperfil()+""};
					abrir();
					Cursor perf = db.query("PERFIL", null, "NPERFIL = ?", id, null, null,
				null);
				if(perf.moveToFirst())
				{
					//Se encontro Alumno
					return true;
				}
				else return false;
				}
				
				case 15:
				{
					//verfiicar que exista carrera
					Carrera carrera2 = (Carrera)dato;
					String[] id = {carrera2.getIdcarrera()+""};
					abrir();
					Cursor carr = db.query("CARRERA", null, "IDCARRERA = ?", id, null, null,
					null);
					if(carr.moveToFirst())
					{
						//Se encontro Alumno
						return true;
					}
					else return false;
				}
						
			default:
			return false;
		}
	}

}
