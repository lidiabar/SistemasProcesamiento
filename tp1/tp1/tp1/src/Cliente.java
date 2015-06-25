import java.math.BigDecimal;

public class Cliente {
	
	String idCuenta;
	String Apellido;
	String Nombre;
	BigDecimal Saldo;
	BigDecimal Debitos;
	BigDecimal Creditos;
	BigDecimal TopeCtaCte;
	
	int cantidadCreditos;
	int CantidadDebitos;
	
	public int getcantidadCreditos() {
		return cantidadCreditos;
	}
	public void setcantidadCreditos(int cantidadCreditos) {
		this.cantidadCreditos = cantidadCreditos;
	}
	
	public int getCantidadDebitos() {
		return CantidadDebitos;
	}
	public void setCantidadDebitos(int CantidadDebitos) {
		this.CantidadDebitos = CantidadDebitos;
	}
	
	

	public String getIdCuenta() {
		return idCuenta;
	}
	public void setIdCuenta(String idCuenta) {
		this.idCuenta = idCuenta;
	}
	public String getApellido() {
		return Apellido;
	}
	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public BigDecimal getSaldo() {
		return Saldo;
	}
	public void setSaldo(BigDecimal saldo) {
		Saldo = saldo;
	}
	public BigDecimal getDebitos() {
		return Debitos;
	}
	public void setDebitos(BigDecimal debitos) {
		Debitos = debitos;
	}
	public BigDecimal getCreditos() {
		return Creditos;
	}
	public void setCreditos(BigDecimal creditos) {
		Creditos = creditos;
	}
	public BigDecimal getTopeCtaCte() {
		return TopeCtaCte;
	}
	public void setTopeCtaCte(BigDecimal topeCtaCte) {
		TopeCtaCte = topeCtaCte;
	}

}

