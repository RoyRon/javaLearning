package TencentClass;

/**
 * @author 江映锋
 * Create on 2019/02/26
 */
public class Count3Quit {
    public static void main(String[] args) {
        boolean[] booleans = new boolean[500];
        for (int i = 0; i < booleans.length; i++) {
            booleans[i] = true;
        }
        int leftCount = 500;
        int countNum = 0;
        int index = 0;
        while (leftCount > 1) {
            if (booleans[index] == true) {
                countNum++;
            }
            if (countNum == 3) {
                booleans[index] = false;
                leftCount--;
                countNum = 0;
            }
            index++;
            if (index==booleans.length){
                index=0;
            }
        }
        for (int i=0;i<booleans.length;i++){
            if (booleans[i]==true){
                System.out.println(i);
            }
        }
    }
}
