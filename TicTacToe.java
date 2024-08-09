import java.util.*;
/**
 * TicTacToe
 */
public class TicTacToe {
    static HashSet<Integer> set=new HashSet<>();
    static HashSet<Integer> set1=new HashSet<>();
public static void main(String[] args) {
    char [][]g_board={
        {' ','|',' ','|',' '},
        {'-','-','-','-','-'},
        {' ','|',' ','|',' '},        
        {'-','-','-','-','-'},
        {' ','|',' ','|',' '},
    };
    TicTacToe obj=new TicTacToe();
    obj.print(g_board);
    Scanner in=new Scanner(System.in);

    while (true) {
        System.out.println("Enter values from1-9:");
        int value=in.nextInt();
        while (set.contains(value)||set1.contains(value)) {
            System.out.println();
            System.out.println("The place already taken Enter values from1-9:");
            value=in.nextInt();
        }
        obj.p_borad(g_board,value,"You"); 

        String res= check_winner();
        if(res.length()>0){
            System.out.println(res);
            break;
        }

        int value1=get_random();
        while (set.contains(value1)||set1.contains(value1)) {
            value1=get_random();
        }
        obj.p_borad(g_board,value1,"Comp");
        
        res= check_winner();
        if(res.length()>0){
            System.out.println(res);
            break;
        } 
    }
}


static String check_winner(){
    HashSet<Integer> r1=new HashSet<Integer>();
    r1.add(1);r1.add(2);r1.add(3);
    HashSet<Integer> r2=new HashSet<Integer>();
    r2.add(4);r2.add(5);r2.add(6);
    HashSet<Integer> r3=new HashSet<Integer>();
    r3.add(7); r3.add(8);r3.add(9);
    HashSet<Integer> c1=new HashSet<Integer>();
    c1.add(1);c1.add(4);c1.add(7);
    HashSet<Integer> c2=new HashSet<Integer>();
    c2.add(2);c2.add(5);c2.add(8);
    HashSet<Integer> c3=new HashSet<Integer>();
    c3.add(3);c3.add(6);c3.add(9);
    HashSet<Integer> d1=new HashSet<Integer>();
    d1.add(1);d1.add(5);d1.add(9);
    HashSet<Integer> d2=new HashSet<Integer>();
    d2.add(3); d2.add(5);d2.add(7);
    HashSet<HashSet> check = new HashSet<HashSet>();
    check.add(r1);check.add(r2);check.add(r3);
    check.add(c1);check.add(c2);check.add(c3);
    check.add(d1);check.add(d2);
    for(HashSet l : check) {
    if(set.containsAll(l))
    return "YOU WON";
    else if (set1.containsAll(l))
    return "YOU LOSE";
    }
    if (set.size()+set1.size()==9)
    return "ITS A DRAW";
    return "";
    }



    public  void print(char[][]g_board){
        for(int i=0;i<g_board.length;i++){
            for(int j=0;j<g_board[i].length;j++){
                System.out.print(g_board[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
public void p_borad(char [][]g_board,int pos,String s){
    char syb='X';
    if(s.equals("You")){
        syb='X';
        set.add(pos);
    }
    else if (s.equals("Comp")) {
        syb='O';
        set1.add(pos);
    }
    switch (pos) {
        case 1:g_board[0][0]=syb;
            break;
        case 2:g_board[0][2]=syb;
            break;
        case 3:g_board[0][4]=syb;
            break;
        case 4:g_board[2][0]=syb;
            break;
        case 5:g_board[2][2]=syb;
            break;
        case 6:g_board[2][4]=syb;
            break;
        case 7:g_board[4][0]=syb;
            break;
        case 8:g_board[4][2]=syb;
            break;
        case 9:g_board[4][4]=syb;
            break;
    
        default:
        System.out.println("Invalid Input");
            break;
    }
    print(g_board);
}
public static int get_random(){
    int max=9;
    int min=1;
    
    int range=max-min+1;
    int res=(int) (Math.random()*range) + min;
    return res;
    }
}