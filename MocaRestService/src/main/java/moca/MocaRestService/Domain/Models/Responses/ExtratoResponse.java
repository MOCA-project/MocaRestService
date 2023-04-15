package moca.MocaRestService.Domain.Models.Responses;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExtratoResponse {
    List<ItemExtrato> items = new ArrayList<>();


    public List<ItemExtrato> getItems() {
        return items;
    }

    public void setItems(List<ItemExtrato> items) {
        this.items = items;
    }

    public void add(ItemExtrato item){
        this.items.add(item);
    }
    @JsonIgnore
    public List<String> getSituacao(){
        List<String> situacoes = new ArrayList<>();
        for (ItemExtrato itemExtrato : items){
            situacoes.add(itemExtrato.getSituacao());
        }
        return situacoes;
    }
    @JsonIgnore
    public List<LocalDate> getData(){
        List<LocalDate> datas = new ArrayList<>();
        for (ItemExtrato itemExtrato : items){
            datas.add(itemExtrato.getData());
        }
        return datas;
    }
    @JsonIgnore
    public List<String> getDescricao(){
        List<String> descricoes = new ArrayList<>();
        for (ItemExtrato itemExtrato : items){
            descricoes.add(itemExtrato.getDescricao());
        }
        return descricoes;
    }
    @JsonIgnore
    public List<String> getCategoria(){
        List<String> categorias = new ArrayList<>();
        for (ItemExtrato itemExtrato : items){
            categorias.add(itemExtrato.getCategoria());
        }
        return categorias;
    }
    @JsonIgnore
    public List<Double> getValor(){
        List<Double> valores = new ArrayList<>();
        for (ItemExtrato itemExtrato : items){
            valores.add(itemExtrato.getValor());
        }
        return valores;
    }

}
