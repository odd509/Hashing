import Backend.Utils;
import UI.HomeFrame;

public class MessageBox {
    public static void main(String[] args) {

        Utils.importData();

        new HomeFrame();

        Thread onExit = new Thread(() -> Utils.exportData());
        Runtime.getRuntime().addShutdownHook(onExit);

    }
}
