package chart.utils;

import au.com.bytecode.opencsv.CSVReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by kleintid on 3/18/2015.
 */
public class CsvReader {


    public static void printCsv(File csvFileName) throws IOException {
        CSVReader csvReader = null;
        csvReader = new CSVReader(new InputStreamReader(new FileInputStream(csvFileName)));
        // get the headers (Metadata)
        String[] headers = csvReader.readNext();
        String[] nextLine;
        //read line by line (each line is an instance)
        while ((nextLine = csvReader.readNext()) != null) {
            for (String str : headers) {
                System.out.println(str+',');
            }
        }
    }

    public static String getRowAsString(String[] row){
        StringBuffer stringBuffer = new StringBuffer("");
        for (String str : row) {
            System.out.println(str+',');
            stringBuffer.append(str+",");
        }
        return stringBuffer.toString();
    }

    public static void main(String[] args) {

    }
}
