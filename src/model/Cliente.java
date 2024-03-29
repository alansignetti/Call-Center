package model;

public class Cliente extends Persona{
	private boolean activo;

	public Cliente(int idPersona, String nombre, String apellido, long dni, boolean activo) {
		super(idPersona, nombre, apellido, dni);
		this.activo = activo;
	}

	

	@Override
	public String toString() {
		return "\nCliente" + ", IdPersona=" + getIdPersona()  + ",Nombre=" + getNombre()
				+ ", pellido=" + getApellido() + ", Dni=" + getDni() +", activo="+ activo+ "]";
	}



	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	

}
