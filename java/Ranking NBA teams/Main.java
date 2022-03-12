task url: https://www.codewars.com/kata/5a420163b6cfd7cde5000077
import javax.sound.midi.Soundbank;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Nba {
    public static String nbaCup(String resultSheet, String toFind) {
        if(toFind.isEmpty())
            return "";
        if(!resultSheet.contains(toFind+" "))
            return toFind+":This team didn't play!";
        int w=0,d=0,l=0,s=0,c=0,p;
        String[] matches=resultSheet.split(",");
        for(String x:matches){
            if(x.contains(toFind)) {
                if(x.contains("."))
                    return "Error(float number):"+x;
                x+=',';
                Pattern pattern1 = Pattern.compile("(\\s([0-9])+,)|(\\s([0-9])+\\s)", Pattern.CASE_INSENSITIVE);
                Matcher matcher1 = pattern1.matcher(x);

                while (matcher1.find()) {
                    int t1Points=Integer.parseInt(matcher1.group().replace(" ",""));
                    matcher1.find();
                    int t2Points=Integer.parseInt(matcher1.group().replace(",","").replace(" ",""));

                    if(t1Points==t2Points)
                        d++;

                    if(x.contains(toFind+" "+t1Points)){
                        s+=t1Points;
                        c+=t2Points;
                        if(t1Points>t2Points){
                            w++;
                        }else if(t1Points<t2Points){
                            l++;
                        }
                    }else{
                        s+=t2Points;
                        c+=t1Points;
                        if(t2Points>t1Points){
                            w++;
                        }else if(t2Points<t1Points){
                            l++;
                        }
                    }
                }
            }
        }
        p=w*3+d*1;
        return toFind+":W="+w+";D="+d+";L="+l+";Scored="+s+";Conceded="+c+";Points="+p;
    }
}
public class Main {
    public static void main(String[] args) {
        String resultSheet1 = "Los Angeles Clippers 104 Dallas Mavericks 88,New York Knicks 101 Atlanta Hawks 112,Indiana Pacers 103 Memphis Grizzlies 112,"
                + "Los Angeles Lakers 111 Minnesota Timberwolves 112,Phoenix Suns 95 Dallas Mavericks 111,Portland Trail Blazers 112 New Orleans Pelicans 94,"
                + "Sacramento Kings 104 Los Angeles Clippers 111,Houston Rockets 85 Denver Nuggets 105,Memphis Grizzlies 76 Cleveland Cavaliers 106,"
                + "Milwaukee Bucks 97 New York Knicks 122,Oklahoma City Thunder 112 San Antonio Spurs 106,Boston Celtics 112 Philadelphia 76ers 95,"
                + "Brooklyn Nets 100 Chicago Bulls 115,Detroit Pistons 92 Utah Jazz 87,Miami Heat 104 Charlotte Hornets 94,"
                + "Toronto Raptors 106 Indiana Pacers 99,Orlando Magic 87 Washington Wizards 88,Golden State Warriors 111 New Orleans Pelicans 95,"
                + "Atlanta Hawks 94 Detroit Pistons 106,Chicago Bulls 97 Cleveland Cavaliers 95,";
        String resultSheet2 = "San Antonio Spurs 111 Houston Rockets 86,Chicago Bulls 103 Dallas Mavericks 102,Minnesota Timberwolves 112 Milwaukee Bucks 108,"
                + "New Orleans Pelicans 93 Miami Heat 90,Boston Celtics 81 Philadelphia 76ers 65,Detroit Pistons 115 Atlanta Hawks 87,"
                + "Toronto Raptors 92 Washington Wizards 82,Orlando Magic 86 Memphis Grizzlies 76,Los Angeles Clippers 115 Portland Trail Blazers 109,"
                + "Los Angeles Lakers 97 Golden State Warriors 136,Utah Jazz 98 Denver Nuggets 78,Boston Celtics 99 New York Knicks 85,"
                + "Indiana Pacers 98 Charlotte Hornets 86,Dallas Mavericks 87 Phoenix Suns 99,Atlanta Hawks 81 Memphis Grizzlies 82,"
                + "Miami Heat 110 Washington Wizards 105,Detroit Pistons 94 Charlotte Hornets 99,Orlando Magic 110 New Orleans Pelicans 107,"
                + "Los Angeles Clippers 130 Golden State Warriors 95,Utah Jazz 102 Oklahoma City Thunder 113,San Antonio Spurs 84 Phoenix Suns 104,"
                + "Chicago Bulls 103 Indiana Pacers 94,Milwaukee Bucks 106 Minnesota Timberwolves 88,Los Angeles Lakers 104 Portland Trail Blazers 102,"
                + "Houston Rockets 120 New Orleans Pelicans 100,Brooklyn Nets 105 Boston Celtics 111,Charlotte Hornets 94 Chicago Bulls 86,Cleveland Cavaliers 103 Dallas Mavericks 97";

        String resultSheet3 = resultSheet1 + resultSheet2;
        System.out.println(Nba.nbaCup(resultSheet3, "Boston Celtics"));
        System.out.println("\nBoston Celtics:W=4;D=0;L=0;Scored=403;Conceded=350;Points=12");
    }
}
