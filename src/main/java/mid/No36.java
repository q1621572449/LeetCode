package mid;

public class No36 {
    //暴力破解，但是得注意界限
    public boolean isValidSudoku(char[][] board) {
        //遍历整个数组
        for (int i = 0; i < board[0].length; i++) {
            for (int j = 0; j < board.length; j++) {
                //.的话就跳过
                if (board[i][j]=='.'){
                    continue;
                }
                if (!line(i,j,board)){
                    return false;
                }
                if (!column(i,j,board)){
                    return false;
                }
                if (!lineAndColumn(i,j,board)){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean line(int x,int y,char[][] board){
        char s = board[x][y];
        for (int i = y+1; i < board[x].length; i++) {
            if (board[x][i]==s){
                return false;
            }
        }
        return true;
    }

    public boolean column(int x,int y,char[][] board){
        char s = board[x][y];
        for (int i = x+1; i < board.length; i++) {
            if (board[i][y]==s){
                return false;
            }
        }
        return true;
    }

    public boolean lineAndColumn(int x,int y,char[][] board){
        char s = board[x][y];
        //用除法来判断是在哪个区间
        int a = x/3;
        int b = y/3;


        for (int i = x; i < (a+1)*3; i++) {
            if (i==x){
                for (int j = y+1; j < (b+1)*3; j++) {
                    if (s==board[i][j]){
                        return false;
                    }
                }
            }else
            {
                for (int j = b*3; j < (b+1)*3; j++) {
                    if (s==board[i][j]){
                        return false;
                    }
                }
            }

        }
        return true;
    }

    public boolean isValidSudokuOfficial(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] columns = new int[9][9];
        int[][][] subboxes = new int[3][3][9];
        //遍历二维数组
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int index = c - '0' - 1;
                    rows[i][index]++;
                    columns[j][index]++;
                    subboxes[i / 3][j / 3][index]++;
                    if (rows[i][index] > 1 || columns[j][index] > 1 || subboxes[i / 3][j / 3][index] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
//        String[][] board={
//         {"5","3",".",".","7",".",".",".","."}
//        ,{"6",".",".","1","9","5",".",".","."}
//        ,{".","9","8",".",".",".",".","6","."}
//        ,{"8",".",".",".","6",".",".",".","3"}
//        ,{"4",".",".","8",".","3",".",".","1"}
//        ,{"7",".",".",".","2",".",".",".","6"}
//        ,{".","6",".",".",".",".","2","8","."}
//        ,{".",".",".","4","1","9",".",".","5"}
//        ,{".",".",".",".","8",".",".","7","9"}
//        };

//        String[][] board = {
//                 {".",".","5",".",".",".",".",".","."}
//                ,{".",".",".","8",".",".",".","3","."}
//                ,{".","5",".",".","2",".",".",".","."}
//                ,{".",".",".",".",".",".",".",".","."}
//                ,{".",".",".",".",".",".",".",".","9"}
//                ,{".",".",".",".",".",".","4",".","."}
//                ,{".",".",".",".",".",".",".",".","7"}
//                ,{".","1",".",".",".",".",".",".","."}
//                ,{"2","4",".",".",".",".","9",".","."}
//        };

                String[][] board = {
                        {".",".",".","1","8",".",".",".","7"},
                        {".",".",".",".",".",".","2",".","."},
                        {".",".",".",".",".",".",".",".","3"},
                        {"4",".","3",".",".",".",".","1","9"},
                        {".",".",".",".",".",".",".",".","."},
                        {".",".",".",".",".",".",".",".","."},
                        {"1",".",".",".","5",".",".",".","."},
                        {".",".",".",".",".",".",".",".","."},
                        {".",".",".","5",".",".",".",".","6"}};


        char[][] board1 = new char[9][9];
        for (int i = 0; i <9; i++) {
            for (int j = 0; j < 9; j++) {
//                System.out.println(board[i][j]);
                board1[i][j]=board[i][j].charAt(0);
            }
        }
        No36 no36 = new No36();
        boolean validSudoku = no36.isValidSudoku(board1);
        System.out.println(validSudoku);

    }
}
