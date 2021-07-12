/**
 * Ability for the analyser to load the Indian States Code Information from a csv file
 * Create CSVStates Class to load the CSV Data
 *
 * @author : SAYANI KOLEY
 * @since : 12.07.2021
 */

package com.sayani.controller;

import com.sayani.exception.StateAnalysisException;
import com.sayani.readoperations.ReadOperations;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVStates {
    public static void main(String[] args) throws StateAnalysisException, IOException {
        String filePathRead = "src/main/java/com/sayani/readoperations/StateCode.csv";
        String fileName = "StateCode";
        String delimiter =",";
        List<String> stringName = new ArrayList<>();
        stringName.add("SrNo");
        stringName.add("State");
        stringName.add("Name");
        stringName.add("TIN");
        stringName.add("StateCode");

        ReadOperations readObj = new ReadOperations();
        int count = readObj.readDataCount(filePathRead, fileName);
        System.out.println(count);

        readObj.readDelimiter(filePathRead, delimiter);
        readObj.readHeader(filePathRead, stringName);
    }
}
