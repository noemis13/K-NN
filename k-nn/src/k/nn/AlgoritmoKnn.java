package k.nn;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author noemi
 */

/* 1: Abre os dois arquivos: teste e treino
 2: Normaliza os dados do arquivo usando max-min ou z-score
 3: Aplicar k-nn (mahathan ou euclidiana)
 4: Gerar matriz de confusão: matriz de dados
 */
public class AlgoritmoKnn {

    /*public String lerDadosTeste() throws FileNotFoundException, IOException {
        FileReader dadosTeste = new FileReader("teste.data");
        BufferedReader lerArquivoTeste = new BufferedReader(dadosTeste);

        String linhaTeste = lerArquivoTeste.readLine();
        while (linhaTeste != null) {
            //System.out.println(linhaTeste);
            linhaTeste = lerArquivoTeste.readLine();
            return linhaTeste;
        
        }
        return null;
        
        
    }

    public void lerDadosTreino() throws FileNotFoundException, IOException {
        FileReader dadosTreino = new FileReader("treino.data");
        BufferedReader lerArquivoTreino = new BufferedReader(dadosTreino);

        String linhaTreino = lerArquivoTreino.readLine();
        while (linhaTreino != null) {
            System.out.println(linhaTreino);
            linhaTreino = lerArquivoTreino.readLine();
            //return linhaTreino;
        }
        //return null;
    }*/

    public void normalizarDados() throws IOException {
        //---------------LER ARQUIVOS------------//
        FileReader dadosTeste = new FileReader("teste.data");
        BufferedReader lerArquivoTeste = new BufferedReader(dadosTeste);
        FileReader dadosTreino = new FileReader("treino.data");
        BufferedReader lerArquivoTreino = new BufferedReader(dadosTreino);

        
        String linhaTeste = lerArquivoTeste.readLine();
        String linhaTreino = lerArquivoTreino.readLine();
        
        String tiraMeses;
        
        
        /* Usando o z-score
        1: aplica a media de todos os elementos
        2: aplica o desvio padrão
        3: normaliza os dados usando: v0i = (vi − A¯)/σA
        */
        
        int mediaTeste = 0, desvioPadraoTeste = 0;
        int contValores = 0;
        
        while (linhaTeste != null) {
            //colocar condicao
            contValores++;
            mediaTeste = mediaTeste + Integer.parseInt(linhaTeste);
            linhaTeste = lerArquivoTeste.readLine();
            
        }
        mediaTeste = mediaTeste/contValores;
        //calcular desvio padrao
        
        /*
        Calcular para cada valor e salvar em uma lista
        */
        int normalizaDadosTeste;
        ArrayList<Integer> dadosNormalizadosTeste = new ArrayList<>();
        while(linhaTeste != null) {
            normalizaDadosTeste = (Integer.parseInt(linhaTeste)-mediaTeste)/desvioPadraoTeste;
            dadosNormalizadosTeste.add(normalizaDadosTeste);
        }
        
        /**
         * NORMALIZAR DADOS TREINO
         */
  
        int mediaTreino = 0, desvioPadraoTreino = 0;
        int contValoresTreino = 0;
        
        while (linhaTeste != null) {
            //colocar condicao
            contValores++;
            mediaTreino = mediaTreino + Integer.parseInt(linhaTeste);
            linhaTreino = lerArquivoTeste.readLine();
            
        }
        mediaTeste = mediaTeste/contValores;
        //calcular desvio padrao
        
        int normalizaDadosTreino;
        ArrayList<Integer> dadosNormalizadosTreino = new ArrayList<>();
        while(linhaTeste != null) {
            normalizaDadosTreino = (Integer.parseInt(linhaTreino)-mediaTreino)/desvioPadraoTreino;
            dadosNormalizadosTreino.add(normalizaDadosTreino);
        }
        
        
    }
    
    public void aplicaDistanciaManhattan(int valorK, ArrayList<Integer> dadosNormalizadosTreino, ArrayList<Integer> dadosNormalizadosTeste) {
        
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
