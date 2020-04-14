import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

// Java implementation of the approach 
class WeightedUniformString {

	static String[] weightedUniformStrings(String s, int[] queries) {
		String[] res = new String[queries.length];

		Map<Integer, List<Integer>> hash = new TreeMap<>();
		for (int i = 0; i < queries.length; i++) {
			if (hash.get(queries[i]) == null) {
				hash.put(queries[i], new ArrayList<Integer>());
			}
			hash.get(queries[i]).add(i);
			res[i] = "No";
		}
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			int key = c - 'a' + 1;
			if (hash.containsKey(key)) {
				List<Integer> list = hash.get(key);
				for (int x : list) {
					res[x] = "Yes";
				}
			}
			int j = i + 1;
			int n = key;
			while (j < s.length() && c == s.charAt(j)) {
				n += s.charAt(j) - 'a' + 1;
				j++;
				if (n == 28950) {
					System.out.println("ddd");
				}
				if (hash.containsKey(n)) {
					List<Integer> list = hash.get(n);
					for (int x : list) {
						res[x] = "Yes";
					}
				}
			}
			i = j - 1;
		}

		return res;
	}

	static String s = "";

	// Driver code
	public static void main(String[] args) {
		String s = "aaabbbbcccddd";
		int[] queries = { 9, 7, 8, 12, 5 };

		String[] res = weightedUniformStrings(s, queries);
		for (String r : res) {
			System.out.println(r);
		}
	}
}
