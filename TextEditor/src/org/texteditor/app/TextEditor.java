package org.texteditor.app;

import org.texteditor.model.Action;
import org.texteditor.model.CharacterNode;
import org.texteditor.model.ITextEditor;
import org.texteditor.model.Revision;

import java.util.Stack;

public class TextEditor implements ITextEditor {

    CharacterNode start,cursor;
    Stack<Revision> undoStack;
    int numChar;

    public TextEditor(){
        // '\0' denotes end of String i.e. tail of CharacterNode linkedlist
        this.cursor = new CharacterNode('\0');
        this.undoStack = new Stack<>();
        this.start = null;
        this.numChar = 0;
    }
    @Override
    public void moveLeft() {
        if(cursor.getPrev() == null)
            return ;
        /*
        e.g. - ajggaf\0g
         suppose cursor is at above position.
         After moving left  - ajgga\0fg
         */
        cursor = cursor.getPrev();
        // Move cursor to RIGHT in case of undo
        undoStack.add(new Revision(Action.RIGHT,null));
    }

    @Override
    public void moveRight() {
        if(cursor.getNext() == null)
            return;
        cursor = cursor.getNext();
        // Move cursor to LEFT in case of undo
        undoStack.add(new Revision(Action.LEFT,null));
    }

    @Override
    public void backspace() {
        if(null == cursor.getPrev())
            return;


        CharacterNode chDeleted = delete(cursor.getPrev());

        undoStack.add(new Revision(Action.INSERT,chDeleted));

        if(numChar == 0){
            start = null;
        }
    }

    private CharacterNode delete(CharacterNode toDelete) {
        numChar--;
        CharacterNode previous = toDelete.getPrev();
        CharacterNode next = toDelete.getNext();

        if(null !=previous){
            previous.setNext(next);
        }
        if(next!=null){
            next.setPrev(previous);
        }

        /*
        only one character is there which we are removing
         */
        if(toDelete.getPrev() == null && numChar==0){
            start = null;
        }

        /*
        We are deleting the first character but we have remaining characters
         */
        if(toDelete == start){
            start = next;
        }

        /*
        As we have initialised cursor with end_of_string '\0'
        So, if all characters are removed already and again some1 tries to do backspace.
         */
        if(cursor.getPrev() == null && numChar == 0){
            start = null;
        }

        return toDelete;
    }

    @Override
    public void insert(char data) {
        insert(data, true);
    }


    private void insert(char data, boolean recordInStack) {
        CharacterNode newNode = new CharacterNode(data);
        CharacterNode prev = cursor.getPrev();

        newNode.setNext(cursor);
        cursor.setPrev(newNode);

        if(prev != null){
            newNode.setPrev(prev);
            prev.setNext(newNode);
        }else {
            start = newNode;
        }

        numChar++;
        if(recordInStack)
            undoStack.add(new Revision(Action.DELETE, newNode));
    }

    //This is Imp
    //While doing undo , dont push that action is stack, otherwise it will be toggling between undoing and redoing
    @Override
    public void undo() {
        if(undoStack.isEmpty()){
            return;
        }

        Revision revision = undoStack.pop();
        Action undoAction = revision.getAction();

        switch (undoAction) {
            case LEFT :
                if(cursor != null && cursor.getPrev() != null){
                    cursor = cursor.getPrev();
                }
                break;
            case RIGHT :
                if(cursor != null && cursor.getNext() != null){
                    cursor = cursor.getNext();
                }
                break;
            case INSERT :
                insert(revision.getCharacterNode().getCh(),false);
                break;
            case DELETE :
                if(cursor != null){
                    // if we have added only one character and we want to do undo.
                    // In that case, that one character will be removed making the whole
                    // text empty. Hence start becomes null.
                    if(cursor.getPrev() == null){
                        start= null;
                    }
                    // We always insert at prev/left position of cursor, so do the same for delete
                    delete(cursor.getPrev());
                }
                break;
            default:
                return;
        }
    }

    @Override
    public String print() {
        StringBuilder sb = new StringBuilder();
        CharacterNode temp = start;
        //When there is no character just print the cursor
        if(start == null){
            sb.append("|");
        }
        while(temp !=null){
            //System.out.print(temp.getCh());
            if(temp==cursor) {
                sb.append('|');
            }
            if(temp.getCh()!='\0') {
                sb.append(temp.getCh());
            }
            temp = temp.getNext();
        }

        System.out.println(sb.toString());
        return sb.toString();
    }

    @Override
    public CharacterNode getCursor() {
        return cursor;
    }
}
