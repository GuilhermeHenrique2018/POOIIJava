package edu.pitagoras.interfacegrafica;

import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import edu.pitagoras.config.Conexao;
import edu.pitagoras.modeloDAO.ClienteDAO;
import edu.pitagoras.modelodados.Cliente;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InterfacegraficaApplicationTests {

	@Test
	public void testeConexao() throws SQLException {
		Connection con = Conexao.getConnection();
		assertTrue(con.isValid(1000));
	}
	
	@Test
	public void testeAdicionarRemoverCliente() throws SQLException {
		Cliente cliente = new Cliente();
		cliente.setNome("Teste");
		cliente.setCpf("11111111");
		ClienteDAO.adicionarCliente(cliente);
		ClienteDAO.removerCliente(cliente);
	}
	
	@Test(expected = SQLException.class)
	public void testeAdicionarClienteComMesmoNomeErro() throws SQLException {
		Cliente cliente = new Cliente();
		cliente.setNome("Teste");
		cliente.setCpf("11111111");
		ClienteDAO.adicionarCliente(cliente);
		ClienteDAO.adicionarCliente(cliente);
	}
}
