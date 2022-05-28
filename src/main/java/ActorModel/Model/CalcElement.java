package ActorModel.Model;

public class CalcElement{
    private int [][] matrizA;
    private int [][] matrizB;

    public CalcElement(int[][] matrizA, int[][] matrizB) {
        this.matrizA = matrizA;
        this.matrizB = matrizB;
    }

    public int calcValue (int row, int col){
        int aux = 0;
        for (var i = 0; i < matrizA[row].length; i++) {
            aux += matrizA[row][i] * matrizB[i][col];
        }
        return aux;
    }
}
