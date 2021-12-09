package applicationBank;

import java.util.*;

public class Encryption{
	public static String encrypt(String word){
		char[] ch = word.toCharArray();
        for(int i = 0; i < ch.length; i++) {
            switch(ch[i]){
                case '9':
                ch[i] = '0';
                break;
                case 'z':
                ch[i] = 'a';
                break;
                case 'Z':
                ch[i] = 'A';
                break;
                default:
                ch[i] += 1;
            }
        }
        String encryptedPwd = new String(ch);
        return encryptedPwd;
	}
}