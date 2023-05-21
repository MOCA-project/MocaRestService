package moca.MocaRestService.Domain.Models.Requests;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

public class ConfigRequest {
    private boolean enviarEmail;
    private boolean enviarSms;
    @Size(max = 11, min = 11)
    private String numeroCelular;
    @Email
    private String email;

    public boolean isEnviarEmail() {
        return enviarEmail;
    }

    public void setEnviarEmail(boolean enviarEmail) {
        this.enviarEmail = enviarEmail;
    }

    public boolean isEnviarSms() {
        return enviarSms;
    }

    public void setEnviarSms(boolean enviarSms) {
        this.enviarSms = enviarSms;
    }

    public String getNumeroCelular() {
        return numeroCelular;
    }

    public void setNumeroCelular(String numeroCelular) {
        this.numeroCelular = numeroCelular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
