import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.util.ArrayList;

/**
 * Created by Charles on 14/04/2017.
 */
public class Main {



    public static void main(String[]args) {
        ArrayList<String> verbes = new ArrayList<String>();
        verbes.add("murder");
        verbes.add("slay");
        verbes.add("hit");
        verbes.add("dispatch");
        verbes.add("bump off");
        verbes.add("polish off");
        verbes.add("off");
        verbes.add("remove");
        verbes.add("shoot");
        verbes.add("eliminate");
        verbes.add("decimate");
        verbes.add("wipe out");
        verbes.add("exterminate");
        verbes.add("carry off");
        verbes.add("eradicate");
        verbes.add("drown");
        verbes.add("massacre");
        verbes.add("slaughter");
        verbes.add("mow down");
        verbes.add("poison");
        verbes.add("stone");
        verbes.add("saber");
        verbes.add("sabre");
        verbes.add("asphyxiate");
        verbes.add("strangle");
        verbes.add("assassinate");
        verbes.add("execute");
        verbes.add("put to death");
        verbes.add("pip");
        verbes.add("electrocute");


        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        // Création de notre parseur via la factory
        DocumentBuilder builder = null;
        try {
            builder = factory.newDocumentBuilder();
            File fileXML = new File("td1.txt.xml");

            // parsing de notre fichier via un objet File et récupération d'un
            // objet Document
            // Ce dernier représente la hiérarchie d'objet créée pendant le parsing
            Document xml = builder.parse(fileXML);

            Element root = xml.getDocumentElement();
            //System.out.println(root.getNodeName());

            NodeList rootNoeuds = root.getChildNodes();

            for (int i = 0; i < rootNoeuds.getLength(); i++) {
                if(rootNoeuds.item(i).getNodeType() == Node.ELEMENT_NODE) {
                    Node document = rootNoeuds.item(i);
                    //System.out.println(personne.getNodeName());

                    NodeList documentNoeuds = document.getChildNodes();
                    for(int j = 0; j < documentNoeuds.getLength(); j++){

                        if(documentNoeuds.item(j).getNodeType() == Node.ELEMENT_NODE){
                            //System.out.println(documentNoeuds.item(j).getNodeName());

                            Node sentences = documentNoeuds.item(j);
                            NodeList sentencesNoeuds = sentences.getChildNodes();

                            for(int k = 0; k < sentencesNoeuds.getLength(); k++){
                                //System.out.println(sentencesNoeuds.item(k).getNodeName());

                                if(sentencesNoeuds.item(k).getNodeType() == Node.ELEMENT_NODE){
                                    Node sentence = sentencesNoeuds.item(k);
                                    NodeList sentenceNoeuds = sentence.getChildNodes();

                                    for(int l = 0 ; l < sentenceNoeuds.getLength(); l++){

                                        if(sentenceNoeuds.item(l).getNodeType() == Node.ELEMENT_NODE){
                                            //System.out.println(sentenceNoeuds.item(l).getNodeName());

                                            Node tokens = sentenceNoeuds.item(l);
                                            NodeList tokensNoeuds = tokens.getChildNodes();

                                            for(int m = 0; m < tokensNoeuds.getLength(); m++){

                                                if(tokensNoeuds.item(m).getNodeType() == Node.ELEMENT_NODE){
                                                    //System.out.println(tokensNoeuds.item(m).getNodeName());

                                                    Node token = tokensNoeuds.item(m);
                                                    NodeList tokenNoeuds = token.getChildNodes();

                                                    for(int n = 0; n < tokenNoeuds.getLength(); n++){
                                                       // System.out.println(tokensNoeuds.item(n).getNodeType());
                                                        if(tokenNoeuds.item(n).getNodeType() == Node.ELEMENT_NODE){
                                                            //System.out.println(tokenNoeuds.item(n).getNodeValue());

                                                            //PERMET DE RECUPERER LES PERSONNES
                                                            if(tokenNoeuds.item(n).getNodeName().equals("NER")){
                                                                Node word = tokenNoeuds.item(n);
                                                                if(word.getFirstChild().getNodeValue().equals("PERSON")){
                                                                   // System.out.println(word.getFirstChild().getNodeValue());
                                                                    if(tokenNoeuds.item(1).getFirstChild().getNodeValue().charAt(0)=='C'){
                                                                       // System.out.println(tokenNoeuds.item(1).getFirstChild().getNodeValue());
                                                                    }

                                                                }


                                                            }

                                                            //PERMET DE RECUPERER LES VERBES
                                                            if(tokenNoeuds.item(n).getNodeName().equals("POS")){
                                                                Node word = tokenNoeuds.item(n);
                                                                if(word.getFirstChild().getNodeValue().contains("VB")){
                                                                    // System.out.println(word.getFirstChild().getNodeValue());
                                                                    //if(verbes.contains(tokenNoeuds.item(1).getFirstChild().getNodeValue())){
                                                                        System.out.println(tokenNoeuds.item(1).getFirstChild().getNodeValue());
                                                                    //}


                                                                }


                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
