package motd;

public class MessageOfTheDayBasicImpl implements MessageOfTheDayService {

    private String message;

    public void setMessage(String message)
    {
        this.message = message;
    }

    public String getTodaysMessage() {
        return this.message;
    }

}