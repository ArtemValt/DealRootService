package com.example.diplom.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.xwpf.converter.pdf.PdfConverter;
import org.apache.poi.xwpf.converter.pdf.PdfOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBookmark;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class FileService {
    public void getFileWithoutBookMarks(Map<String, String> bookmarks) {
        try {
//            XWPFDocument document = new XWPFDocument();
//            runParagraphs(bookmarks, document);
//            return getNewFile(document);
            convertToPDF("/Users/belousovartem/IdeaProjects/bdcourse/Diplom/dq.docx", "/Users/belousovartem/IdeaProjects/bdcourse/Diplom/test.pdf");

        } catch (Exception e) {
            log.info(e.getLocalizedMessage());
            throw new RuntimeException();
        }
    }

    private XWPFDocument getNewFile(XWPFDocument document) throws IOException {
        writeDataToFile(document);
        return document;
    }

    private void writeDataToFile(XWPFDocument document) throws IOException {
        OutputStream out = new FileOutputStream("/Users/belousovartem/IdeaProjects/bdcourse/Diplom/dq.docx");
        document.write(out);
        document.close();
        out.close();
        convertToPDF("/Users/belousovartem/IdeaProjects/bdcourse/Diplom/dq.docx", "/Users/belousovartem/IdeaProjects/bdcourse/Diplom/test.pdf");
    }

    private void runParagraphs(Map<String, String> bookmarks, XWPFDocument document) {
        List<XWPFParagraph> paragraphs = document.getParagraphs();
        for (XWPFParagraph paragraph : paragraphs) {
            List<CTBookmark> bookmarkStartList = getCtBookmarks(paragraph);
            bookmarkStartList.forEach(bookmark -> insertValueBookmark(bookmarks, paragraph));
        }
    }

    private List<CTBookmark> getCtBookmarks(XWPFParagraph paragraph) {
        CTP ctp = paragraph.getCTP();
        return ctp.getBookmarkStartList();
    }

    private void insertValueBookmark(Map<String, String> bookmarks, XWPFParagraph paragraph) {
        String paraText = paragraph.getText();
        String replacedText = getParaBookmark(bookmarks, paraText);
        removeAllRuns(paragraph);
        insertReplacementRuns(paragraph, replacedText);
    }

    private String getParaBookmark(Map<String, String> bookmarks, String paraText) {
        String bookmarkName = StringUtils.substringBetween(paraText, "&", "&");
        return paraText.replaceAll("\\b&" + bookmarkName + "&\\b", bookmarks.get(bookmarkName));
    }

    private void convertToPDF(String docPath, String pdfPath) {
        try {
            InputStream doc = new FileInputStream(docPath);
            XWPFDocument document = new XWPFDocument(doc);
            PdfOptions options = PdfOptions.create();
            OutputStream out = new FileOutputStream(pdfPath);
            PdfConverter.getInstance().convert(document, out, options);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void removeAllRuns(XWPFParagraph paragraph) {
        int size = paragraph.getRuns().size();
        for (int i = 0; i < size; i++) {
            paragraph.removeRun(0);
        }
    }

    private void insertReplacementRuns(XWPFParagraph paragraph, String replacedText) {
        String[] replacementTextSplitOnCarriageReturn = StringUtils.split(replacedText, "\n");

        for (int j = 0; j < replacementTextSplitOnCarriageReturn.length; j++) {
            String part = replacementTextSplitOnCarriageReturn[j];

            XWPFRun newRun = paragraph.insertNewRun(j);
            newRun.setText(part);

            if (j + 1 < replacementTextSplitOnCarriageReturn.length) {
                newRun.addCarriageReturn();
            }
        }
    }

}
