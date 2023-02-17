import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int presetNumber;
        String hostsPath = String.format("C:\\Windows\\system32\\drivers\\etc\\hosts");
        File hostsFile = new File(hostsPath);
        PrintWriter enable = null;
        try {
            enable = new PrintWriter(hostsFile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        Scanner readPreset = new Scanner(System.in);
        System.out.println("Please enter preset number");
        presetNumber = readPreset.nextInt();

        switch (presetNumber) {
            case 0 -> {
                try {
                    enable.write("#No restriction");
                    enable.close();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                System.out.println("All restriction revoked");
            }
            case 1 -> {
                try {
                    enable.write("ya.ru");
                    enable.println();
                    enable.write("https://youtube.com");
                    System.out.println();
                    enable.write("yandex.ru");
                    enable.close();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Preset 1 applied");
            }
            default -> {
                System.out.println("Not found preset with this number");
            }
        }
    }
}
