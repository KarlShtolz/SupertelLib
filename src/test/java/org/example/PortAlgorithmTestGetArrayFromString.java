package org.example;

import junit.framework.TestCase;
import org.junit.Assert;

public class PortAlgorithmTestGetArrayFromString extends TestCase {
    String stringForTest;
    int [] arrExpected;
    int [] arrActual;
    public void testGetIntArrayFromString001() {
        stringForTest = "1,3-5";
        arrActual = PortAlgorithm.getIntArrayFromString(stringForTest);
        arrExpected = new int[]{1, 3, 4, 5};
        Assert.assertArrayEquals(arrExpected, arrActual);
    }
    public void testGetIntArrayFromString002() {
        stringForTest = "1,35-45";
        arrActual = PortAlgorithm.getIntArrayFromString(stringForTest);
        arrExpected = new int[]{1, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45};
        Assert.assertArrayEquals(arrExpected, arrActual);
    }
    public void testGetIntArrayFromString003() {
        stringForTest = "2";
        arrActual = PortAlgorithm.getIntArrayFromString(stringForTest);
        arrExpected = new int[]{2};
        Assert.assertArrayEquals(arrExpected, arrActual);
    }
    public void testGetIntArrayFromString004() {
        stringForTest = "2-8";
        arrActual = PortAlgorithm.getIntArrayFromString(stringForTest);
        arrExpected = new int[]{2, 3, 4, 5, 6, 7, 8};
        Assert.assertArrayEquals(arrExpected, arrActual);
    }
    public void testGetIntArrayFromString005() {
        stringForTest = "8,10";
        arrActual = PortAlgorithm.getIntArrayFromString(stringForTest);
        arrExpected = new int[]{8, 10};
        Assert.assertArrayEquals(arrExpected, arrActual);
    }
    public void testGetIntArrayFromString006() {
        stringForTest = "8-10,13-15";
        arrActual = PortAlgorithm.getIntArrayFromString(stringForTest);
        arrExpected = new int[]{8, 9, 10, 13, 14, 15};
        Assert.assertArrayEquals(arrExpected, arrActual);
    }
    public void testGetIntArrayFromString007() {
        stringForTest = "8-10,13-15,6";
        arrActual = PortAlgorithm.getIntArrayFromString(stringForTest);
        arrExpected = new int[]{8, 9, 10, 13, 14, 15, 6};
        Assert.assertArrayEquals(arrExpected, arrActual);
    }
    public void testGetIntArrayFromString008() {
        stringForTest = "2,8-10,13-15,6";
        arrActual = PortAlgorithm.getIntArrayFromString(stringForTest);
        arrExpected = new int[]{2, 8, 9, 10, 13, 14, 15, 6};
        Assert.assertArrayEquals(arrExpected, arrActual);
    }
    public void testGetIntArrayFromString009() {
        stringForTest = "";
        arrActual = PortAlgorithm.getIntArrayFromString(stringForTest);
        arrExpected = null;
        Assert.assertArrayEquals(arrExpected, arrActual);
    }
    public void testGetIntArrayFromString010() {
        stringForTest = null;
        arrActual = PortAlgorithm.getIntArrayFromString(stringForTest);
        arrExpected = null;
        Assert.assertArrayEquals(arrExpected, arrActual);
    }
}