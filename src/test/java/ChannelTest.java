import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.liuyuan.cms.domain.Channel;
/**
 * 
 * @ClassName: ChannelTest 
 * @Description: 栏目
 * @author: 刘媛
 * @date: 2020年3月3日 下午5:14:09
 */
public class ChannelTest {

	public static void main(String[] args) throws Exception {
		File file = new File("D:/channel");
		//序列化
		ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream(file));
		Channel channel = new Channel(1,"栏目");
		oout.writeObject(channel);
		oout.close();
		
		//反序列
		ObjectInputStream oin = new ObjectInputStream(new FileInputStream(file));
		Object newUser = oin.readObject();
		oin.close();
		System.out.println(newUser);
		
	}
}
