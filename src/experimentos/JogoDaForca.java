package experimentos;

import java.util.Random;
import java.util.Scanner;

public class JogoDaForca {

	public static void main(String[] args) {
		Random random = new Random();
		Scanner in = new Scanner(System.in);

		String[] palavras = { "ORTODOXO", "PALAVRA", "MACARRONADA", "COMPLEXIDADE", "AMIGO", "PNEUMONIA", "MITOCONDRIA",
				"CAVALEIRO", "FEITICEIRA" };

		int quantPalavras = palavras.length;
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

		while (!ganhou && vidas > 0) {
			System.out.println();
			System.out.println("\n" + "Você tem " + vidas + " vidas" + "\nLetras utilizadas: " + letrasUtilizadas
					+ "\nQual letra você deseja tentar?");
			letra = in.next().charAt(0);
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

		}
		if (vidas != 0) {
			System.out.println("\n\nVOCÊ GANHOU, PARABÉNS");

		} else {
			System.out.println("\tNão foi dessa vez");
System.out.println("\tA palavra era: " + sorteada);
		}
	}

}
