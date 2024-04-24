package commonUtils;

import org.openqa.selenium.WebElement;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CommonUtils {
    public static void saveTextToFile(List<WebElement> elements, String fileName) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fileName);
            for (WebElement element : elements) {
                String text = element.getText();
                fileWriter.write(text + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileWriter != null) {
                    fileWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}

