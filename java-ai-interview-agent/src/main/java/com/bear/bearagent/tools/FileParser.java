package com.bear.bearagent.tools;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class FileParser {

    public static String parseWord(InputStream inputStream) throws IOException {
        XWPFDocument document = new XWPFDocument(inputStream);
        StringBuilder text = new StringBuilder();
        List<XWPFParagraph> paragraphs = document.getParagraphs();
        for (XWPFParagraph paragraph : paragraphs) {
            text.append(paragraph.getText()).append("\n");
        }
        document.close();
        return text.toString();
    }

    public static String parsePDF(InputStream inputStream) throws IOException {
        PDDocument document = PDDocument.load(inputStream);
        PDFTextStripper stripper = new PDFTextStripper();
        String text = stripper.getText(document);
        document.close();
        return text;
    }



}
