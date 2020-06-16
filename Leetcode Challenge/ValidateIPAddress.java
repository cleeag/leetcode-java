import java.util.Arrays;

public class ValidateIPAddress {
    public static void main(String[] args) {
//        String s = "12.32.12.3";
//        String s = "2001:0db8:85a3:0:0:8A2E::0370:7334:";
//        System.out.println(Arrays.toString(s.split(":")));
//        String s = "20EE:FGb8:85a3:0:0:8A2E:0370:7334";
        String s = "192.0.0.1";
        ValidateIPAddress v = new ValidateIPAddress();
        System.out.println(v.validIPAddress(s));
    }
    public String validIPAddress(String IP) {
        if (IP.length() == 0 || IP.endsWith(".") ||  IP.endsWith(":")) return "Neither";

        if (IP.contains(".")){
            String[] add = IP.split("\\.");
            if (add.length != 4) return "Neither";
            else{
                for (String s : add) {
                    if (s.length() == 0 ||s.length() > 3|| (s.charAt(0) == '0'&&s.length()>1)) return "Neither";
                    for (int i = 0; i < s.length(); i++)
                        if (!Character.isDigit(s.charAt(i))) return "Neither";

                    int value = Integer.parseInt(s);
                    if (!(value >= 0  && value <256)) return "Neither";
                }
            }
            return "IPv4";
        }
        else if (IP.contains(":")){
            String[] add = IP.split(":");
            if (add.length != 8) return "Neither";
            else{
                for (String s : add) {
                    if (s.length() == 0 ||s.length() > 4 || !s.matches("^[0-9a-fA-F]+$")) return "Neither";
                }
            }
            return "IPv6";
        }
        return "Neither";
    }

}
