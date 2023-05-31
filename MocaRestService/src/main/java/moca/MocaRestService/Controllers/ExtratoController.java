package moca.MocaRestService.Controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import moca.MocaRestService.Domain.Models.Responses.ArquivoResponse;
import moca.MocaRestService.Domain.Models.Responses.ExtratoResponse;
import moca.MocaRestService.Domain.Services.ArquivoService;
import moca.MocaRestService.Domain.Services.ClienteService;
import moca.MocaRestService.Domain.Services.ExtratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
@Tag(name = "Extrato", description = "Grupo de requisições de extrato")
@RestController
@RequestMapping("api/extrato/")
public class ExtratoController {
    @Autowired
    ExtratoService service;
    @Autowired
    private ClienteService clienteService;
    @Autowired
    ArquivoService arquivoService;

    Path diretorioBase = Path.of(System.getProperty("user.dir"));

    Path txtBase = Paths.get("").toAbsolutePath();
    private Path diretorioBase2;
    //Path diretorioBase2 = Paths.get(txtBase + "/extrato");


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
        //clienteService.foundClienteOrThrow(idCliente);
        List<ExtratoResponse> listaExtrato = Collections.singletonList(service.get(idCliente, mes, ano));
        service.gravaArquivoTxt(listaExtrato, "extrato" + idCliente);

        diretorioBase2 = Paths.get(txtBase + "/extrato" + idCliente);

        File file = this.diretorioBase2.toFile();

        try {
            InputStream fileInputStream = new FileInputStream(file);

            return ResponseEntity.status(200)
                    .header("Content-Disposition",
                            "attachment; filename=" + "extrato"+idCliente+".txt")
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
            summary = "Upload do extrato em txt", responses = {
            @ApiResponse(responseCode = "200", description = "Extrato bancário baixado com sucesso"),
            @ApiResponse(responseCode = "422", description = "Não foi possível baixar o extrato bancário"),
    })
    //UPLOAD TXT
    @PostMapping(value = "arquivoTxt/upload/{idCliente}")
    public ResponseEntity<ArquivoResponse> uploadTxt(@RequestParam("file") MultipartFile fileTxt,
                                                     @PathVariable long idCliente) throws UnsupportedEncodingException{
        clienteService.foundClienteOrThrow(idCliente);

        String itemString = null;

        try {
            itemString = new String(fileTxt.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String situacao = itemString.substring(39, 47).trim();
        LocalDate data = LocalDate.parse(itemString.substring(47, 57).trim());
        String descricao = itemString.substring(57, 107).trim();
        String categoria = itemString.substring(107, 157).trim();
        Double valor = Double.valueOf(itemString.substring(157, 162).replace(',', '.'));

        Long idArquivo = 1L;
        ArquivoResponse response = new ArquivoResponse(idArquivo,situacao,data,descricao,categoria,valor,idCliente);

        arquivoService.saveArquivo(response);
        return ResponseEntity.status(201).body(response);
    }
}
