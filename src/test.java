import java.io.File;

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
                }else if (file.isDirectory()) {
                    directories = file.listFiles();
                    System.out.println(file.getName() + " is a Folder");
                }
            }
        }
    }

    public void partitionListOfDirectories(){
    }

    public static void main(String[] args) {
        test test = new test();
        String startDir = ("C:\\Users\\hvanrooyen\\IdeaProjects");
        test.listFilesAndDirectories(startDir);
    }
}

/*
public class Task implements Runnable{
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

 */