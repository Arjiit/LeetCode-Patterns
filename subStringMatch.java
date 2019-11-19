import java.util.regex.*;
class patternMatch {
	public static void match(String pattern, String blob) {
		String[] splitString = bolb.split("|");
		StringBuilder sb = new StringBuilder();

		for (int i=0; i<splitString.length(); i++){
			String toMatch = splitString[i];
			Pattern pat = Pattern.compile(pattern);
			Matcher mat = pat.matcher(toMatch);
			int count = 0;
			while(mat.find()){
				count++;
			}
			sb.append(count);
			sb.append("|");

		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());

	}

	public static void main(String[] args) {
		match("ab", "aaababcccab");
	}
}