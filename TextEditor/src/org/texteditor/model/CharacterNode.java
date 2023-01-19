package org.texteditor.model;

import lombok.Getter;
import lombok.Setter;


// Doubly linked list used as text editor data structure
@Getter
@Setter
public class CharacterNode {
    char ch;
    CharacterNode next;
    CharacterNode prev;

    public CharacterNode(char c){
        this.ch = c;
    }

    @Override
    public String toString(){
        return Character.toString(this.ch);
    }
}
