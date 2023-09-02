import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class DadosPassageirosExtractor {
    public static void main(String[] args) {
        try {
            
            File xmlFile = new File("passageiros.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);

            
            NodeList passageirosList = document.getElementsByTagName("passageiro");

           
            System.out.println("Número de Passageiros: " + passageirosList.getLength());

           
            for (int i = 0; i < passageirosList.getLength(); i++) {
                Node passageiroNode = passageirosList.item(i);

                if (passageiroNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element passageiroElement = (Element) passageiroNode;

                    String origem = passageiroElement.getElementsByTagName("origem").item(0).getTextContent();
                    String destino = passageiroElement.getElementsByTagName("destino").item(0).getTextContent();

                    System.out.println("Passageiro " + (i + 1) + ": Origem: " + origem + ", Destino: " + destino);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}