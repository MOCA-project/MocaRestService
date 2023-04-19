package moca.MocaRestService.Domain.Helper.ListaGenerica;

import java.util.List;

public class ListaObj <T> {

    private final T[] vetor;
    private int nroElem;

    public ListaObj(int tamanho) {
        vetor = (T[]) new Object[tamanho];
        nroElem = 0;
    }

    public void adiciona(T elemento) {
        if (nroElem == vetor.length) {
            throw new IllegalStateException("A lista está cheia");
        }
        vetor[nroElem] = elemento;
        nroElem++;
    }

    public int busca(T elementoBuscado) {
        for (int i = 0; i < nroElem; i++) {
            if (vetor[i].equals(elementoBuscado)) {
                return i;
            }
        }
        return -1;
    }

    public boolean removePeloIndice(int indice) {
        if (indice < 0 || indice >= nroElem) {
            return false;
        }
        for (int i = indice; i < nroElem - 1; i++) {
            vetor[i] = vetor[i+1];
        }
        nroElem--;
        return true;
    }

    public boolean removeElemento(T elementoARemover) {
        int indice = busca(elementoARemover);
        if (indice == -1) {
            return false;
        }
        return removePeloIndice(indice);
    }

    public int getTamanho() {
        return nroElem;
    }

    public T getElemento(int indice) {
        if (indice < 0 || indice >= nroElem) {
            return null;
        }
        return vetor[indice];
    }

    public void limpa() {
        nroElem = 0;
    }

    public void exibe() {
        for (int i = 0; i < nroElem; i++) {
            System.out.println(vetor[i]);
        }
    }

    public T[] getVetor() {
        return vetor;
    }
    public void adicionaAll(List<T> lista) {
        for (T elemento : lista) {
            adiciona(elemento);
        }
    }
}
