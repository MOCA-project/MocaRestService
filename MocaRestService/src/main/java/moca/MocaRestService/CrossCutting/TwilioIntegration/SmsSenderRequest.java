package moca.MocaRestService.CrossCutting.TwilioIntegration;

public class SmsSenderRequest {
    public String to;
    public String message;

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
