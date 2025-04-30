package conta_bancaria.controller;

import java.util.ArrayList;

import conta_bancaria.model.Conta;
import conta_bancaria.repository.ContaRepository;
import conta_bancaria.util.Cores;

public class ContaController implements ContaRepository {

	// Criar a Collection ArrayList
	private ArrayList<Conta> listaContas = new ArrayList<Conta>();
	
	// Variável para controlar os números das contas
	int numero = 0;
	
	@Override
	public void procurarPorNumero(int numero) {
		var conta = buscarNaCollection(numero);
		
		if(conta != null)
			conta.visualizar();
		else
			System.out.printf("\nA Conta número %d não foi encontrada", numero);
		
	}

	@Override
	public void listarTodas() {
		
		//for each pra percorrer tudo
		for(var conta : listaContas)
		{
			conta.visualizar();
		}
		
	}

	@Override
	public void cadastrar(Conta conta) {
		
		listaContas.add(conta);
		System.out.println(Cores.TEXT_GREEN_BOLD + Cores.ANSI_BLACK_BACKGROUND + "A conta foi criada com sucesso!");
		//por try catch dps
	}

	@Override
	public void atualizar(Conta conta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletar(int numero) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sacar(int numero, float valor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void depositar(int numero, float valor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {
		// TODO Auto-generated method stub
		
	}
	
	// Métodos auxiliaries
	
	public int gerarNumero()
	{
		return ++ numero;
	}
	
	//modificador, tipo retorno, nome metodo
	public Conta buscarNaCollection(int numero)
	{
		for(var conta : listaContas)
		{
			if(conta.getNumero() == numero)
				return conta;
		}
		
		return null;
	}
	
}
