package petshoponline.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import petshoponline.models.*;

public class ComprasDAO {

	private Connection connection;

	public ComprasDAO() {
		connection = ConnectionFactory.getConnection();
	}
	
	public boolean inserir(Compra compra) {

		String sql = "insert into compras (cliente_id, produto_id, dataCompra, valor) values (?, ?, ?, ?)";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setLong(1, compra.getCliente().getId());
			stmt.setLong(2, compra.getProduto().getId());
			stmt.setDate(3, new java.sql.Date(compra.getDataCompra().getTimeInMillis()));
			if (getNumeroDeCompras(compra.getCliente()) >= 3) {
				
				double valorComDesconto = compra.getProduto().getPreco() - (compra.getProduto().getPreco() * 0.10);
				stmt.setDouble(4, valorComDesconto);
				
			}else {
				
				stmt.setDouble(4, compra.getProduto().getPreco());
				
			}
			

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {

			e.printStackTrace();
			return false;
		}

		return true;
	}

	public List<Compra> getLista() {
		List<Compra> resultado = new ArrayList<>();

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from compras;");
			ResultSet rs = stmt.executeQuery();
			ProdutoDAO pDAO = new ProdutoDAO();
			ClienteDAO cDAO = new ClienteDAO();
			while (rs.next()) {
				// cria o objeto Compra
				Compra compra = new Compra();
				
				compra.setId(rs.getLong("id"));
				compra.setCliente(cDAO.getById(rs.getLong("cliente_id")));
				compra.setProduto(pDAO.getById(rs.getLong("produto_id")));
				
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataCompra"));
				compra.setDataCompra(data);
				compra.setValor(rs.getDouble("valor"));
				
			
				resultado.add(compra);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resultado;
	}
	
	public List<Compra> getComprasDoCliente(String nome) {
		List<Compra> resultado = new ArrayList<>();
		Cliente cliente = new ClienteDAO().getByNome(nome);

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from compras where cliente_id = ?;");
			stmt.setLong(1 , cliente.getId());
			ResultSet rs = stmt.executeQuery();
			
			ProdutoDAO pDAO = new ProdutoDAO();
			ClienteDAO cDAO = new ClienteDAO();
			while (rs.next()) {
				// cria o objeto Compra
				Compra compra = new Compra();
				
				compra.setId(rs.getLong("id"));
				compra.setCliente(cDAO.getById(rs.getLong("cliente_id")));
				compra.setProduto(pDAO.getById(rs.getLong("produto_id")));
				
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataCompra"));
				compra.setDataCompra(data);
				
				compra.setValor(rs.getDouble("valor"));
			
				resultado.add(compra);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resultado;
	}
	
	
	public int getNumeroDeCompras(Cliente cliente) {
		int numeroDeCompras = 0;

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from compras where cliente_id = ?;");
			stmt.setLong(1 , cliente.getId());
			
			ResultSet rs = stmt.executeQuery();
	
			while (rs.next()) {
				numeroDeCompras++;
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return numeroDeCompras;
	}
	
	

	public boolean alterar(Compra compra) {
		String sql = "update compras set cliente_id=?, produto_id=?, dataCompra=?, valor=? where id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setLong(1, compra.getCliente().getId());
			stmt.setLong(2, compra.getProduto().getId());
			stmt.setDate(3, new java.sql.Date(compra.getDataCompra().getTimeInMillis()));
			stmt.setDouble(4, compra.getValor());
			stmt.setLong(5, compra.getId());

			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean remover(Compra compra) {
		
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from compras where id=?;");
			stmt.setLong(1, compra.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	
	
	
	
}