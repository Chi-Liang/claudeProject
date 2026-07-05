import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;

public class PostToolUse {

    public static void main(String[] args) {
        String logPath = "E:\\ideaProject\\claudeProject\\.claude\\hooks\\postToolUse.log";

        StringBuilder input = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String line;
            while ((line = reader.readLine()) != null) {
                input.append(line);
            }
        } catch (IOException e) {
            System.err.println("Failed to read stdin: " + e.getMessage());
        }

        String logLine = LocalDateTime.now() + " | " + input;

        try (FileWriter fw = new FileWriter(logPath, true)) {
            fw.write(logLine + System.lineSeparator());
        } catch (IOException e) {
            System.err.println("Failed to write log: " + e.getMessage());
        }

        System.exit(0);
    }
}