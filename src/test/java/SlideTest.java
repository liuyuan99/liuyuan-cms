import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.liuyuan.cms.domain.Slide;
/**
 * 
 * @ClassName: SlideTest 
 * @Description: 广告表
 * @author: 刘媛
 * @date: 2020年3月3日 下午5:20:45
 */
public class SlideTest {

	public static void main(String[] args) throws Exception {
		File file = new File("D:/slide");
		//序列化
		ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream(file));
		Slide slide = new Slide(1,"广告标题");
		oout.writeObject(slide);
		oout.close();
		
		//反序列
		ObjectInputStream oin = new ObjectInputStream(new FileInputStream(file));
		Object newUser = oin.readObject();
		oin.close();
		System.out.println(newUser);
		
	}
}
