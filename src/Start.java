import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.regex.*;

public class Start {
	
	static final ArrayList<DataModel> listDm = new ArrayList();
	
	public static void download(){
		
		String nextLine = null;
		String[] massStrok;
		
		Pattern pName = Pattern.compile("(?<=\"FullName\":\").+?(?=\",\")");
		Pattern pArticle = Pattern.compile("(?<=\"Article\":\").+?(?=\",\")");
		Pattern pId = Pattern.compile("(?<=\"ID\":\").+?(?=\",\")");
		Pattern pPriceDiler = Pattern.compile("(?<=\"Diler2\":\")[-]?[0-9]+(.[0-9]+)?(?=\",\")");
		Pattern pPriceRozn = Pattern.compile("(?<=\"Roznichnaya\":\")[-]?[0-9]+(.[0-9]+)?(?=\",\")");
		Pattern pOst = Pattern.compile("(?<=\"Moskow\":\\{\"Available\":\")[-]?[0-9]+(.[0-9]+)?(?=\",\")");
		
		System.out.println("Началось скачивание");
		try(BufferedReader buff = 
				new BufferedReader(new InputStreamReader(new URL("https://api.mkplitka.ru/api/products?access_token=u4OsnB1uJc5KaftNC4ZAjCFLX3JfEvLpYnk8lYbJDODSc59irbQF2IBdif91oHSq").openConnection().getInputStream(), "UTF8"))){
				nextLine = buff.readLine();
				System.out.println("Скачивание прошло успешно");
		}catch(Exception e){
			System.out.println("Ошибка");
		}
		
		massStrok = nextLine.split("\\}\\p{Punct}\\{");
		int count = 1;
		for(String s : massStrok){
			
			Matcher mName = pName.matcher(s);
			Matcher mArticle = pArticle.matcher(s);
			Matcher mId = pId.matcher(s);
			Matcher mPriceDiler = pPriceDiler.matcher(s);
			Matcher mPriceRozn = pPriceRozn.matcher(s);
			Matcher mOst = pOst.matcher(s);
			
			DataModel d = new DataModel();
			if(mName.find()){
				d.setName(mName.group().trim());
			}
			if(mArticle.find()){
				d.setArticle(mArticle.group().trim().replaceAll("\\\\|//", "/"));
			}
			if(mId.find()){
				d.setId(mId.group().trim());
			}
			if(mPriceDiler.find()){
				d.setPriceDiler(mPriceDiler.group().trim());
			}
			if(mPriceRozn.find()){
				d.setPriceRozn(mPriceRozn.group().trim());
			}
			if(mOst.find()){
				d.setOst(mOst.group().trim());
			}
			listDm.add(d);
			System.out.println("Номер добавленой позиции " + count++);

		}
		
	}
}
