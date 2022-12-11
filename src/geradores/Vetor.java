package geradores;

import java.util.Random;

public class Vetor {
	
	public static int[] ordenado(int tamanho){
		int vetor[] = new int[tamanho];
		
		for(int i = 0; i < vetor.length; i++) vetor[i] = i + 1;
		
		return vetor;
	}
	
	public static int[] invertido(int tamanho){
		int j = tamanho, vetor[] = new int[tamanho];
		
		for(int i = 0; i < vetor.length; i++){
			vetor[i] = j;
			j--;
		}

		return vetor;
	}
	
	public static int[] aleatorioSemRepetir(int tamanho){
		int vetor[] = new int[tamanho], aux;
		
		Random rd = new Random();
		
		int i = 0;
		boolean existe;
		do {
			aux = rd.nextInt(tamanho)+1;
			
			existe = false;
			for(int j = 0; j < i; j++){
				if(aux == vetor[j]){
					existe = true;
					break;
				}
			}
			
			if(!existe) {
				vetor[i] = aux;
				i++;
			}
			
		}while(i<vetor.length);

		return vetor;
	}
	
	public static int[] aleatorio(int tamanho){
		int vetor[] = new int[tamanho];
		
		Random rd = new Random();
		
		for(int i = 0; i < vetor.length; i++) vetor[i] = rd.nextInt();

		return vetor;
	}
	
}