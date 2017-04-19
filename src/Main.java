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
        //verbes.add("hit");
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
        nomsV.add("lynching");

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
        Boolean complet = false;
        Boolean stop= false;
        Boolean stop1=false;
        Boolean stop2 = false;
        Boolean stop3 = false;
        Boolean stop4 = false;
        Boolean stop5 = false;
        Boolean stop6 = false;
        Boolean stop7 = false;
        Boolean stop8 = false;
        Boolean bdate=false;
        Boolean blieu=false;
        Boolean suivant=false;
        Boolean victime=false;
        int tmp1=0;
        int tmp2=0;
        int tmp3=0;
        int numl=0;
        int tmp4=0;
        int comptV=0;

        String s="";


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
                                                            complet=false;
                                                            stop1=false;
                                                            stop2=false;
                                                            stop3=false;
                                                            stop4=false;
                                                            stop5=false;
                                                            stop6=false;
                                                            stop7=false;
                                                            stop8=false;
                                                            suivant=false;
                                                            victime=false;
                                                            tmp3=0;
                                                            if(s.length()>0){
                                                               // System.out.println("");
                                                                //System.out.println();
                                                                System.out.println("- "+s);
                                                                System.out.println("");
                                                                //System.out.println("");
                                                            }
                                                            s="";
                                                        }

                                                        //Si le meutrier n'a pas été trouvé
                                                        if(!complet) {

                                                            if (tokenNoeuds.item(n).getNodeName().equals("NER")) {
                                                                Node word = tokenNoeuds.item(n);

                                                                if (!tmp && first) {
                                                                    if ((!word.getFirstChild().getNodeValue().equals("PERSON") && !word.getFirstChild().getNodeValue().equals("O")) ||
                                                                            tokenNoeuds.item(9).getFirstChild().getNodeValue().contains("VB")) {
                                                                        first = false;
                                                                        if (bkiller) {
                                                                            s+=killer+" ";
                                                                            person.add(killer);
                                                                            compteur.add(pages);
                                                                            id += 1;
                                                                            stop = true;
                                                                            //System.out.println(killer);
                                                                            suivant=true;
                                                                        }
                                                                        killer = "";
                                                                    }
                                                                }

                                                                //Si le mot correspond à une personne ou apostrophe et que c'est la premiere personne cité
                                                                if ((word.getFirstChild().getNodeValue().equals("PERSON") ||
                                                                        tokenNoeuds.item(9).getFirstChild().getNodeValue().equals("``") ||
                                                                        tokenNoeuds.item(9).getFirstChild().getNodeValue().equals("\'\'") ||
                                                                        tokenNoeuds.item(9).getFirstChild().getNodeValue().equals("FW") ||
                                                                        tokenNoeuds.item(9).getFirstChild().getNodeValue().equals("NNP")) &&
                                                                        first) {
                                                                    //Si le mot commence par la lettre C (lettre du groupe)
                                                                    if (tokenNoeuds.item(1).getFirstChild().getNodeValue().charAt(0) == 'C') {
                                                                        //alors le tueur est un tueur que l'on recherche
                                                                        bkiller = true;
                                                                    }
                                                                    //on recupere le tueur
                                                                    killer += tokenNoeuds.item(1).getFirstChild().getNodeValue() + " ";
                                                                    tmp = false;
                                                                }


                                                                //Si le meurtrier est trouvé
                                                                if (stop) {
                                                                    //Recupere la premiere phrase
                                                                    for (int m1 = 0; m1 < tokensNoeuds.getLength(); m1++) {
                                                                        if (tokensNoeuds.item(m1).getNodeType() == Node.ELEMENT_NODE) {
                                                                            Node token1 = tokensNoeuds.item(m1);
                                                                            NodeList tokenNoeuds1 = token1.getChildNodes();

                                                                            for (int n1 = 0; n1 < tokenNoeuds1.getLength(); n1++) {
                                                                                if (tokenNoeuds1.item(n1).getNodeName().equals("lemma")) {

                                                                                    //Si il y a un verbe "direct"
                                                                                    if (!tokenNoeuds1.item(1).getFirstChild().getNodeValue().equals("***") &&
                                                                                            (tokenNoeuds1.item(9).getFirstChild().getNodeValue().equals("VB") ||
                                                                                                    tokenNoeuds1.item(9).getFirstChild().getNodeValue().equals("VBG") ||
                                                                                                    tokenNoeuds1.item(9).getFirstChild().getNodeValue().equals("VBD"))) {
                                                                                        //Si le mot est un verbe

                                                                                        if (verbes.contains(tokenNoeuds1.item(3).getFirstChild().getNodeValue())) {
                                                                                            //si le verbe est dans la liste
                                                                                            //System.out.println(test);
                                                                                           // s+=tokenNoeuds1.item(1).getFirstChild().getNodeValue()+" ";
                                                                                            stop1 = true;
                                                                                            tmp1 = m1;
                                                                                            stop1 = true;
                                                                                            //System.out.println(tokenNoeuds1.item(1).getFirstChild().getNodeValue());
                                                                                            s+= "killed ";
                                                                                            //System.out.println("bingo");
                                                                                        }
                                                                                    }else{
                                                                                        if(nomsV.contains(tokenNoeuds1.item(3).getFirstChild().getNodeValue())){
                                                                                            //Si le mot est dans la liste nomsV
                                                                                           //* System.out.println("\n  NN   " + tokenNoeuds1.item(1).getFirstChild().getNodeValue());
                                                                                            tmp1 = m1;
                                                                                            stop1 = true;
                                                                                            //s+="commit a "+tokenNoeuds1.item(1).getFirstChild().getNodeValue()+" ";
                                                                                            s+= "killed ";
                                                                                            //System.out.println("bingo2");
                                                                                        }else{
                                                                                            if(nomsA.contains(tokenNoeuds1.item(3).getFirstChild().getNodeValue())){
                                                                                                //Si le mot est dans la liste nomsV
                                                                                                //System.out.println("\n  NN   " + tokenNoeuds1.item(1).getFirstChild().getNodeValue());
                                                                                                tmp1 = m1;
                                                                                                stop1 = true;
                                                                                                //s+="was a "+tokenNoeuds1.item(1).getFirstChild().getNodeValue()+" ";
                                                                                                s+= "killed ";
                                                                                                //System.out.println("bingo3");
                                                                                            }else{
                                                                                                //Si il y a un verbe voix passive
                                                                                                if (!tokenNoeuds1.item(1).getFirstChild().getNodeValue().equals("***") &&
                                                                                                        tokenNoeuds1.item(9).getFirstChild().getNodeValue().equals("VBN")) {
                                                                                                    if (verbes.contains(tokenNoeuds1.item(3).getFirstChild().getNodeValue())) {
                                                                                                        //Si le verbe est dans la liste
                                                                                                        //System.out.println("\n  VBN   " + tokenNoeuds1.item(1).getFirstChild().getNodeValue());
                                                                                                        //Cas Particulier
                                                                                                        stop1 = true;
                                                                                                        //System.out.println("bingo1");
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                                //fin de for
                                                                                if(stop1){
                                                                                    break;
                                                                                }
                                                                            }

                                                                            //*System.out.print(tokenNoeuds1.item(1).getFirstChild().getNodeValue() + " ");
                                                                        }
                                                                    }
                                                                    //fin de phrase
                                                                    //System.out.println("");
                                                                    test = "";
                                                                    stop = false;

                                                                    //Si pas d'action trouvé
                                                                }

                                                                //si mot en rapport avec le meurtre
                                                                if (stop1) {
                                                                    //Si on a un mot en rapport avec le meurtre on cherche dans cette phrase sinon on passe au prochain meutrier
                                                                    complet=true;


                                                                    //System.out.println(tmp1);

                                                                    //On parcourt la phrase à partir de ce mot
                                                                    for (int m1 = tmp1; m1 < tokensNoeuds.getLength(); m1++) {
                                                                        if (tokensNoeuds.item(m1).getNodeType() == Node.ELEMENT_NODE) {
                                                                            tmp3+=1;
                                                                            Node token1 = tokensNoeuds.item(m1);
                                                                            NodeList tokenNoeuds1 = token1.getChildNodes();
                                                                            for (int n1 = 0; n1 < tokenNoeuds1.getLength(); n1++) {
                                                                                if (tokenNoeuds1.item(n1).getNodeName().equals("POS")) {

                                                                                    //Si on trouve un nom propre après le mot en rapport avec le meurtre
                                                                                    if ((tokenNoeuds1.item(n1).getFirstChild().getNodeValue().equals("NNP") || tokenNoeuds1.item(n1).getFirstChild().getNodeValue().equals("NNPS"))
                                                                                            && tokenNoeuds1.item(11).getFirstChild().getNodeValue().equals("PERSON")) {
                                                                                        //Victime Nom Propre
                                                                                        //System.out.println("VICTIMEp : "+tokenNoeuds1.item(1).getFirstChild().getNodeValue());
                                                                                        victime = true;
                                                                                        s+=tokenNoeuds1.item(1).getFirstChild().getNodeValue() +" ";


                                                                                    } else {

                                                                                        //Si on trouve un pronom possessif
                                                                                        //System.out.println("PRP :  "+tmp3);
                                                                                        if (tokenNoeuds1.item(n1).getFirstChild().getNodeValue().equals("PRP$") && tmp3<4) {
                                                                                            //Victime nom commun
                                                                                            stop2 = true;
                                                                                            //s+=tokenNoeuds1.item(1).getFirstChild().getNodeValue() +" ";
                                                                                            victime=true;
                                                                                        }

                                                                                    }

                                                                                }
                                                                            }

                                                                            //*System.out.print(tokenNoeuds1.item(1).getFirstChild().getNodeValue() + " ");

                                                                            //Si on a trouvé un pronom possessif
                                                                            if (stop2) {
                                                                                //on cherche le nom qui suit
                                                                                //On vérifie que c'est bien un nom ou un nombre ou un "and"
                                                                                if ((tokenNoeuds1.item(9).getFirstChild().getNodeValue().equals("PRP$") ||
                                                                                        tokenNoeuds1.item(9).getFirstChild().getNodeValue().equals("NN") ||
                                                                                        tokenNoeuds1.item(9).getFirstChild().getNodeValue().equals("NNS") ||
                                                                                        tokenNoeuds1.item(9).getFirstChild().getNodeValue().equals("CD") ||
                                                                                        tokenNoeuds1.item(9).getFirstChild().getNodeValue().equals("CC"))
                                                                                        && !stop4){
                                                                                    //On ajoute à la liste des victime
                                                                                    //System.out.println("VICTIME c :"+tokenNoeuds1.item(1).getFirstChild().getNodeValue());
                                                                                    s+=tokenNoeuds1.item(1).getFirstChild().getNodeValue() +" ";

                                                                                } else {
                                                                                    //Sinon on arrete de cherche les victimes
                                                                                    stop4 = true;
                                                                                }
                                                                            }
                                                                            if(tokenNoeuds1.item(1).getFirstChild().getNodeValue().contains(".")){
                                                                                break;
                                                                            }
                                                                        }
                                                                    }
                                                                    if(!victime){
                                                                        s+="someone ";
                                                                        victime=false;
                                                                    }
                                                                    tmp3=0;
                                                                    //fin for

                                                                    //on cherche la date est le lieu
                                                                    for (int m1 = tmp1; m1 < tokensNoeuds.getLength(); m1++) {
                                                                        if (tokensNoeuds.item(m1).getNodeType() == Node.ELEMENT_NODE) {
                                                                            Node token1 = tokensNoeuds.item(m1);
                                                                            NodeList tokenNoeuds1 = token1.getChildNodes();
                                                                            if(!stop5){
                                                                                if(tokenNoeuds1.item(1).getFirstChild().getNodeValue().contains(",") ||
                                                                                        tokenNoeuds1.item(1).getFirstChild().getNodeValue().contains(".")   ){
                                                                                    stop5=true;
                                                                                }else{
                                                                                    //Si il y a une date dans la phrase en rapport avec le meurtre
                                                                                    if (tokenNoeuds1.item(11).getFirstChild().getNodeValue().equals("DATE") && !stop3) {
                                                                                        //On la recupere
                                                                                        //System.out.println("DATE : "+tokenNoeuds1.item(13).getFirstChild().getNodeValue());
                                                                                        s+="in "+tokenNoeuds1.item(1).getFirstChild().getNodeValue() +" ";
                                                                                        stop3=true;
                                                                                    }


                                                                                    //Si il y a un Lieu LOCATION dans la phrase en rapport avec le meurtre
                                                                                    if (tokenNoeuds1.item(11).getFirstChild().getNodeValue().equals("LOCATION")) {
                                                                                        //On la recupere
                                                                                        //System.out.println("LIEU : "+tokenNoeuds1.item(1).getFirstChild().getNodeValue());
                                                                                        s+="at "+tokenNoeuds1.item(1).getFirstChild().getNodeValue() +" ";
                                                                                    }
                                                                                }
                                                                            }
                                                                        }


                                                                    }
                                                                    if(!bdate && !blieu){
                                                                        for (int m1 =tmp1; m1 >= 0; m1--) {
                                                                            if (tokensNoeuds.item(m1).getNodeType() == Node.ELEMENT_NODE) {
                                                                                Node token1 = tokensNoeuds.item(m1);
                                                                                NodeList tokenNoeuds1 = token1.getChildNodes();

                                                                                if(!stop6){
                                                                                    if(tokenNoeuds1.item(1).getFirstChild().getNodeValue().equals(",")){
                                                                                        stop6=true;
                                                                                    }else {
                                                                                        //Si il y a une date dans la phrase en rapport avec le meurtre
                                                                                        if (tokenNoeuds1.item(11).getFirstChild().getNodeValue().equals("DATE") && !stop3) {
                                                                                            //On la recupere
                                                                                            //System.out.println("DATE : "+tokenNoeuds1.item(13).getFirstChild().getNodeValue());
                                                                                            stop3 = true;
                                                                                            s+="in "+tokenNoeuds1.item(1).getFirstChild().getNodeValue() +" ";
                                                                                        }


                                                                                        //Si il y a un Lieu LOCATION dans la phrase en rapport avec le meurtre
                                                                                        if (tokenNoeuds1.item(11).getFirstChild().getNodeValue().equals("LOCATION")) {
                                                                                            //On la recupere
                                                                                            //System.out.println("LIEU : "+tokenNoeuds1.item(1).getFirstChild().getNodeValue());
                                                                                            s+="at "+tokenNoeuds1.item(1).getFirstChild().getNodeValue() +" ";
                                                                                        }
                                                                                    }
                                                                                }

                                                                            }
                                                                        }
                                                                    }



                                                                    stop1 = false;
                                                                    stop2 = false;
                                                                    stop3 = false;
                                                                    stop4=false;
                                                                    //System.out.println("\n"+person.get(id));
                                                                    //System.out.println("");
                                                                    //System.out.println(""+l);
                                                                }else{
                                                                    if(suivant) {
                                                                        //System.out.println("gybhunji,gvhnj,gbhnj," + killer);
                                                                        while (!stop7) {
                                                                            //Tant que l'on est pas sur une nouvelle page ou que l'on a pas de mot en rapport avec le meurtre
                                                                            //On parcourt les phrases
                                                                            //Node sentence1 = sentencesNoeuds.item(k);
                                                                            //NodeList sentenceNoeuds1 = sentence1.getChildNodes();

                                                                            for(int k1 = k+1; k1 < sentencesNoeuds.getLength(); k1++){
                                                                                //System.out.println(sentencesNoeuds.item(k).getNodeName());

                                                                                if(sentencesNoeuds.item(k1).getNodeType() == Node.ELEMENT_NODE) {
                                                                                    Node sentence1 = sentencesNoeuds.item(k1);
                                                                                    NodeList sentenceNoeuds1 = sentence1.getChildNodes();
                                                                                    for(int l1 = 0 ; l1 < sentenceNoeuds1.getLength(); l1++) {

                                                                                        if (sentenceNoeuds1.item(l1).getNodeType() == Node.ELEMENT_NODE) {

                                                                                            Node tokens1 = sentenceNoeuds1.item(l1);
                                                                                            NodeList tokensNoeuds1 = tokens1.getChildNodes();
                                                                                            //Recupere la premiere phrase
                                                                                            for (int m1 = 0; m1 < tokensNoeuds1.getLength(); m1++) {
                                                                                                if (tokensNoeuds1.item(m1).getNodeType() == Node.ELEMENT_NODE) {
                                                                                                    Node token1 = tokensNoeuds1.item(m1);
                                                                                                    NodeList tokenNoeuds1 = token1.getChildNodes();
                                                                                                    if(tokenNoeuds1.item(1).getFirstChild().getNodeValue().equals("***")){
                                                                                                        stop7=true;
                                                                                                    }else{
                                                                                                        //*System.out.print(tokenNoeuds1.item(1).getFirstChild().getNodeValue() + " ");
                                                                                                        if (!tokenNoeuds1.item(1).getFirstChild().getNodeValue().equals("***") &&
                                                                                                                (tokenNoeuds1.item(9).getFirstChild().getNodeValue().equals("VB") ||
                                                                                                                        tokenNoeuds1.item(9).getFirstChild().getNodeValue().equals("VBG") ||
                                                                                                                        tokenNoeuds1.item(9).getFirstChild().getNodeValue().equals("VBD"))) {
                                                                                                            //Si le mot est un verbe

                                                                                                            if (verbes.contains(tokenNoeuds1.item(3).getFirstChild().getNodeValue())) {
                                                                                                                //si le verbe est dans la liste
                                                                                                                //System.out.println(test);
                                                                                                                //s+=tokenNoeuds1.item(1).getFirstChild().getNodeValue()+" ";
                                                                                                                stop7 = true;
                                                                                                                tmp4=m1;
                                                                                                                //System.out.println(tokenNoeuds1.item(1).getFirstChild().getNodeValue());
                                                                                                                //System.out.println("bingo"+m1);
                                                                                                                s+= "killed ";
                                                                                                            }
                                                                                                        }else{
                                                                                                            if(nomsV.contains(tokenNoeuds1.item(3).getFirstChild().getNodeValue())){
                                                                                                                //Si le mot est dans la liste nomsV
                                                                                                                //System.out.println("\n  NN   " + tokenNoeuds1.item(1).getFirstChild().getNodeValue());
                                                                                                                stop7=true;
                                                                                                                tmp4=m1;
                                                                                                                s+= "killed ";
                                                                                                                //s+="commit a "+tokenNoeuds1.item(1).getFirstChild().getNodeValue()+" ";
                                                                                                                //System.out.println("bingo2"+m1);
                                                                                                            }else{
                                                                                                                if(nomsA.contains(tokenNoeuds1.item(3).getFirstChild().getNodeValue())){
                                                                                                                    //Si le mot est dans la liste nomsV
                                                                                                                    //System.out.println("\n  NN   " + tokenNoeuds1.item(1).getFirstChild().getNodeValue());
                                                                                                                    stop7=true;
                                                                                                                    tmp4=m1;
                                                                                                                    s+= "killed ";
                                                                                                                    //s+="was a "+tokenNoeuds1.item(1).getFirstChild().getNodeValue()+" ";
                                                                                                                    //System.out.println("bingo3"+m1);
                                                                                                                }else{
                                                                                                                    //Si il y a un verbe voix passive
                                                                                                                    if (!tokenNoeuds1.item(1).getFirstChild().getNodeValue().equals("***") &&
                                                                                                                            tokenNoeuds1.item(9).getFirstChild().getNodeValue().equals("VBN")) {
                                                                                                                        if (verbes.contains(tokenNoeuds1.item(3).getFirstChild().getNodeValue())) {
                                                                                                                            //Si le verbe est dans la liste
                                                                                                                            //System.out.println("\n  VBN   " + tokenNoeuds1.item(1).getFirstChild().getNodeValue());
                                                                                                                            //Cas Particulier
                                                                                                                            stop7 = true;
                                                                                                                            tmp4=m1;

                                                                                                                            // System.out.println("bingo1"+m1);
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                                if(stop7){
                                                                                                    break;
                                                                                                }
                                                                                            }
                                                                                            //System.out.println();
                                                                                            //Si on a trouvé un mot en rapport avec le meurtre on cherche la suite
                                                                                            if(stop7){
                                                                                                //Si on a un mot en rapport avec le meurtre on cherche dans cette phrase sinon on passe au prochain meutrier
                                                                                                complet=true;
                                                                                                //On parcourt la phrase à partir de ce mot
                                                                                                //System.out.println("TMP' ="+tmp4);
                                                                                                for (int m1 = tmp4; m1 < tokensNoeuds1.getLength(); m1++) {
                                                                                                    if (tokensNoeuds1.item(m1).getNodeType() == Node.ELEMENT_NODE) {
                                                                                                        Node token1 = tokensNoeuds1.item(m1);
                                                                                                        NodeList tokenNoeuds1 = token1.getChildNodes();
                                                                                                        tmp3+=1;
                                                                                                        for (int n1 = 0; n1 < tokenNoeuds1.getLength(); n1++) {
                                                                                                            if (tokenNoeuds1.item(n1).getNodeName().equals("POS")) {

                                                                                                                //Si on trouve un nom propre après le mot en rapport avec le meurtre
                                                                                                                if ((tokenNoeuds1.item(n1).getFirstChild().getNodeValue().equals("NNP") || tokenNoeuds1.item(n1).getFirstChild().getNodeValue().equals("NNPS"))
                                                                                                                        && tokenNoeuds1.item(11).getFirstChild().getNodeValue().equals("PERSON")) {
                                                                                                                    //Victime Nom Propre
                                                                                                                    //
                                                                                                                    //System.out.println("VICTIMEp : "+tokenNoeuds1.item(1).getFirstChild().getNodeValue());
                                                                                                                    s+=tokenNoeuds1.item(1).getFirstChild().getNodeValue() +" ";
                                                                                                                    //System.out.println(killer+"hbunij,kolpji,kl;");
                                                                                                                    victime=true;
                                                                                                                    //System.out.println(killer+"     ALLLO ALLO ALLO      "+victime);


                                                                                                                } else {

                                                                                                                    //Si on trouve un pronom possessif
                                                                                                                    //System.out.println("PRP :  "+tmp3);
                                                                                                                    if (tokenNoeuds1.item(n1).getFirstChild().getNodeValue().equals("PRP$") && tmp3<4) {
                                                                                                                        //Victime nom commun
                                                                                                                        stop2 = true;
                                                                                                                        //System.out.println(killer+"hbunij,kolpji,kl;");
                                                                                                                        //s+=tokenNoeuds1.item(1).getFirstChild().getNodeValue() +" ";
                                                                                                                        victime=true;
                                                                                                                       // System.out.println(killer+"     ALLLO ALLO ALLO      "+victime);
                                                                                                                    }


                                                                                                                }

                                                                                                            }
                                                                                                        }

                                                                                                       //System.out.print(tokenNoeuds1.item(1).getFirstChild().getNodeValue() + " ");

                                                                                                        //Si on a trouvé un pronom possessif
                                                                                                        if (stop2) {
                                                                                                            //on cherche le nom qui suit
                                                                                                            //On vérifie que c'est bien un nom ou un nombre ou un "and"
                                                                                                            if ((tokenNoeuds1.item(9).getFirstChild().getNodeValue().equals("PRP$") ||
                                                                                                                    tokenNoeuds1.item(9).getFirstChild().getNodeValue().equals("NN") ||
                                                                                                                    tokenNoeuds1.item(9).getFirstChild().getNodeValue().equals("NNS") ||
                                                                                                                    tokenNoeuds1.item(9).getFirstChild().getNodeValue().equals("CD") ||
                                                                                                                    tokenNoeuds1.item(9).getFirstChild().getNodeValue().equals("CC"))
                                                                                                                    && !stop4){
                                                                                                                //On ajoute à la liste des victime
                                                                                                                //System.out.println("VICTIME c :"+tokenNoeuds1.item(1).getFirstChild().getNodeValue());
                                                                                                                s+=tokenNoeuds1.item(1).getFirstChild().getNodeValue() +" ";

                                                                                                            } else {
                                                                                                                //Sinon on arrete de cherche les victimes
                                                                                                                stop4 = true;
                                                                                                            }
                                                                                                        }

                                                                                                        if(tokenNoeuds1.item(1).getFirstChild().getNodeValue().contains(".")){
                                                                                                            break;
                                                                                                        }
                                                                                                    }
                                                                                                }

                                                                                                if(!victime){
                                                                                                    //System.out.println(killer+"tueur tueur tuer");
                                                                                                    s+="someone ";
                                                                                                    victime=false;
                                                                                                }
                                                                                                tmp3=0;
                                                                                                //on cherche la date est le lieu
                                                                                                for (int m1 = tmp4; m1 < tokensNoeuds1.getLength(); m1++) {
                                                                                                    if (tokensNoeuds1.item(m1).getNodeType() == Node.ELEMENT_NODE) {
                                                                                                        Node token1 = tokensNoeuds1.item(m1);
                                                                                                        NodeList tokenNoeuds1 = token1.getChildNodes();
                                                                                                        if(!stop5){
                                                                                                            if(tokenNoeuds1.item(1).getFirstChild().getNodeValue().contains(",") ||
                                                                                                                    tokenNoeuds1.item(1).getFirstChild().getNodeValue().contains(".")   ){
                                                                                                                stop5=true;
                                                                                                            }else{
                                                                                                                //Si il y a une date dans la phrase en rapport avec le meurtre
                                                                                                                if (tokenNoeuds1.item(11).getFirstChild().getNodeValue().equals("DATE") && !stop3) {
                                                                                                                    //On la recupere
                                                                                                                    //System.out.println("DATE : "+tokenNoeuds1.item(13).getFirstChild().getNodeValue());
                                                                                                                    s+="in "+tokenNoeuds1.item(1).getFirstChild().getNodeValue() +" ";
                                                                                                                    stop3=true;
                                                                                                                }


                                                                                                                //Si il y a un Lieu LOCATION dans la phrase en rapport avec le meurtre
                                                                                                                if (tokenNoeuds1.item(11).getFirstChild().getNodeValue().equals("LOCATION")) {
                                                                                                                    //On la recupere
                                                                                                                    //System.out.println("LIEU : "+tokenNoeuds1.item(1).getFirstChild().getNodeValue());
                                                                                                                    s+="at "+tokenNoeuds1.item(1).getFirstChild().getNodeValue() +" ";
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }


                                                                                                }
                                                                                                if(!bdate && !blieu){
                                                                                                    for (int m1 =tmp4; m1 >= 0; m1--) {
                                                                                                        if (tokensNoeuds1.item(m1).getNodeType() == Node.ELEMENT_NODE) {
                                                                                                            Node token1 = tokensNoeuds1.item(m1);
                                                                                                            NodeList tokenNoeuds1 = token1.getChildNodes();

                                                                                                            if(!stop6){
                                                                                                                if(tokenNoeuds1.item(1).getFirstChild().getNodeValue().equals(",")){
                                                                                                                    stop6=true;
                                                                                                                }else {
                                                                                                                    //Si il y a une date dans la phrase en rapport avec le meurtre
                                                                                                                    if (tokenNoeuds1.item(11).getFirstChild().getNodeValue().equals("DATE") && !stop3) {
                                                                                                                        //On la recupere
                                                                                                                        //System.out.println("DATE : "+tokenNoeuds1.item(13).getFirstChild().getNodeValue());
                                                                                                                        stop3 = true;
                                                                                                                        s+="in "+tokenNoeuds1.item(1).getFirstChild().getNodeValue() +" ";
                                                                                                                    }


                                                                                                                    //Si il y a un Lieu LOCATION dans la phrase en rapport avec le meurtre
                                                                                                                    if (tokenNoeuds1.item(11).getFirstChild().getNodeValue().equals("LOCATION")) {
                                                                                                                        //On la recupere
                                                                                                                        //System.out.println("LIEU : "+tokenNoeuds1.item(1).getFirstChild().getNodeValue());
                                                                                                                        s+="at "+tokenNoeuds1.item(1).getFirstChild().getNodeValue() +" ";
                                                                                                                    }
                                                                                                                }
                                                                                                            }

                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                                stop2 = false;
                                                                                                stop3 = false;
                                                                                                stop4=false;
                                                                                            }

                                                                                        }
                                                                                        if(stop7){
                                                                                            break;
                                                                                        }
                                                                                    }

                                                                                }
                                                                                if(stop7){
                                                                                    break;
                                                                                }
                                                                            }



                                                                        }
                                                                        //Continuer sur les phrases qui suivent
                                                                    }
                                                                    suivant=false;
                                                                }


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
