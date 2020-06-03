package ceit.aut.ac.ir.utils;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class FileUtils {

    private static final String NOTES_PATH = "./notes/";

    //It's a static initializer. It's executed when the class is loaded.
    //It's similar to constructor
    static {
        boolean isSuccessful = new File(NOTES_PATH).mkdirs();
        System.out.println("Creating " + NOTES_PATH + " directory is successful: " + isSuccessful);
    }

    public static File[] getFilesInDirectory() {
        return new File(NOTES_PATH).listFiles();
    }


    public static String fileReader(File file) throws IOException {
        //TODO: Phase1: read content from file
        FileReader in=new FileReader(file);
        Scanner scanner=new Scanner(in);
        StringBuilder stringBuilder=new StringBuilder("");
        while ((scanner.hasNext())){
            stringBuilder.append(scanner.next());
        }
        scanner.close();
        in.close();

        return stringBuilder.toString();
    }
    public static void fileWriter(String content) throws IOException {
        //TODO: write content on file
        String fileName = getProperFileName(content);
        FileWriter out=new FileWriter(fileName);
        out.write(content);
        out.close();
    }
    //TODO: Phase1: define method here for writing file with OutputStream

    public static void fileWriter1(String content) throws IOException {
        String filename=getProperFileName(content);
        FileOutputStream out=new FileOutputStream(new File(filename));
        byte[] bytes=content.getBytes();
        out.write(bytes);
        out.close();
    }
    //TODO: Phase1: define method here for reading file with InputStream
    public static void fileReader1(File file) throws IOException {
        FileInputStream in=new FileInputStream(file);
        StringBuilder str=new StringBuilder("");
        int a;
        while ((a=in.read())!=1){
            str.append(a);
        }
        in.close();
    }

    //TODO: Phase2: proper methods for handling serialization

    private static String getProperFileName(String content) {
        int loc = content.indexOf("\n");
        if (loc != -1) {
            return content.substring(0, loc);
        }
        if (!content.isEmpty()) {
            return content;
        }
        return System.currentTimeMillis() + "_new file.txt";
    }
}
