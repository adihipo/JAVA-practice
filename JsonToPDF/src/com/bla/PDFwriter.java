package com.bla;


import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

//PDFBOX-ot le kellett tölteni hozzá. External lib. Ilyesmi nélkül kurvára nehéz...
public class PDFwriter {

  private final String RESULT_FOLDER = "C:\\Users\\Adi\\Desktop";
  private final String FILE_NAME = "example.pdf";
  private PDFont pdfFont = PDType1Font.HELVETICA;
  private float fontSize = 12;
  private float leading = 1.5f * fontSize;
  private float margin = 35;
  private List<String> lines = new ArrayList<>();

  public void createPDF(String[] paragraphs) throws Exception {
    PDDocument doc = null;
    try {
      doc = new PDDocument();
      PDPage page = new PDPage();
      doc.addPage(page);
      PDPageContentStream contentStream = new PDPageContentStream(doc, page);

      PDRectangle mediabox = page.getMediaBox();
      float width = mediabox.getWidth() - 2 * margin;
      float startX = mediabox.getLowerLeftX() + margin;
      float startY = mediabox.getUpperRightY() - margin;

      buildPage(paragraphs, width);

      contentStream.beginText();
      contentStream.setFont(pdfFont, fontSize);
      contentStream.newLineAtOffset(startX, startY);
      for (String line : lines) {
        contentStream.showText(line);
        contentStream.newLineAtOffset(0, -leading);
      }
      contentStream.endText();
      contentStream.close();

      doc.save(new File(RESULT_FOLDER, FILE_NAME));
    } finally {
      if (doc != null) {
        doc.close();
      }
    }
  }

  public void addLines(String text, float width) throws Exception {
    int lastSpace = -1;
    while (text.length() > 0) {
      int spaceIndex = text.indexOf(' ', lastSpace + 1);
      if (spaceIndex < 0)
        spaceIndex = text.length();
      String subString = text.substring(0, spaceIndex);
      float size = fontSize * pdfFont.getStringWidth(subString) / 1000;
      if (size > width) {
        if (lastSpace < 0)
          lastSpace = spaceIndex;
        subString = text.substring(0, lastSpace);
        lines.add(subString);
        text = text.substring(lastSpace).trim();
        lastSpace = -1;
      } else if (spaceIndex == text.length()) {
        lines.add(text);
        text = "";
      } else {
        lastSpace = spaceIndex;
      }
    }
  }

  public void addBreak() {
    lines.add("");
  }

  public void buildPage(String[] paragraphs, float width) throws Exception{
    addLines(paragraphs[0], width);
    for (int i = 1; i < paragraphs.length; i++) {
      addBreak();
      addLines(paragraphs[i], width);
    }
  }

}
