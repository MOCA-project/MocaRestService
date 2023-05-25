package moca.MocaRestService.Domain.Models.Responses;

import java.util.ArrayList;
import java.util.List;

public class HistoricoPorquinho {
    private List<HistoricoPorquinhoItem> items;

    public HistoricoPorquinho() {
        this.items = new ArrayList<>();
    }

    public void add(HistoricoPorquinhoItem item){
        this.items.add(item);
    }

    public boolean isEmpty(){
        return items.isEmpty();
    }
}
