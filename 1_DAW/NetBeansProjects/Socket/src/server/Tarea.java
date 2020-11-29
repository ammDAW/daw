package server;

public class Tarea {
	private int numTarea;
	private String descripcion;
	private String estado;
	
	public Tarea(int numTarea, String descripcion, String estado) {
		super();
		this.numTarea = numTarea;
		this.descripcion = descripcion;
		this.estado = estado;
	}
	
	public int getNumTarea() {
		return numTarea;
	}

	public String getEstado() {
		return estado;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setNumTarea(int numTarea) {
		this.numTarea = numTarea;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Tarea [numTarea=" + numTarea + ", descripcion=" + descripcion + ", estado=" + estado + "]";
	}
}
