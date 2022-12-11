package ordenadores;

import java.util.Arrays;

public class AlgoritmosComplexos {
	
	//Array
    public static void arraySort (int[] vetor){
    	Arrays.sort(vetor);
    }
    
    //QuickSort
    public static void quickSort(int[] vetor){
    	quickSort(vetor, 0, vetor.length -1);
    }
    
    public static void quickSort(int[] vetor, int inicio, int fim){
    	int aux;
    	
    	if (inicio < fim){
    		aux = separar(vetor, inicio, fim);
    		
    		quickSort(vetor, inicio, aux - 1);
    		quickSort(vetor, aux + 1, fim);
    	}
	}

	public static int separar(int[] vetor, int inicio, int fim){
		int principal = vetor[inicio], aux = inicio + 1;
		
		while (aux <= fim) {
			if (vetor[aux] <= principal) aux++;
			
			else if (principal < vetor[fim]) fim--;
			
			else {
				int troca = vetor[aux];
				vetor[aux] = vetor[fim];
				vetor[fim] = troca;
				
				aux++;
				fim--;
			}
		}
		vetor[inicio] = vetor[fim];
		vetor[fim] = principal;
		
		return fim;
	}
	
	//Merge
	public static void merge(int[] vetor){
		merge(vetor, 0, vetor.length - 1);
	}
	
	public static void merge(int[] vetor, int inicio, int fim) {
		int meio;
		
		if(fim - inicio >= 2) {
			meio = (inicio + fim) / 2;
            
			merge(vetor,  inicio, meio);
            merge(vetor,  meio , fim); 
            
            mergeIntercala(vetor, inicio, meio, fim);
        }
    }

    private static void mergeIntercala(int[] vetor, int inicio, int meio, int fim) {
        int tamanhoA = meio, tamanhoB = fim, tamanhoC = fim - inicio;
        int posicaoA = inicio, posicaoB = meio, posicaoC = 0;
        
        int arrayAuxilar[] = new int [tamanhoC];
        
        while (posicaoA < tamanhoA && posicaoB < tamanhoB){
            if(vetor[posicaoA] < vetor [posicaoB]) arrayAuxilar[posicaoC++] = vetor[posicaoA++];
            else arrayAuxilar[posicaoC++] = vetor[posicaoB++];
        }
        
        while(posicaoA < tamanhoA) arrayAuxilar[posicaoC++] = vetor[posicaoA++];
        
        while(posicaoB < tamanhoB) arrayAuxilar[posicaoC++] = vetor[posicaoB++];
        
        for ( int atual = 0 ; atual < arrayAuxilar.length ; atual++ ) vetor[atual + inicio] = arrayAuxilar[atual];
    }
    
}