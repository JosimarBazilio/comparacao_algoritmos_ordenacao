package main;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Duration;
import java.time.Instant;
import java.util.function.Consumer;

import geradores.Vetor;
import ordenadores.*;

public class CompararAlgoritmos {

	public static void main(String[] args) throws IOException{
		
		FileWriter arq = new FileWriter("DadosBrutos.csv");
	    PrintWriter gravarArq = new PrintWriter(arq);
	    
	    int dados[][], inicio, fim, crescimento;
		String[] algoritmos = {"Bubble", "Insertion", "Selection", "Array", "QuickSort", "Merge"};
		
		gravarArq.printf("algoritmo, qtd, rdn1, rdn2, rdn3, ordem, inver");
		
	    for(int k = 0; k < 1000; k++) {
	    	
	    	inicio = 100; 
			fim = 17600; 
			crescimento = 500;
			
			while(inicio <= fim){
				
				dados = gerador(inicio);
				
				System.out.println("Qtd Elementos: " + inicio);
				
				//Bubble
				executar(AlgoritmosSimples 		:: bubble, 		dados, "\n" + algoritmos[0], gravarArq, inicio);
				
				//Insertion
				executar(AlgoritmosSimples 		:: insertion, 	dados, "\n" + algoritmos[1], gravarArq, inicio);
				
				//Selection 
				executar(AlgoritmosSimples 		:: selection, 	dados, "\n" + algoritmos[2], gravarArq, inicio);

				//Array
				executar(AlgoritmosComplexos 	:: arraySort, 	dados, "\n" + algoritmos[3], gravarArq, inicio);

				//QuickSort
				executar(AlgoritmosComplexos 	:: quickSort, 	dados, "\n" + algoritmos[4], gravarArq, inicio);

				//Merge
				executar(AlgoritmosComplexos 	:: merge, 		dados, "\n" + algoritmos[5], gravarArq, inicio);

				System.out.println("\n");

				inicio += crescimento;
			}
		}
	    
	    gravarArq.close();
	}
	
	public static void executar(Consumer<int[]> metodo, int[][] dados, String algoritmo, PrintWriter arq, int tamanho) {
				
		Instant iInicial, iFinal;
		Duration duracao;
		String salvar = "";
		
		int[] auxA1 = dados[0].clone();
		int[] auxA2 = dados[1].clone();
		int[] auxA3 = dados[2].clone();
		int[] auxO 	= dados[3].clone();
		int[] auxI 	= dados[4].clone();
		
		System.out.println(algoritmo + " Sort");
		salvar += algoritmo + "," + tamanho; 
				
		//Aleatorios
		iInicial = Instant.now();
		metodo.accept(auxA1);
		iFinal = Instant.now();
		duracao = Duration.between(iInicial, iFinal);
		salvar += "," + duracao.toMillis();
		System.out.println("Rnd 1" + "\tExecutado em = " + duracao.toMillis() + "\tMs");
		
		iInicial = Instant.now();
		metodo.accept(auxA2);
		iFinal = Instant.now();
		duracao = Duration.between(iInicial, iFinal);
		salvar += "," + duracao.toMillis();
		System.out.println("Rnd 2" + "\tExecutado em = " + duracao.toMillis() + "\tMs");
		
		iInicial = Instant.now();
		metodo.accept(auxA3);
		iFinal = Instant.now();
		duracao = Duration.between(iInicial, iFinal);
		salvar += "," + duracao.toMillis();
		System.out.println("Rnd 3" + "\tExecutado em = " + duracao.toMillis() + "\tMs");
		
		//Ordenado
		iInicial = Instant.now();
		metodo.accept(auxO);
		iFinal = Instant.now();
		duracao = Duration.between(iInicial, iFinal);
		salvar += "," + duracao.toMillis();
		System.out.println("Ordem" + "\tExecutado em = " + duracao.toMillis() + "\tMs");
		
		//Inver
		iInicial = Instant.now();
		metodo.accept(auxI);
		iFinal = Instant.now();
		duracao = Duration.between(iInicial, iFinal);
		salvar += "," + duracao.toMillis();
		System.out.println("Inver" + "\tExecutado em = " + duracao.toMillis() + "\tMs");
		
		arq.printf(salvar);
	}
	
	public static int[][] gerador(int atual){
		int[] aleatorio1, aleatorio2, aleatorio3, melhor, pior;
		
		aleatorio1 = Vetor.aleatorio(atual);
		aleatorio2 = Vetor.aleatorioSemRepetir(atual);
		aleatorio3 = Vetor.aleatorio(atual);
		
		melhor = Vetor.ordenado(atual);
		pior = Vetor.invertido(atual);
		
		int[][] dados = {aleatorio1, aleatorio2, aleatorio3, melhor, pior};
		
		return dados;
	}
}