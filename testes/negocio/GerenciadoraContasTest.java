package negocio;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class GerenciadoraContasTest {

	private GerenciadoraContas gerContas;
	
	@Test
	public void testTransfereValor() {

		/* ========== Montagem do cenário ========== */
		
		// criando alguns clientes
		int idConta01 = 1;
		int idConta02 = 2;
		ContaCorrente conta01 = new ContaCorrente(idConta01, 200, true);
		ContaCorrente conta02 = new ContaCorrente(idConta02, 0, true);
		
		// inserindo os clientes criados na lista de clientes do banco
		List<ContaCorrente> contasDoBanco = new ArrayList<>();
		contasDoBanco.add(conta01);
		contasDoBanco.add(conta02);
		
		gerContas = new GerenciadoraContas(contasDoBanco);

		/* ========== Execução ========== */
		boolean sucesso = gerContas.transfereValor(idConta01, 100, idConta02);
		
		/* ========== Verificações ========== */
		assertTrue(sucesso);
		assertThat(conta02.getSaldo(), is(100.0));
		assertThat(conta01.getSaldo(), is(100.0));
	}
	

	@Test
	public void testTransfereValor_SaldoInsuficiente() {

		int idConta01 = 1;
		int idConta02 = 2;
		ContaCorrente conta01 = new ContaCorrente(idConta01, 100, true);
		ContaCorrente conta02 = new ContaCorrente(idConta02, 0, true);
		

		List<ContaCorrente> contasDoBanco = new ArrayList<>();
		contasDoBanco.add(conta01);
		contasDoBanco.add(conta02);
		
		gerContas = new GerenciadoraContas(contasDoBanco);


		boolean sucesso = gerContas.transfereValor(idConta01, 200, idConta02);
		

		assertTrue(sucesso);
		assertThat(conta01.getSaldo(), is(-100.0));
		assertThat(conta02.getSaldo(), is(200.0));
	}


	@Test
	public void testTransfereValor_SaldoNegativo() {

		
		int idConta01 = 1;
		int idConta02 = 2;
		ContaCorrente conta01 = new ContaCorrente(idConta01, -100, true);
		ContaCorrente conta02 = new ContaCorrente(idConta02, 0, true);
		
		List<ContaCorrente> contasDoBanco = new ArrayList<>();
		contasDoBanco.add(conta01);
		contasDoBanco.add(conta02);
		
		gerContas = new GerenciadoraContas(contasDoBanco);


		boolean sucesso = gerContas.transfereValor(idConta01, 200, idConta02);
		
		assertTrue(sucesso);
		assertThat(conta01.getSaldo(), is(-300.0));
		assertThat(conta02.getSaldo(), is(200.0));
	}
	
	@Test
	public void testTransfereValor_SaldoNegativoParaNegativo() {

		int idConta01 = 1;
		int idConta02 = 2;
		ContaCorrente conta01 = new ContaCorrente(idConta01, -100, true);
		ContaCorrente conta02 = new ContaCorrente(idConta02, -100, true);
		
		List<ContaCorrente> contasDoBanco = new ArrayList<>();
		contasDoBanco.add(conta01);
		contasDoBanco.add(conta02);
		
		gerContas = new GerenciadoraContas(contasDoBanco);

		boolean sucesso = gerContas.transfereValor(idConta01, 200, idConta02);
		
		assertTrue(sucesso);
		assertThat(conta01.getSaldo(), is(-300.0));
		assertThat(conta02.getSaldo(), is(100.0));
	}
	

	@Test
	public void testTransfereValor_Nenhum() {


		int idConta01 = 1;
		int idConta02 = 2;
		ContaCorrente conta01 = new ContaCorrente(idConta01, -100, true);
		ContaCorrente conta02 = new ContaCorrente(idConta02, -100, true);
		

		List<ContaCorrente> contasDoBanco = new ArrayList<>();
		contasDoBanco.add(conta01);
		contasDoBanco.add(conta02);
		
		gerContas = new GerenciadoraContas(contasDoBanco);


		boolean sucesso = gerContas.transfereValor(idConta01, 2, idConta02);
		

		assertTrue(sucesso);
		assertThat(conta01.getSaldo(), is(-102.0));
		assertThat(conta02.getSaldo(), is(-98.0));
	}
	
	
	@Test
	public void testDepositaValor() {
		
		int idConta01= 1;
		
		ContaCorrente conta01 = new ContaCorrente(idConta01, 0, true);
		
		List<ContaCorrente> contasDoBanco = new ArrayList<>();
		contasDoBanco.add(conta01);
		
		gerContas = new GerenciadoraContas(contasDoBanco);
		
		conta01.depositar(100);
		
		assertThat(conta01.getSaldo(), is(100.0));
		
	}
	
	
	@Test
	public void testSacarValor() {
		
		int idConta01 = 1;
		
		ContaCorrente conta01 = new ContaCorrente(idConta01, 100.0, true);
		
		List<ContaCorrente> contasDoBanco = new ArrayList<>();
		contasDoBanco.add(conta01);
		
		gerContas = new GerenciadoraContas(contasDoBanco);
		
		conta01.sacar(100.0);
		
		assertThat(conta01.getSaldo(), is(0.0));
			
		
		
	}
	
	
	@Test
	public void testeSacarValor() {
		
		int idConta01 = 1;
		int idConta02 = 2;
		
		
		ContaCorrente conta01 = new ContaCorrente(idConta01, 100.0, true);
		ContaCorrente conta02 = new ContaCorrente(idConta02, 100.0, true);
		
		List<ContaCorrente> contasDoBanco =   new ArrayList<>();
		contasDoBanco.add(conta01);
		contasDoBanco.add(conta02);
		
		gerContas = new GerenciadoraContas(contasDoBanco);
		
		conta01.sacar(80);
		conta02.sacar(50);
		
		
		assertThat(conta01.getSaldo(), is(20.0));
		assertThat(conta02.getSaldo(), is(50.0));
		
	}
	
	
}