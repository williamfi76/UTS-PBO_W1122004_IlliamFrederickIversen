package Main;

import Controller.Controller;
import Model.ContentState;

public class Main {
    public Main() {
        // FUNC 1
        Controller.showUserPost(Controller.users.get(1));
        System.out.println("==========================================");

        // FUNC 2
        Controller.showPost("20002");
        System.out.println("==========================================");

        //FUNC 3
        Controller.changePostStatus(Controller.users.get(0).getPosts().get(2), ContentState.DELETED);

        //FUNC 4
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}
