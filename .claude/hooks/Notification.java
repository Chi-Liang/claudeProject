import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class Notification {
    public static void main(String[] args) {
        String logPath = "E:\\ideaProject\\claudeProject\\.claude\\hooks\\notification.log";
        String message = LocalDateTime.now() + " - Notification hook triggered";
        if (args.length > 0) {
            message += " | args: " + String.join(" ", args);
        }

        try (FileWriter fw = new FileWriter(logPath, true)) {
            fw.write(message + System.lineSeparator());
        } catch (IOException e) {
            System.err.println("Failed to write log: " + e.getMessage());
        }
    }
}