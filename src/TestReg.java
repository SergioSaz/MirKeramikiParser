import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestReg {
	
	public static void main(String[] args) throws FileNotFoundException, IOException{
		String vhod = null;
		try(BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\User\\Desktop\\Сазонов С\\Java\\Тест.txt"))){
			if(br.ready()){
				vhod = br.readLine();
			}
		}
		Pattern pName = Pattern.compile("(?<=\"FullName\":\").+?(?=\",\")");
		Pattern pArticle = Pattern.compile("(?<=\"Article\":\").+?(?=\",\")");
		Pattern pId = Pattern.compile("(?<=\"ID\":\").+?(?=\",\")");
		Matcher mName = pName.matcher(vhod);
		Matcher mArticle = pArticle.matcher(vhod);
		Matcher mId = pId.matcher(vhod);
		
		if(mName.find()){
			System.out.println(mName.group());
		}
		if(mArticle.find()){
			System.out.println(mArticle.group());
		}
		if(mId.find()){
			System.out.println(mId.group());
		}
	}
}
