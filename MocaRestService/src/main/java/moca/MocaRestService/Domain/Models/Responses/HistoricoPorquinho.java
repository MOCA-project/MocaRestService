package moca.MocaRestService.Domain.Models.Responses;

import java.util.ArrayList;
import java.util.List;

public class HistoricoPorquinho {
    private List<HistoricoPorquinhoItem> items = new ArrayList<>();

    public HistoricoPorquinho() {
        this.items = new ArrayList<>();
    }

    public void add(HistoricoPorquinhoItem item){
        this.items.add(item);
    }

    public List<HistoricoPorquinhoItem> getItems() {
        return items;
    }

    public void setItems(List<HistoricoPorquinhoItem> items) {
        this.items = items;
    }
}
