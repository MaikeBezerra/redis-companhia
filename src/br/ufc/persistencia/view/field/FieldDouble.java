package br.ufc.persistencia.view.field;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class FieldDouble implements KeyListener{

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		char vchar = e.getKeyChar();
		if ((!Character.isDigit(vchar) && vchar != '.') ||
				vchar == KeyEvent.VK_BACK_SPACE ||
				vchar == KeyEvent.VK_DELETE) {
			e.consume();
		}
	}
	
}
