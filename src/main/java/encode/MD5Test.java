package encode;

import java.security.MessageDigest;

/**
 * Created by chengwenjie on 2018/12/11.
 */
public class MD5Test {

    public static void main(String[] args) {
        System.out.println(getMD5Code("你若安好，便是晴天"));
    }

    public static String getMD5Code(String message) {
        String md5Str = "";

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] md5Bytes = md.digest(message.getBytes());
            md5Str = bytes2Hex(md5Bytes);
        } catch (Exception e) {}

        return md5Str;
    }

    public static String bytes2Hex(byte[] bytes) {
        StringBuffer result = new StringBuffer();
        int temp;
        try {
            for (int i = 0; i < bytes.length; i++) {
                temp = bytes[i];
                if(temp < 0) {
                    temp += 256;
                }
                if (temp < 16) {
                    result.append("0");
                }
                result.append(Integer.toHexString(temp));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toString();
    }
}
