package amazingcontrol.model;

import java.util.Calendar;

public class Venda extends Entidate<Integer> {

	private Cliente cliente;
	private Usuario usuario;
	private Calendar date;

	public Venda() {
	}

	public Venda(Usuario usuario, Cliente cliente, Calendar date) {
		this.usuario = usuario;
		this.cliente = cliente;
		this.date = date;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

}
