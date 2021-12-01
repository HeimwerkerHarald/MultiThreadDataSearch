import java.io.*;
import java.util.*;

class FindFile {
    public void findFile(String filename, String directory) {
        String foundFile = recursiveSearch(directory, filename);

        if (foundFile == "") {
            System.out.println("Suche erfolglos.");
        } else {
            System.out.println("Datei gefunden!");
        }
    }

    public String recursiveSearch(String directory, String filename) {
        String[] pathNames = new File(directory).list();
        String foundpath = "";

        for (String pathname : pathNames) {
            if (foundpath.equals("")) {
                if (new File(directory + "\\" + pathname).isFile()) {
                    if (filename.equals(pathname)) {
                        foundpath = directory + "\\" + pathname;
                        System.out.println(foundpath);
                    }
                } else {
                    foundpath = recursiveSearch(directory + "\\" + pathname, filename);
                }
            }
        }
        return foundpath;
    }

    public static void main(String[] args) {
        FindFile ff = new FindFile();
        Scanner scan = new Scanner(System.in);

        System.out.println("Bitte gib den exakten Namen der gesuchten Datei an.");
        String filename = scan.next();
        System.out.println("Bitte gib das zu durchsuchende Verzeichnis an.");
        String directory = scan.next();
        ff.findFile(filename, directory);
        ff.findFoldersInDirectory(directory);
    }

    public List<String> findFoldersInDirectory(String directoryPath) {
        File directory = new File(directoryPath);

        FileFilter directoryFileFilter = new FileFilter() {
            public boolean accept(File file) {
                return file.isDirectory();
            }
        };

        File[] directoryListAsFile = directory.listFiles(directoryFileFilter);
        List<String> foldersInDirectory = new ArrayList<>(directoryListAsFile.length);
        for (File directoryAsFile : directoryListAsFile) {
            foldersInDirectory.add(directoryAsFile.getName());
        }
        System.out.println(foldersInDirectory);
        return foldersInDirectory;
    }
}
