package com.demo.generatepdf;

import java.io.FileOutputStream;

import com.demo.user.model.User;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfGenerator {
	public static void generatePdf(User pdf) {
		Document document = new Document();
		//ByteArrayOutputStream out = new ByteArrayOutputStream();
		
		//String path="C:\\MyFolder\\User-service\\src\\main\\resources\\templates";
		System.out.println("Inside pdf");
		try {
		//System.out.println("path->"+pnrPath);
		//String absPath=pnrPath+"//";
		FileOutputStream fos=new FileOutputStream("C:\\MyFolder\\User-service\\src\\main\\resources\\templates\\tickets\\"+pdf.getPnr()+".pdf");
		PdfWriter.getInstance(document, fos);
		// PdfWriter.getInstance(document, new FileOutputStream(absPath));
		//System.out.println("abs path->"+absPath);
		document.open();
		Paragraph title = new Paragraph("BOOKING DETAILS",
		FontFactory.getFont(FontFactory.HELVETICA, 14, Font.BOLD, new BaseColor(20, 255, 255)));
		title.setAlignment(Element.ALIGN_CENTER);
		document.add(title);
		document.add(new Paragraph(" "));
		Paragraph pnr=new Paragraph("PNR "+" "+ pdf.getPnr());
		//pnr.setAlignment(Element.ALIGN_CENTER);
		document.add(pnr);
		// document.add(new Paragraph(" "));
		System.out.println("para started");
		Paragraph fname=new Paragraph("Email "+" "+ pdf.getEmail());
		fname.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(fname);

		Paragraph fNum=new Paragraph("Name "+" "+ (pdf.getName()));
		fname.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(fNum);
		Paragraph seat=new Paragraph("SEAT BOOKED "+" "+ (pdf.getSeatNumber()));
		fname.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(seat);

		Paragraph fromPlace=new Paragraph("Gender "+" "+ pdf.getGender());
		fname.setAlignment(Element.ALIGN_RIGHT);
		document.add(fromPlace);

		Paragraph pass= new Paragraph("PASSENGER DETAILS",
		FontFactory.getFont(FontFactory.HELVETICA, 14, Font.BOLD, new BaseColor(200, 200, 255)));
		title.setAlignment(Element.ALIGN_LEFT);

		fname.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(pass);

		document.close();
		fos.close();
		System.out.println("pdf generated");

		} catch (Exception ex) {

		}
	}
}
