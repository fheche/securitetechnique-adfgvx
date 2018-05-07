package ch.hearc.ig.st.adfgvx.metier;

public class Adfgvx {

  private static String[][] tableauSubstitution = new String[6][6];

  public static String chiffrerPhrase(String phraseADechiffrer, String cle) {
    String phraseChiffree = "";
    String phrasePermutee = "";
    initialiseTableauSubstitution();
    phraseChiffree=chiffrerPhrase(phraseADechiffrer);
    System.out.println("La phrase est chiffrée sans permutation est "+phraseChiffree);
    phrasePermutee = permuterSelonCle(phraseChiffree,cle);
    System.out.println("La phrase chiffrée avec permutation est : "+phrasePermutee);
    return phrasePermutee;
  }

  private static String permuterSelonCle(String phraseChiffree, String cle) {

    System.out.println("La clé utilisée est : " + cle);
    // Enlève les lettres redondantes
    String cleTmp=cle;
    cle="";
    for (int i = 0; i < cleTmp.length(); ++i) {
      if (!cle.contains(String.valueOf(cleTmp.charAt(i)))) {
        cle += cleTmp.charAt(i);
      }
    }
    System.out.println("Les lettres redondantes de la clé sont enlevées : " + cle);

    String[][] tableauReponse = new String[6][cle.length()];
    int indicePhraseChiffree=0;

    for (int i = 0; i < 6; ++i) {
      for(int j=0;j<cle.length();++j){
        if(indicePhraseChiffree>=phraseChiffree.length()){
          tableauReponse[i][j]=ajouteLettreAleatoire();
        }else{
          tableauReponse[i][j]=String.valueOf(phraseChiffree.charAt(indicePhraseChiffree++));
        }
      }
    }

    System.out.println("La clé est combinée à un tableau contenant le message chiffré");
    // Affichage de la clé
    for(int i=0;i<cle.length();++i){
      System.out.print(String.valueOf(cle.charAt(i)).toUpperCase()+"  ");
    }
    System.out.print("\n");

    // Affichage du tableau
    for (int i = 0; i < 6; ++i) {
      for(int j=0;j<cle.length();++j){
        System.out.print(tableauReponse[i][j]+"  ");
      }
      System.out.print("\n");
    }

    //A faire : Permuter le tableau selon l'ordre alphabétique

    return "";
  }

  private static String ajouteLettreAleatoire() {
    int nombreAleatoire = 1 + (int)(Math.random() * ((6 - 1) + 1));
    switch (nombreAleatoire){
      case 1:
        return "A";
      case 2:
        return "D";
      case 3:
        return "F";
      case 4:
        return "G";
      case 5:
        return "V";
      case 6:
        return "X";
      default:
        return "";
    }
  }


  public static String dechiffrerPhrase(String phraseADechiffrer, String cle) {
    return "";
  }

  private static String dechiffrerPhrase(String phraseADechiffrer) {
    String phraseDechiffreeTmp = "";
    String phraseDechiffree = "";

    // Transforme les lettres ADFGVX en indices
    for (int i = 0; i < phraseADechiffrer.length(); ++i) {
      switch (phraseADechiffrer.charAt(i)) {
        case 'A':
          phraseDechiffreeTmp += '0';
          break;
        case 'D':
          phraseDechiffreeTmp += '1';
          break;
        case 'F':
          phraseDechiffreeTmp += '2';
          break;
        case 'G':
          phraseDechiffreeTmp += '3';
          break;
        case 'V':
          phraseDechiffreeTmp += '4';
          break;
        case 'X':
          phraseDechiffreeTmp += '5';
          break;
      }
    }

    for (int i = 0; i < phraseDechiffreeTmp.length(); i+=2) {
      phraseDechiffree+=tableauSubstitution[Integer.valueOf(phraseDechiffreeTmp.charAt(i)-'0')][Integer.valueOf(phraseDechiffreeTmp.charAt(i+1)-'0')];
    }

    return phraseDechiffree;
  }

  private static String chiffrerPhrase(String phraseAChiffrer) {
    String phraseChiffreeTmp = "";
    String phraseChiffree = "";
    String lettreAChiffree = "";

    for (int i = 0; i < phraseAChiffrer.length(); ++i) {
      lettreAChiffree = String.valueOf(phraseAChiffrer.charAt(i));

      // Parcours du tableau et recherche de la lettre
      for (int j = 0; j < 6; ++j) {
        for (int k = 0; k < 6; ++k) {
          if (tableauSubstitution[j][k].equals(lettreAChiffree)) {
            phraseChiffreeTmp += String.valueOf(j) + String.valueOf(k);
            break;
          }
        }
      }
    }

    // Transforme les indices en lettres ADFGVX
    for (int i = 0; i < phraseChiffreeTmp.length(); ++i) {
      switch (phraseChiffreeTmp.charAt(i)) {
        case '0':
          phraseChiffree += 'A';
          break;
        case '1':
          phraseChiffree += 'D';
          break;
        case '2':
          phraseChiffree += 'F';
          break;
        case '3':
          phraseChiffree += 'G';
          break;
        case '4':
          phraseChiffree += 'V';
          break;
        case '5':
          phraseChiffree += 'X';
          break;
      }
    }

    return phraseChiffree;
  }

  private static void initialiseTableauSubstitution() {
    // Initialisation du tableau de substitution
    // 8  T  B  W  R  Q
    // P  4  C  G  2  9
    // 3  O  5  M  X  E
    // D  A  Z  J  S  Y
    // L  H  7  U  V  0
    // N  1  K  6  I  F
    tableauSubstitution[0][0] = "8";
    tableauSubstitution[0][1] = "t";
    tableauSubstitution[0][2] = "b";
    tableauSubstitution[0][3] = "w";
    tableauSubstitution[0][4] = "r";
    tableauSubstitution[0][5] = "q";

    tableauSubstitution[1][0] = "p";
    tableauSubstitution[1][1] = "4";
    tableauSubstitution[1][2] = "c";
    tableauSubstitution[1][3] = "g";
    tableauSubstitution[1][4] = "2";
    tableauSubstitution[1][5] = "9";

    tableauSubstitution[2][0] = "3";
    tableauSubstitution[2][1] = "o";
    tableauSubstitution[2][2] = "5";
    tableauSubstitution[2][3] = "m";
    tableauSubstitution[2][4] = "x";
    tableauSubstitution[2][5] = "e";

    tableauSubstitution[3][0] = "d";
    tableauSubstitution[3][1] = "a";
    tableauSubstitution[3][2] = "z";
    tableauSubstitution[3][3] = "j";
    tableauSubstitution[3][4] = "s";
    tableauSubstitution[3][5] = "y";

    tableauSubstitution[4][0] = "l";
    tableauSubstitution[4][1] = "h";
    tableauSubstitution[4][2] = "7";
    tableauSubstitution[4][3] = "u";
    tableauSubstitution[4][4] = "v";
    tableauSubstitution[4][5] = "0";

    tableauSubstitution[5][0] = "n";
    tableauSubstitution[5][1] = "1";
    tableauSubstitution[5][2] = "k";
    tableauSubstitution[5][3] = "6";
    tableauSubstitution[5][4] = "i";
    tableauSubstitution[5][5] = "f";

    System.out.println("Tableau de substitution utilisé :");
    System.out.println("   A  D  F  G  V  X");
    // Parcours le tableau de substitution et l'affiche
    for (int i = 0; i < 6; ++i) {
      switch (i){
        case 0:
          System.out.print("A  ");
          break;
        case 1:
          System.out.print("D  ");
          break;
        case 2:
          System.out.print("F  ");
          break;
        case 3:
          System.out.print("G  ");
          break;
        case 4:
          System.out.print("V  ");
          break;
        case 5:
          System.out.print("X  ");
          break;
      }
      for (int j = 0; j < 6; ++j) {
        System.out.print(tableauSubstitution[i][j] + "  ");
      }
      System.out.print("\n");
    }
  }
}
