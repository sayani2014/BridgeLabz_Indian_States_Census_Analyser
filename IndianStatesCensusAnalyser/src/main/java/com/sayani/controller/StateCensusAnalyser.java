/**
 * Ability for the analyser to load the Indian States Census Information from a .csv file
 * Create a StateCensusAnalyser Class to load the State Census CSV Data
 * Use Iterator to load the data
 * Check with StateCensusAnalyser to ensure number of record matches
 *
 * @author : SAYANI KOLEY
 * @since : 12.07.2021
 */

package com.sayani.controller;

import com.sayani.exception.StateSensorAnalysisException;
import com.sayani.readoperations.ReadOperations;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StateCensusAnalyser {

    public static void main(String[] args) throws StateSensorAnalysisException, IOException {
        String filePathRead = "src/main/java/com/sayani/readoperations/StateCensusData.csv";
        String fileName = "StateCensusData";
        String delimiter =",";
        List<String> stringName = new ArrayList<>();
        stringName.add("State");
        stringName.add("Population");
        stringName.add("AreaInSqKm");
        stringName.add("DensityPerSqKm");

        ReadOperations readObj = new ReadOperations();
        int count = readObj.readDataCount(filePathRead, fileName);
        System.out.println(count);

        readObj.readDelimiter(filePathRead, delimiter);
        readObj.readHeader(filePathRead, stringName);
    }
}
