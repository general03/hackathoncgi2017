package com.cgi.hackathon.service;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.kernel.events.Event;
import com.itextpdf.kernel.events.IEventHandler;
import com.itextpdf.kernel.events.PdfDocumentEvent;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.layout.Document;

import java.io.IOException;

/**
 * Created by guelerauda on 23/06/2017.
 */
public class TextFooterEventHandler implements IEventHandler {

    protected Document document;
    public TextFooterEventHandler(Document doc) {
        this.document = doc;
    }

    @Override
    public void handleEvent(Event event) {
        PdfDocumentEvent docEvent = (PdfDocumentEvent) event;
        PdfCanvas canvas = new PdfCanvas(docEvent.getPage());
        Rectangle pageSize = docEvent.getPage().getPageSize();
        canvas.beginText();
        try {
            canvas.setFontAndSize(PdfFontFactory.createFont(FontConstants.HELVETICA_OBLIQUE), 8);
        } catch (IOException e) {
            e.printStackTrace();
        }

        canvas
            .moveText(document.getLeftMargin() + 115, 20)
            .showText("L'information sur cette application est fournie à titre d'information seulement")
            .moveText(-30, - 10)
            .showText("et elle ne peut, en aucun cas, remplacer un avis médical professionnel ou d'un ophtalmologue.")
            .endText()
            .release();
    }
}
