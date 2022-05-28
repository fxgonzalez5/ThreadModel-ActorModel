package ThreadModel.Model;

import java.util.ArrayList;
import java.util.List;

public class Matriz {
    private int[][] values;

    public Matriz(int[][] values) {
        this.values = values;
    }

    public Matriz multiplyWithThreads(Matriz mat2) throws InterruptedException {
        List<TaskCalElement> threads;

        if (values.length == mat2.values[0].length) {
            int[][] output = new int[values.length][mat2.values[0].length];
            threads = new ArrayList<>();

            for (var i = 0; i < output.length; i++) {
                for (var j = 0; j < output[0].length; j++) {
                    TaskCalElement thread = new TaskCalElement(this, mat2, i, j);
                    thread.start();
                    threads.add(thread);
                }
            }
            setWaitThreads(threads);

            for (var t : threads) {
                output[t.getRowIndex()][t.getColIndex()] = t.getElement();
            }

            return new Matriz(output);
        } else {
            throw new InterruptedException("No se puede multiplicar");
        }
    }

    private void setWaitThreads(List<TaskCalElement> threads) throws InterruptedException {
        for (var t : threads) {
            t.join();
        }
    }

    public int[] getRow(int rowIndex){
        if (rowIndex >= 0 && rowIndex < values.length) {
            return values[rowIndex];
        }else {
            throw new IllegalArgumentException("Indice no válido");
        }
    }

    public int[] getColumn(int colIndex){
        int[] output = new int[values.length];
        if (colIndex < values[0].length){
            for (var i = 0; i < values.length; i++) {
                output[i] = values[i][colIndex];
            }
        }
        return output;
    }

    @Override
    public String toString() {
        String output = "";
        for (var fila : values){
            output += "{";
            for (var value : fila){
                if(value == fila[fila.length-1]){
                    output += value;
                }else {
                    output += value + "\t";
                }
            }
            output += "}\n";
        }
        return "Matriz {\n" + output + "}";
    }
}