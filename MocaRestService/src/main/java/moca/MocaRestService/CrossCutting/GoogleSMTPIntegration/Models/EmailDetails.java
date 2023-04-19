package moca.MocaRestService.CrossCutting.GoogleSMTPIntegration.Models;

public class EmailDetails {
    public String assunto;
    public String destinatario;

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }
}
