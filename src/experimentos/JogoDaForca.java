package experimentos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.LineNumberReader;
import java.util.Random;
import java.util.Scanner;

public class JogoDaForca {

	public static void main(String[] args) throws Exception {
		Random random = new Random();
		Scanner in = new Scanner(System.in);

		LineNumberReader leitorLinhas = new LineNumberReader(new FileReader("BancoPalavras.txt"));
		leitorLinhas.skip(Long.MAX_VALUE);
		int quantPalavras = leitorLinhas.getLineNumber() + 1;
		System.out.println("Tente a sorte, temos " + quantPalavras + " palavras!!");
		leitorLinhas.close();

		String[] palavras = new String[quantPalavras];

		BufferedReader leitorArquivo = new BufferedReader(new FileReader("BancoPalavras.txt"));
		String linhaLida;
		int linha = 0;
		while ((linhaLida = leitorArquivo.readLine()) != null) {
			palavras[linha] = linhaLida;
			linha++;
		}
		leitorArquivo.close();
		int indiceSorteado = random.nextInt(quantPalavras);
		String sorteada = palavras[indiceSorteado];

		char[] acertos = new char[sorteada.length()];
		for (int i = 0; i < acertos.length; i++) {
			acertos[i] = 0;
		}
		String letrasUtilizadas = "";
		char letra;
		boolean ganhou = false;
		int vidas = sorteada.length();

		do {
			System.out.println();
			System.out.println("\n" + "Você tem " + vidas + " vidas" + "\nLetras utilizadas: " + letrasUtilizadas
					+ "\nQual letra você deseja tentar?");
			letra = in.next().toUpperCase().charAt(0);
			letrasUtilizadas += " " + letra;

			boolean perdeVida = true;
			for (int i = 0; i < sorteada.length(); i++) {
				if (letra == sorteada.charAt(i)) {
					System.out.println("Tem essa letra na posição " + i);
					acertos[i] = 1;
					perdeVida = false;
				}
			}
			if (perdeVida)
				vidas--;
			System.out.println("\n");
			ganhou = true;
			for (int i = 0; i < sorteada.length(); i++) {
				if (acertos[i] == 0) {
					System.out.print(" _ ");
					ganhou = false;
				} else {
					System.out.print(" " + sorteada.charAt(i) + " ");
				}
			}
			System.out.println("\n");

		} while (!ganhou && vidas > 0);
		if (vidas != 0) {
			System.out.println("\n\nVOCÊ GANHOU, PARABÉNS");

		} else {
			System.out.println("\tNão foi dessa vez");
			System.out.println("\tA palavra era: " + sorteada);
		}
	}

}
