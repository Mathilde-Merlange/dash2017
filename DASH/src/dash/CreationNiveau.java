package dash;
/**
 * Created by mathilde on 12/02/17.
 */
import java.io.*;
import java.util.Scanner;

public class CreationNiveau {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Saisir le nombre de niveaux à créer");
		int n = sc.nextInt();
		String name = "/home/mathilde/Desktop/tryme";
		File f = new File(name);
		try {
			// f.createNewFile();
			FileWriter fw = new FileWriter(f);
			try {
				fw.write("[BDCFF]\n");
				fw.write("[game]\n");
				fw.write("Caves=" + n + "\n");
				fw.write("\n");
				for (int i = 1; i <= n; i++) {
					fw.write("[cave]\n");
					fw.write("Name=Cave " + i + "\n");
					fw.write("[map]\n");
					fw.write("[/map]\n");
					fw.write("[/cave]\n");
					fw.write("\n");
				}
				fw.write("[/game]\n");
				fw.write("[/BDCFF]");
			} finally {
				fw.close();
			}

		} catch (Exception e) {
            System.out.println(e);
		}

	}
}
