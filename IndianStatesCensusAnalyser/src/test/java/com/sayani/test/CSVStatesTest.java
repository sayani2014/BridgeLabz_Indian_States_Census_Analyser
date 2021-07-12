package com.sayani.test;

import com.sayani.exception.StateAnalysisException;
import com.sayani.readoperations.ReadOperations;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVStatesTest {
    ReadOperations readObj = new ReadOperations();
    String fileName = "StateCode";

    /**
     * Purpose : Given the States Code CSV file
     *           Check to ensure the Number of Record matches
     *
     * @throws StateAnalysisException
     */

    @Test
    public void givenStateCensusCSVFileCorrect_EnsureNumberOfRecordsMatch() throws StateAnalysisException {
        String filePathRead = "src/main/java/com/sayani/readoperations/StateCode.csv";
        try {
            int count = readObj.readDataCount(filePathRead, fileName);
            Assert.assertEquals(38, count);
        } catch (StateAnalysisException e) {
            e.printStackTrace();
        }
    }

    /**
     * Purpose : Given the State Code CSV File if incorrect
     *           Return a Custom Exception
     */

    @Test
    public void givenStateCensusCSVFile_WhenFileNameIncorrectShouldThrowException()  {
        String filePathRead = "src/main/java/com/sayani/readoperations/StateCode";

        try {
            int count = readObj.readDataCount(filePathRead, fileName);
            Assert.assertEquals(38, count);
        } catch (StateAnalysisException e) {
            e.printStackTrace();
        }
    }

    /**
     * Purpose : Given the State Code CSV File when correct but type incorrect
     *           Return a Custom Exception
     */

    @Test
    public void givenStateCensusCSVFile_WhenFileTypeIncorrectShouldThrowException()  {
        String filePathRead = "src/main/java/com/sayani/readoperations/StateCode.pdf";

        try {
            int count = readObj.readDataCount(filePathRead, fileName);
            Assert.assertEquals(38, count);
        }  catch (StateAnalysisException e) {
            e.printStackTrace();
        }
    }

    /**
     * Purpose : Given the State Code CSV File when correct but delimiter incorrect
     *           Return a Custom Exception
     */

    @Test
    public void givenStateCensusCSVFileCorrect_ButDelimiterIncorrectShouldThrowException() {
        String filePathRead = "src/main/java/com/sayani/readoperations/StateCode.csv";
        String delimiter = ".";
        try {
            if(delimiter.equals(","))
                Assert.assertTrue(readObj.readDelimiter(filePathRead, delimiter));
            else
                Assert.assertFalse(readObj.readDelimiter(filePathRead, delimiter));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Purpose : Given the State Code CSV File when correct but csv header incorrect
     *           Returns a Custom Exception
     */

    @Test
    public void givenStateCensusCSVFileCorrect_ButHeaderIncorrectShouldThowException() {
        List<String> stringName = new ArrayList<>();
        String filePathRead = "src/main/java/com/sayani/readoperations/StateCode.csv";
        stringName.add("SrNo");
        stringName.add("State");
        stringName.add("Name");
        stringName.add("TN");
        stringName.add("StateCode");

        try {
            boolean flag = readObj.readHeader(filePathRead, stringName);
            if(flag == true)
                Assert.assertTrue(flag);
            else
                Assert.assertFalse(flag);
        } catch (IOException | StateAnalysisException e) {
            e.printStackTrace();
        }
    }
}
