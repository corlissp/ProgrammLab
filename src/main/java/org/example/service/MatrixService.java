package org.example.service;

import org.example.printer.Printer;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author Min Danil 15.10.2023
 */
public class MatrixService extends Service {

    public MatrixService(Printer printer) {
        super(printer);
    }

    public int [][] createMatrix() {
        System.out.print("Введите кол-во столбцов: ");
        int colum = scanner.nextInt();
        System.out.print("Введите кол-во строк: ");
        int rows = scanner.nextInt();
        int [][] matrix = new int[rows][colum];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < colum; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        return matrix;
    }

    public int[][] removeColumn(int[][] matrix) {
        System.out.print("Введите файл с индексом столбца: ");
        String name = scanner.next();
        int columnIndex = readColumnIndexFromFile(name);
        int[][] newMatrix = new int[matrix.length][matrix[0].length - 1];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0, newJ = 0; j < matrix[i].length; j++) {
                if (j != columnIndex) {
                    newMatrix[i][newJ] = matrix[i][j];
                    newJ++;
                }
            }
        }
        return newMatrix;
    }

    public int[][] transposeMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] transposedMatrix = new int[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposedMatrix[j][i] = matrix[i][j];
            }
        }
        return transposedMatrix;
    }

    public int[][] removeMainDiagonal(int[][] matrix) {
        if (matrix.length != matrix[0].length) {
            System.out.println("Матрица не квадратная!");
            return matrix;
        }
        int n = matrix.length;
        for (int i = 0; i < n * n; i++) {
            int row = i / n;
            int col = i % n;
            if (row == col) {
                matrix[row][col] = 0;
            }
        }
        return matrix;
    }

    public int[][] replaceColumn(int[][] matrix1, int[][] matrix2, int columnIndex) {
        if (columnIndex >= matrix1[0].length
                || columnIndex >= matrix2[0].length || columnIndex < 0) {
            System.out.println(Printer.RED + "Неверный индекс!");
            return matrix1;
        }
        int numRows = Math.min(matrix1.length, matrix2.length);
        for (int i = 0; i < numRows; i++) {
            matrix1[i][columnIndex] = matrix2[i][columnIndex];
        }
        return matrix1;
    }

    public int[][] searchElement(int[][] matrix, int searchValue) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] % searchValue == 0) {
                    if (j + 1 < matrix[i].length && matrix[i][j + 1] % 2 == 0) {
                        for (int k = 0; k < matrix[i].length; k++) {
                            matrix[i][k] = 0;
                        }
                    } else if (i + 1 < matrix.length && matrix[i + 1][j] % 2 != 0) {
                        for (int k = 0; k < matrix.length; k++) {
                            matrix[k][j] = 0;
                        }
                    }
                }
            }
        }
        return matrix;
    }

    public int calculateDeterminant(int[][] matrix) {
        int n = matrix.length;
        if (n != matrix[0].length) {
            throw new IllegalArgumentException("Матрица должна быть квадратной");
        }
        if (n == 1) {
            return matrix[0][0];
        }
        int determinant = 0;
        for (int j = 0; j < n; j++) {
            determinant += matrix[0][j] * Math.pow(-1, j) * calculateDeterminant(getMinor(matrix, 0, j));
        }
        return determinant;
    }

    private int[][] getMinor(int[][] matrix, int row, int col) {
        int n = matrix.length;
        int[][] minor = new int[n - 1][n - 1];
        for (int i = 0, newRow = 0; i < n; i++) {
            if (i == row) {
                continue;
            }
            for (int j = 0, newCol = 0; j < n; j++) {
                if (j == col) {
                    continue;
                }
                minor[newRow][newCol] = matrix[i][j];
                newCol++;
            }
            newRow++;
        }
        return minor;
    }

     private int readColumnIndexFromFile(String filename) {
        try  {
            File file = new File(absPath + separator + filename);
            Scanner fileScanner = new Scanner(file);
            if(!fileScanner.hasNext()) {
                System.out.println(Printer.YELLOW + "Файл пустой!");
                return -1;
            }
            String line = fileScanner.nextLine();
            return Integer.parseInt(line);
        } catch (IOException e) {
            System.out.println(Printer.RED + "Не удалось считать файл: " + filename);
            return -1;
        }
    }

    public int[][] multiMatrix(int[][] matrixFromKeyboard) {
        System.out.print("Введите имя файла с матрицей: ");
        String name = scanner.next();
        int[][] matrixFromFile = readMatrixFromFile(name);
        int[][] resultMatrix = new int[0][];
        if (matrixFromFile != null && matrixFromKeyboard != null) {
            if (matrixFromFile[0].length == matrixFromKeyboard.length) {
                resultMatrix = multiplyMatrices(matrixFromFile, matrixFromKeyboard);
                System.out.println(Printer.GREEN + "Результат умножения матриц:");
            } else {
                System.out.println(Printer.RED + "Невозможно выполнить умножение. Количество столбцов первой матрицы не соответствует количеству строк второй матрицы.");
            }
        } else {
            System.out.println(Printer.RED + "Ошибка чтения матриц из файла или с клавиатуры.");
        }
        return resultMatrix;
    }

    private int[][] multiplyMatrices(int[][] firstMatrix, int[][] secondMatrix) {
        int rows = firstMatrix.length;
        int cols = secondMatrix[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                for (int k = 0; k < firstMatrix[0].length; k++) {
                    result[i][j] += firstMatrix[i][k] * secondMatrix[k][j];
                }
            }
        }
        return result;
    }

    private int[][] readMatrixFromFile(String filename) {
        try {
            File file = new File(absPath + separator + filename);
            Scanner fileScanner = new Scanner(file);
            if(!fileScanner.hasNext()) {
                System.out.println(Printer.YELLOW + "Файл пустой!");
                return new int[0][];
            }
            String line;
            int rows = Integer.parseInt(fileScanner.nextLine());
            int cols = Integer.parseInt(fileScanner.nextLine());
            int[][] matrix = new int[rows][cols];
            for (int i = 0; i < rows; i++) {
                line = fileScanner.nextLine();
                String[] values = line.split("\\s+");
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = Integer.parseInt(values[j]);
                }
            }
            return matrix;
        } catch (IOException e) {
            System.out.println(Printer.RED + "Не удалось считать файл: " + filename);
            return new int[0][];
        }
    }

    public int[][] swapRowsMatrix() {
        System.out.print(Printer.GREEN + "Введите имя файла с матрицей: ");
        String name = scanner.next();
        int[][] matrix = readMatrixFromFile(name);
        System.out.print(Printer.GREEN + "Введите номер первой строки для обмена: ");
        int firstRow = scanner.nextInt();
        System.out.print(Printer.GREEN + "Введите номер второй строки для обмена: ");
        int secondRow = scanner.nextInt();
        if (firstRow >= 0 && firstRow < matrix.length && secondRow >= 0 && secondRow < matrix.length) {
            swapRows(matrix, firstRow, secondRow);
            System.out.println(Printer.GREEN + "Матрица после обмена строк:");
        } else {
            System.out.println(Printer.RED +"Неверные номера строк.");
        }
        return matrix;
    }

    private int[][] transArrayToMatrix(int[][] matrix, int[] array) {
        int k = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = array[k];
                k++;
            }
        }
        return matrix;
    }

    private int[] transMatrixToArray(int [][] matrix) {
        int n = matrix.length * matrix[0].length;
        int[] array = new int[n];
        int k = 0;
        for (int[] ints : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                array[k] = ints[j];
                k++;
            }
        }
        return array;
    }

    public int[][] sortMatrixShell(int[][] matrix) {
        int[] array = transMatrixToArray(matrix);
        int n = array.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = array[i];
                int j;
                for (j = i; j >= gap && array[j - gap] > temp; j -= gap) {
                    array[j] = array[j - gap];
                }
                array[j] = temp;
            }
        }
        return transArrayToMatrix(matrix, array);
    }

    public int[][] sortMatrixBubble(int[][] matrix) {
        int[] array = transMatrixToArray(matrix);
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return transArrayToMatrix(matrix, array);
    }

    public int[][] sortMatrixInsertion(int[][] matrix) {
        int[] array = transMatrixToArray(matrix);
        int n = array.length;
        for (int i = 1; i < n; ++i) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
        return transArrayToMatrix(matrix, array);
    }

    public int[][] sortMatrixSelection(int[][] matrix) {
        int[] array = transMatrixToArray(matrix);
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
        return transArrayToMatrix(matrix, array);
    }

    public int[][] sortMatrixHeap(int[][] matrix) {
        int[] array = transMatrixToArray(matrix);
        int n = array.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heap(array, n, i);
        }
        for (int i = n - 1; i >= 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            heap(array, i, 0);
        }
        return transArrayToMatrix(matrix, array);
    }

    public static void heap(int arr[], int n, int index) {
        int largest = index;
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;
        if (leftChild < n && arr[leftChild] > arr[largest]) {
            largest = leftChild;
        }
        if (rightChild < n && arr[rightChild] > arr[largest]) {
            largest = rightChild;
        }
        if (largest != index) {
            int swap = arr[index];
            arr[index] = arr[largest];
            arr[largest] = swap;
            heap(arr, n, largest);
        }
    }

    private void swapRows(int[][] matrix, int firstRow, int secondRow) {
        int[] temp = matrix[firstRow];
        matrix[firstRow] = matrix[secondRow];
        matrix[secondRow] = temp;
    }

}
