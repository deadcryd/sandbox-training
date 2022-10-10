package org.deadcryd.unit_02.task_03.messenger;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import org.deadcryd.unit_02.task_03.Client;
import org.deadcryd.unit_02.task_03.NoSuchClientException;

public abstract class AbstractSimpleMessenger implements Messenger {

    protected final Map<String, ArrayDeque<String>> dataBase = new HashMap<>();

    @Override
    public void sendMessage(Client current, String message, String userId) throws NoSuchClientException {
        ArrayDeque<String> messages = dataBase.get(userId);
        if (messages == null) {
            throw new NoSuchClientException();
        }
        messages.addFirst(message);
    }

    @Override
    public String readMessage(Client current) {
        return dataBase.get(current.getId()).poll();
    }

    public void register(Client client) {
        dataBase.put(client.getId(), new ArrayDeque<>());
    }
}
