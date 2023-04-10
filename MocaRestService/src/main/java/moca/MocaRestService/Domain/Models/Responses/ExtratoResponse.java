package moca.MocaRestService.Domain.Models.Responses;

import java.util.ArrayList;
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
}
