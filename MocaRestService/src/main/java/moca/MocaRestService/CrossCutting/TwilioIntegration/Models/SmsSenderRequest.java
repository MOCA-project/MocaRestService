package moca.MocaRestService.CrossCutting.TwilioIntegration.Models;

public class SmsSenderRequest {
    public String destinatario;
    public String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }
}
