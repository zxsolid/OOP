package HomeWork7;

import java.net.Socket;

/**
 * Класс базового модема
 */
public abstract class BaseModem implements Internet {
    String model;
    InterfaceType type;
    @Override
    public void connect() {

    }

    @Override
    public void disconnect() {

    }

    @Override
    public void getIpByURL() {

    }

    @Override
    public void openSocket(Socket s) {

    }

    @Override
    public Socket getSocket() {
        return null;
    }
}