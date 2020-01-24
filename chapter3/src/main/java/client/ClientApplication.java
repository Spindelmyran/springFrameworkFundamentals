package client;

import motd.MessageOfTheDayService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClientApplication
{
    public static void main(String[] args)
    {
        ClassPathXmlApplicationContext container = new
                ClassPathXmlApplicationContext("application.xml");

        MessageOfTheDayService helloWorld =
                container.getBean(MessageOfTheDayService.class);

        System.out.println(helloWorld.getTodaysMessage());

        container.close();
    }
}
