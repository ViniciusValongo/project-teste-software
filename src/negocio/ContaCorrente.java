package negocio;


public class ContaCorrente {
	
	private int id;
	
	private double saldo;
	
	private boolean ativa;

	public ContaCorrente(int id, double saldo, boolean ativa) {
		this.id = id;
		this.saldo = saldo;
		this.ativa = ativa;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public double getSaldo() {
		return saldo;
	}


	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	

	public boolean isAtiva() {
		return ativa;
	}


	public void setAtiva(boolean ativa) {
		this.ativa = ativa;
	}
	
	public void depositar(double v) {
		if(this.isAtiva()) {
			this.setSaldo(this.getSaldo()+v);
			System.out.println("Deposito de "+v+" realizado com sucesso");
		}else {
			System.out.println("Impossivel depositar");
		}
	}
	
	public void sacar(double v) {
		if(this.isAtiva()== true ) {
			if(this.getSaldo()>=v) {
				this.setSaldo(this.getSaldo()-v);
				System.out.println("Saque de "+v+" realizado com sucesso");
			}else {
				System.out.println("Saldo insuficiente");
			}
		}else {
			System.out.println("Impossivel sacar");
		}
	}
	

	@Override
	public String toString() {
		
		String str = "========================="
					+ "Id: " + this.id + "\n"
					+ "Saldo: " + this.saldo + "\n"
					+ "Status: " + (ativa?"Ativa":"Inativa") + "\n"
					+ "=========================";
		return str;
	}
	
}
