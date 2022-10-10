package org.deadcryd.unit_02.task_03;

import org.deadcryd.unit_02.task_03.messenger.AbstractSimpleMessenger;
import org.deadcryd.unit_02.task_03.messenger.SimpleMessenger;
import org.deadcryd.unit_02.task_03.messenger.TimedMessenger;
import org.deadcryd.unit_02.task_03.messenger.UserMessenger;

public class TaskRunner {

    public static void main(String[] args) {
        AbstractSimpleMessenger simpleMessenger = new SimpleMessenger();
        AbstractSimpleMessenger timedMessenger = new TimedMessenger();
        AbstractSimpleMessenger userMessenger = new UserMessenger();

        Client userMax = new Client("Max");
        Client userDima = new Client("Dima");

        testMessenger(userMax, userDima, simpleMessenger);
        testMessenger(userMax, userDima, timedMessenger);
        testMessenger(userMax, userDima, userMessenger);
    }

    public static void testMessenger(Client fromClient, Client toClient, AbstractSimpleMessenger messenger) {
        fromClient.setMessenger(messenger);
        toClient.setMessenger(messenger);

        fromClient.sendMessage("Hello!", toClient.getId());
        System.out.println(toClient.readMessage());

    }
}
