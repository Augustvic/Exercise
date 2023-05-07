package Algorithm.Math;

public class IPInteger {

    public static void main(String[] args) {
        String ip = "10.0.3.193";
        int val = 167773121;
        System.out.println(ip2Int(ip));
        System.out.println(int2Ip(val));
    }

    public static Integer ip2Int(String ip) {
        String[] ipArray = ip.split("\\.");
        int result = 0;
        for (int i = 0; i < 4; i++) {
            int ipSeg = Integer.parseInt(ipArray[i]);
            result |= (ipSeg << (3 - i) * 8);
        }
        return result;
    }

    public static String int2Ip(int val) {
        StringBuilder sb = new StringBuilder();
        int base = 255;
        for (int i = 0; i < 4; i++) {
            int ipSeg = val & (base << (3 - i) * 8);
            sb.append(ipSeg >> (3 - i) * 8);
            sb.append(".");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
