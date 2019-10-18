import classse.User;


public class Main {
    public static void main(String[] args) throws Exception {
        //用户登录
        User currentUser = User.login();
        boolean isQuit;
        do{
            //用户登录完成后显示出对应用户职业的菜单栏
            currentUser.menu();
            isQuit = currentUser.input();
        }while(!isQuit);
    }
}
