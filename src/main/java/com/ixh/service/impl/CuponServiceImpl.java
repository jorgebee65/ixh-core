package com.ixh.service.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.border.DottedBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.VerticalAlignment;
import com.ixh.dao.AdvDAO;
import com.ixh.dao.CuponDAO;
import com.ixh.dao.UserDAO;
import com.ixh.exception.DatabaseExceptionCO;
import com.ixh.model.bo.AdvertiseBO;
import com.ixh.model.bo.CuponBO;
import com.ixh.model.bo.UserBO;
import com.ixh.service.CuponService;
import com.ixh.util.RandomString;

@Service
public class CuponServiceImpl implements CuponService {

	@Autowired
	private CuponDAO cuponDAO;

	@Autowired
	private AdvDAO advDAO;

	@Autowired
	private UserDAO usrDAO;

	@Override
	public CuponBO generateCupon(CuponBO pCuponBO) throws ServiceException {
		CuponBO resp = new CuponBO();
		AdvertiseBO adv = null;
		UserBO usrBO = null;
		try {
			adv = advDAO.find(pCuponBO.getAdv().getId());
			usrBO = usrDAO.find(pCuponBO.getUser().getUid());
		} catch (DatabaseExceptionCO e) {
			e.printStackTrace();
		}
		Date today = new Date();
		if (today.after(adv.getStart()) && today.before(adv.getEnds())) {
			resp.setCode(generateCode());
			resp.setAdv(adv);
			resp.setUser(usrBO);
		} else {
			throw new ServiceException("La vigencia del cupón ha caducado.");
		}
		return cuponDAO.save(resp);
	}

	private String generateCode() {
		String code = "";
		RandomString gen = new RandomString(5, ThreadLocalRandom.current());
		code = gen.nextString().toUpperCase();
		if (cuponDAO.checkAvailability(code)) {
			code = generateCode();
		}
		return code;
	}

	@Override
	public File generateFile(String psCupon) throws ServiceException {
		try {
			CuponBO cuponBO = cuponDAO.getCupon(psCupon);
			if (cuponBO != null) {
				String dest = "C:/itextExamples/" + psCupon + ".pdf";

				PdfWriter writer;

				writer = new PdfWriter(dest);

				// Creating a PdfDocument object
				PdfDocument pdfDoc = new PdfDocument(writer);

				// Creating a Document object
				Document doc = new Document(pdfDoc);

				// Creating a table
				float[] mainColumnWidths = { 500F };
				Table table = new Table(mainColumnWidths);

				float[] headerColumnWidths = { 150f, 350f };
				Table tbHeader = new Table(headerColumnWidths);

				float[] dateailsColumnWidths = { 340f };
				Table tbDetails = new Table(dateailsColumnWidths);

				float[] contentColumnWidths = { 350f, 150f };
				Table tbContent = new Table(contentColumnWidths);

				float[] dateailsColumnWidths2 = { 340f };
				Table tbDetails2 = new Table(dateailsColumnWidths2);

				// Details
				Cell cFirst = new Cell();
				cFirst.add("PUBLICOLLI");
				cFirst.setBorder(Border.NO_BORDER);
				tbDetails.addCell(cFirst);

				// Setting font of the text
				PdfFont font = PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD);
				PdfFont small = PdfFontFactory.createFont(FontConstants.COURIER);

				Cell cSecond = new Cell().add(new Paragraph(cuponBO.getAdv().getsDiscount()).setFontColor(Color.ORANGE)
						.setFontSize(50f).setFont(font));
				// cSecond.add(text1);
				cSecond.setBorder(Border.NO_BORDER);
				tbDetails.addCell(cSecond);

				Cell cThird = new Cell();
				cThird.add(cuponBO.getAdv().getTitle());
				cThird.setBorder(Border.NO_BORDER);
				tbDetails.addCell(cThird);

				// Populating row 1 and adding it to the nested table
				Cell cImage = new Cell();

				// Creating an ImageData object
				String imageFile = cuponBO.getAdv().getImage();
				ImageData data = ImageDataFactory.create(imageFile);

				// Creating the image
				Image img = new Image(data);

				cImage.add(img.setAutoScale(true));
				cImage.setBorder(Border.NO_BORDER);
				cImage.setVerticalAlignment(VerticalAlignment.MIDDLE);
				tbHeader.addCell(cImage);

				Cell cDetails = new Cell();
				cDetails.add(tbDetails);
				cDetails.setBorder(Border.NO_BORDER);
				tbHeader.addCell(cDetails);

				// Content
				Cell cContent1 = new Cell();
				// Details2
				Cell cdFirst = new Cell();
				Paragraph original = new Paragraph(cuponBO.getAdv().getsOriginalPrice()).setFont(font).setLineThrough().setFontColor(Color.GRAY);
				Paragraph newPrice = new Paragraph(cuponBO.getAdv().getsPrice()).setFont(font).setFontColor(Color.LIGHT_GRAY);
				
				cdFirst.add(original);
				cdFirst.add(newPrice);
				
				cdFirst.setBorder(Border.NO_BORDER);
				tbDetails2.addCell(cdFirst);

				Cell cdSecond = new Cell()
						.add(new Paragraph(cuponBO.getAdv().getDescription()).setFontSize(8f).setFont(small));
				cdSecond.setBorder(Border.NO_BORDER);
				tbDetails2.addCell(cdSecond);

				Cell cdThird = new Cell();
				cdThird.add(psCupon);
				cdThird.setBorder(Border.NO_BORDER);
				tbDetails2.addCell(cdThird);

				Cell cDetails2 = new Cell();
				cDetails2.add(tbDetails2);
				cDetails2.setBorder(Border.NO_BORDER);
				tbContent.addCell(cDetails2);

				Cell lastCorner = new Cell()
						.add(new Paragraph(psCupon).setFontColor(Color.DARK_GRAY).setFontSize(35f).setFont(font));
				lastCorner.setBorder(Border.NO_BORDER);
				lastCorner.setVerticalAlignment(VerticalAlignment.MIDDLE);
				tbContent.addCell(lastCorner);

				// Adding row 2 to the table
				Cell cuponDotted = new Cell();
				cuponDotted.add(tbHeader);
				cuponDotted.add(tbContent);
				cuponDotted.setBorder(new DottedBorder(Color.DARK_GRAY, 3));
				cuponDotted.setTextAlignment(TextAlignment.CENTER);
				table.addCell(cuponDotted);

				// Adding Table to document
				doc.add(table);

				// Closing the document
				doc.close();
			} else {
				throw new ServiceException("No se encontró el cupón");
			}
			return new File("C:/itextExamples/" + psCupon + ".pdf");
		} catch (DatabaseExceptionCO e) {
			throw new ServiceException("Cupon no valido", e);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
