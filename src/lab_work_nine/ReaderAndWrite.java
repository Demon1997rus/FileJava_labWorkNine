package lab_work_nine;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;


public class ReaderAndWrite {

	private File fileSource = new File("sourceText.txt");
	private File fileEdited = new File("editedText.html");
	
	public String sourceText()
	{
		String sourceText = "";
		
		try (FileReader reader = new FileReader(fileSource))
		{
			StringBuilder strBuilder = new StringBuilder();
			int c;
			while((c = reader.read()) != -1)
			{
				strBuilder.append((char)c);
			}
			sourceText = strBuilder.toString();
			reader.close();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		return sourceText;
	}

	private String htmlEdited()
	{
		String htmlEdited = "<p align=\"center\"><b>Лабораторная работа №9</b></p>\n" +
				"<p align=\"center\"><i>Вариант А</i></p>\n" +
				"<p align=\"left\">Выполнил студент группы ВТАСбз-11 <b>Ротанов Д.И.</b></p>\n" + 
				"<p align=\"left\">Файл: <b>" + fileSource.getName() + "</b></p>\n" +
				"<p align=\"left\">Количество найденных слов: <b>" + amount_A() + "</b></p>\n" +
				"<p align=\"center\"><i>Исходный текст</i></p>\n" +
				"<p align=\"justify\"><b>" + sourceText() + "</b></p>\n";
		return htmlEdited;
	}

	public void writeText()
	{
		try(FileWriter writer = new FileWriter(fileEdited,false)) {
			writer.write(htmlEdited());
			writer.flush();
			writer.close();
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
	}

	private int amount_A()
	{
		int N = 0;
		StringTokenizer st = new StringTokenizer(sourceText()," \t\n\r,.");
		while(st.hasMoreTokens()) {
			char[] arrChar = st.nextToken().toCharArray();
			if(arrChar[0] == 'А' || arrChar[0] == 'а')
				N++;
		}
		return N;
	}
}