import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.liuyuan.cms.domain.Article;
/**
 * 
 * @ClassName: ArticleTest 
 * @Description: 文章内容表 
 * @author: 刘媛
 * @date: 2020年3月3日 下午5:10:13
 */
public class ArticleTest {

	public static void main(String[] args) throws Exception {
		File file = new File("D:/article");
		//序列化
		ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream(file));
		Article article = new Article(1,"hfnuasij");
		oout.writeObject(article);
		oout.close();
		
		//反序列
		ObjectInputStream oin = new ObjectInputStream(new FileInputStream(file));
		Object newUser = oin.readObject();
		oin.close();
		System.out.println(newUser);
		
	}
}
