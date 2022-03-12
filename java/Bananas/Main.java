//task url: https://www.codewars.com/kata/5917fbed9f4056205a00001e
import java.util.*;

class Dinglemouse {

    static Set<String> bananas(final String s) {
        Set<String> r=new HashSet<String>();
        for(int b=0;b<s.length()-5;b++) {
            if (s.toCharArray()[b] == 'b') {

                for (int a1 = b+1; a1 < s.length() - 4; a1++) {
                    if (s.toCharArray()[a1] == 'a') {

                        for (int n1 = a1+1; n1 < s.length() - 3; n1++) {
                            if (s.toCharArray()[n1] == 'n') {

                                for (int a2 = n1+1; a2 < s.length() - 2; a2++) {
                                    if (s.toCharArray()[a2] == 'a') {

                                        for (int n2 = a2+1; n2 < s.length() - 1; n2++) {
                                            if (s.toCharArray()[n2] == 'n') {

                                                for (int a3 = n2+1; a3 < s.length(); a3++) {
                                                    if (s.toCharArray()[a3] == 'a') {

                                                        String ret = "";
                                                        for (int i = 0; i < s.length(); i++) {
                                                            if (i == b) {
                                                                ret += "b";
                                                            } else if (i == a1 || i == a2 || i == a3) {
                                                                ret += "a";
                                                            } else if (i == n1 || i == n2) {
                                                                ret += "n";
                                                            } else {
                                                                ret += "-";
                                                            }
                                                        }
                                                        r.add(ret);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return r;
    }

}

public class Main {
    public static void main(String[] args) {
        for(String a:Dinglemouse.bananas("bbananana"))
            System.out.println(a);
    }
}
