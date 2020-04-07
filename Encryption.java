public class Solution {

	static String encryption(String s) {
		s = s.replaceAll("\\s+", "");
		int len = s.length();
		double x = Math.sqrt((double) len);
		int n = (int) Math.ceil(x);

		StringBuilder t = new StringBuilder();
		int i = 0;
		while (i < n) {
			int j = i;
			while (j < len) {
				char c = s.charAt(j);
				t.append(c);
				j = j + n;
			}
			t.append(" ");
			i++;
		}
		return t.toString();
	}

	public static void main(String[] args) {
		String s = "chillout";
		String res = encryption(s);
		System.out.println(res);
	}
}
