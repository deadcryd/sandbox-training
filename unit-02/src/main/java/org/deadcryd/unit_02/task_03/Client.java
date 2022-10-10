package org.deadcryd.unit_02.task_03;

import java.util.Objects;
import java.util.UUID;
import org.deadcryd.unit_02.task_03.messenger.AbstractSimpleMessenger;

public class Client {

    private final String id = UUID.randomUUID().toString();
    private String name;

    private AbstractSimpleMessenger messenger;

    Client(String name) {
        this.name = name;
    }

    public void sendMessage(String message, String userId) {
        if (messenger != null)
            messenger.sendMessage(this, message, userId);
    }

    public String readMessage() {
        if (messenger != null)
            return messenger.readMessage(this);
        return null;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AbstractSimpleMessenger getMessenger() {
        return messenger;
    }

    public void setMessenger(AbstractSimpleMessenger messenger) {
        this.messenger = messenger;
        messenger.register(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Client client = (Client) o;
        return Objects.equals(getId(), client.getId()) && Objects.equals(getName(), client.getName())
            && Objects.equals(getMessenger(), client.getMessenger());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getMessenger());
    }
}
