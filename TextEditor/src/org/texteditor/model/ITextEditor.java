package org.texteditor.model;

public interface ITextEditor {
    void moveLeft();
    void moveRight();
    void backspace();
    void insert(char data);
    void undo();
    String print();
    CharacterNode getCursor();
}
