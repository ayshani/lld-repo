package test;

import org.texteditor.app.TextEditor;

public class TextEditorApplication {
    public static void main(String[] args) {

        TextEditor textEditor= new TextEditor();
        textEditor.insert('a');
        textEditor.print();
        textEditor.insert('b');
        textEditor.print();
        textEditor.insert('c');
        textEditor.print();
        textEditor.insert('d');
        textEditor.print();

        textEditor.undo();
        textEditor.print();
        textEditor.undo();
        textEditor.print();
        textEditor.undo();
        textEditor.print();
        textEditor.undo();
        textEditor.print();

        textEditor.insert('a');
        textEditor.print();
        textEditor.insert('b');
        textEditor.print();
        textEditor.insert('c');
        textEditor.print();
        textEditor.insert('d');
        textEditor.print();


        textEditor.moveLeft();
        textEditor.print();

        textEditor.undo();
        textEditor.print();

        textEditor.moveLeft();
        textEditor.print();
        textEditor.moveLeft();
        textEditor.print();

        textEditor.moveRight();
        textEditor.print();
        textEditor.moveRight();
        textEditor.print();
        textEditor.moveRight();
        textEditor.print();

        textEditor.backspace();
        textEditor.print();
        textEditor.moveLeft();
        textEditor.print();

        textEditor.undo();
        textEditor.print();
        textEditor.undo();
        textEditor.print();
        textEditor.undo();
        textEditor.print();
        textEditor.undo();
        textEditor.print();
        textEditor.undo();
        textEditor.print();
    }
}