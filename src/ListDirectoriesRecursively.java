import java.io.*;


public class ListDirectoriesRecursively {
    public void listDirectories(String startDir){
        File dir = new File(startDir);
        File[] directories = dir.listFiles();

        if (directories != null && directories.length > 0){
            for (File file : directories){
                if (file.isDirectory()){
                    listDirectories(file.getAbsolutePath());
                }else{
                    System.out.println(file.getName());
                }
            }
        }
    }

    public static void main(String[] args) {
        ListDirectoriesRecursively test = new ListDirectoriesRecursively();
        String startDir = ("C:\\Users\\hvanrooyen\\IdeaProjects\\calculateInterest");
        test.listDirectories(startDir);
    }
}
