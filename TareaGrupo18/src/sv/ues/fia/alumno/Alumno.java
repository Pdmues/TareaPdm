package sv.ues.fia.alumno;

public class Alumno 
{

	private String carnet;
	private String nombre;
	private String apellido;
	private String sexo;
	private int ngrupo;
	private int idcarrera;

	
	
	public Alumno()
	{
	}
	public Alumno(String carnet, String nombre, String apellido, String sexo) 
	{
		this.carnet = carnet;
		this.nombre = nombre;
		this.apellido = apellido;
		this.sexo = sexo;
	}
	public String getCarnet() 
	{
		return carnet;
	}
	public void setCarnet(String carnet) 
	{
		this.carnet = carnet;
	}
	public String getNombre() 
	{
		return nombre;
	}
	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}
	public String getApellido() 
	{
		return apellido;
	}
	public void setApellido(String apellido) 
	{
		this.apellido = apellido;
	}
	public String getSexo() 
	{
		return sexo;
	}
	public void setSexo(String sexo) 
	{
		this.sexo = sexo;
	}
	
	public int getNgrupo() {
		return ngrupo;
	}
	public void setNgrupo(int ngrupo) {
		this.ngrupo = ngrupo;
	}
	public int getIdcarrera() {
		return idcarrera;
	}
	public void setIdcarrera(int idcarrera) {
		this.idcarrera = idcarrera;
	}
}