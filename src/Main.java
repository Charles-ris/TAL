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
        verbes.add("kill");
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
        verbes.add("attack");

        ArrayList<String> nomsV = new ArrayList<String>();
        nomsV.add("kill");
        nomsV.add("deathblow");
        nomsV.add("murder");
        nomsV.add("homicide");
        nomsV.add("death");
        nomsV.add("assassination");
        nomsV.add("kill");

        ArrayList<String> nomsA = new ArrayList<String>();
        nomsA.add("murderer");
        nomsA.add("assassin");
        nomsA.add("assassinator");
        nomsA.add("butcher");
        nomsA.add("cutthroat");
        nomsA.add("fratricide");
        nomsA.add("infanticide");
        nomsA.add("serial killer");
        nomsA.add("liquidator");
        nomsA.add("man slayer");



        boolean boolverbe=false;
        boolean boolnom=false;


        int id=-1;
        String test ="";
        Boolean stop= false;
        Boolean stop1=false;
        Boolean stop2 = false;
        Boolean stop3 = false;
        int numl=0;

        ArrayList<Integer> compteur = new ArrayList<Integer>();
        int pages = 0;
        boolean first = true;
        boolean tmp = true;
        boolean bkiller =false;
        ArrayList<String> person = new ArrayList<String>();
        String killer="";

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        // Création de notre parseur via la factory
        DocumentBuilder builder = null;
        try {
            builder = factory.newDocumentBuilder();
            File fileXML = new File("td3.txt.xml");

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
                                                        if(tokenNoeuds.item(n).getNodeType() == Node.ELEMENT_NODE) {
                                                        }
                                                        if(tokenNoeuds.item(1).getFirstChild().getNodeValue().equals("***")){
                                                            //nouvelle page
                                                            pages+=1;
                                                            first=true;
                                                            tmp = true;
                                                            bkiller=false;

                                                        }

                                                        if(tokenNoeuds.item(n).getNodeName().equals("NER")){
                                                            Node word = tokenNoeuds.item(n);
                                                            if(!tmp && first){
                                                                if(!word.getFirstChild().getNodeValue().equals("PERSON") && !word.getFirstChild().getNodeValue().equals("O")){
                                                                    first=false;
                                                                    if(bkiller){
                                                                        person.add(killer);
                                                                        compteur.add(pages);
                                                                        id+=1;
                                                                        stop=true;
                                                                        //System.out.println(killer);
                                                                    }
                                                                    killer="";
                                                                }
                                                            }
                                                            if((word.getFirstChild().getNodeValue().equals("PERSON") ||
                                                                    tokenNoeuds.item(9).getFirstChild().getNodeValue().equals("``") ||
                                                                    tokenNoeuds.item(9).getFirstChild().getNodeValue().equals("\'\'") ||
                                                                    tokenNoeuds.item(9).getFirstChild().getNodeValue().equals("FW") ||
                                                                    tokenNoeuds.item(9).getFirstChild().getNodeValue().equals("NNP")) &&
                                                                    first){
                                                                //Si c'est une personne ou un caractère spécial ("" pour preceder des surnoms par exemple)
                                                                //Si c'est la premiere personne citée de la page
                                                                if(tokenNoeuds.item(1).getFirstChild().getNodeValue().charAt(0)=='C') {
                                                                    bkiller = true;
                                                                }
                                                                killer += tokenNoeuds.item(1).getFirstChild().getNodeValue()+" ";
                                                                tmp =false;
                                                            }



                                                            if(stop){
                                                                for(int m1 = 0; m1 < tokensNoeuds.getLength() ; m1++){
                                                                    if(tokensNoeuds.item(m1).getNodeType() == Node.ELEMENT_NODE) {
                                                                        Node token1 = tokensNoeuds.item(m1);
                                                                        NodeList tokenNoeuds1 = token1.getChildNodes();

                                                                        for(int n1 = 0; n1 < tokenNoeuds1.getLength(); n1++){
                                                                            if(tokenNoeuds1.item(n1).getNodeName().equals("lemma")){
                                                                                if(!tokenNoeuds1.item(1).getFirstChild().getNodeValue().equals("***") &&
                                                                                        (tokenNoeuds1.item(9).getFirstChild().getNodeValue().equals("VB") ||
                                                                                        tokenNoeuds1.item(9).getFirstChild().getNodeValue().equals("VBG") ||
                                                                                        tokenNoeuds1.item(9).getFirstChild().getNodeValue().equals("VBD")) ){
                                                                                   // System.out.println("\n"+tokenNoeuds1.item(3).getFirstChild().getNodeValue()+"");
                                                                                    if(verbes.contains(tokenNoeuds1.item(3).getFirstChild().getNodeValue())) {
                                                                                        test = person.get(id)+" "+tokenNoeuds1.item(1).getFirstChild().getNodeValue();
                                                                                        //System.out.println(test);
                                                                                        person.remove(id);
                                                                                        person.add(test);
                                                                                        stop1=true;

                                                                                    }


                                                                                    //System.out.println("oui");
                                                                                }

                                                                            }
                                                                        }

                                                                        //System.out.print(tokenNoeuds1.item(1).getFirstChild().getNodeValue()+" ");
                                                                    }
                                                                }
                                                                //fin de phrase
                                                                System.out.println("");
                                                                test="";
                                                                stop=false;
                                                            }

                                                            if(stop1){
                                                                for(int m1 = 0; m1 < tokensNoeuds.getLength() ; m1++){
                                                                    if(tokensNoeuds.item(m1).getNodeType() == Node.ELEMENT_NODE) {

                                                                        Node token1 = tokensNoeuds.item(m1);
                                                                        NodeList tokenNoeuds1 = token1.getChildNodes();
                                                                        for(int n1 = 0; n1 < tokenNoeuds1.getLength(); n1++){
                                                                            if(tokenNoeuds1.item(n1).getNodeName().equals("POS")){

                                                                                if((tokenNoeuds1.item(n1).getFirstChild().getNodeValue().equals("NNP") || tokenNoeuds1.item(n1).getFirstChild().getNodeValue().equals("NNPS"))
                                                                                        && tokenNoeuds1.item(11).getFirstChild().getNodeValue().equals("PERSON")){
                                                                                    //Victime

                                                                                } else {
                                                                                    if(tokenNoeuds1.item(n1).getFirstChild().getNodeValue().equals("PRP$")){
                                                                                        //System.out.println(tokenNoeuds1.item(1).getFirstChild().getNodeValue()+" "+tokensNoeuds.item(m1+1).getChildNodes().item(1).getFirstChild().getNodeValue());
                                                                                    }
                                                                                }

                                                                            }
                                                                        }
                                                                        System.out.print(tokenNoeuds1.item(1).getFirstChild().getNodeValue()+" ");;
                                                                    }
                                                                }
                                                                stop1=false;
                                                               // System.out.println("\n"+person.get(id));
                                                                System.out.println("");
                                                                System.out.println("");
                                                            }




                                                        }

                                                        //if(tokenNoeuds.item(9).getNodeValue().equals("PERSON") && tokenNoeuds.item(1).getFirstChild().getNodeValue().charAt(0)=='C'){
                                                          //  System.out.println(tokenNoeuds.item(1).getFirstChild().getNodeValue());
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

            for (int i=0;i<person.size();i++){
                //System.out.println(person.get(i));
            }
            for (int i=0;i<compteur.size();i++){
                //System.out.println(compteur.get(i));
            }
        //System.out.println(pages);
        //System.out.println(person.size());
            //System.out.print(person.get(0));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
