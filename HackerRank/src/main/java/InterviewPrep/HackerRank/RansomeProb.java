package InterviewPrep.HackerRank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class RansomeProb {

	HashMap<String, Integer> magzineMap;
	HashMap<String, Integer> noteMap;

	public RansomeProb(String magzineMap, String noteMap) {
		super();
		this.magzineMap = new HashMap<String, Integer>();
		this.noteMap = new HashMap<String, Integer>();

	}

	// Complete the checkMagazine function below.
	static void checkMagazine(String[] magazine, String[] note) {
		Integer occurances;
		HashMap<String, Integer> magzineMap = new HashMap<String, Integer>();
		HashMap<String, Integer> noteMap = new HashMap<String, Integer>();

		for (String s : magazine) {
			occurances = magzineMap.get(s);
			if (occurances == null) {
				magzineMap.put(s, 1);
			} else {
				magzineMap.put(s, occurances + 1);
			}
		}

		for (String s : note) {
			occurances = noteMap.get(s);
			if (occurances == null) {
				noteMap.put(s, 1);
			} else {
				noteMap.put(s, occurances + 1);
			}
		}

		boolean canReplicate = true;
		for (String s : noteMap.keySet()) {
			if(!magzineMap.containsKey(s) || (magzineMap.get(s)<noteMap.get(s))) {
				canReplicate=false;
				break;
			}
		}
		System.out.println((canReplicate)? "Yes":"No");
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		String[] mn = scanner.nextLine().split(" ");

		int m = Integer.parseInt(mn[0]);

		int n = Integer.parseInt(mn[1]);

		String[] magazine = new String[m];

		String[] magazineItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < m; i++) {
			String magazineItem = magazineItems[i];
			magazine[i] = magazineItem;
		}

		String[] note = new String[n];

		String[] noteItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			String noteItem = noteItems[i];
			note[i] = noteItem;
		}

		checkMagazine(magazine, note);

		scanner.close();
	}
}
