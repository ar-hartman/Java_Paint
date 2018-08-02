package command;

public class UndoCommand implements ICommand{

	@Override
	public void execute() {
		System.out.println("Undo Command Triggered");
		CommandHistory.undo();
	}

}
