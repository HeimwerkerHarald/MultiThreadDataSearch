import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListCode implements Runnable{

        public static ArrayList<File> directoriesList = new ArrayList<File>();
        public static ArrayList<File> filesList = new ArrayList<File>();
        public static Scanner scr = new Scanner(System.in);

        public static ArrayList<File> listFilesAndDirectories(File[] i_files) {

            for (File file : i_files) {
                if (file.isDirectory()) {
                    directoriesList.add(file);
                } else {
                    filesList.add(file);
                    //check if file is found (first directory level)
                }
            }
            System.out.println(directoriesList);
            //directoriesList : first level of directories
            return directoriesList;
        }

        private static void runnable(ArrayList<File> files) {
            //search sub directories
            System.out.println("Bitte gib den Namen der gesuchten Datei ein.");
            String filename = scr.next();
            String foundpath = "";
            for (File pathname : filesList) {
                if (foundpath == "") {
                    if (directoriesList.contains(filename) || filesList.contains(filename) || new File(directory + "\\" + pathname).isFile()) {
                        if (filename.equals(pathname)) {
                            foundpath = directory + "\\" + pathname;
                            System.out.println("The file: " + filename + " can be fond at " + foundpath);
                        }
                    }
                }
            }
        }
        public static void main(String[] args) {
            System.out.println("Bitte gib das zu durchsuchende Verzeichnis an.");
            //enter file name and directory name
            File dir = new File(scr.next());
            runnable(listFilesAndDirectories(dir.listFiles()));
        }

        @Override
        public void run() {

        }
    }

