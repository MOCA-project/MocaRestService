package moca.MocaRestService.Controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import moca.MocaRestService.Domain.Models.Responses.ExtratoResponse;
import moca.MocaRestService.Domain.Services.ExtratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Tag(name = "Extrato", description = "Grupo de requisições de extrato")
@RestController
@RequestMapping("api/extrato/")
public class ExtratoController {
    @Autowired
    ExtratoService service;

    Path diretorioBase = Path.of(System.getProperty("user.dir"));
    Path txtBase = Paths.get("").toAbsolutePath();
    Path diretorioBase2 = Paths.get(txtBase + "/extrato.txt");


    @Operation(summary = "Retorna o extrato do cliente referente a data solicitada", responses = {
            @ApiResponse(responseCode = "200")
    })
    @GetMapping("{idCliente}/{mes}/{ano}")
    public ResponseEntity<ExtratoResponse> get(@PathVariable long idCliente,
                                              @PathVariable int mes,
                                              @PathVariable int ano){
        var result =  service.get(idCliente, mes, ano);
        return ResponseEntity.status(200).body(result);
    }

    @Operation(
            summary = "Downdload do extrato em excel", responses = {
            @ApiResponse(responseCode = "200", description = "Extrato bancário baixado com sucesso"),
            @ApiResponse(responseCode = "422", description = "Não foi possível baixar o extrato bancário"),
    })
    @GetMapping("arquivo/{idCliente}/{mes}/{ano}")
    public ResponseEntity<byte[]> download(@PathVariable long idCliente,
                                           @PathVariable int mes,
                                           @PathVariable int ano){
        List<ExtratoResponse> listaExtrato = Collections.singletonList(service.get(idCliente, mes, ano));
        service.gravaArquivoCsv(listaExtrato,"extrato");

        File file = this.diretorioBase.resolve("extrato.csv").toFile();

        try {
            InputStream fileInputStream = new FileInputStream(file);

            return ResponseEntity.status(200)
                    .header("Content-Disposition",
                            "attachment; filename=" + "extrato.csv")
                    .body(fileInputStream.readAllBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new ResponseStatusException(422, "Diretório não encontrado", null);
        } catch (IOException e) {
            e.printStackTrace();
            throw new ResponseStatusException(422, "Não foi possível converter para byte[]", null);
        }
    }
    @Operation(
            summary = "Downdload do extrato em txt", responses = {
            @ApiResponse(responseCode = "200", description = "Extrato bancário baixado com sucesso"),
            @ApiResponse(responseCode = "422", description = "Não foi possível baixar o extrato bancário"),
    })
    @GetMapping("arquivoTxt/{idCliente}/{mes}/{ano}")
    public ResponseEntity<byte[]> downloadTxt(@PathVariable long idCliente,
                                           @PathVariable int mes,
                                           @PathVariable int ano) {
        List<ExtratoResponse> listaExtrato = Collections.singletonList(service.get(idCliente, mes, ano));
        service.gravaArquivoTxt(listaExtrato, "extrato.txt");

        File file = this.diretorioBase2.toFile();

        try {
            InputStream fileInputStream = new FileInputStream(file);

            return ResponseEntity.status(200)
                    .header("Content-Disposition",
                            "attachment; filename=" + "extrato.txt")
                    .body(fileInputStream.readAllBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new ResponseStatusException(422, "Diretório não encontrado", null);
        } catch (IOException e) {
            e.printStackTrace();
            throw new ResponseStatusException(422, "Não foi possível converter para byte[]", null);
        }
    }
}
