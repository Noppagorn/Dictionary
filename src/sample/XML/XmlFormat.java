package sample.XML;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import sample.Vocabulary;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class XmlFormat {
    public void writeXML(ArrayList<Vocabulary> words) {
        try {

            DocumentBuilderFactory dFact = DocumentBuilderFactory.newInstance();
            DocumentBuilder build = null;
            try {
                build = dFact.newDocumentBuilder();
            } catch (ParserConfigurationException e) {
                e.printStackTrace();
            }
            Document doc = build.newDocument();

            Element root = doc.createElement("Dictionary");
            doc.appendChild(root);

            Element Details = doc.createElement("Details");
            root.appendChild(Details);


            for (Vocabulary dtl : words) {

                Element name = doc.createElement("Word");
                name.appendChild(doc.createTextNode(String.valueOf(dtl
                        .getWord())));
                Details.appendChild(name);

                Element mmi = doc.createElement("PartOfSpeech");
                mmi.appendChild(doc.createTextNode(String.valueOf(dtl.getPartOfSpeech())));
                Details.appendChild(mmi);


                Element id = doc.createElement("Meaning");
                id.appendChild(doc.createTextNode(String.valueOf(dtl.getMeaning())));
                Details.appendChild(id);

                Element example = doc.createElement("Example");
                example.appendChild(doc.createTextNode(String.valueOf(dtl.getExample())));
                Details.appendChild(example);

            }

            // Save the document to the disk file
            TransformerFactory tranFactory = TransformerFactory.newInstance();
            Transformer aTransformer = tranFactory.newTransformer();

            // format the XML nicely
            aTransformer.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1");

            aTransformer.setOutputProperty(
                    "{http://xml.apache.org/xslt}indent-amount", "4");
            aTransformer.setOutputProperty(OutputKeys.INDENT, "yes");

            DOMSource source = new DOMSource(doc);
            try {
                // location and name of XML file you can change as per need
                FileWriter fos = new FileWriter("src/sample/DataBase/xmlFormat.xml");
                StreamResult result = new StreamResult(fos);
                aTransformer.transform(source, result);

            } catch (IOException e) {

                e.printStackTrace();
            }

        } catch (TransformerException ex) {
            System.out.println("Error outputting document");

        }
    }
}
