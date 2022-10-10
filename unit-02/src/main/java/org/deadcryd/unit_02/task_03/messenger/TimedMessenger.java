package org.deadcryd.unit_02.task_03.messenger;

import java.time.LocalDateTime;
import java.util.ArrayDeque;
import org.deadcryd.unit_02.task_03.Client;
import org.deadcryd.unit_02.task_03.NoSuchClientException;

public class TimedMessenger extends AbstractSimpleMessenger {

    @Override
    public void sendMessage(Client current, String message, String userId) throws NoSuchClientException {
        ArrayDeque<String> messages = dataBase.get(userId);
        if (messages == null) {
            throw new NoSuchClientException();
        }
        messages.addFirst(LocalDateTime.now() + "\t" + message);
    }
}
