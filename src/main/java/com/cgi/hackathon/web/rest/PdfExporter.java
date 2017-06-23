package com.cgi.hackathon.web.rest;

import com.cgi.hackathon.domain.*;
import com.cgi.hackathon.service.MailService;
import com.cgi.hackathon.service.TextFooterEventHandler;
import com.google.common.collect.Lists;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.events.PdfDocumentEvent;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.element.*;
import com.itextpdf.layout.property.HorizontalAlignment;
import com.itextpdf.layout.property.VerticalAlignment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Created by guelerauda on 22/06/2017.
 */
@RestController
@RequestMapping("/pdfexport")
public class PdfExporter {

    @Autowired
    private MailService mailService;

    private final Logger log = LoggerFactory.getLogger(PdfExporter.class);

    public static final String LOGO = "src/main/webapp/content/images/logo.png";
    public static final String RACINE_PHOTO = "src/main/webapp";


    public byte[] createPdf(Pathogene bacterienne) throws IOException {
        ByteArrayOutputStream pdf = new ByteArrayOutputStream();

        //Parameters
        Float headerSize = 45f;
        Float titleSize = 20f;

        //Open Document
        PdfDocument pdfDocument = new PdfDocument(new PdfWriter(pdf));
        Document document = new Document(pdfDocument, PageSize.A4);
        pdfDocument.addEventHandler(PdfDocumentEvent.END_PAGE, new TextFooterEventHandler(document));

        //Header
        Image image = new Image(ImageDataFactory.create(LOGO));
        Table header = new Table(5);
        header.setMarginBottom(15);
        header.setBorder(Border.NO_BORDER);

        Cell imageCell = new Cell();
        imageCell.add(image.setAutoScale(true));
        imageCell.setHeight(headerSize);
        imageCell.setBorder(Border.NO_BORDER);
        header.addCell(imageCell);

        Cell nomPathogeneCell = new Cell(1, 4);
        nomPathogeneCell.add(bacterienne.getNom());
        nomPathogeneCell.setHeight(headerSize);
        nomPathogeneCell.setFontSize(25);
        nomPathogeneCell.setHorizontalAlignment(HorizontalAlignment.CENTER);
        nomPathogeneCell.setVerticalAlignment(VerticalAlignment.MIDDLE);
        nomPathogeneCell.setBorder(Border.NO_BORDER);
        header.addCell(nomPathogeneCell);

        document.add(header);

        //Symptomes
        document.add(new Paragraph("Symptomes").setFontSize(titleSize));

        Table symptomeTable = new Table(2);
        symptomeTable.setBorder(Border.NO_BORDER);

        Cell symptomeTextCell = new Cell();
        List symptomesList = new List();
        bacterienne.getSymptomes().forEach(s -> symptomesList.add(new ListItem(s)));
        symptomeTextCell.add(symptomesList);
        symptomeTextCell.setBorder(Border.NO_BORDER);
        symptomeTextCell.setVerticalAlignment(VerticalAlignment.MIDDLE);
        symptomeTable.addCell(symptomeTextCell);

        Cell symptomeImageCell = new Cell();
        Image symptome = new Image(ImageDataFactory.create(RACINE_PHOTO + bacterienne.getUrlImage()));
        symptomeImageCell.add(symptome.setWidthPercent(75));
        symptomeImageCell.setBorder(Border.NO_BORDER);
        symptomeTable.addCell(symptomeImageCell);

        document.add(symptomeTable);

        //Conduite
        document.add(new Paragraph("Conduite a tenir").setFontSize(titleSize));

        Table conduiteTable = new Table(2);
        conduiteTable.setBorder(Border.NO_BORDER);

        Cell conduiteTextCell = new Cell();
        List conduiteList = new List();
        bacterienne.getConduites().forEach(s -> conduiteList.add(new ListItem(s)));
        conduiteTextCell.add(conduiteList);
        conduiteTextCell.setBorder(Border.NO_BORDER);
        conduiteTextCell.setVerticalAlignment(VerticalAlignment.MIDDLE);
        conduiteTable.addCell(conduiteTextCell);

        document.add(conduiteTable);

        //Close document
        document.close();

        return pdf.toByteArray();
    }

    @RequestMapping(value = "/{namePatho}", method = RequestMethod.GET)
    public ResponseEntity<InputStreamResource> generatePdf(@PathVariable("namePatho") String namePatho) throws IOException {
        Pathogene pathogene;
        if("ConjonctiviteBacterienne".equalsIgnoreCase(namePatho)) {
            pathogene = new ConjonctiviteBacterienne();
        } else if ("ConjonctiviteVirale".equalsIgnoreCase(namePatho)) {
            pathogene = new ConjonctiviteVirale();
        } else if ("ConjonctiviteAllergique".equalsIgnoreCase(namePatho)) {
            pathogene = new ConjonctiviteAllergique();
        } else if ("FragiliteCapillaireConjonctivale".equalsIgnoreCase(namePatho)) {
            pathogene = new FragiliteCapillaireConjonctivale();
        } else if ("SecheresseOculaire".equalsIgnoreCase(namePatho)) {
            pathogene = new SecheresseOculaire();
        } else if ("IrritationConjonctivaleChroniqueNonInfectieuse".equalsIgnoreCase(namePatho)) {
            pathogene = new IrritationConjonctivaleChroniqueNonInfectieuse();
        } else {
            pathogene = new Pathogene();
        }
        return ResponseEntity
            .ok()
            .contentType(MediaType.APPLICATION_PDF)
            .body(new InputStreamResource(new ByteArrayInputStream(createPdf(pathogene))));
    }

    @RequestMapping(value = "/mailExample", method = RequestMethod.GET)
    public Boolean sendEmail() throws IOException {
        mailService.sendEmailWithPdf("antoine.gueleraud@gmail.com", "Report", "content", true, false, createPdf(new ConjonctiviteAllergique()));
        return true;
    }
}
