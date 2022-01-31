import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayListCode {

    public static ArrayList<File> directoriesList = new ArrayList<File>();
    public static ArrayList<File> filesList = new ArrayList<File>();
    public static Scanner scr = new Scanner(System.in);
    public static String fileName;
    public static long directorieslistLength;
    public static long filesListLength;
    public static long threadCountForDirectories;

    public static ArrayList<File> listFilesAndDirectories(File[] i_files) {

        for (File file : i_files) {
            if (file.isDirectory()) {
                directoriesList.add(file);
                directorieslistLength++;
            } else {
                filesList.add(file);
                filesListLength++;
                //check if file is found (first directory level)
            }
        }
        //directoriesList : first level of directories
        threadCountForDirectories = (directorieslistLength / 2) + (directorieslistLength % 2);
        return directoriesList;
    }

    private static void runnable(ArrayList<File> files) {
    }

    public static void main(String[] args) {
        long time;
        System.out.println("Bitte gib das zu durchsuchende Verzeichnis an.");
        //enter file name and directory name
        File dir = new File(scr.next());
        runnable(listFilesAndDirectories(dir.listFiles()));
        System.out.println("Bitte gib den gesuchten Dateinamen ein.");
        fileName = scr.next();
        long timeStart = System.currentTimeMillis();
        if (filesListLength > 0) {
            for (int i = 0; i < filesListLength; i++) {
                recursiveSearch(filesList.get(i), fileName);
            }
        }
        Thread t1 = new Thread(() -> run(0,threadCountForDirectories));
        Thread t2 = new Thread(() -> run(threadCountForDirectories,directorieslistLength));
        t1.start();
        t2.start();
        final long timeStop = System.currentTimeMillis();
        time = timeStop - timeStart;
        System.out.println("Die benötigte Zeit betrag: " + time);
    }

        public static void run(long from, long to) {

            for (; from < to; from++) {
                recursiveSearch(directoriesList.get((int) from), fileName);
            }
        }

    public static ArrayList<String> recursiveSearch(File file, String fileName) {
        if (directoriesList.contains(fileName) || filesList.contains(fileName) || file.isFile()) {
            if (file.getName().equals(fileName)) {
                System.out.println("Die gesuchte Datei ist unter: " + file.getAbsolutePath() + " zu finden.");
                return new ArrayList<String>(Arrays.asList(fileName));
            } else return new ArrayList<String>();
        } else if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files.length == 0 || files == null) {
                return new ArrayList<String>();
            } else {
                ArrayList<String> foundpath = new ArrayList<String>();
                for (File newSubFile : files) {
                    foundpath.addAll(recursiveSearch(newSubFile, fileName));
                }
                return foundpath;
            }
        }
        return null;
    }
}

