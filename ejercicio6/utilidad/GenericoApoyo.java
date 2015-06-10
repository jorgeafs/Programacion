package utilidad;


import java.util.List;

public class GenericoApoyo<T> {
	private T t;
	
	public GenericoApoyo() {
		this.t = null;
	}

	public T getT() {
		return this.t;
	}
	
	public void setT(T t) {
		this.t = t;
	}

	@SuppressWarnings("unchecked")
	public void setT(List<Object> asList) {
		this.t = (T) asList;
	}
}
