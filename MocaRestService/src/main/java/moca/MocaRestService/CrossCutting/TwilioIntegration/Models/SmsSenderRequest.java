package moca.MocaRestService.CrossCutting.TwilioIntegration.Models;

public class SmsSenderRequest {
    public String destinatario;

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }
}
