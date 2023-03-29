package HomeWork7;

import java.awt.*;

// умеем звонить, слать СМС, и фоткать c камеры.
public class OldMobilePhone extends Phone implements SMSSender<SMSContentText>, RealCamera, Scheduler {

    @Override
    public void call() {
    }
    @Override
    public void smsSend(SMSContentText message) {
    }

    @Override
    public Image getPhotoFromRearCam() {
        return null;
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
    public void setFocus() {

    }
}
