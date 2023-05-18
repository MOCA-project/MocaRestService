package moca.MocaRestService.Domain.Helper.GenericTypes;

public class PilhaObj<T> {

    // 01) Atributos
    private T[] pilha;
    private int topo;

    // 02) Construtor
    public PilhaObj(int capacidade) {
        pilha = (T[]) new Object[capacidade];
        topo = -1;
    }

    // 03) Método isEmpty
    public Boolean isEmpty() {
        return topo == -1;
    }

    // 04) Método isFull
    public Boolean isFull() {
        return topo >= pilha.length - 1;
    }

    // 05) Método push
    public void push(T info) {
        if (isFull()) {
            throw new IllegalStateException("Pilha cheia!");
        }
       pilha[++topo] = info;
    }

    // 06) Método pop
    public T pop() {
        if (isEmpty()) {
            return null;
        }
        return pilha[topo--];
    }

    // 07) Método peek
    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return pilha[topo];
    }

    // 08) Método exibe
    public void exibe() {
        if (isEmpty()) {
            System.out.println("Pilha vazia!");
        }
        else {
            System.out.println("\nElementos da pilha:");
            for (int i = topo; i >= 0; i--) {
                System.out.println(pilha[i]);
            }
        }
    }


    //Getters & Setters (manter)
    public int getTopo() {
        return topo;
    }
}