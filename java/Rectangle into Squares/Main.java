import java.util.*;

class SqInRect{
    public static List<Integer> sqInRect(int height, int width) {
        List<Integer> list=new ArrayList<Integer>();
        if(height==width){return null;}// If it's a square return null
        while (true) {
            if(width>height){ // Always sets a higher value to 'height'
                int t=height;
                height=width;
                width=t;
            }
            list.add(width); // Add smaller square to list
            height -= width; // Subtract the length of the smaller one from the larger side
            if(width == height){ // If only a square remains, return the list with that square
                list.add(width);
                return list;
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(SqInRect.sqInRect(5, 3));
        System.out.println(SqInRect.sqInRect(3, 6));
        System.out.println(SqInRect.sqInRect(4, 10));

    }
}
