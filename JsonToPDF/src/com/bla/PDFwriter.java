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
  private PDFont pdfFont = PDType1Font.HELVETICA;
  private float fontSize = 12;
  private float leading = 1.5f * fontSize;
  private float margin = 35;
  private List<String> lines = new ArrayList<>();
  private String text = "";

  public void createPDF() throws Exception {
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

      text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam non arcu nec lorem rhoncus fringilla sit amet vitae sapien. Donec a elementum sem. Etiam porttitor feugiat nunc, ut dapibus magna dictum eu. Maecenas tempor nunc diam, ut cursus nisi accumsan eu. Cras rutrum nunc eget mi faucibus, non efficitur arcu elementum. Etiam ac elit sed augue dictum tincidunt sed sed sem. Phasellus leo sem, tincidunt id condimentum et, tempus vel nulla. Fusce malesuada eu nisi non viverra. Quisque sit amet eleifend ante. Nullam sit amet euismod ex. Vivamus quis iaculis ex.";
      addLines(width);
      addBreak();
      text = "Vivamus sed eleifend dolor, ut pulvinar odio. Aenean faucibus a lectus et euismod. Nullam in sapien eros. Aliquam eget lacinia neque. Praesent vel libero at eros molestie placerat. Curabitur id aliquam ligula. Sed sed felis malesuada massa blandit molestie. Aenean nisi ligula, mattis et auctor vitae, sagittis sit amet metus. Aliquam a mauris ac ipsum vulputate lobortis. Nam bibendum odio felis, vel eleifend odio dignissim et. Sed non efficitur nibh. Aenean a bibendum nisi, et iaculis mauris. Duis eu tincidunt mi, vitae aliquam mauris. In tristique id ipsum et bibendum. Morbi ornare, erat sit amet ornare luctus, ante justo tincidunt lorem, ac porttitor ligula lectus feugiat lorem.";
      addLines(width);
      addBreak();
      text = "Praesent lacinia ultricies leo nec dictum. Sed sollicitudin lacus dolor, sit amet consequat risus vulputate vitae. Quisque laoreet nisl metus, nec auctor felis interdum ac. Integer eros erat, gravida sit amet sem et, consequat iaculis diam. Suspendisse convallis nibh ac blandit ullamcorper. Nunc cursus orci est, sit amet imperdiet tellus hendrerit consequat. Nunc sit amet accumsan dui, at rutrum urna.";
      addLines(width);

      contentStream.beginText();
      contentStream.setFont(pdfFont, fontSize);
      contentStream.newLineAtOffset(startX, startY);
      for (String line : lines) {
        contentStream.showText(line);
        contentStream.newLineAtOffset(0, -leading);
      }
      contentStream.endText();
      contentStream.close();

      doc.save(new File(RESULT_FOLDER, "example.pdf"));
    } finally {
      if (doc != null) {
        doc.close();
      }
    }
  }

  public void addLines(float width) throws Exception {
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

  public void addBreak() throws Exception {
    lines.add("");
  }

}
