package Serialization;

import java.io.Serializable;
import java.util.Date;
import java.util.Calendar;

public class SerialClass implements Serializable {
    private static final long serialVersionUID = 1L;
    private Date currentTime;

    public SerialClass() {
        currentTime = Calendar.getInstance().getTime();
    }

    public Date getCurrentTime() {
        return currentTime;
    }

}
