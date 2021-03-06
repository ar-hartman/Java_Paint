package view.gui;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import javax.swing.*;
import javax.swing.border.*;

import collection.ClipBoard;
import command.CopyCommand;
import command.DeleteCommand;
import command.ICommand;
import command.NullCommand;
import command.PasteCommand;
import command.RedoCommand;
import command.UndoCommand;
import model.Selector;
import mouse.MouseHandler;
import view.interfaces.IGuiWindow;
import view.EventName;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * Description of changes:
 * - Added mouseListener to the GuiWindow instantiation
 * - Added actionPerformed logic to trigger the following commands: UNDO, REDO, COPY, PASTE, and DELETE
 * 
 * Added Fields:
 * - n/a
 * 
 * Added Methods:
 * - actionPerformed
 */

public class GuiWindow extends JFrame implements IGuiWindow, ActionListener {
	private static final long serialVersionUID = 1L;
	private final int defaultWidth = 1200;
    private final int defaultHeight = 800;
    private final String defaultTitle = "JPaint";
    private final Insets defaultButtonDimensions = new Insets(5, 8, 5, 8);
    private final Map<EventName, JButton> eventButtons = new HashMap<>();
	private final PaintCanvas canvas;


    public GuiWindow(PaintCanvas canvas, MouseHandler mouseHandler){
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle(defaultTitle);
        setSize(defaultWidth, defaultHeight);
        JPanel window = createWindow();
        this.canvas = canvas;
        window.add(canvas, BorderLayout.CENTER);
        window.addMouseListener(mouseHandler);    
		validate();
    }


	@Override
	public JButton getButton(EventName eventName) {
		if(!eventButtons.containsKey(eventName))
			throw new NoSuchElementException("No button exists for action " + eventName.toString());
		
		return eventButtons.get(eventName);
	}

	private JPanel createWindow() {
		JPanel contentPane = createBackgroundPanel();
        JPanel buttonPanel = createMenu();
        contentPane.add(buttonPanel, BorderLayout.NORTH);
        return contentPane;
	}

    private JPanel createMenu() {
        JPanel buttonPanel = createButtonPanel();

        for(EventName eventName : EventName.values()){
            addButtonToPanel(eventName, buttonPanel);
        }

        return buttonPanel;
    }

	private void addButtonToPanel(EventName eventName, JPanel panel) {
		JButton newButton = createButton(eventName);
        eventButtons.put(eventName, newButton);
        panel.add(newButton);
	}

	private JButton createButton(EventName eventName) {
		JButton newButton = new JButton(eventName.toString());
		newButton.setForeground(Color.BLACK);
		newButton.setBackground(Color.WHITE);
        newButton.setBorder(createButtonBorder());
        newButton.addActionListener(this);
		return newButton;
	}

	private Border createButtonBorder() {
        Border line = new LineBorder(Color.BLACK);
        Border margin = new EmptyBorder(defaultButtonDimensions);
    	return new CompoundBorder(line, margin);
	}

	private JPanel createButtonPanel() {
		JPanel panel = new JPanel();
        FlowLayout flowLayout = (FlowLayout) panel.getLayout();
        flowLayout.setAlignment(FlowLayout.LEFT);
        panel.setBackground(Color.lightGray);
		return panel;
	}

    private JPanel createBackgroundPanel() {
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
        contentPane.setLayout(new BorderLayout(0, 0));
        contentPane.setBackground(Color.WHITE);
        setContentPane(contentPane);
        return contentPane;
    }


	@Override
	public void actionPerformed(ActionEvent e) {
		ICommand command;
		String action = e.getActionCommand().toString();
		
		switch(action) {
		case "UNDO":
			command = new UndoCommand();
			break;	
		case "REDO":
			command = new RedoCommand();
			break;
		case "DELETE":
			command = new DeleteCommand(Selector.getShape());
			break;
		case "COPY":
			command = new CopyCommand(Selector.getShape());
			break;
		case "PASTE":
			command = new PasteCommand(ClipBoard.getShape());
			break;
		default:
			command = new NullCommand();
		}
		command.execute();
	}



}
