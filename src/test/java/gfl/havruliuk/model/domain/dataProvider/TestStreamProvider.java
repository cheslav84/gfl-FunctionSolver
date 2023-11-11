package gfl.havruliuk.model.domain.dataProvider;

import lombok.SneakyThrows;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TestStreamProvider {

    private static final PrintStream standardOut = System.out;
    private static ByteArrayOutputStream consoleContent;



    public static void setUpOutputStream() {
        consoleContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(consoleContent));
    }

    public static ByteArrayOutputStream getConsoleContent(){
        return consoleContent;
    }

    @SneakyThrows
    public static void tearDownOutputStream() {
        consoleContent.close();
        System.setOut(standardOut);
    }
}
