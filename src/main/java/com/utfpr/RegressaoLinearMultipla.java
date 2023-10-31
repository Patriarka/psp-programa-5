package com.utfpr;

import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.LUDecomposition;
import org.apache.commons.math3.linear.RealMatrix;

public class RegressaoLinearMultipla {
        private ListaEncadeada listaEncadeada;

        public RegressaoLinearMultipla(ListaEncadeada listaEncadeada) {
                this.listaEncadeada = listaEncadeada;
        }

        private double[][] extrairVariaveisDependentes() {
                ListaEncadeada.No noAtual = listaEncadeada.obterNo(0);

                int tamanho = listaEncadeada.tamanho();

                double[][] matrizA = new double[tamanho][4];

                int i = 0;

                while (noAtual != null) {
                        matrizA[i][0] = 1;
                        matrizA[i][1] = noAtual.getLinhasAdicionadas();
                        matrizA[i][2] = noAtual.getLinhasReutilizadas();
                        matrizA[i][3] = noAtual.getLinhasModificadas();

                        noAtual = noAtual.getProximo();
                        i++;
                }

                return matrizA;
        }

        private double[][] extrairVariaveisIndependentes() {
                ListaEncadeada.No noAtual = listaEncadeada.obterNo(0);

                int tamanho = listaEncadeada.tamanho();

                double[][] matrizB = new double[tamanho][1];

                int i = 0;

                while (noAtual != null) {
                        matrizB[i][0] = noAtual.getTempoDesenvolvimento();

                        noAtual = noAtual.getProximo();
                        i++;
                }

                return matrizB;
        }

        public double[][] calcularMatrizX() {
                RealMatrix matrizA = new Array2DRowRealMatrix(extrairVariaveisDependentes());
                RealMatrix matrizB = new Array2DRowRealMatrix(extrairVariaveisIndependentes());

                RealMatrix matrizAtransposta = matrizA.transpose();

                LUDecomposition decomposition = new LUDecomposition(matrizAtransposta.multiply(matrizA));

                RealMatrix auxiliar = decomposition.getSolver().getInverse();

                RealMatrix realMatrix = auxiliar.multiply(matrizAtransposta.multiply(matrizB));

                double[][] matrizX = realMatrixToDouble(realMatrix);

                return matrizX;
        }

        private static double[][] realMatrixToDouble(RealMatrix realMatrix) {
                int numRows = realMatrix.getRowDimension();
                int numCols = realMatrix.getColumnDimension();

                double[][] matrizX = new double[numRows][numCols];

                for (int i = 0; i < numRows; i++) {
                        for (int j = 0; j < numCols; j++) {
                                matrizX[i][j] = realMatrix.getEntry(i, j);
                        }
                }
                return matrizX;
        }
}
