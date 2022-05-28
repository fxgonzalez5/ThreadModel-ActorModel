package ActorModel.Model;

public class Matriz {
    private int [][] matrizA;
    private int [][] matrizB;

    public Matriz(int[][] matrizA, int[][] matrizB) {
        this.matrizA = matrizA;
        this.matrizB = matrizB;
    }

    public void multiplyWithActor() {
        if (matrizA.length == matrizB[0].length) {
            int[][] output = new int[matrizA.length][matrizB[0].length];

            for (var i = 0; i < output.length; i++) {
                for (var j = 0; j < output[0].length; j++) {
                    CalcElement obj = new CalcElement(matrizA, matrizB);
                    output[i][j] = obj.calcValue(i,j);
                }
            }

            String out = "";
            for (var fila : output){
                out += "{";
                for (var value : fila){
                    if(value == fila[fila.length-1]){
                        out += value;
                    }else {
                        out += value + "\t";
                    }
                }
                out+= "}\n";
            }
            System.out.println("Matriz {\n" + out + "}");
        }
    }
}
