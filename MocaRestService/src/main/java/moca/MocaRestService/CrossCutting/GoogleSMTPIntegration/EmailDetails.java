package moca.MocaRestService.CrossCutting.GoogleSMTPIntegration;

public class EmailDetails {
    public String subject;
    public String recipient;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }
}
