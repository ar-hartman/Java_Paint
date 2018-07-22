package command;

import java.util.ArrayList;
import java.util.List;

public class CommandList {
	private List<Command> commandList = new ArrayList<Command>();
	
	public void takeCommand(Command command) {
		commandList.add(command);
	}
	public void doCommand() {
		for (Command command: commandList) {
			command.execute();
		}
	}
}

