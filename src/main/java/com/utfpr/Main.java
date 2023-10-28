package com.utfpr;

public final class Main {
        private Main() {
                throw new AssertionError("Esta classe não deve ser instanciada.");
        }

        public static void main(String[] args) {
                ListaEncadeada lista = new ListaEncadeada();

                lista.adicionarNoFinalLista(1, 1142, 1060, 325, 201);
                lista.adicionarNoFinalLista(2, 863, 995, 98, 98);
                lista.adicionarNoFinalLista(3, 1065, 3205, 23, 162);
                lista.adicionarNoFinalLista(4, 554, 120, 0, 54);
                lista.adicionarNoFinalLista(5, 983, 2896, 120, 138);
                lista.adicionarNoFinalLista(6, 256, 485, 88, 61);

                RegressaoLinearMultipla regressao = new RegressaoLinearMultipla(lista);

                double[][] matrizX = regressao.calcularMatrizX();

                for (int i = 0; i < matrizX.length; i++) {
                        for (int j = 0; j < matrizX[i].length; j++) {
                                System.out.print(matrizX[i][j] + " ");
                        }
                        System.out.println();
                }
        }
}
