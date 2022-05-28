package ThreadModel.Controller;


import ThreadModel.Model.Matriz;

public class RunThreads {
    public static void main(String[] args) throws InterruptedException {
        int[][] mat1Values = {
                {1, 2},
                {3, 4},
                {5, 6}
        };
        Matriz m1 = new Matriz(mat1Values);

        int[][] mat2Values = {
                {1, 2, 3},
                {4, 5, 6}
        };
        Matriz m2 = new Matriz(mat2Values);

        Matriz result = m1.multiplyWithThreads(m2);
        System.out.println(result);
    }
}
