package bancoDio;

public class Main {

	public static void main(String[] args) {
		Cliente samuel = new Cliente();
		samuel.setNome("Samuel");
		
		Conta cc = new ContaCorrente(samuel);
		Conta poupanca = new ContaPoupanca(samuel);
		
		cc.depositar(1000);
		poupanca.depositar(1000);
		
		cc.sacar(-100);
		cc.tranferir(10, poupanca);
		poupanca.depositar(0);
		poupanca.sacar(1011);
		
		cc.imprimirExtrato();
		poupanca.imprimirExtrato();
		
		
	}

}
