package org.example;

import junit.framework.TestCase;
import org.junit.Assert;

import java.util.Arrays;

public class PortAlgorithmTestGetGroups extends TestCase {
    String [] arrStr;
    int [][] arrActual;
    String strExpected;
    String strActual;
    public void testGetGroups001() {
        arrStr = new String[]{"1,3-5", "2", "3-4"};
        arrActual = PortAlgorithm.getGroups(arrStr);
        strActual = Arrays.deepToString(arrActual);
        strExpected = "[[4, 2, 4], [4, 2, 3], [3, 2, 4], [3, 2, 3], [5, 2, 4], [5, 2, 3], [1, 2, 3], [1, 2, 4]]";
        Assert.assertEquals(strExpected, strActual);
    }
    public void testGetGroups002() {
        arrStr = new String[]{"1,2,3", "5", "3-4"};
        arrActual = PortAlgorithm.getGroups(arrStr);
        strActual = Arrays.deepToString(arrActual);
        strExpected = "[[1, 5, 3], [1, 5, 4], [2, 5, 3], [3, 5, 4], [3, 5, 3], [2, 5, 4]]";
        Assert.assertEquals(strExpected, strActual);
    }
    public void testGetGroups003() {
        arrStr = new String[]{"1,2,3", "4-6"};
        arrActual = PortAlgorithm.getGroups(arrStr);
        strActual = Arrays.deepToString(arrActual);
        strExpected = "[[3, 5], [3, 4], [2, 4], [1, 4], [2, 6], [1, 5], [2, 5], [1, 6], [3, 6]]";
        Assert.assertEquals(strExpected, strActual);
    }
    public void testGetGroups004() {
        arrStr = new String[]{"1", "4-10"};
        arrActual = PortAlgorithm.getGroups(arrStr);
        strActual = Arrays.deepToString(arrActual);
        strExpected = "[[1, 8], [1, 9], [1, 10], [1, 4], [1, 5], [1, 6], [1, 7]]";
        Assert.assertEquals(strExpected, strActual);
    }
    public void testGetGroups005() {
        arrStr = new String[]{"1,2","3,4","5,6","7,8"};
        arrActual = PortAlgorithm.getGroups(arrStr);
        strActual = Arrays.deepToString(arrActual);
        strExpected = "[[1, 4, 6, 8], [2, 3, 6, 7], [1, 4, 6, 7], [2, 4, 6, 7], [2, 4, 6, 8], [2, 3, 6, 8], [1, 3, 5, 8], [1, 4, 5, 7], [1, 3, 5, 7], [1, 4, 5, 8], [2, 3, 5, 8], [2, 3, 5, 7], [2, 4, 5, 7], [2, 4, 5, 8], [1, 3, 6, 7], [1, 3, 6, 8]]";
        Assert.assertEquals(strExpected, strActual);
    }
    public void testGetGroups006() {
        arrStr = new String[]{"1,2","3,4","5,6","7,8","9-10"};
        arrActual = PortAlgorithm.getGroups(arrStr);
        strActual = Arrays.deepToString(arrActual);
        strExpected = "[[1, 4, 5, 8, 10], [2, 4, 6, 7, 10], [2, 3, 6, 8, 10], [1, 4, 5, 7, 9], [2, 4, 5, 7, 9], [2, 4, 6, 7, 9], [1, 3, 6, 8, 10], [1, 4, 6, 7, 10], [1, 3, 5, 8, 10], [1, 4, 6, 7, 9], [1, 4, 5, 7, 10], [1, 3, 6, 7, 10], [1, 4, 6, 8, 9], [2, 4, 6, 8, 9], [2, 4, 6, 8, 10], [2, 4, 5, 8, 9], [1, 4, 5, 8, 9], [2, 4, 5, 8, 10], [1, 3, 5, 7, 10], [2, 3, 6, 7, 9], [2, 3, 5, 7, 9], [2, 3, 5, 7, 10], [1, 3, 5, 7, 9], [1, 3, 6, 7, 9], [2, 3, 6, 7, 10], [2, 3, 5, 8, 10], [1, 3, 5, 8, 9], [1, 3, 6, 8, 9], [2, 4, 5, 7, 10], [1, 4, 6, 8, 10], [2, 3, 5, 8, 9], [2, 3, 6, 8, 9]]";
        Assert.assertEquals(strExpected, strActual);
    }
    public void testGetGroups007() {
        arrStr = new String[]{"1,2","3,4","5,6","7,8","9-10","11,12"};
        arrActual = PortAlgorithm.getGroups(arrStr);
        strActual = Arrays.deepToString(arrActual);
        strExpected = "[[1, 4, 6, 7, 10, 11], [1, 4, 5, 8, 9, 12], [2, 3, 5, 8, 9, 11], [1, 3, 5, 8, 9, 11], [1, 3, 6, 8, 10, 11], [1, 3, 6, 7, 9, 12], [2, 4, 5, 8, 9, 12], [1, 4, 5, 7, 10, 11], [2, 4, 5, 8, 10, 11], [2, 3, 5, 7, 10, 12], [1, 4, 6, 8, 9, 11], [2, 4, 6, 8, 10, 11], [1, 4, 5, 8, 10, 12], [1, 4, 6, 8, 10, 12], [2, 3, 6, 7, 9, 11], [2, 4, 6, 7, 9, 12], [2, 3, 6, 8, 10, 11], [2, 3, 5, 8, 10, 11], [1, 4, 5, 8, 9, 11], [1, 3, 6, 8, 9, 11], [2, 3, 5, 7, 9, 12], [1, 4, 6, 7, 9, 12], [2, 4, 5, 7, 9, 11], [2, 4, 5, 8, 10, 12], [2, 3, 5, 7, 10, 11], [2, 4, 6, 8, 10, 12], [1, 3, 5, 8, 10, 11], [2, 4, 6, 7, 10, 11], [1, 3, 5, 8, 9, 12], [1, 4, 6, 8, 10, 11], [1, 4, 5, 8, 10, 11], [2, 4, 5, 7, 10, 11], [2, 3, 6, 7, 9, 12], [2, 4, 6, 7, 9, 11], [1, 4, 5, 7, 9, 12], [2, 3, 5, 8, 10, 12], [2, 3, 6, 8, 10, 12], [1, 3, 6, 8, 9, 12], [2, 3, 5, 7, 9, 11], [2, 4, 5, 7, 9, 12], [1, 4, 6, 7, 9, 11], [2, 3, 6, 7, 10, 11], [1, 3, 6, 7, 10, 11], [2, 3, 6, 8, 9, 11], [1, 3, 5, 8, 10, 12], [2, 4, 6, 8, 9, 12], [2, 4, 5, 7, 10, 12], [1, 3, 5, 7, 9, 11], [1, 3, 5, 7, 10, 11], [2, 4, 6, 7, 10, 12], [1, 4, 6, 7, 10, 12], [2, 3, 5, 8, 9, 12], [1, 3, 6, 8, 10, 12], [1, 3, 6, 7, 9, 11], [1, 4, 6, 8, 9, 12], [1, 4, 5, 7, 10, 12], [2, 3, 6, 7, 10, 12], [1, 3, 6, 7, 10, 12], [2, 4, 5, 8, 9, 11], [2, 3, 6, 8, 9, 12], [2, 4, 6, 8, 9, 11], [1, 3, 5, 7, 9, 12], [1, 4, 5, 7, 9, 11], [1, 3, 5, 7, 10, 12]]";
        Assert.assertEquals(strExpected, strActual);
    }
    public void testGetGroups008() {
        arrStr = new String[]{"1,2","3,4","5,6","7,8","9-10","11,12","13,14"};
        arrActual = PortAlgorithm.getGroups(arrStr);
        strActual = Arrays.deepToString(arrActual);
        strExpected = "[[2, 4, 5, 7, 9, 12, 13], [2, 3, 5, 7, 9, 11, 13], [2, 4, 5, 8, 9, 12, 13], [1, 4, 5, 7, 9, 11, 13], [2, 3, 5, 8, 9, 11, 13], [1, 3, 6, 7, 10, 12, 14], [2, 3, 5, 8, 9, 12, 14], [1, 3, 6, 7, 10, 11, 13], [1, 4, 5, 7, 9, 12, 14], [1, 3, 5, 7, 9, 11, 14], [1, 4, 5, 8, 9, 12, 14], [1, 3, 5, 8, 9, 11, 14], [1, 4, 5, 8, 10, 12, 13], [2, 3, 6, 7, 10, 12, 14], [2, 3, 5, 7, 9, 12, 14], [2, 4, 5, 7, 9, 11, 13], [2, 3, 6, 7, 10, 11, 13], [1, 4, 5, 8, 9, 11, 14], [2, 4, 5, 8, 9, 11, 13], [1, 4, 5, 8, 10, 11, 13], [1, 3, 6, 7, 10, 12, 13], [2, 3, 5, 8, 9, 11, 14], [1, 3, 6, 8, 9, 12, 13], [1, 4, 5, 8, 9, 12, 13], [1, 3, 6, 7, 9, 12, 13], [2, 3, 5, 7, 9, 11, 14], [2, 3, 6, 7, 10, 12, 13], [1, 4, 5, 8, 10, 12, 14], [2, 4, 5, 8, 10, 11, 13], [2, 4, 5, 7, 9, 11, 14], [1, 4, 6, 7, 9, 12, 13], [1, 4, 6, 8, 9, 12, 13], [2, 4, 5, 8, 9, 11, 14], [1, 4, 5, 8, 10, 11, 14], [1, 4, 6, 7, 9, 11, 13], [1, 4, 6, 8, 9, 11, 13], [1, 3, 6, 8, 9, 12, 14], [1, 4, 6, 7, 10, 11, 13], [2, 3, 5, 7, 10, 12, 14], [1, 3, 6, 7, 9, 12, 14], [2, 3, 6, 7, 9, 12, 14], [2, 3, 6, 8, 9, 12, 14], [1, 3, 5, 8, 10, 12, 13], [2, 3, 5, 7, 10, 11, 14], [1, 3, 6, 8, 10, 12, 14], [2, 3, 6, 8, 10, 11, 13], [2, 4, 6, 8, 9, 11, 13], [2, 4, 5, 8, 9, 12, 14], [1, 4, 6, 7, 9, 11, 14], [1, 3, 6, 7, 10, 11, 14], [1, 3, 5, 7, 9, 11, 13], [1, 4, 6, 8, 9, 11, 14], [1, 4, 6, 7, 10, 11, 14], [1, 3, 5, 8, 9, 11, 13], [2, 4, 6, 7, 9, 11, 13], [2, 3, 5, 7, 10, 12, 13], [2, 4, 5, 7, 10, 12, 13], [2, 4, 5, 7, 9, 12, 14], [2, 3, 6, 8, 9, 12, 13], [2, 3, 6, 7, 9, 12, 13], [2, 4, 6, 8, 10, 11, 14], [2, 3, 6, 8, 10, 11, 14], [2, 4, 6, 8, 9, 11, 14], [1, 4, 6, 8, 10, 12, 14], [2, 4, 6, 7, 9, 11, 14], [1, 3, 5, 8, 10, 11, 14], [2, 3, 5, 8, 10, 12, 14], [1, 4, 5, 7, 10, 11, 14], [2, 4, 5, 7, 10, 12, 14], [1, 4, 6, 8, 10, 11, 13], [2, 4, 6, 8, 10, 12, 14], [2, 4, 5, 7, 10, 11, 14], [1, 3, 5, 7, 10, 12, 13], [2, 3, 5, 8, 10, 11, 14], [2, 4, 6, 8, 10, 11, 13], [1, 4, 5, 7, 10, 11, 13], [1, 4, 6, 8, 10, 12, 13], [1, 3, 5, 8, 10, 11, 13], [1, 4, 6, 7, 10, 12, 13], [1, 3, 5, 7, 10, 11, 13], [2, 4, 5, 7, 10, 11, 13], [2, 4, 6, 7, 10, 12, 13], [2, 3, 5, 8, 10, 11, 13], [1, 3, 5, 7, 10, 12, 14], [2, 3, 5, 7, 10, 11, 13], [2, 3, 6, 8, 10, 12, 13], [2, 4, 6, 8, 10, 12, 13], [1, 3, 5, 8, 10, 12, 14], [2, 3, 6, 8, 9, 11, 14], [1, 3, 6, 8, 10, 12, 13], [1, 4, 5, 7, 10, 12, 14], [2, 3, 6, 7, 9, 11, 14], [1, 4, 6, 7, 10, 12, 14], [1, 3, 5, 7, 10, 11, 14], [2, 4, 5, 8, 10, 12, 14], [1, 3, 6, 8, 10, 11, 13], [1, 3, 6, 8, 9, 11, 14], [2, 4, 5, 8, 10, 11, 14], [1, 3, 5, 7, 9, 12, 13], [1, 3, 6, 7, 9, 11, 14], [1, 3, 5, 8, 9, 12, 13], [1, 4, 6, 7, 9, 12, 14], [2, 3, 6, 8, 10, 12, 14], [2, 4, 6, 8, 9, 12, 13], [2, 3, 6, 8, 9, 11, 13], [2, 4, 6, 7, 10, 11, 13], [1, 4, 5, 7, 10, 12, 13], [2, 3, 6, 7, 9, 11, 13], [2, 4, 6, 7, 9, 12, 13], [1, 4, 6, 8, 9, 12, 14], [2, 3, 5, 8, 10, 12, 13], [1, 4, 5, 7, 9, 11, 14], [1, 4, 6, 8, 10, 11, 14], [2, 3, 5, 8, 9, 12, 13], [2, 4, 5, 8, 10, 12, 13], [1, 3, 6, 8, 10, 11, 14], [1, 3, 6, 8, 9, 11, 13], [1, 3, 5, 8, 9, 12, 14], [2, 3, 5, 7, 9, 12, 13], [1, 4, 5, 8, 9, 11, 13], [2, 4, 6, 7, 10, 11, 14], [2, 4, 6, 8, 9, 12, 14], [2, 3, 6, 7, 10, 11, 14], [2, 4, 6, 7, 9, 12, 14], [1, 3, 6, 7, 9, 11, 13], [1, 3, 5, 7, 9, 12, 14], [0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0]]";
        Assert.assertEquals(strExpected, strActual);
    }
    public void testGetGroups009() {
        arrStr = new String[]{null,"3,4","5,6","7,8","9-10","11,12","13,14"};
        arrActual = PortAlgorithm.getGroups(arrStr);
        strActual = Arrays.deepToString(arrActual);
        int [][] tmp = null;
        strExpected = Arrays.deepToString(tmp);
        Assert.assertEquals(strExpected, strActual);
    }
    public void testGetGroups010() {
        arrStr = new String[]{"","3,4","5,6","7,8","9-10","11,12","13,14"};
        arrActual = PortAlgorithm.getGroups(arrStr);
        strActual = Arrays.deepToString(arrActual);
        int [][] tmp = null;
        strExpected = Arrays.deepToString(tmp);
        Assert.assertEquals(strExpected, strActual);
    }
    public void testGetGroups011() {
        arrStr = new String[]{"1,2","3,4"};
        arrActual = PortAlgorithm.getGroups(arrStr);
        strActual = Arrays.deepToString(arrActual);
        strExpected = "[[2, 4], [2, 3], [1, 3], [1, 4]]";
        Assert.assertEquals(strExpected, strActual);
    }
}