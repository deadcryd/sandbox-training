package org.deadcryd.unit_02.task_03.messenger;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import org.deadcryd.unit_02.task_03.Client;
import org.deadcryd.unit_02.task_03.NoSuchClientException;

public class UserMessenger extends AbstractSimpleMessenger {

    protected final Map<String, Client> userDataBase = new HashMap<>();

    @Override
    public void sendMessage(Client current, String message, String userId) throws NoSuchClientException {
        ArrayDeque<String> messages = dataBase.get(userId);
        if (messages == null) {
            throw new NoSuchClientException();
        }

        String fromName = userDataBase.get(current.getId()).getName();
        String toName = userDataBase.get(userId).getName();

        String resultMessage = "From: "
            + fromName
            + "\nTo:"
            + toName
            + "\nMessage: "
            + message;

        messages.addFirst(resultMessage);
    }

    public void register(Client client) {
        super.register(client);
        userDataBase.put(client.getId(), client);
    }
}
