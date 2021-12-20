import java.io.File;
import java.util.*;

import java.util.stream.Collectors;

public class test {

    public File[] files;
    public ArrayList<File> arrayFiles = new ArrayList<File>();
    public File[] directories;
    public ArrayList<File[]> arrayDirectories = new ArrayList<File[]>();
    public File[] subdirectories;

    public void listFilesAndDirectories(String startDir) {
        File dir = new File(startDir);
        files = dir.listFiles();
        directories = dir.listFiles();
        if (files != null && files.length > 0) {
            for (File file : files) {
                if (file.isFile()) {
                    //arrayFiles.add();
                    files = file.listFiles();
                    System.out.println(file.getName() + " is a File");
                } else if (file.isDirectory()) {
                    directories = file.listFiles();
                    arrayDirectories.add(directories);
                    System.out.println(file.getName() + " is a Folder");
                }
            }
        }
        System.out.println(arrayDirectories);
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
    }
    }

class Threadpool {

    public Threadpool(){

    }
}
