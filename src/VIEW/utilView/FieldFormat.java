/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VIEW.utilView;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author Rafael
 */
public class FieldFormat extends PlainDocument{
    
    public enum TypeEntrance {
        INT, DECIMAL, NAME, EMAIL, DATE, USER, PASSWORD;
    };
    
    private int characterAmount;
    private TypeEntrance tpEntrance; 

    public FieldFormat(int characterAmount, TypeEntrance tpEntrance) {
        this.characterAmount = characterAmount;
        this.tpEntrance = tpEntrance;
    }

    @Override
    public void insertString(int i, String string, AttributeSet as) throws BadLocationException {
        if (string == null || getLength() == characterAmount){
            return;
        }
        int totalCharac = getLength() + string.length();
        String regex ="";
        switch (tpEntrance){
            case INT: regex = "[^0-9]"; break; 
            case DECIMAL: regex = "[^0-9,.]"; break;
            case NAME: regex = "[^\\p{IsLatin} ]"; break;
            case EMAIL: regex = "[^\\p{IsLatin}@.\\-_][0-9]"; break;
            case DATE: regex = "[^0-9/]"; break; 
            case USER: regex = "[^\\p{IsLatin}@.\\-_][0-9]"; break;
            case PASSWORD: regex = "[^\\p{IsLatin}@.\\-_][0-9]"; break;
        }
                
        string = string.replaceAll(regex, "");
        
        if (totalCharac <= characterAmount){
            super.insertString(i, string, as); //To change body of generated methods, choose Tools | Templates. 
        } else {
            String nova = string.substring(0, characterAmount);
            super.insertString(i, nova, as); //To change body of generated methods, choose Tools | Templates. 
        }
        
    }
    
} 
    

