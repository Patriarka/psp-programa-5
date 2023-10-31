package com.utfpr;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class RegressaoLinearMultiplaTest extends TestCase {
        private ListaEncadeada lista;

        private RegressaoLinearMultipla regressao;

        @Before
        public void setUp() {
                lista = new ListaEncadeada();

                lista.adicionarNoFinalLista(1, 1142, 1060, 325, 201);
                lista.adicionarNoFinalLista(2, 863, 995, 98, 98);
                lista.adicionarNoFinalLista(3, 1065, 3205, 23, 162);
                lista.adicionarNoFinalLista(4, 554, 120, 0, 54);
                lista.adicionarNoFinalLista(5, 983, 2896, 120, 138);
                lista.adicionarNoFinalLista(6, 256, 485, 88, 61);

                regressao = new RegressaoLinearMultipla(lista);
        }

        @Test
        public void testCalcularX() {
                double[][] matrizX = regressao.calcularMatrizX();

                double[][] expectedMatrix = {
                        {6.7013365364},
                        {0.0783660367},
                        {0.0150413312},
                        {0.2460563326}
                };

                for (int i = 0; i < expectedMatrix.length; i++) {
                        for (int j = 0; j < expectedMatrix[i].length; j++) {
                                assertEquals(expectedMatrix[i][j], matrizX[i][j], 0.0001);
                        }
                }
        }
}
