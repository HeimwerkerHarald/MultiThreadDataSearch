import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class test {
    public File[] files;
    public File[] directories;
    public File[] subdirectories;

    public void listFilesAndDirectories(String startDir) {
        File dir = new File(startDir);
        files = dir.listFiles();
        directories = dir.listFiles();

        if (files != null && files.length > 0) {
            for (File file : files) {
                if (file.isFile()) {
                    files = file.listFiles();
                    System.out.println(file.getName() + " is a File");
                } else if (file.isDirectory()) {
                    directories = file.listFiles();
                    System.out.println(file.getName() + " is a Folder");
                        }
                }
            }
        if (directories.length > 0) {
            int nThreads = 3;
            int numberSubdirectories = (directories.length/ nThreads) + (directories.length % nThreads);
            System.out.println(numberSubdirectories);
            Map<String, String> map = new HashMap<>();
            int i = 0;
            while (i < numberSubdirectories) {
                map.put("key" + i, "val: " + i);
                i++;
                System.out.println(map);
            }
        }
    }


    public static void main(String[] args) {
        test test = new test();
        Scanner scan = new Scanner(System.in);

        System.out.println("Bitte gib den exakten Namen der gesuchten Datei an.");
        String filename = scan.next();
        System.out.println("Bitte gib das zu durchsuchende Verzeichnis an.");
        String directory = scan.next();
        String startDir = (directory);

        test.listFilesAndDirectories(startDir);
    }
}

class Task implements Runnable{
    public Task(String s){
        s = "";
    }

    @Override
    public void run() {
        FindFile.main();
    }
    }

class Threadpool {

    public Threadpool(){

    }
}
