
package executavel;

import java.util.Scanner;

public class JogoDaVelha {

    // Declaração do tabuleiro do jogo como uma matriz 3x3 de caracteres
    private static char[][] tabuleiro = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
    
    // Declaração do jogador atual, começando com 'X'
    private static char jogadorAtual = 'X'; 

    public static void main(String[] args) {
        // Scanner para ler a entrada do usuário
        Scanner scanner = new Scanner(System.in);
        
        // Variável para manter o estado do jogo (ativo ou não)
        boolean jogoAtivo = true;

        // Loop principal do jogo
        while (jogoAtivo) {
            imprimirTabuleiro(); // Imprime o estado atual do tabuleiro
            realizarJogada(scanner); // Solicita ao jogador atual que faça uma jogada
            jogoAtivo = verificarEstadoDoJogo(); // Verifica se o jogo ainda está ativo
            mudarJogador(); // Muda para o próximo jogador
        }

        // Imprime o tabuleiro final quando o jogo termina
        imprimirTabuleiro();
        System.out.println("Fim de jogo!");
        
        // Fecha o scanner
        scanner.close();
    }

    // Método para imprimir o tabuleiro no console
    private static void imprimirTabuleiro() {
        System.out.println("  0 1 2"); // Imprime os índices das colunas
        for (int i = 0; i < 3; i++) {
            System.out.print(i + " "); // Imprime o índice da linha atual
            for (int j = 0; j < 3; j++) {
                System.out.print(tabuleiro[i][j]); // Imprime o valor da célula atual do tabuleiro
                if (j < 2) System.out.print("|"); // Imprime o separador de colunas
            }
            System.out.println(); // Nova linha após cada linha do tabuleiro
            if (i < 2) System.out.println("  -----"); // Imprime o separador de linhas
        }
    }

    // Método para realizar uma jogada
    private static void realizarJogada(Scanner scanner) {
        boolean jogadaValida = false; // Variável para controlar a validade da jogada

        while (!jogadaValida) {
            System.out.println("Jogador " + jogadorAtual + ", insira sua jogada (linha e coluna): ");
            int linha = scanner.nextInt(); // Lê a linha escolhida pelo jogador
            int coluna = scanner.nextInt(); // Lê a coluna escolhida pelo jogador

            // Verifica se a jogada está dentro dos limites do tabuleiro e se a célula está vazia
            if (linha >= 0 && linha < 3 && coluna >= 0 && coluna < 3 && tabuleiro[linha][coluna] == ' ') {
                tabuleiro[linha][coluna] = jogadorAtual; // Atualiza o tabuleiro com a jogada do jogador
                jogadaValida = true; // Marca a jogada como válida para sair do loop
            } else {
                System.out.println("Essa jogada não é válida. Tente novamente."); // Mensagem de erro para jogada inválida
            }
        }
    }

    // Método para verificar o estado do jogo
    private static boolean verificarEstadoDoJogo() {
        // Verifica todas as linhas para ver se há um vencedor
        for (int i = 0; i < 3; i++) {
            if (tabuleiro[i][0] == jogadorAtual && tabuleiro[i][1] == jogadorAtual && tabuleiro[i][2] == jogadorAtual) {
                System.out.println("Jogador " + jogadorAtual + " vence!"); // Declara o vencedor
                return false; // Termina o jogo
            }
        }

        // Verifica todas as colunas para ver se há um vencedor
        for (int i = 0; i < 3; i++) {
            if (tabuleiro[0][i] == jogadorAtual && tabuleiro[1][i] == jogadorAtual && tabuleiro[2][i] == jogadorAtual) {
                System.out.println("Jogador " + jogadorAtual + " vence!"); // Declara o vencedor
                return false; // Termina o jogo
            }
        }

        // Verifica a diagonal principal para ver se há um vencedor
        if (tabuleiro[0][0] == jogadorAtual && tabuleiro[1][1] == jogadorAtual && tabuleiro[2][2] == jogadorAtual) {
            System.out.println("Jogador " + jogadorAtual + " vence!"); // Declara o vencedor
            return false; // Termina o jogo
        }

        // Verifica a diagonal secundária para ver se há um vencedor
        if (tabuleiro[0][2] == jogadorAtual && tabuleiro[1][1] == jogadorAtual && tabuleiro[2][0] == jogadorAtual) {
            System.out.println("Jogador " + jogadorAtual + " vence!"); // Declara o vencedor
            return false; // Termina o jogo
        }

        // Verifica se o tabuleiro está cheio
        boolean tabuleiroCheio = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tabuleiro[i][j] == ' ') {
                    tabuleiroCheio = false; // Se encontrar uma célula vazia, o tabuleiro não está cheio
                    break;
                }
            }
        }

        if (tabuleiroCheio) {
            System.out.println("O jogo empatou!"); // Declara empate
            return false; // Termina o jogo
        }

        return true; // O jogo continua
    }

    // Método para alternar entre os jogadores
    private static void mudarJogador() {
        // Alterna o jogador atual entre 'X' e 'O'
        jogadorAtual = (jogadorAtual == 'X') ? 'O' : 'X';
    }
}
