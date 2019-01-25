package petshoponline.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import petshoponline.models.Produto;

public class ProdutoDAO {

	private Connection connection;

	public ProdutoDAO() {
		connection = ConnectionFactory.getConnection();
	}

	public boolean inserir(Produto produto) {

		String sql = "insert into produtos (nome, marca, categoria, preco, dataValidade) values (?, ?, ?, ?, ?);";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, produto.getNome());
			stmt.setString(2, produto.getMarca());
			stmt.setString(3, produto.getCategoria());
			stmt.setDouble(4, produto.getPreco());
			
			stmt.setDate(5, new java.sql.Date(produto.getDataValidade().getTimeInMillis()));

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public List<Produto> getLista() {
		List<Produto> resultado = new ArrayList<>();

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from produtos;");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// cria o objeto Produto
				Produto produto = new Produto();
				produto.setId(rs.getLong("id"));
				produto.setNome(rs.getString("nome"));
				produto.setMarca(rs.getString("marca"));
				produto.setCategoria(rs.getString("categoria"));
				produto.setPreco(rs.getDouble("preco"));
				
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataValidade"));
				produto.setDataValidade(data);
				
			
				resultado.add(produto);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resultado;
	}

	public boolean alterar(Produto produto) {
		String sql = "update produtos set nome=?, marca=?, preco=?, categoria=?, dataValidade=? where id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, produto.getNome());
			stmt.setString(2, produto.getMarca());
			stmt.setDouble(3, produto.getPreco());
			stmt.setString(4, produto.getCategoria());
			stmt.setDate(5, new java.sql.Date(produto.getDataValidade().getTimeInMillis()));
			stmt.setLong(6, produto.getId());

			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean remover(Produto produto) {
		
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from produtos where id=?;");
			stmt.setLong(1, produto.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public Produto getById(Long id) {
		Produto resultado = null;

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from produtos where id = ?;");
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();

			if(rs.next()) {
				// cria o objeto Produto
				resultado = new Produto();
				resultado.setId(rs.getLong("id"));
				resultado.setNome(rs.getString("nome"));
				resultado.setMarca(rs.getString("marca"));
				resultado.setCategoria(rs.getString("categoria"));
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataValidade"));
				resultado.setDataValidade(data);
				resultado.setPreco(rs.getDouble("preco"));
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resultado;
	}
	
	public List<Produto> getByMarca(String marca) {
		List<Produto> produtos = new ArrayList<Produto>();

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from produtos where marca = ?;");
			stmt.setString(1, marca);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				// cria o objeto Produto
				Produto p = new Produto();
				p.setId(rs.getLong("id"));
				p.setMarca(rs.getString("marca"));
				p.setNome(rs.getString("nome"));
				p.setCategoria(rs.getString("categoria"));
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataValidade"));
				p.setDataValidade(data);
				p.setPreco(rs.getDouble("preco"));
				produtos.add(p);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return produtos;
	}

}