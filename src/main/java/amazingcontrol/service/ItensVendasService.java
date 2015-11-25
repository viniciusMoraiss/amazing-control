package amazingcontrol.service;

import java.sql.Connection;
import java.util.List;

import amazingcontrol.connection.ConexaoMySQL;
import amazingcontrol.dao.ItensVendasDAO;
import amazingcontrol.model.ItensVendas;

public class ItensVendasService {
	private ItensVendasDAO dao;
	private Connection con;

	public ItensVendasService() {
		dao = new ItensVendasDAO();
		con = ConexaoMySQL.conectar();
	}

	public List<ItensVendas> listVendas() {
		return dao.listVendas(con);
	}

}
