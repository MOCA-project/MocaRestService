package moca.MocaRestService.Domain.Models.Responses;

import java.util.List;

public class HistoricoPorquinho {
    private List<HistoricoPorquinhoItem> items;

    public HistoricoPorquinho(List<HistoricoPorquinhoItem> items) {
        this.items = items;
    }

    public HistoricoPorquinho() {
    }

    public void add(HistoricoPorquinhoItem item){
        this.items.add(item);
    }
}
