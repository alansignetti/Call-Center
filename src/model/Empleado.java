package model;

public class Empleado extends Persona{
	private int sueldoBase;

	public Empleado(int idPersona, String nombre, String apellido, long dni, int sueldoBase) {
		super(idPersona, nombre, apellido, dni);
		this.sueldoBase = sueldoBase;
	}

	@Override
	public String toString() {
		return "Empleado [sueldoBase=" + sueldoBase + "]";
	}

	public int getSueldoBase() {
		return sueldoBase;
	}

	public void setSueldoBase(int sueldoBase) {
		this.sueldoBase = sueldoBase;
	}
	

}
