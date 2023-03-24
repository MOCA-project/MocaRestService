package moca.MocaRestService.Domain.Helper;

import java.io.BufferedReader;
import java.io.IOException;

public class JsonConverter {
    public static String jsonAsString(BufferedReader buffereReader) throws IOException {
        String resposta, jsonEmString = "";
        while ((resposta = buffereReader.readLine()) != null) {
            jsonEmString += resposta;
        }
        return jsonEmString;
    }
}
