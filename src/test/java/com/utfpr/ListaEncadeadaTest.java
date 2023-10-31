package com.utfpr;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class ListaEncadeadaTest extends TestCase {
        private ListaEncadeada lista;

        @Before
        public void setUp() {
                lista = new ListaEncadeada();
        }

        @Test
        public void testAdicionarElementoPosicaoNegativa() {
                try {
                        lista.adicionarNo(1, 2, 3, 4, 5, -1);
                } catch (IllegalArgumentException e) {
                        assertEquals("Posição não pode ser negativa.", e.getMessage());
                }
        }

        @Test
        public void testObterElemento() {
                lista.adicionarNo(1, 2, 3, 4, 5, 0);

                assertEquals(2, lista.obterNo(0).getLinhasAdicionadas(), 0.001);
                assertEquals(3, lista.obterNo(0).getLinhasReutilizadas(), 0.001);
                assertEquals(4, lista.obterNo(0).getLinhasModificadas(), 0.001);
                assertEquals(5, lista.obterNo(0).getTempoDesenvolvimento(), 0.001);
        }

        @Test
        public void testAdicionarNoInicio() {
                lista.adicionarNo(1, 2, 3, 4, 5, 0);
                assertEquals(1, lista.obterNo(0).getIdentificador(), 0.001);
        }

        @Test
        public void testAdicionarNoMeio() {
                lista.adicionarNo(1, 2, 3, 4, 5, 0);
                lista.adicionarNo(3, 3, 3, 4, 5, 0);
                lista.adicionarNo(5, 4, 3, 4, 5, 2);

                assertEquals(1, lista.obterNo(1).getIdentificador(), 0.001);
        }

        @Test
        public void testAdicionarNoFim() {
                lista.adicionarNo(1, 2, 3, 4, 5, 0);
                lista.adicionarNo(3, 3, 3, 4, 5, 1);
                lista.adicionarNoFinalLista(5, 4, 3, 4, 5);

                assertEquals(5, lista.obterNo(2).getIdentificador(), 0.001);
        }
}
