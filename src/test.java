public class test {
    public static void main(String[] args) {
        String s1 = "1234";
        String s2 = "2468";
        String s3 = "435";
        System.out.println(t.add(s1, s2));
        System.out.println(t.add(s2, s3));
    }

    private static test t = new test();

    public String add(String s1, String s2) {
        StringBuilder sb1 = new StringBuilder(s1).reverse();
        StringBuilder sb2 = new StringBuilder(s2).reverse();
        int i = 0, j = 0;
        int carry = 0;
        StringBuilder ret = new StringBuilder();
        while (i < sb1.length() || j < sb2.length()) {
            int a =  i < sb1.length() ? sb1.charAt(i) - '0' : 0;
            int b = j < sb2.length() ? sb2.charAt(j) - '0' : 0;
            int sum = a + b + carry;
            carry = sum / 10;
            ret.append(sum % 10);
            i++;j++;
        }
        return ret.reverse().toString();
    }
}
