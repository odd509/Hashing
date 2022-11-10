import UI.HomeFrame;

public class App {
    public static void main(String[] args) {

        new HomeFrame();

        Thread onExit = new Thread(() -> System.out.println("In the middle of a shutdown"));
        Runtime.getRuntime().addShutdownHook(onExit);
        String testStr = "asdasd\rasdasdasd\r";
        System.out.println(testStr);
        for (char c : testStr.toCharArray()) {
            if (c == '\r') {
                System.out.println("return 1");
            }

        }
    }
}
