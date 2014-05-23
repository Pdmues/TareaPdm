package sv.ues.fia.carrera;

public class Carrera 
{

	private String idcarrera="";
	private String nombcarrera="";
	private String idfacultad="";
	
	
	public Carrera() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Carrera(String idcarrera, String nombcarrera,String idfacultad) {
		super();
		this.idcarrera = idcarrera;
		this.idfacultad=idfacultad;
		this.nombcarrera = nombcarrera;
	}
	
	public String getIdfacultad() {
		return idfacultad;
	}

	public void setIdfacultad(String idfacultad) {
		this.idfacultad = idfacultad;
	}

	public String getIdcarrera() {
		return idcarrera;
	}
	
	public void setIdcarrera(String idcarrera) {
		this.idcarrera = idcarrera;
	}
	
	public String getNombcarrera() {
		return nombcarrera;
	}
	
	public void setNombcarrera(String nombcarrera) {
		this.nombcarrera = nombcarrera;
	}
	

	

}
