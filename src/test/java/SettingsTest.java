import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.liuyuan.cms.domain.Settings;
/**
 * 
 * @ClassName: SettingsTest 
 * @Description: 配置表
 * @author: 刘媛
 * @date: 2020年3月3日 下午5:17:10
 */
public class SettingsTest {

	public static void main(String[] args) throws Exception {
		File file = new File("D:/settings");
		//序列化
		ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream(file));
		Settings test = new Settings(1,"配置表");
		oout.writeObject(test);
		oout.close();
		
		//反序列
		ObjectInputStream oin = new ObjectInputStream(new FileInputStream(file));
		Object newUser = oin.readObject();
		oin.close();
		System.out.println(newUser);
		
	}
}
