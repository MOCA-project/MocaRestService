package moca.MocaRestService.Domain.Models.Responses;

import java.util.ArrayList;
import java.util.List;

public class GraficoDespesas {
    List<IndiceGrafico> indices = new ArrayList<>();

    public List<IndiceGrafico> getIndices() {
        return indices;
    }

    public void setIndices(List<IndiceGrafico> indices) {
        this.indices = indices;
    }
    public void add(IndiceGrafico indice){
        this.indices.add(indice);
    }
}
