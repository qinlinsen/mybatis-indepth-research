package com.timo.xml;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.*;
import java.io.File;

/**
 * @author Abraham Qin
 * @since 2018/11/11
 */
public class ParseXmlTest {
    private static final String XPath_EXPRESSION = "//book[price>40]/title/text()|//book[price>40]/@*";
    public static void main(String[] args) throws Exception {

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        //开启验证：
        documentBuilderFactory.setValidating(true);
        documentBuilderFactory.setNamespaceAware(false);
        documentBuilderFactory.setIgnoringComments(true);
        documentBuilderFactory.setIgnoringElementContentWhitespace(true);
        documentBuilderFactory.setCoalescing(false);
        documentBuilderFactory.setExpandEntityReferences(true);
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        //设置异常处理：
        documentBuilder.setErrorHandler(new ErrorHandler() {
            @Override
            public void warning(SAXParseException exception) throws SAXException {
                System.out.println("warn:" + exception.getMessage());
            }

            @Override
            public void error(SAXParseException exception) throws SAXException {
                System.out.println("error:" + exception.getMessage());
            }

            @Override
            public void fatalError(SAXParseException exception) throws SAXException {
                System.out.println("fatalError:" + exception.getMessage());
            }
        });
        //将test.xml加载到一个Document的对象中：
        String filePath = "E:\\mybatis-indepth-research\\mybatis-3\\src\\main\\java\\com\\timo\\xml\\test.xml";
        Document document = documentBuilder.parse(new File(filePath));
        //查询author为洪应明的title：

        processParseXmlWithXpath(document,XPath_EXPRESSION );
    }

    private static void processParseXmlWithXpath(Document document, String xPathExpression) throws Exception {
        //创建XPathFactory:
        XPathFactory xPathFactory = XPathFactory.newInstance();
        XPath xPath = xPathFactory.newXPath();
        XPathExpression expression = xPath.compile(xPathExpression);
        Object result = expression.evaluate(document, XPathConstants.NODESET);
        if (result instanceof NodeList) {
            NodeList nodes = (NodeList) result;
            for (int i = 0; i < nodes.getLength(); i++) {
                System.out.println(String.format("%s=%s", nodes.item(i).getNodeName(), nodes.item(i).getNodeValue()));
            }
        }
    }
}
