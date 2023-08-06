public class Matrix {
    public static void main(String[] args) {
        final int[][] matrix = {
                {4, 5, 6},
                {1, 2, 3},
                {7, 8, 9}
        };
        final int[][] matrixCheck = {
                {2, 1, 2, 4, 5, 6},
                {1, 2, 1, 2, 4, 5},
                {1, 2, 1, 2, 5, 5},
                {1, 2, 1, 2, 3, 6}
        };

        final int[][] sub = {
                {1, 2},
                {1, 2}
        };

        final int[][] changedMatrix = changeDiagonals(matrix);

        System.out.println("Questão 1:");
        printMatrix(changedMatrix);

        final int count = countSubMatrix(matrixCheck, sub);
        System.out.println("Questão 2:");
        System.out.println("Encontrada " + count + " vezes");

    }

    /*  Questão 1:
    *   implemente uma função que inverta as diagonais de uma matriz
    *   quadrada.
    */
    public static int[][] changeDiagonals(int[][] matrix) {
        final int lenMatrix = matrix.length;
        for (int i = 0; i < lenMatrix; i++) {
            if (i != lenMatrix) {
                int temp = matrix[i][i];
                matrix[i][i] = matrix[i][lenMatrix -i -1];
                matrix[i][lenMatrix -i -1] = temp;
            }
        }
        return matrix;
    }

    /*  Questão 2:
    *   implemente uma função que, dado uma matriz A e uma submatriz B
    *   (dimensões menores que A), esta função retorne quantas vezes esta submatriz B
    *   pode ser encontrada na matriz A.
    */
    public static int countSubMatrix(int[][] matrix, int[][] subMatrix) {
        final int lenMatrix = matrix.length;
        final int lenIMatrix = matrix[0].length;
        final int lenSubMatrix = subMatrix.length;
        final int lenISubMatrix = subMatrix[0].length;
        int count = 0;

        for (int i = 0; i < lenMatrix; i++) {
            for (int j = 0; j < lenIMatrix; j++) {
                if (matrix[i][j] != subMatrix[0][0]) {
                    continue;
                }
                boolean check = false;
                for (int k = 0; k < lenSubMatrix; k++) {
                    for (int l = 0; l < lenISubMatrix; l++) {
                        final int a = i + k;
                        final int b = j + l;
                        if (a >= lenMatrix || b >= lenIMatrix) {
                            check = false;
                            break;
                        }
                        if (matrix[a][b] == subMatrix[k][l]) {
                            check = true;
                        } else {
                            check = false;
                            break;
                        }
                    }
                }
                if (check) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void printMatrix(int[][] matrix) {
        System.out.println("------");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("------");
    }
}