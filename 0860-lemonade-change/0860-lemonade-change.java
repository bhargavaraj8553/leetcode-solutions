class Change{
    int five;
    int ten;
    int twenty;
}

class Solution {
    public boolean lemonadeChange(int[] bills) {
        Change change= new Change();
        for (int bill:bills){
            if (bill==5){
                change.five++;
            } else if (bill==10){
                if (change.five>=1){
                    change.five--;
                    change.ten++;
                }
                else {
                    return false;
                }
            } else if (bill==20){
                if (change.five>=1 && change.ten>=1){
                    change.ten-=1;
                    change.five-=1;
                    change.twenty+=1;
                } else if (change.five>=3){
                    change.five-=3;
                    change.twenty+=1;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}