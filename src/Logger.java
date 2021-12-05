import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
    protected int num = 1;
    private static Logger instance = null;
    private static final String DATE_FORMAT_NOW = "dd-MM-yyyy HH:mm:ss";

    public void log(String msg) {
        System.out.println("[" + new SimpleDateFormat(DATE_FORMAT_NOW).format(new Date()) + " " + num++ + "] " + msg);
    }

    private Logger() {
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }
}