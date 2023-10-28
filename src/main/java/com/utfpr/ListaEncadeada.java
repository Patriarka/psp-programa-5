package com.utfpr;

public class ListaEncadeada {
        private final Cabeca cabeca;

        public ListaEncadeada() {
                this.cabeca = new Cabeca();
        }

        public void adicionarNo(int identificador, int linhasAdicionadas, int linhasReutilizadas, int linhasModificadas, int tempoDesenvolvimento, int posicao) {
                validarPosicao(posicao);

                No novo = new No(identificador, linhasAdicionadas, linhasReutilizadas, linhasModificadas, tempoDesenvolvimento);
                No noAtual = obterNo(posicao);

                if (posicao == 0) {
                        if (listaVazia()) {
                                cabeca.setPrimeiro(novo);
                        } else {
                                novo.setProximo(cabeca.getPrimeiro());
                                cabeca.setPrimeiro(novo);
                        }
                } else {
                        novo.setProximo(noAtual.getProximo());
                        noAtual.setProximo(novo);
                }
        }

        private static void validarPosicao(int posicao) {
                if (posicao < 0) {
                        throw new IllegalArgumentException("Posição não pode ser negativa.");
                }
        }

        public No obterNo(int posicao) {
                No noAtual = cabeca.getPrimeiro();

                int posicaoAtual = 0;

                while (posicaoAtual < posicao && noAtual.getProximo() != null) {
                        posicaoAtual++;
                        noAtual = noAtual.getProximo();
                }

                return noAtual;
        }

        public boolean listaVazia() {
                return cabeca.getPrimeiro() == null;
        }

        public void adicionarNoFinalLista(int identificador, int linhasAdicionadas, int linhasReutilizadas, int linhasModificadas, int tempoDesenvolvimento) {
                adicionarNo(identificador, linhasAdicionadas, linhasReutilizadas, linhasModificadas, tempoDesenvolvimento, tamanho());
        }

        public int tamanho() {
                int tamanho = 0;

                ListaEncadeada.No noAtual = obterNo(0);

                while (noAtual != null) {
                        tamanho++;
                        noAtual = noAtual.getProximo();
                }
                return tamanho;
        }

        public class No {

                private int identificador;

                private int linhasAdicionadas;

                private int linhasReutilizadas;

                private int linhasModificadas;

                private int tempoDesenvolvimento;

                private No proximo;

                public No(int identificador, int linhasAdicionadas, int linhasReutilizadas, int linhasModificadas, int tempoDesenvolvimento) {
                        this.identificador = identificador;
                        this.linhasAdicionadas = linhasAdicionadas;
                        this.linhasReutilizadas = linhasReutilizadas;
                        this.linhasModificadas = linhasModificadas;
                        this.tempoDesenvolvimento = tempoDesenvolvimento;

                        this.proximo = null;
                }

                public int getIdentificador() {
                        return identificador;
                }

                public int getLinhasAdicionadas() {
                        return linhasAdicionadas;
                }

                public int getLinhasReutilizadas() {
                        return linhasReutilizadas;
                }

                public int getLinhasModificadas() {
                        return linhasModificadas;
                }

                public int getTempoDesenvolvimento() {
                        return tempoDesenvolvimento;
                }

                public No getProximo() {
                        return proximo;
                }

                public void setProximo(No proximo) {
                        this.proximo = proximo;
                }
        }

        public class Cabeca {
                private No primeiro;

                public Cabeca() {
                        this.primeiro = null;
                }

                public No getPrimeiro() {
                        return primeiro;
                }

                public void setPrimeiro(No proximo) {
                        this.primeiro = proximo;
                }
        }
}
