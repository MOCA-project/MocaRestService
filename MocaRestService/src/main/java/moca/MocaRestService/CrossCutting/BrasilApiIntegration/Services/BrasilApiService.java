package moca.MocaRestService.CrossCutting.BrasilApiIntegration.Services;

import com.google.gson.Gson;
import moca.MocaRestService.CrossCutting.BrasilApiIntegration.Models.Response.BanksResponse;
import moca.MocaRestService.Domain.Helper.Util.JsonConverter;
import moca.MocaRestService.CrossCutting.BrasilApiIntegration.Interfaces.IBrasilApiService;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;;

@Service
public class BrasilApiService implements IBrasilApiService {
    static String webService = "https://brasilapi.com.br/api/";
    static int codigoSucesso = 200;

    public void getTaxas() throws Exception {
        String taxUrl = webService + "taxas/v1";
        try {
            URL url = new URL(taxUrl);
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();

            if (conexao.getResponseCode() != codigoSucesso)
                throw new RuntimeException("HTTP error code : " + conexao.getResponseCode());

            BufferedReader resposta = new BufferedReader(new InputStreamReader((conexao.getInputStream())));
            String jsonEmString = JsonConverter.jsonAsString(resposta);

            System.out.println(jsonEmString);
        } catch (Exception e) {
            throw new Exception("ERRO: " + e);
        }
    }

    public BanksResponse getBancos() throws Exception {
        String banksUrl = webService + "banks/v1";
        try {
            URL url = new URL(banksUrl);
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();

            if (conexao.getResponseCode() != codigoSucesso)
                throw new RuntimeException("HTTP error code : " + conexao.getResponseCode());

            BufferedReader resposta = new BufferedReader(new InputStreamReader((conexao.getInputStream())));
            BanksResponse.Bank data = new Gson().fromJson(resposta, BanksResponse.Bank.class);
            return null;
        } catch (Exception e) {
            throw new Exception("ERRO: " + e);
        }
    }
}
