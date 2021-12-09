package day1209;


class Solution {
    public boolean validTicTacToe(String[] board) {
        int[] nums=new int[3];
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[i].charAt(j)=='X'){
                    nums[1]++;
                }else if(board[i].charAt(j)=='O'){
                    nums[2]++;
                }else{
                    nums[0]++;
                }
            }
        }
        if(nums[0]==0||nums[0]==1||nums[0]==9){
            return true;
        }
        boolean isPlayer1Win=isSame('X',board);
        boolean isPlayer2Win=isSame('O',board);
        if(isPlayer1Win&&isPlayer2Win&&nums[1]==nums[2]+1){
            return true;
        }
        if(!isPlayer1Win&&isPlayer2Win&&nums[1]==nums[2]){
            return true;
        }
        return false;

    }
    public boolean isSame(char ch,String[] board){
        boolean isWin=true;
        for(int i=0;i<3;i++){
            isWin=true;
            for(int j=0;j<3;j++){
                if(board[i].charAt(j)!=ch){
                    isWin=false;
                    break;
                }
            }
            if(isWin==true){
                return true;
            }
        }
        if(ch==board[0].charAt(0)&&ch==board[1].charAt(1)&&ch==board[2].charAt(2)){
            return true;
        }
        if(ch==board[2].charAt(0)&&ch==board[1].charAt(1)&&ch==board[0].charAt(2)){
            return true;
        }
        return false;
    }
}
public class TestDemo {
    public static void main(String[] args) {
        String[] board={"XXX","XOO","OO "};
        Solution solution=new Solution();
        System.out.println(solution.validTicTacToe(board));
    }
}
