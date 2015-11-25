package amazingcontrol.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import amazingcontrol.model.Cliente;
import amazingcontrol.model.ItensVendas;
import amazingcontrol.model.Produto;
import amazingcontrol.model.Tipo;
import amazingcontrol.model.Usuario;
import amazingcontrol.model.Venda;

public class ItensVendasDAO {
	public void inserir(ItensVendas itensVendas, Connection con) {
		PreparedStatement stmt = null;
		String sql = "INSERT INTO itensVendas (produtos_id, vendas_id, valorTotal, quantidade) values (?, ?, ?, ?)";
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, itensVendas.getProduto().getId());
			stmt.setInt(2, itensVendas.getVenda().getId());
			stmt.setDouble(3, itensVendas.getValorTotal());
			stmt.setInt(4, itensVendas.getQuantidade());
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public List<ItensVendas> listVendas(Connection con) {
		List<ItensVendas> itensVendidos = new ArrayList<>();
		
		String sql = "SELECT p.nome, p.tipo, p.valorVenda, iv.quantidade, c.nome, u.nome, v.data "
				+ "FROM produtos as p JOIN itensVendas as iv on p.id = produtos_id"
				+ " JOIN vendas as v on iv.vendas_id = v.id"
				+ " JOIN clientes as c on v.cliente_id = c.id"
				+ " JOIN usuarios as u on v.usuario_id = u.id";

		try (PreparedStatement stmt = con.prepareStatement(sql)){
			try(ResultSet rs = stmt.executeQuery()){
				ItensVendas itensVendas;
				
				while (rs.next()) {
					itensVendas = new ItensVendas();
					
					// seta atributos dos produtos
					Produto produto = new Produto();
					produto.setNome(rs.getString("p.nome"));
					
					for (Tipo tipo : Tipo.values()) {
						if(rs.getString("p.tipo").equals(tipo.toString())) {
							produto.setTipo(tipo);
						}
					}
					
					produto.setValorVenda(rs.getDouble("p.valorVenda"));
					
					// seta atributos do cliente
					Cliente cliente = new Cliente();
					cliente.setNome(rs.getString("c.nome"));
					
					// seta atributos do usuarios
					Usuario usuario = new Usuario();
					usuario.setNome(rs.getString("u.nome"));
					
					// seta atributos da vendas
					Venda venda = new Venda();
					venda.setCliente(cliente);
					venda.setUsuario(usuario);
					
					// configura data no padrao java
					Calendar data = Calendar.getInstance();
					data.setTime(rs.getDate("v.data"));
					venda.setDate(data);
						
					itensVendas.setProduto(produto);
					itensVendas.setVenda(venda);
					itensVendas.setQuantidade(rs.getInt("iv.quantidade"));
					
					// cria lista com os itens vendidos
					itensVendidos.add(itensVendas);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return itensVendidos;
	}
}
