package k.nn;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* 1: Abre os dois arquivos: teste e treino
 2: Normaliza os dados do arquivo usando max-min ou z-score
 3: Aplicar k-nn (mahathan ou euclidiana)
 4: Gerar matriz de confusão: matriz de dados
 */
public class AlgoritmoKnn {

    public void normalizarDados() throws IOException {
        //---------------LER ARQUIVOS------------//
        FileReader dadosTeste = new FileReader("teste.data");
        BufferedReader lerArquivoTeste = new BufferedReader(dadosTeste);
        String linhaTeste = lerArquivoTeste.readLine();
        
        FileReader dadosTreino = new FileReader("treino.data");
        BufferedReader lerArquivoTreino = new BufferedReader(dadosTreino);
        String linhaTreino = lerArquivoTreino.readLine();
        
        /* Usando o z-score
        1: aplica a media de todos os elementos
        2: aplica o desvio padrão
        3: normaliza os dados usando: v0i = (vi − A¯)/σA
        */
        
        double mediaTeste = 0, desvioPadraoTeste = 0;
        int tamTeste = 0;
        String apenasNumeros = new String();
        ArrayList<String> valoresTeste = new ArrayList<>();
        
        while (linhaTeste != null) {
            if(linhaTeste.contains("janeiro")) {
               apenasNumeros  = linhaTeste.replace("janeiro", "");
               valoresTeste.add(apenasNumeros);
                       
            }else if(linhaTeste.contains("fevereiro")){
               apenasNumeros  = linhaTeste.replace("fevereiro", "");
               valoresTeste.add(apenasNumeros);
               
            }else if(linhaTeste.contains("maio")){
               apenasNumeros  = linhaTeste.replace("maio", "");
               valoresTeste.add(apenasNumeros);
               
            }else if(linhaTeste.contains("abril")){
               apenasNumeros  = linhaTeste.replace("abril", "");
               valoresTeste.add(apenasNumeros);
               
            }else if(linhaTeste.contains("junho")){
               apenasNumeros  = linhaTeste.replace("junho", "");
               valoresTeste.add(apenasNumeros);
               
            }else if(linhaTeste.contains("julho")){
               apenasNumeros  = linhaTeste.replace("julho", "");
               valoresTeste.add(apenasNumeros);
               
            }else if(linhaTeste.contains("agosto")){
               apenasNumeros  = linhaTeste.replace("agosto", "");
               valoresTeste.add(apenasNumeros);
               
            }else if(linhaTeste.contains("setembro")){
               apenasNumeros  = linhaTeste.replace("setembro", "");
               valoresTeste.add(apenasNumeros);
                       
            }else if(linhaTeste.contains("outubro")){
               apenasNumeros  = linhaTeste.replace("outubro", "");
               valoresTeste.add(apenasNumeros);
                        
            }else if(linhaTeste.contains("novembro")){
               apenasNumeros  = linhaTeste.replace("novembro", "");
               valoresTeste.add(apenasNumeros);
               
            }else if(linhaTeste.contains("desembro")){
               apenasNumeros  = linhaTeste.replace("dezembro", "");
               valoresTeste.add(apenasNumeros);
            }
            linhaTeste = lerArquivoTeste.readLine();
        }
        
        tamTeste = valoresTeste.size();
        double sum = 0; 
        int count = 0;
        //--ACHA MEDIA
        for (int i = 0; i < tamTeste; i++) {
            int tam = valoresTeste.get(i).trim().split(",").length;
            count += tam;            
            for(int k = 0; k < tam; k++){
                sum += Double.valueOf(valoresTeste.get(i).split(",")[k]);
            }
           
        }
         mediaTeste = sum / count;
         
         //--ACHA DESVIO
         double desvio=0, desvioQuadrado = 0, desvioSub=0, mediaQuadrado;
         int contDesvioPadrao = 0;
         
         for (int i = 0; i < tamTeste; i++) {
             int valor = valoresTeste.get(i).trim().split(",").length;
             contDesvioPadrao += valor;
             for (int j = 0; j < valor; j++) {
                desvio = Double.valueOf(valoresTeste.get(i).split(",")[j]);
                desvioSub = desvio - mediaTeste;
                desvioQuadrado = desvioQuadrado + (desvioSub*desvioSub);
                
             }
         }
         mediaQuadrado = desvioQuadrado/contDesvioPadrao;
         desvioPadraoTeste = Math.sqrt(mediaQuadrado);
        
         //--NORMALIZA
        
        double normalizaDadosTeste, valor = 0, calcNormaliza;
        ArrayList<Double> dadosNormalizadosTeste = new ArrayList<>();
        for (int i = 0; i < tamTeste; i++) {
            int dados = valoresTeste.get(i).trim().split(",").length;
            for (int j = 0; j < dados; j++) {
                 valor = Double.valueOf(valoresTeste.get(i).split(",")[j]);
                 calcNormaliza = (valor-mediaTeste)/desvioPadraoTeste;
                 dadosNormalizadosTeste.add(calcNormaliza); 
            }
        }
    
        
        /* Usando o z-score
        1: aplica a media de todos os elementos
        2: aplica o desvio padrão
        3: normaliza os dados usando: v0i = (vi − A¯)/σA
        */
        
        double mediaTreino = 0, desvioPadraoTreino = 0;
        
        int tamTreino = 0;
        String apenasNumerosTreino = new String();
        ArrayList<String> valoresTreino = new ArrayList<>();
        
        while (linhaTreino != null) {
            if(linhaTreino.contains("janeiro")) {
               apenasNumerosTreino  = linhaTreino.replace("janeiro", "");
               valoresTreino.add(apenasNumeros);
                       
            }else if(linhaTreino.contains("fevereiro")){
               apenasNumerosTreino  = linhaTreino.replace("fevereiro", "");
               valoresTreino.add(apenasNumeros);
               
            }else if(linhaTreino.contains("maio")){
               apenasNumerosTreino = linhaTreino.replace("maio", "");
               valoresTreino.add(apenasNumeros);
               
            }else if(linhaTreino.contains("abril")){
               apenasNumerosTreino = linhaTreino.replace("abril", "");
               valoresTreino.add(apenasNumeros);
               
            }else if(linhaTreino.contains("junho")){
               apenasNumerosTreino = linhaTreino.replace("junho", "");
               valoresTreino.add(apenasNumeros);
               
            }else if(linhaTreino.contains("julho")){
               apenasNumerosTreino = linhaTreino.replace("julho", "");
               valoresTreino.add(apenasNumeros);
               
            }else if(linhaTreino.contains("agosto")){
               apenasNumerosTreino = linhaTreino.replace("agosto", "");
               valoresTreino.add(apenasNumeros);
               
            }else if(linhaTreino.contains("setembro")){
               apenasNumerosTreino = linhaTreino.replace("setembro", "");
               valoresTreino.add(apenasNumeros);
                       
            }else if(linhaTreino.contains("outubro")){
               apenasNumerosTreino = linhaTreino.replace("outubro", "");
               valoresTreino.add(apenasNumeros);
                        
            }else if(linhaTreino.contains("novembro")){
               apenasNumerosTreino = linhaTreino.replace("novembro", "");
               valoresTreino.add(apenasNumeros);
               
            }else if(linhaTreino.contains("desembro")){
               apenasNumerosTreino = linhaTreino.replace("dezembro", "");
               valoresTreino.add(apenasNumeros);
            }
            linhaTreino = lerArquivoTreino.readLine();
        }
        
        tamTreino = valoresTreino.size();
        double sumTreino = 0; 
        int countTreino = 0;
        //--ACHA MEDIA
        for (int i = 0; i < tamTreino; i++) {
            int tam = valoresTreino.get(i).trim().split(",").length;
            countTreino += tam;            
            for(int k = 0; k < tam; k++){
                sumTreino += Double.valueOf(valoresTreino.get(i).split(",")[k]);
            }
           
        }
         mediaTreino = sumTreino / countTreino;
         
         //--ACHA DESVIO
         double desvioTreino=0, desvioQuadradoTreino = 0, desvioSubTreino=0, mediaQuadradoTreino;
         int contDesvioPadraoTreino = 0;
         
         for (int i = 0; i < tamTreino; i++) {
             int valorTreino = valoresTreino.get(i).trim().split(",").length;
             contDesvioPadraoTreino += valorTreino;
             for (int j = 0; j < valorTreino; j++) {
                desvioTreino = Double.valueOf(valoresTreino.get(i).split(",")[j]);
                desvioSubTreino = desvioTreino - mediaTreino;
                desvioQuadradoTreino = desvioQuadradoTreino + (desvioSubTreino*desvioSubTreino);
                
             }
         }
         mediaQuadradoTreino = desvioQuadradoTreino/contDesvioPadraoTreino;
         desvioPadraoTreino = Math.sqrt(mediaQuadradoTreino);
        
         //--NORMALIZA
        
        double valorTreino = 0, calcNormalizaTreino;
        ArrayList<Double> dadosNormalizadosTreino = new ArrayList<>();
        for (int i = 0; i < tamTreino; i++) {
            int dados = valoresTreino.get(i).trim().split(",").length;
            for (int j = 0; j < dados; j++) {
                 valorTreino = Double.valueOf(valoresTreino.get(i).split(",")[j]);
                 calcNormalizaTreino = (valorTreino-mediaTreino)/desvioPadraoTreino;
                 dadosNormalizadosTreino.add(calcNormalizaTreino);
                 
            }
        }
        System.out.println(dadosNormalizadosTreino);
        
    }
    
    public void aplicaDistanciaManhattan(int valorK) {
        
    }

    public void geraMatrizConfusao() {

    }

    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        AlgoritmoKnn knn = new AlgoritmoKnn();
        knn.normalizarDados();
        //knn.lerDadosTeste();
    }

}
