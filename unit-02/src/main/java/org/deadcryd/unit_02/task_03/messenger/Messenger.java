package org.deadcryd.unit_02.task_03.messenger;

import org.deadcryd.unit_02.task_03.Client;

public interface Messenger {

    void sendMessage(Client current, String message, String toSendUserId);

    String readMessage(Client current);
}
