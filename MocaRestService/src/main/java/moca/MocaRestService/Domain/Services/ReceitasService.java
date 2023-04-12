package moca.MocaRestService.Domain.Services;

import moca.MocaRestService.Domain.Helper.Exception.CustomException;
import moca.MocaRestService.Domain.Mappers.ReceitaMapper;
import moca.MocaRestService.Infrastructure.Entities.Receita;
import moca.MocaRestService.Infrastructure.Repositories.IReceitasRepository;
import moca.MocaRestService.Domain.Models.Requests.ReceitaRequest;
import moca.MocaRestService.Domain.Models.Responses.ReceitaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.http.HttpStatus;

@Service
public class ReceitasService {
    @Autowired
    private IReceitasRepository repository;

    public ReceitaResponse add(ReceitaRequest request){
        var receita = ReceitaMapper.toEntity(request);

        var result = repository.save(receita);

        return ReceitaMapper.toResponse(result);
    }

    public List<ReceitaResponse> postReceitaFixa(ReceitaRequest request) {
        // Adiciona a mesma receita para os próximos 12 meses
        List<ReceitaResponse> response = new ArrayList<>();
        List<Receita> receitas = new ArrayList<>();

        LocalDate data = request.getData();

        for (int i = 0; i < 12; i++) {
            var receita = ReceitaMapper.toEntity(request);
            receita.setData(data.plusMonths(i));
            receitas.add(receita);
        }

        List<Receita> result = repository.saveAll(receitas);

        for (Receita r : result) {
            response.add(ReceitaMapper.toResponse(r));
        }

        return response;
    }

    public void removeReceita(long idDespesa) {
        var receita = repository.findById(idDespesa);
        if (receita.isPresent())
            repository.deleteById(idDespesa);

        throw new CustomException("Despesa não encontrada", HttpStatus.NOT_FOUND);
    }
}