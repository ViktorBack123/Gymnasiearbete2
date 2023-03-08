package readExcel;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import java.util.ArrayList;

public class readExcel {
    public static void main(String[] args) throws IOException {
        //ändra file encodings till windows 1252
        read();
        // https://www.youtube.com/watch?v=Mrtw7NvMQvw
        ArrayList<String> name = new ArrayList<>();
        ArrayList<Integer> URLcode = new ArrayList<>();
        ArrayList<String> team = new ArrayList<>();

        // Opens excel-file via popup window

        JFileChooser openFileChooser = new JFileChooser();
        openFileChooser.setDialogTitle("Open File");
        openFileChooser.removeChoosableFileFilter(openFileChooser.getFileFilter());
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel File (.xlsx)","xlsx");
        openFileChooser.setFileFilter(filter);

        if (openFileChooser.showOpenDialog(null)== JFileChooser.APPROVE_OPTION){
            File inputFile = openFileChooser.getSelectedFile();
            try(FileInputStream in = new FileInputStream(inputFile)){

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
    private static void read() throws IOException {
        FileReader fileReader = new FileReader("J:\\Min enhet\\Programmering\\GyA\\gymnasiearbeteexcel.csv");
        BufferedReader bufferedReader  =new BufferedReader(fileReader);
        String row = bufferedReader.readLine();
        row = bufferedReader.readLine();
        int i=1;
        while (row!=null) {
            System.out.println(i + ". " + row);
            row=bufferedReader.readLine();
            i++;
        }

    }
}
