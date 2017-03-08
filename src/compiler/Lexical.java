package compiler;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class Lexical{

    static ArrayList<Token> lexemeList = new ArrayList<Token>();
    static Token lexeme = null;
    static String token = "";
    static int asci1;
    static int state = 0;
    static String[] keywords = {"const","float","int","break","continue","else",
            "for","switch","void","case","char","do","if","return","union","while"};


    public static void main(String args[]) throws IOException {

        char [] string = ReadFileToCharArray("C:\\Source.txt");
        char char_val = ' ';

        for (int i=0 ; i<string.length; i++){
            char_val = string[i];
            asci1 = (int) char_val;

            switch (state){



                case 0: {
                    if ((asci1 >= 97 && asci1 <= 122) || (asci1 == 95) || (asci1 >= 65 && asci1 <= 90)) {
                        token += char_val;
                        state = 1;
                        break;
                    }
                    else if(asci1 >= 48 && asci1 <= 57){
                        token += char_val;
                        state = 5;
                        break;
                    }
                    else if (asci1 == 46){
                        token += 0;
                        token += char_val;
                        state = 7;
                        break;
                    }
                    else if (asci1 == 32){
                        break;
                    }
                    else if (asci1 == 123){
                        state = 18;
                        i--;
                        break;
                    }
                    else if (asci1 == 125){
                        state = 19;
                        i--;
                        break;
                    }
                    else if (asci1 == 91){
                        state = 20;
                        i--;
                        break;
                    }
                    else if (asci1 == 93){
                        state = 21;
                        i--;
                        break;
                    }
                    else if (asci1 == 40){
                        state = 22;
                        i--;
                        break;
                    }
                    else if (asci1 == 41){
                        state = 23;
                        i--;
                        break;
                    }
                    else if (asci1 == 34){
                        state = 24;
                        token+=char_val;
                        break;
                    }
                    else if (asci1== 62){
                        state = 25;
                        token += char_val;
                        break;
                    }
                    else if (asci1 == 60){
                        state = 28;
                        token += char_val;
                        break;
                    }
                    else if (asci1== 61){
                        state = 32;
                        token += char_val;
                        break;
                    }
                    else if (asci1== 43){
                        state = 39;
                        token += char_val;
                        break;
                    }
                    else if (asci1== 45){
                        state = 42;
                        token += char_val;
                        break;
                    }
                    else if (asci1== 38){
                        state = 45;
                        token += char_val;
                        break;
                    }
                    else if (asci1== 42){
                        state = 53;
                        token += char_val;
                        break;
                    }
                    else if (asci1== 47){
                        state = 54;
                        token += char_val;
                        break;
                    }
                    else if (asci1== 124){
                        state = 49;
                        token += char_val;
                        break;
                    }
                    else if (asci1== 33){
                        state = 35;
                        token += char_val;
                        break;
                    }
                    else if (asci1== 58){
                        state = 36;
                        token += char_val;
                        break;
                    }
                    else if (asci1== 59){
                        state = 46;
                        token += char_val;
                        break;
                    }
                }



                case 1:{
                    if ((asci1 >= 97 && asci1 <= 122) || (asci1 == 95) || (asci1 >= 65 && asci1 <= 90)) {
                        token += char_val;
                        state = 1;
                        break;
                    }
                    else if(asci1 >= 48 && asci1 <= 57){
                        token += char_val;
                        state = 2;
                        break;
                    }
                    else {
                        int a = keywordCheck(token);
                        if (a == 1){
                            i--;
                            state = 10;
                            break;
                        }
                        else if (a == 0) {
                            if (Objects.equals(token, "In")) {
                                i--;
                                state = 12;
                                break;
                            }
                            else if (Objects.equals(token, "Out")){
                                i--;
                                state = 15;
                                break;
                            }
                            state = 444;
                            i--;
                            break;
                        }
                    }
                }
                case 2:{
                    if ((asci1 >= 97 && asci1 <= 122) || (asci1 >= 48 && asci1 <= 57) || (asci1 >= 65 && asci1 <= 90)) {
                        token += char_val;
                        state = 2;
                        break;
                    }
                    else if(asci1 == 95){
                        token += char_val;
                        state = 4;
                        break;
                    }
                    else {
                        i--;
                        state = 3;
                        break;
                    }
                }
                case  4:{
                    if ((asci1 >= 97 && asci1 <= 122) || (asci1 >= 48 && asci1 <= 57) || (asci1 >= 65 && asci1 <= 90)) {
                        token += char_val;
                        state = 2;
                        break;
                    }
                    else{
                        state = 444;
                        i--;
                        break;
                    }
                }
                case  5:{
                    if (asci1 == 46){
                        token += char_val;
                        state = 7;
                        break;
                    }
                    else if(asci1 >= 48 && asci1 <= 57){
                        token += char_val;
                        state = 5;
                        break;
                    }
                    else {
                        state = 6;
                        i--;
                        break;
                    }
                }
                case 7:{
                    if (asci1 == 46){
                        state = 777;
                    }
                    else if (asci1 >= 48 && asci1 <= 57){
                        token += char_val;
                        state = 8;
                        break;
                    }
                }
                case 8:{
                    if (asci1 >= 48 && asci1 <= 57){
                        token += char_val;
                        state = 8;
                        break;
                    }
                    else if (asci1 == 46){
                        state = 777;
                    }
                    else {
                    state = 9;
                        i--;
                        break;
                    }
                }
                case 12:{
                    if (asci1 == 62){
                        token += char_val;
                        state = 13;
                        break;
                    }
                    else {
                        state = 1222;
                        i--;
                        break;
                    }
                }
                case 13:{
                    if (asci1 == 62){
                        token += char_val;
                        state = 14;
                        break;
                    }
                    else {
                        state = 1222;
                        i--;
                        break;
                    }
                }
                case 15:{
                    if (asci1 == 60){
                        token += char_val;
                        state = 16;
                        break;
                    }
                    else {
                        state = 1555;
                        i--;
                        break;
                    }
                }
                case 16:{
                    if (asci1 == 60){
                        token += char_val;
                        state = 17;
                        break;
                    }
                    else {
                        state = 1555;
                        i--;
                        break;
                    }
                }
                case 18:{
                    token += char_val;
                    state = 11;
                    i--;
                    break;
                    }
                case 19:{
                    token += char_val;
                    state = 11;
                    i--;
                    break;
                }
                case 20:{
                    token += char_val;
                    state = 11;
                    i--;
                    break;
                }
                case 21:{
                    token += char_val;
                    state = 11;
                    i--;
                    break;
                }
                case 22:{
                    token += char_val;
                    state = 11;
                    i--;
                    break;
                }
                case 23:{
                    token += char_val;
                    state = 11;
                    i--;
                    break;
                }
                case 24:{
                    while (asci1 != 34){
                        token+=char_val;
                        i++;
                        char_val = string[i];
                        asci1 = (int) char_val;
                    }
                    token += char_val;
                    state = 29;
                    i--;
                    break;
                }
                case 25:{
                    if (asci1 == 62){
                        token += char_val;
                        state = 27;
                        break;
                    }
                    else {
                        state = 26;
                        i--;
                        break;
                    }
                }

                case 27:{
                    state = 26;
                    i--;
                    break;
                }
                case 28:{
                    if (asci1 == 60){
                        token += char_val;
                        state = 30;
                        break;
                    }
                    else if (asci1 == 62){
                        token += char_val;
                        state = 31;
                        break;
                    }
                    else {
                        state = 26;
                        i--;
                        break;
                    }
                }
                case 30:{
                    state = 26;
                    i--;
                    break;
                }
                case 31:{
                    state = 26;
                    i--;
                    break;
                }
                case 32:{
                    if (asci1==61){
                        token += char_val;
                        state = 33;
                        break;
                    }
                    else {
                     state = 26;
                        i--;
                        break;
                    }
                }
                case 33:{
                    state = 26;
                    i--;
                    break;
                }
                case 35:{
                    if (asci1==61){
                        token += char_val;
                        state =33;
                        break;
                    }
                    else {
                        state = 3555;
                        i--;
                        break;
                    }
                }
                case 36:{
                    if (asci1==61){
                        state = 33;
                        token += char_val;
                        break;
                    }
                    else {
                        state = 26;
                        i--;
                        break;
                    }
                }
                case 37:{
                    state = 26;
                    i--;
                    break;
                }
                case 38:{
                    state = 26;
                    i--;
                    break;
                }
                case 39:{
                    if (asci1==43){
                        token += char_val;
                        state = 40;
                        break;
                    }
                    else if (asci1==61){
                        token += char_val;
                        state = 38;
                        break;
                    }
                    else {
                        state = 26;
                        i--;
                        break;
                    }
                }
                case 40:{
                    state = 26;
                    i--;
                    break;
                }
                case 42:{
                    if (asci1==45){
                        token += char_val;
                        state = 43;
                        break;
                    }
                    else if (asci1==61){
                        token += char_val;
                        state = 37;
                        break;
                    }
                    else {
                        state = 26;
                        i--;
                        break;
                    }
                }
                case 43:{
                    state = 26;
                    i--;
                    break;
                }
                case 45:{
                    if (asci1==38){
                        token += char_val;
                        state = 47;
                        break;
                    }
                    else if (asci1==124){
                        token += char_val;
                        state = 48;
                        break;
                    }
                    else {
                        state = 26;
                        i--;
                        break;
                    }
                }
                case 46:{
                    state = 26;
                    i--;
                    break;
                }
                case 47:{
                    state = 26;
                    i--;
                    break;
                }
                case 48:{
                    state = 26;
                    i--;
                    break;
                }

                case 49:{
                    if (asci1==38){
                        token += char_val;
                        state = 51;
                        break;
                    }
                    else if (asci1==124){
                        token += char_val;
                        state = 50;
                        break;
                    }
                    else {
                        state = 26;
                        i--;
                        break;
                    }
                }
                case 50:{
                    state = 26;
                    i--;
                    break;
                }
                case 51:{
                    state = 26;
                    i--;
                    break;
                }
                case 53: {
                    state = 26;
                    i--;
                    break;
                }
                case 54: {
                    state = 26;
                    i--;
                    break;
                }


                case 3:{
                    //System.out.println(token + " Identifier");
                    lexeme = new Token("Identifier",token);
                    lexemeList.add(lexeme);
                    i--;
                    token = "";
                    state = 0;
                    break;
                }
                case 6:{
                    //System.out.println(token + " int Number");
                    lexeme = new Token("int Number",token);
                    lexemeList.add(lexeme);
                    token = "";
                    state = 0;
                    i--;
                    break;
                }
                case 9:{
                    //System.out.println(token + " float Number");
                    lexeme = new Token("float Number",token);
                    lexemeList.add(lexeme);
                    token = "";
                    i--;
                    state = 0;
                    break;
                }
                case 10:{
                    //System.out.println(token + " Keyword");
                    lexeme = new Token("Keyword",token);
                    lexemeList.add(lexeme);
                    token = "";
                    i--;
                    state=0;
                    break;
                }
                case 11:{
                    //System.out.println(token + " Punctuation");
                    lexeme = new Token("Punctuation",token);
                    lexemeList.add(lexeme);
                    token = "";
                    state = 0;
                    break;
                }
                case 14:{
                    //System.out.println(token + " User Input");
                    lexeme = new Token("User Input",token);
                    lexemeList.add(lexeme);
                    token = "";
                    i--;
                    state = 0;
                    break;
                }
                case 17:{
                    //System.out.println(token + " User Output");
                    lexeme = new Token("User Output",token);
                    lexemeList.add(lexeme);
                    token = "";
                    i--;
                    state = 0;
                    break;
                }
                case 26:{
                    //System.out.println(token + " Operator");
                    lexeme = new Token("Operator",token);
                    lexemeList.add(lexeme);
                    token = "";
                    i--;
                    state = 0;
                    break;
                }
                case 29:{
                    //System.out.println(token + " String");
                    lexeme = new Token("String",token);
                    lexemeList.add(lexeme);token = "";
                   // i--;
                    state = 0;
                    break;
                }



                case 444:{
                    state =0;
                    System.out.println("Identifier Error: ");
                    token ="";
                    break;
                }
                case 777:{
                    while (asci1 == 32){i++;}
                    System.out.println("Literal Error: ");
                    token = "";
                    i++;
                    state = 0;
                    break;
                }
                case 1222:{
                    //while (asci1 == 32){i++;}
                    System.out.println("Input operator Error: Missing ");
                    token = "";
                    state = 0;
                    break;
                }
                case 1555:{
                    System.out.println("Output operator Error: Missing ");
                    token = "";
                    state = 0;
                    break;
                }
                case 3555:{
                    System.out.println("Operator Error: operator Missing ");
                    token = "";
                    state = 0;
                    break;

                }


            }

        }
        Output();
    }   //System.out.println(token);




    private static void Output() throws FileNotFoundException {
        System.out.println(lexemeList);
        save(lexemeList);
        System.out.println("Tokens Saved in a file.");
        }

    private static int keywordCheck(String token_1){
        for (String element : keywords){
            if (token_1.equals(element)){
                    return 1;
            }
        }
        return 0;
    }

    private static char[] ReadFileToCharArray(String filePath) throws IOException {
        StringBuilder fileData = new StringBuilder(1000);
        BufferedReader reader = new BufferedReader(new FileReader(filePath));

        char[] buf = new char[10];
        int numRead = 0;
        while ((numRead = reader.read(buf)) != -1) {

            String readData = String.valueOf(buf, 0, numRead);
            String wow1 = readData.replaceAll(System.getProperty("line.separator"), " ");
            fileData.append(wow1);
            buf = new char[1024];
        }
        reader.close();
        return  fileData.toString().toCharArray();
    }



    public static void save(ArrayList<Token> haha) throws FileNotFoundException {
        String tmp = haha.toString();
        PrintWriter a = new PrintWriter(new FileOutputStream("Token.txt"));
        a.write(tmp);
        a.close();
    }


}