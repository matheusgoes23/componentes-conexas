public class AtividadeGrafos {

    static Integer[][] matrizAdjacencia;
    static Integer[] visitado;

    public static void main(String[] args) {

        //Inserindo manualmente os vértices com suas incidências
        matrizAdjacencia = new Integer[][]
                {{0, 1, 1, 0},//u
                        {1, 0, 1, 0},//v
                        {1, 1, 0, 1},//w
                        {0, 0, 1, 0},//x
                        {0, 0, 0, 0}};//y não se liga com ninguem

        //
        visitado = new Integer[]{0, 0, 0, 0};

        //Encontrando as componentes conexas
        COMPONENTES_CONEXAS();
    }

    static void COMPONENTES_CONEXAS() {
        for (int i = 0; i < visitado.length; i++) {
            visitado[i] = 0;
        }

        int componente = 0;

        for (int i = 0; i < visitado.length; i++) {
            if (visitado[i] == 0) {
                componente++;
                PROF(i, componente);
            }
        }

        System.out.println("A quantidade de componentes conexas é: " + componente);
    }

    static void PROF(int v, int marca) {
        visitado[v] = marca;

        //Para cada nó w adjacente a v
        for (int w = 0; w < matrizAdjacencia[v].length; w++) {
            if (visitado[w] == 0 && matrizAdjacencia[v][w] == 1) {
                PROF(w, marca);
            }
        }
    }
}
