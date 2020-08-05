package design_data_structure_questions;

import java.util.Stack;

/*
 * Time Complexity = O(N), where N denotes the number of operations or Elements in the String[][]
 * Space Complexity = O(N)
 */

/*
 * Implement Text Editor Undo Redo. We aim to implement rudimentary undo & redo.
 * 
 * You will be provided a set of actions to perform. Once all actions are performed you will return the 
 * current state the system should be in after all actions in actions are performed.
 * 
 * We will be operating on characters and the "state" of the system will be a string that we are building.
 * These are the actions possible:
 * INSERT: Inserts a single character to the end of the string
 * DELETE: Removes the last character in the string
 * UNDO: Reverses the most recent action
 * REDO: Redoes the most recent action undone
 * 
 * Your inputs will only be single characters. There are only 4 input actions as enumerated above.
 * Example 1:
 * Input:
 * INSERT 'a'
 * INSERT 'b'
 * 
 * Output: "ab"
 * 
 * Example 2:
 * Input:
 * INSERT 'a'
 * INSERT 'b'
 * UNDO
 * 
 * Output: "a"
 * 
 * Example 3:
 * Input:
 * INSERT 'a'
 * INSERT 'b'
 * UNDO
 * REDO
 * 
 * Output: "ab"
 * 
 * Example 4:
 * Input:
 * INSERT 'a'
 * INSERT 'b'
 * UNDO
 * REDO
 * REDO # Does nothing
 * 
 * Output: "ab"
 */

public class ImplementTextEditor {

    public enum ActionType{
        INSERT,
        DELETE,
        UNDO,
        REDO
    }
	
    public class Action{
        Character character;
        ActionType type;

        public Action(Character character, ActionType type){
            this.character = character;
            this.type = type;
        }

        public Action(ActionType type){
            this(null, type);
        }
    }
    
    public void insertCharacter(Character c, Stack<Action> stack, StringBuilder sb){
        sb.append(c);
        Action oppositeAction = new Action(ActionType.DELETE);
        stack.push(oppositeAction);
    }
    
    public void deleteCharacter(Stack<Action> stack, StringBuilder sb){
        int sblen = sb.length()-1;
        char deleteChar = sb.charAt(sblen);
        sb.deleteCharAt(sblen);

        Action oppositeAction = new Action(deleteChar, ActionType.INSERT);
        stack.push(oppositeAction);
    }
    
    public String implementTextEditor(String[][] input){
        StringBuilder sb = new StringBuilder();

        Stack<Action> undo = new Stack<>();
        Stack<Action> redo = new Stack<>();

        for(String[] s: input)
        {
            switch(s[0])
            {
                case "INSERT":
                    insertCharacter(s[1].charAt(0), undo, sb);

                    redo.clear();
                    break;

                case "DELETE":
                    deleteCharacter(undo, sb);

                    redo.clear();
                    break;

                case "UNDO":
                    Action undoact = undo.pop();

                    if(undoact.type == ActionType.DELETE){
                        deleteCharacter(redo, sb);
                    }else if(undoact.type == ActionType.INSERT){
                        insertCharacter(undoact.character, redo, sb);
                    }
                    break;

                case "REDO":
                    if(redo.size() != 0){
                        Action redoact = redo.pop();
                        if(redoact.type == ActionType.DELETE){
                            deleteCharacter(undo, sb);
                        }else if(redoact.type == ActionType.INSERT){
                            insertCharacter(redoact.character, undo, sb);
                        }
                    }
                    break;
            }
        }
        return sb.toString();
    }
    
	public static void main(String[] args) {
		String[][] input = {
				{"INSERT", "a"},
				{"INSERT", "b"},
				{"UNDO"},
				{"REDO"},
				{"REDO"}
		};
		
		ImplementTextEditor textEditorObj = new ImplementTextEditor();
		String result = textEditorObj.implementTextEditor(input);
		System.out.println("Result = " + result);
	}

}

