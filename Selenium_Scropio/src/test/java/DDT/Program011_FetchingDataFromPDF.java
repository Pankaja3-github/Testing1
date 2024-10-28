package DDT;

import java.io.File;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class Program011_FetchingDataFromPDF {
	public static void main(String[] args) throws Throwable {
		File fis = new File("./src/test/resources/pdfdata.pdf");
		
		PDDocument doc = PDDocument.load(fis);
		
		//print no.of pages
//		int pages = doc.getNumberOfPages();
//		System.out.println("Number of pages in pdf :" +pages);
//		
//		//print data
		PDFTextStripper pdfData = new PDFTextStripper();
//		String readDoc = pdfData.getText(doc);
//		System.out.println(readDoc);
		
		pdfData.setStartPage(1);
		pdfData.setEndPage(1);
		String readDoc = pdfData.getText(doc);
		System.out.println(readDoc);
	}

}
