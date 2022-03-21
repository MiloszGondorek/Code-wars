class Xbonacci {
    public double[] tribonacci(double[] s, int n) {
        double[] tab=new double[n];
        for(int i=0;i<n;i++){
            if(i<3){
                tab[i]=s[i];
            }else {
                tab[i] = tab[i - 1] + tab[i - 2] + tab[i - 3];
            }
        }
        return tab;
    }
}

public class main {
    public static void main(String[] args) {
        for (double d:new Xbonacci().tribonacci(new double []{1,1,1},8)) {
            System.out.println(d);
        }
    }
}
