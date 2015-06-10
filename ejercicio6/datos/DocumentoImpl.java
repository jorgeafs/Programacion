package datos;


import java.io.*;

public class DocumentoImpl implements Documento, Serializable, Comparable <DocumentoImpl> {
	private static final long serialVersionUID = 10L;
	private static int codigoDocumento = 0;
	
	private String area;
	private int codigo;
	private String especialidad;
	private String formato;
	private int numeroEjemplares;
	private int tipoPrestamo;
	
	//Constructor por defecto
	public DocumentoImpl() {
		this.area = null;
		this.codigo = ++codigoDocumento;
		this.especialidad = null;
		this.formato = null;
		this.numeroEjemplares = 0;
		this.tipoPrestamo = 0;
	}
	//Constructor 
	public DocumentoImpl(String area, String especialidad, String formato, int numeroEjemplares, int tipoPrestamo) {
		this.area = area;
		this.codigo = ++codigoDocumento;
		this.especialidad = especialidad;
		this.formato = formato;
		this.numeroEjemplares = numeroEjemplares;
		this.tipoPrestamo = tipoPrestamo;
	}
	
	//getters
	public int getCodigoDocumento() {
		return DocumentoImpl.codigoDocumento;
	}
	public String getArea() {
		return this.area;
	}
	public int getCodigo() {
		return this.codigo;
	}
	public String getEspecialidad() {
		return this.especialidad;
	}
	public String getFormato() {
		return this.formato;
	}
	public int getNumeroEjemplares() {
		return this.numeroEjemplares;
	}
	public int getTipoPrestamo() {
		return this.tipoPrestamo;
	}
	
	//set
	public void setArea(String area) {
		this.area = area;
	}
	public void setCodigoDocumento(int codigo) {
		DocumentoImpl.codigoDocumento = codigo;
	}
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	public void setFormato(String formato) {
		this.formato = formato;
	}
	public void setNumeroEjemplares(int numeroEjemplares) {
		this.numeroEjemplares = numeroEjemplares;
	}
	public void setTipoPrestamo(int tipoPrestamo) {
		this.tipoPrestamo = tipoPrestamo;
	}
	
	//Metodos sobreestritos
	@Override
	public String toString(){
		//String devolver = null;
		//return devolver;
		return "("+this.getCodigo()+","+this.getArea()+","+this.getEspecialidad()+","+this.getFormato()+","+this.getTipoPrestamo()+","+this.getNumeroEjemplares()+")";
	}
	//criterio igualdad --> mismo codigo
	@Override
	public boolean equals(Object o) {
		boolean igual = false;
		DocumentoImpl aux = null;
		
		if(o != null && o instanceof DocumentoImpl) {
			aux = (DocumentoImpl) o;
			if(this.getCodigo() == aux.getCodigo()){
				igual = true;
			}
		}
		return igual;
	}
	//criterio de comparacion: this.codigo < aComparar.codigo devuelve -1, si son iguales devuelve 0 y si aComparar.codigo < this.codigo devuelve 1
	@Override
	public int compareTo(DocumentoImpl aComparar) {
		int compara = 0;
		if (this.getCodigo() < aComparar.getCodigo()){
			compara = -1;
		} else if (this.getCodigo() > aComparar.getCodigo()) {
			compara = 1;
		}
		return compara;
	}
	
	//metodos propios
	
	public String mostrar(){
		return "Codigo documento: "+this.getCodigo()+"\nArea: "+this.getArea()+"\nEpecialidad: "+this.getEspecialidad()+"\nFormato: "+this.getFormato()
				+"\nTipo prestamo: "+this.getTipoPrestamo()+"\nNumero Ejemplares: "+this.getNumeroEjemplares();
	}
	
	
	
}
