package moca.MocaRestService.Domain.Models.Responses;

import java.util.ArrayList;
import java.util.List;

public class CartoesHomeResponse {
    private List<CartoesHomeCartao> cartoes = new ArrayList<>();

    public List<CartoesHomeCartao> getCartoes() {
        return cartoes;
    }

    public void setCartoes(List<CartoesHomeCartao> cartoes) {
        this.cartoes = cartoes;
    }

    public void add(CartoesHomeCartao cartao){
        this.cartoes.add(cartao);
    }
}
