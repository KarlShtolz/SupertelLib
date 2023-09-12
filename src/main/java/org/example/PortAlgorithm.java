package org.example;
import java.util.*;
/**
 * Объект Port проиндексирован набором последовательностей чисел произвольной длины, описанной в массиве строк indexes.
 * Каждая строка из массива indexes представляет из себя последовательность чисел, перечисленных через дефис и(или)
 * через запятую. К примеру, запись 1-5,7,9-11 является последовательностью следующих чисел: 1,2,3,4,5,7,9,10,11 .
 * Требуется написать два метода:
 * 1. Метод, преобразовывающий массив строк indexes в массив последовательностей чисел;
 * 2. Метод, возвращающий всевозможные уникальные упорядоченные группы элементов полученных массивов чисел.
 * Пример:
 * Массив строк {"1,3-5", "2", "3-4"} преобразуется в следующий массив чисел:
 * {[1, 2, 3], [1, 2, 4], [3, 2, 3], [3, 2, 4], [4, 2, 3], [4, 2, 4], [5, 2, 3], [5, 2, 4]}
 * Детали:
 * Для реализации используйте Java 8, 11;
 * Проект обязательно должен собираться с помощью фреймворка Maven;
 * При написании методов допускается использовать только возможности стандартной библиотеки Java;
 * В результате решения задачи должна получиться библиотека;
 * Плюсом будет покрытие библиотеки unit тестами. Фреймворки для тестирования можно выбрать на своё усмотрение;
 * Выполненное задание необходимо разместить на GitHub/GitLab.
 */
public class PortAlgorithm {
    private static final char COMMA = ',';
    private static final String EMPTY_STRING = "STRING IS EMPTY!";
    private static final String NULL_STRING = "STRING IS NULL!";
    private static final String NULL_STRING_IN_ARRAY = "EMPTY OR NULL STRING IN ARRAY!";
    private static final String ERROR_IN_ARRAY = "ERROR IN ARRAY!";
    private static final char HYPHEN = '-';
    public static int[] getIntArrayFromString(String str) {
        if (str == null) {
            System.out.println(NULL_STRING);
            return null;
        }
        if (str.isEmpty()) {
            System.out.println(EMPTY_STRING);
            return null;
        }
        str = str + COMMA;
        ArrayList<Integer> collection = new ArrayList<>();
        boolean flagHyphen = false;
        int intToCollection = -1;
        int startSeq = -1;
        int endSeq = -1;
        StringBuilder lastNumAsSb = new StringBuilder();
        char [] strAsArray = str.toCharArray();
        int arrLen = strAsArray.length;
        for (int i = 0; i < arrLen; i++) {
            if (Character.isDigit(strAsArray[i])) {
                lastNumAsSb.append(strAsArray[i]);
            } else if (strAsArray[i] == COMMA || i == arrLen - 1) {
                intToCollection = Integer.parseInt(lastNumAsSb.toString());
                lastNumAsSb = new StringBuilder();
                if (!flagHyphen) {
                    collection.add(intToCollection);
                }
                if (flagHyphen) {
                    endSeq = intToCollection;
                    for (int j = startSeq; j <= endSeq; j++) {
                        collection.add(j);
                    }
                    startSeq = -1;
                    endSeq = -1;
                    flagHyphen = false;
                }
            } else if (strAsArray[i] == HYPHEN) {
                intToCollection = Integer.parseInt(lastNumAsSb.toString());
                startSeq = intToCollection;
                flagHyphen = true;
                lastNumAsSb = new StringBuilder();
            }
        }
        return collection.stream().mapToInt(i -> i).toArray();
    }
    public static int[][] getGroups(String [] arrStr) {
        int count = 1;
        int [][] matrixAll = new int[arrStr.length][];
        int [] arrTmp;
        for (int i = 0; i < arrStr.length; i++) {
            arrTmp = getIntArrayFromString(arrStr[i]);
            if (arrTmp != null) {
                matrixAll[i] = arrTmp;
                count *= arrTmp.length;
                System.out.println(Arrays.toString(arrTmp));
            } else {
                System.out.println(NULL_STRING_IN_ARRAY);
                return null;
            }
        }
        int [][] matrixAnswer = new int[count][arrStr.length];
        for (int j = 0; j < arrStr.length; j++) {
            for (int i = 0; i < count; i++) {
                matrixAnswer[i][j] = matrixAll[j][(i) % matrixAll[j].length];
            }

        }
        int [][] matrixTest = new int [count][arrStr.length];
        Set<String> setAnswer = new HashSet<>();
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < arrStr.length; j++) {
                for (int k = 0; k < arrStr.length; k++) {
                    makeShift(matrixAnswer, k);
                    setAnswer.add(Arrays.toString((matrixAnswer[0])));
                    for (int k2 = k; k2 < arrStr.length; k2++) {
                        makeShift(matrixAnswer, k2);
                        setAnswer.add(Arrays.toString((matrixAnswer[0])));
                        for (int k3 = 0; k3 < arrStr.length; k3++) {
                            makeShift(matrixAnswer, k3);
                            setAnswer.add(Arrays.toString((matrixAnswer[0])));
                        }
                    }
                    makeShift(matrixAnswer, k);
                    setAnswer.add(Arrays.toString((matrixAnswer[0])));
                }
            }
        }
        Iterator<String> i = setAnswer.iterator();
        int b = 0;
        while (i.hasNext()) {
            String disp  = i.next();
            int [] tempFromStr = getIntArrayFromStr(disp);
            for (int m = 0; m < arrStr.length; m++) {
                assert tempFromStr != null;
                matrixTest[b][m] = tempFromStr[m];
            }
            b++;
        }
        return matrixTest;
    }
    public static int[] getIntArrayFromStr(String s) {
        if (s == null || s.isEmpty()) {
            System.out.println(EMPTY_STRING);
            return null;
        }
        int[] arrayFromStr;
        try {
            int s_len = s.length();
            char[] charArrFromStr = s.toCharArray();
            int count = 0;
            for (int i = 0; i < s_len; i++) {
                if (charArrFromStr[i] == ',') {
                    count++;
                }
            }
            count += 1;
            arrayFromStr = new int[count];
            int k = 0;
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 1; i < s_len; i++) {
                if (charArrFromStr[i] == '[' || charArrFromStr[i] == ' ') {
                    continue;
                }
                if (charArrFromStr[i] != ',' && charArrFromStr[i] != ']') {
                    stringBuilder.append(charArrFromStr[i]);
                } else if (charArrFromStr[i] == ',' || charArrFromStr[i] == ']') {
                    arrayFromStr[k] = Byte.parseByte(stringBuilder.toString());
                    k++;
                    stringBuilder = new StringBuilder();
                }
            }
        } catch (Exception e) {
            System.out.println(ERROR_IN_ARRAY);
            return null;
        }
        return arrayFromStr;
    }

    public static int [][] makeShift(int[][]arr, int indWidth){
        int tmp = arr[0][indWidth];
        for(int i = 1; i < arr.length; i++) {
            arr[i - 1][indWidth] = arr[i][indWidth];
        }
        arr[arr.length - 1][indWidth] = tmp;
        return arr;
    }
}
