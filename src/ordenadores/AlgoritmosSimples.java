package ordenadores;

public class AlgoritmosSimples {
	
	//Bubble
	public static void bubble(int[] vetor){
        int aux;
		
        for (int i = 0; i < vetor.length - 1; i++) {
        	for(int j = i + 1; j < vetor.length; j++){
        		
        		if(vetor[j] < vetor[i]){
        			aux = vetor[j];
        			vetor[j] = vetor[i];
        			vetor[i] = aux;
        		}
        	}
        }
    }
	
	//Insertion
	public static void insertion(int[] vetor){
        int j, aux;
        
        for(int i = 1; i < vetor.length; i++){
            aux = vetor[i];

            for(j = i - 1; (j >=0) && (vetor[j] > aux ); j--) vetor[j + 1] = vetor[j];
            
            vetor[j + 1] = aux;
        }
    }
		
	//Selection
	public static void selection(int[] vetor){
		int menor, aux;
		
		for(int i = 0; i < vetor.length - 1; i++){
			menor = i;
			
			for(int j = i + 1; j < vetor.length; j++) if(vetor[j] < vetor[menor]) menor = j;
			
			if(menor != i) {
				aux = vetor[i];
				vetor[i] = vetor[menor];
				vetor[menor] = aux;
			}
		}
	}
	
}