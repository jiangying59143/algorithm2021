package class01;

public class Practice_BSExist {


    public static boolean bs(int[] arr, int value){
        if(arr == null || arr.length==0){
            return false;
        }
        if(arr.length==1){
            return arr[0]==value;
        }
        int L=0, R=arr.length-1, mid;
        while(L < R){ //验证不等的情况
            mid = L+((R-L)>>1); //注意外层括号((R-L)>>1)
            if(arr[mid] == value){
                return true;
            }else if(arr[mid] > value){
                R= mid - 1;
            }else{
                L = mid + 1;
            }
        }
        return arr[L] == value; //验证相等的情况 arr[R] == value 也是对的

    }

    public static  boolean bs2(int arr[], int value){
        if(arr == null || arr.length==0){
            return false;
        }
        if(arr.length==1){
            return arr[0]==value;
        }
        int L=0, R=arr.length-1, mid;
        while(L <= R){ //验证不等的情况
            mid = L+((R-L)>>1);//注意外层括号((R-L)>>1)
            if(arr[mid] == value){
                return true;
            }else if(arr[mid] > value){
                R= mid - 1;
            }else{
                L = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(bs(new int[]{1,2}, 2));
        System.out.println(bs2(new int[]{1,2}, 2));
    }
}
