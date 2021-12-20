import java.io.File;
import java.util.ArrayList;

    public class ArrayListCode {

        public static ArrayList<File> listFilesAndDirectories(File[] i_files) {
            ArrayList<File> directoriesList = new ArrayList<File>();
            ArrayList<File> filesList = new ArrayList<File>();

            for (File file : i_files) {
                if (file.isDirectory()) {
                    directoriesList.add(file);
                } else {
                    filesList.add(file);
                    //check if file is found (first directory level)
                }
            }

            //directoriesList : first level of directories
            return directoriesList;
        }

        private static void runnable(ArrayList<File> files){
            //search sub directories

        };

        public static void main(String[] args) {
            //enter file name and directory name
            File dir = new File("");

            runnable(listFilesAndDirectories(dir.listFiles()));
        }
    }

