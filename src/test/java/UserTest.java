import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.liuyuan.cms.domain.User;
/**
 * 
 * @ClassName: UserTest 
 * @Description: 用户
 * @author: 刘媛
 * @date: 2020年3月3日 下午5:10:27
 */
public class UserTest {

	public static void main(String[] args) throws Exception {
		File file = new File("D:/user");
		//序列化
		ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream(file));
		User user = new User(1,"zhang");
		
		oout.writeObject(user);
		oout.close();
		
		//反序列
		ObjectInputStream oin = new ObjectInputStream(new FileInputStream(file));
		Object newUser = oin.readObject();
		oin.close();
		System.out.println(newUser);
		
	}
}
