package dsa_assignment2_string_sort_lsd;

public class StringSortLSD_main {
	public static void main(String[] args) {
		String[] a = { "158", "124", "238", "707", "608", "250", "888" };
		sort(a, 3);
		for (String a1 : a) {
			System.out.println(a1);
		}
	}

	private static void sort(String[] a, int W) {
		int R = 256; // Character of ASCII
		int N = a.length;
		for (int d = W - 1; d >= 0; d--) {
			int[] count = new int[R + 1];
			for (int i = 0; i < N; i++) {
				count[a[i].charAt(d) + 1]++;
			}
			for (int r = 0; r < R; r++) {
				count[r + 1] += count[r];
			}
			String aux[] = new String[N];
			for (int i = 0; i < N; i++) {
				aux[count[a[i].charAt(d)]] = a[i];
				count[a[i].charAt(d)]++;
			}
			System.arraycopy(aux, 0, a, 0, N);
		}
	}
}
