package HomeWork7;

import java.awt.*;
import java.net.Socket;

public abstract class SmartPhone extends Phone implements SMSSender<SMSContent>, Internet, FrontCamera, RealCamera, Scheduler {
    protected String model;
    protected String os;

    @Override
    public void call() {
    }

    @Override
    public void smsSend(SMSContent message) {

    }

    @Override
    public Image getPhotoFromFrontCam() {
        return null;
    }

    @Override
    public Image getPhotoFromRearCam() {
        return null;
    }

    @Override
    public void setFocus() {
    }

    @Override
    public void alert() {
    }

    @Override
    public void addTask() {
    }

    @Override
    public void delTask() {
    }

    @Override
    public Task[] getTask() {
        return new Task[0];
    }

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