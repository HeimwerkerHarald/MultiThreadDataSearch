import java.io.*;

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

    public static void main(String[] args){
        FindFile ff = new FindFile();
        String filename = "";
        String directory = "";
        ff.findFile(filename, directory);
    }
}
