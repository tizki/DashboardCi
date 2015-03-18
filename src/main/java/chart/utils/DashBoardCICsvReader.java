package chart.utils;

import au.com.bytecode.opencsv.CSVReader;

import java.io.*;
import java.util.List;

/**
 * Created by kleintid on 3/18/2015.
 */
public class DashBoardCICsvReader {


    public static String[] getCsv(String csvFileName) throws IOException {
        CSVReader reader = new CSVReader(new FileReader(csvFileName));
        String [] nextLine;
        List<String[]> rawData = reader.readAll();
        return rawData.get(0);

    }


}
