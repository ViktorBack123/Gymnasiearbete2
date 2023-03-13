package readExcel;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class readExcel {
    public static void main(String[] args) throws IOException {
        //ändra file encodings till windows 1252
        read();
        // https://www.youtube.com/watch?v=Mrtw7NvMQvw
        ArrayList<String> name = new ArrayList<>();
        ArrayList<Integer> URLcode = new ArrayList<>();
        ArrayList<String> team = new ArrayList<>();

        // Opens excel-file via popup window

    }
    private static void read() throws IOException {
        FileReader fileReader = new FileReader("J:\\Min enhet\\Programmering\\GyA\\gymnasiearbeteexcel3.csv");
        BufferedReader bufferedReader  =new BufferedReader(fileReader);
        String row = bufferedReader.readLine();
        row = bufferedReader.readLine();
        String[] arr;
        int i=1;
        while (row!=null) {
            arr=row.split(";");
            System.out.println(i + ". namn: " + arr[0]+" URL: " + arr[1]+ " lag: " + arr[2]);
            row=bufferedReader.readLine();
            i++;
        }

    }
}
