import UI.HomeFrame;

public class App {
    public static void main(String[] args) {

        new HomeFrame();

        Thread onExit = new Thread(() -> System.out.println("In the middle of a shutdown"));
        Runtime.getRuntime().addShutdownHook(onExit);
    }
}
