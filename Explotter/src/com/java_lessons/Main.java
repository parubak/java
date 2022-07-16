package com.java_lessons;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.zip.GZIPOutputStream;

public class Main {

    public static void CopyFile(String source, String dest){
        try {
            InputStream inputStream = new BufferedInputStream(new FileInputStream(source));
            OutputStream outputStream = new GZIPOutputStream(
                    new BufferedOutputStream
                            (new FileOutputStream(dest)));

            CopyFile(inputStream, outputStream);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void CopyFile(InputStream inputStream, OutputStream outputStream) throws IOException {

        byte[] buffer=new byte[1024];

        int reading=0;
        long total=0;

        while ((reading=inputStream.read(buffer))>-1){

            outputStream.write(buffer,0,reading);
            total+=reading;
        }

    }

    public static void main(String[] args) {
        // write your code here
        CopyFile("D:/c-50-i-platforma-net-45-dlya-professionalov.pdf",
                "D:/c-50-i-platforma-net-45-dlya-professionalov.pdf.dzip"
                );
//        try {


//        File file = new File("D:\\");

//        if (file.isDirectory()) {
//            List<File> list = Arrays.asList(file.listFiles());
//            list.sort((a, b) -> {
//                        if (a.isDirectory() && b.isDirectory() || !a.isDirectory() && !b.isDirectory()) {
//                            return a.getName().compareTo(b.getName());
//                        } else {
//                            return a.isDirectory() ? 1 : -1;
//                        }
//                    }
//            );
//
//            for (File f : file.listFiles()) {
//                System.out.println(f.getName());
//            }
//            ;
//
//        }
//        file.listFiles();



    }



}

