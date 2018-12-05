package serial;

import java.io.*;

/**
 * Created by chengwenjie on 2018/12/3.
 */
public class TransientTest {

    static String path = System.getProperty("user.dir") + "/data.txt";

    public static void main(String[] args) {
        User user = new User();
        user.setUsername("Alexia");
        user.setPasswd("123456");

        System.out.println("before serial");
        System.out.println(user.getUsername());
        System.out.println(user.getPasswd());

        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(path));
            os.writeObject(user);
            os.flush();
            os.close();
        } catch (Exception e) { e.printStackTrace(); }

        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream(path));
            user = (User) is.readObject();
            is.close();

            System.out.println("after serial");
            System.out.println(user.getUsername());
            System.out.println(user.getPasswd());
        } catch (Exception e) { e.printStackTrace(); }
    }
}

class User implements Serializable {

    private static final long serialVersionUID = 8294180014912103005L;

    private String username;
    private transient String passwd; // transient marked field, not included in serialization

    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }

    public String getPasswd() { return passwd; }

    public void setPasswd(String passwd) { this.passwd = passwd; }
}
