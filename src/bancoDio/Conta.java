package bancoDio;

public abstract class Conta implements IConta {
	
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;
	
	
	protected int agencia;
	protected int numero;
	protected double saldo;	
	protected Cliente cliente;
	
	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
	}

	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}
	
	@Override
	public void sacar(double valor) {
		if(valor < 0 ) {
			imprimirMaiorZero();
		} else if (valor > this.saldo) {
			imprimirSaldoAbaixo();
		}
		else {
			this.saldo -= valor;
			System.out.printf("\n>>> Saque de %.2f realizado com sucesso! <<<\n", valor);
		}
	}


	@Override
	public void depositar(double valor) {
		if(valor > 0) {
			this.saldo += valor;
			System.out.printf("\n>>> Deposito de %.2f realizado com sucesso! <<<\n", valor);
		}
		else {
			imprimirMaiorZero();
		}
			
	}

	@Override
	public void tranferir(double valor, Conta contaDestino) {
		if (valor > 0) {
			this.saldo -= valor;
			contaDestino.saldo += valor;			
			System.out.printf("\n>>> Tranferência de %.2f realizada com sucesso! <<<\n", valor);
		} else {
			imprimirMaiorZero();
		}
	}

	
	protected void imprimirInfoConta() {
		System.out.printf("Titular: %s \n", this.cliente.getNome());
		System.out.printf("Agencia: %d \n", agencia);
		System.out.printf("Numero: %d\n", numero);
		System.out.printf("Saldo: %.2f\n", saldo);
	}
	
	protected void imprimirMaiorZero() {
		System.out.println("\n*** Operação inválida! ***");
		System.out.println("Digite um valor maior que zero!");
	}
	
	protected void imprimirSaldoAbaixo() {
		System.out.println("\n*** Operação inválida! ***");
		System.out.println("Saldo insuficiente!");
	}
	
}
