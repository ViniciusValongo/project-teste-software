package negocio;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class GerenciadoraClientesTest {

	private GerenciadoraClientes gerClientes;

	@Test
	public void testePesquisaCliente() {

		Cliente cliente01 = new Cliente(1, "Gustavo Farias", 31, "gugafarias@gmail.com", 1, true);
		Cliente cliente02 = new Cliente(2, "Felipe Augusto", 34, "felipeaugusto@gmail.com", 2, true);
		

		List<Cliente> clientesDoBanco = new ArrayList<>();
		clientesDoBanco.add(cliente01);
		clientesDoBanco.add(cliente02);
		
		gerClientes = new GerenciadoraClientes(clientesDoBanco);
		
		Cliente cliente = gerClientes.pesquisaCliente(1);
		
		assertThat(cliente.getId(), is(1));
		
	}
	
	@Test
	public void testeIdadeCliente() {

		Cliente cliente01 = new Cliente(1, "Gustavo Farias", 14, "gugafarias@gmail.com", 1, true);
		

		List<Cliente> clientesDoBanco = new ArrayList<>();
		clientesDoBanco.add(cliente01);
		
		gerClientes = new GerenciadoraClientes(clientesDoBanco);
		
		Cliente cliente = gerClientes.pesquisaCliente(1);
		
		assertThat(cliente.getIdade(), is(14));

		
	}
	
	
	@Test
	public void testeEmailCliente() {

		Cliente cliente01 = new Cliente(1, "Gustavo Farias", 14, "gugafarias@gmail.com", 1, true);
		

		List<Cliente> clientesDoBanco = new ArrayList<>();
		clientesDoBanco.add(cliente01);
		
		gerClientes = new GerenciadoraClientes(clientesDoBanco);
		
		Cliente cliente = gerClientes.pesquisaCliente(1);
		
		assertThat(cliente.getEmail(), is("gugafarias@gmail.com"));

		
	}
	
	
	@Test
	public void testeNomeCliente() {

		Cliente cliente01 = new Cliente(1, "Gustavo Farias", 14, "gugafarias@gmail.com", 1, true);
		

		List<Cliente> clientesDoBanco = new ArrayList<>();
		clientesDoBanco.add(cliente01);
		
		gerClientes = new GerenciadoraClientes(clientesDoBanco);
		
		Cliente cliente = gerClientes.pesquisaCliente(1);
		
		assertThat(cliente.getNome(), is("Gustavo Farias"));

		
	}
	
	
	@Test
	public void testeClienteIdadeValida() throws IdadeNaoPermitidaException {

		Cliente cliente01 = new Cliente(1, "Gustavo Farias", 18, "gugafarias@gmail.com", 1, true);
		

		List<Cliente> clientesDoBanco = new ArrayList<>();
		clientesDoBanco.add(cliente01);
		
		gerClientes = new GerenciadoraClientes(clientesDoBanco);
		
		boolean cliente = gerClientes.validaIdade(18);
		
		assertTrue(cliente);
		
				
	}
	

	
	
	@Test
	public void testeClienteAtivo() {

		Cliente cliente01 = new Cliente(1, "Julya Havilla", 21, "julyahavilla@gmail.com", 1, true);
		

		List<Cliente> clientesDoBanco = new ArrayList<>();
		clientesDoBanco.add(cliente01);
		

		gerClientes = new GerenciadoraClientes(clientesDoBanco);
		

		boolean clienteAtivo = gerClientes.clienteAtivo(1);
		
		assertThat(clienteAtivo, is(true));
	}
	
	@Test
	public void testeClienteInativo() {

		Cliente cliente01 = new Cliente(1, "Julya Havilla", 21, "julyahavilla@gmail.com", 1, false);
		

		List<Cliente> clientesDoBanco = new ArrayList<>();
		clientesDoBanco.add(cliente01);
		

		gerClientes = new GerenciadoraClientes(clientesDoBanco);
		

		boolean clienteAtivo = gerClientes.clienteAtivo(1);
		
		assertThat(clienteAtivo, is(false));
	}
	
	@Test
	public void testRemoveCliente() {


		Cliente cliente01 = new Cliente(1, "Gustavo Farias", 31, "gugafarias@gmail.com", 1, true);
		Cliente cliente02 = new Cliente(2, "Felipe Augusto", 34, "felipeaugusto@gmail.com", 2, true);
		

		List<Cliente> clientesDoBanco = new ArrayList<>();
		clientesDoBanco.add(cliente01);
		clientesDoBanco.add(cliente02);
		
		gerClientes = new GerenciadoraClientes(clientesDoBanco);
		

		boolean clienteRemovido = gerClientes.removeCliente(2);
		

		assertThat(clienteRemovido, is(true));
		assertThat(gerClientes.getClientesDoBanco().size(), is(1));
		assertNull(gerClientes.pesquisaCliente(2));
		
	}
	
	@Test
	public void testeClienteEmail() {

		Cliente cliente01 = new Cliente(1, "Julya Havilla", 21, "julyahavilla@gmail.com", 1, true);
		
		assertTrue(cliente01.validaEmail());
	}
	
	@Test
	public void testeClienteEmailFail() {

		Cliente cliente01 = new Cliente(1, "Julya Havilla", 21, "julyahavillagmail.com", 1, true);
		
		
		assertFalse(cliente01.validaEmail());
	}
	

	
	

}
