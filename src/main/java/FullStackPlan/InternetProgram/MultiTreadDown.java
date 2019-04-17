package FullStackPlan.InternetProgram;

public class MultiTreadDown {
    public static void main(String[] args) throws Exception {
        final DownUtil downUtil=new DownUtil("https://qd.myapp.com/myapp/qqteam/tim/down/tim_pc.exe","1.rar",4);
        downUtil.download();


    }
}
