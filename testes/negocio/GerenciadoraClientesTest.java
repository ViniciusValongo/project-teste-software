package negocio;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

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
	public void testeClienteIdadeValida() throws IdadeNaoPermitidaException {

		Cliente cliente01 = new Cliente(1, "Gustavo Farias", 18, "gugafarias@gmail.com", 1, true);
		

		List<Cliente> clientesDoBanco = new ArrayList<>();
		clientesDoBanco.add(cliente01);
		
		gerClientes = new GerenciadoraClientes(clientesDoBanco);
		
		boolean cliente = gerClientes.validaIdade(18);
		
		assertThat(cliente, is(true));
		
				
	}
	
	
	@Test
	public void testeClienteIdadeInvalida() throws IdadeNaoPermitidaException {

		Cliente cliente01 = new Cliente(1, "Gustavo Farias", 14, "gugafarias@gmail.com", 1, true);
		

		List<Cliente> clientesDoBanco = new ArrayList<>();
		clientesDoBanco.add(cliente01);
		
		gerClientes = new GerenciadoraClientes(clientesDoBanco);
		
		boolean cliente = gerClientes.validaIdade(14);
		
		assertThat(cliente, is(IdadeNaoPermitidaException.MSG_IDADE_INVALIDA));
		
				
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
	
	

}
