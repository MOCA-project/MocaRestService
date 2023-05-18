package moca.MocaRestService.Domain.Helper.GenericTypes;

public class FilaObj<T> {
    private int tamanho;
    private T[] fila;

    public FilaObj(int capacidade) {
        this.tamanho = 0;
        this.fila = (T[]) new Object[capacidade];
    }

    public boolean isEmpty() {
        return tamanho == 0;
    }

    public boolean isFull() {
        return tamanho == fila.length;
    }

    public void insert(T elemento) {
        if (isFull()) {
            throw new IllegalStateException("A fila está cheia.");
        }
        fila[tamanho] = elemento;
        tamanho++;
    }

    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return fila[0];
    }

    public T poll() {
        if (isEmpty()) {
            return null;
        }
        T elementoRemovido = fila[0];
        for (int i = 0; i < tamanho - 1; i++) {
            fila[i] = fila[i + 1];
        }
        fila[tamanho - 1] = null;
        tamanho--;
        return elementoRemovido;
    }

    public void exibe() {
        if (isEmpty()) {
            System.out.println("A fila está vazia.");
            return;
        }
        for (int i = 0; i < tamanho; i++) {
            System.out.println(fila[i]);
        }
    }

    public int getTamanho() {
        return tamanho;
    }
}
