package com.example.diplom.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class FileService {
    private final String PATH = "/Users/belousovartem/IdeaProjects/bdcourse/Diplom/dq12.docx";
    private final String DELIMITER = "&";

    public File getFileWithoutBookMarks(Map<String, String> bookmarks) {
        try {
            return getFile(bookmarks);
        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
            throw new RuntimeException();
        }
    }

    private File getFile(Map<String, String> bookmarks) throws IOException {
        saveFileWithBookmarks(bookmarks);
        return new File(PATH);
    }

    private void saveFileWithBookmarks(Map<String, String> bookmarks) throws IOException {
        InputStream fis = new FileInputStream(PATH);
        XWPFDocument document = new XWPFDocument(fis);
        List<XWPFParagraph> paragraphs = document.getParagraphs();
        paragraphs.forEach(paragraph -> updateParagraph(bookmarks, paragraph));
        saveDataInDoc(document);
    }

    private void updateParagraph(Map<String, String> bookmarks, XWPFParagraph paragraph) {
        paragraph.getCTP().getBookmarkStartList()
                .stream()
                .map(bookmark -> paragraph.getText())
                .forEach(paraText -> updateRowWithBookMark(bookmarks, paragraph, paraText));
    }

    private void updateRowWithBookMark(Map<String, String> bookmarks, XWPFParagraph paragraph, String paraText) {
        String replacedText = getReplacedText(bookmarks, paraText);
        removeAllRuns(paragraph);
        insertReplacementRuns(paragraph, replacedText);
    }

    private String getReplacedText(Map<String, String> bookmarks, String paraText) {
        String bookmarkName = StringUtils.substringBetween(paraText, DELIMITER, DELIMITER);
        return paraText.replaceAll(DELIMITER + bookmarkName + DELIMITER, bookmarks.get(bookmarkName));
    }

    private void saveDataInDoc(XWPFDocument document) throws IOException {
        OutputStream out = new FileOutputStream(PATH);
        document.write(out);
        document.close();
        out.close();
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
