package curs17;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class PdfReadExample {

	public static void main(String[] args) throws IOException {

		File file = new File("sample.pdf");
		
		PDDocument document =  PDDocument.load(file);
		PDFTextStripper pdfStripper =  new PDFTextStripper();
		String text =  pdfStripper.getText(document);
		//System.out.println(text);
		
		document.close();
		
		System.out.println("---------------------------------");
		
		String myText =  "Acesta este un text";
		//                0123456789..					
		System.out.println(myText.substring(1, 5));
		
		System.out.println(readLineFromPDF("sample.pdf", "This", "text"));
			
	}
	
	public static String readLineFromPDF(String path, String inceput, String finish) throws IOException {
		String returnedString = "";
		
		PDDocument  document =  PDDocument.load(new File(path));
		PDFTextStripper pdfSripper = new PDFTextStripper();
		String allPdfText = pdfSripper.getText(document);
		//readLineFromPDf("sample.pdf", "this", "small" )
		String strStart = inceput;
		String strFinish =  finish;
		
		int startIndex =  allPdfText.indexOf(strStart);
		int endIndex = allPdfText.indexOf(strFinish);
		
		returnedString = allPdfText.substring(startIndex, endIndex) + strFinish;
		
		document.close();
		
		return returnedString;
	}
	
	

}
