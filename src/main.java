import java.io.File;
import java.io.FilenameFilter;
import java.lang.*;
import java.util.Arrays;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        System.out.println("Bitte gib das zu durchsuchende Verzeichnis an.");
        String directoryPath = scr.next();
        String kekw = ".gitignore";
        findFile(kekw, directoryPath);
    }
    public static String[] listOfFiles(String directoryPath) {
        File file = new File(directoryPath);
        String[] files = file.list(new FilenameFilter() {
            @Override
            public boolean accept(File current, String name) {
                return new File(current, name).isFile();
            }
        });
        System.out.println(Arrays.toString(files));
        return files;
    }
    public static String[] listOfDirectories(String directoryPath) {
        File file = new File(directoryPath);
        String[] directories = file.list(new FilenameFilter() {
            @Override
            public boolean accept(File current, String name) {
                return new File(current, name).isDirectory();
            }
        });
        System.out.println(Arrays.toString(directories));
        return directories;
    }
    public static void findFile(String fileName, String directory){
        if (Arrays.asList(listOfFiles(directory)).contains(fileName)) {
            System.out.println("Datei gefunden !");
        }
    }
}
