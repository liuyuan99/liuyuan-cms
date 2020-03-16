import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.liuyuan.cms.domain.Category;
/**
 * 
 * @ClassName: CategoryTest 
 * @Description: 栏目子类
 * @author: 刘媛
 * @date: 2020年3月3日 下午5:11:36
 */
public class CategoryTest {

	public static void main(String[] args) throws Exception {
		File file = new File("D:/category");
		//序列化
		ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream(file));
		Category category = new Category(1,"子类");
		oout.writeObject(category);
		oout.close();
		
		//反序列
		ObjectInputStream oin = new ObjectInputStream(new FileInputStream(file));
		Object newUser = oin.readObject();
		oin.close();
		System.out.println(newUser);
		
	}
}
