package testeThread;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelThread extends JDialog{
	
	private JPanel jPanel = new JPanel(new GridBagLayout());
	
	private JLabel text1 = new JLabel("Nome");
	private JTextField field1 = new JTextField();
	
	private JLabel text2 = new JLabel("Relatório");
	private JTextField field2 = new JTextField();
	
	private JButton jButtonStart = new JButton("Start");
	private JButton jButtonStop = new JButton("Stop");
	private JButton jButtonLista = new JButton("Lista");
	
	private ImplementacaoFilaThread fila = new ImplementacaoFilaThread();

	public PanelThread() {
		setTitle("Panel Thread");
		setSize(new Dimension(240, 280));
		setResizable(false);
		setLocationRelativeTo(null);
		
		
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.insets = new Insets(0, 5, 15, 5);
		
		
		//Adicionando JLabel e JTextField
		text1.setPreferredSize(new Dimension(200, 25));
		jPanel.add(text1, gridBagConstraints);
		
		field1.setPreferredSize(new Dimension(200, 25));
		gridBagConstraints.gridy++;
		jPanel.add(field1, gridBagConstraints);
		
		text2.setPreferredSize(new Dimension(200, 25));
		gridBagConstraints.gridy++;
		jPanel.add(text2, gridBagConstraints);
		
		field2.setPreferredSize(new Dimension(200, 25));
		gridBagConstraints.gridy++;
		jPanel.add(field2, gridBagConstraints);
		
		
		//Adicionando JButton
		jButtonStart.setPreferredSize(new Dimension(93, 25));
		jButtonStop.setPreferredSize(new Dimension(93, 25));
		jButtonLista.setPreferredSize(new Dimension(200, 25));
		
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.gridy++;
		
		jPanel.add(jButtonStart, gridBagConstraints);
		gridBagConstraints.gridx++;
		jPanel.add(jButtonStop, gridBagConstraints);
		
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.gridy++;
		gridBagConstraints.gridx = 0;
		jPanel.add(jButtonLista, gridBagConstraints);
		
		
		jButtonStart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if( fila == null ) {
					fila = new ImplementacaoFilaThread();
					fila.start();
				}
				
				for( int i = 0; i < 10; i++ ) {					
					ObjetoFilaThread objetoFilaThread = new ObjetoFilaThread();
					objetoFilaThread.setNome(field1.getText());
					objetoFilaThread.setTituloRelatorio(field2.getText() + " " + i);
					fila.add(objetoFilaThread);
				}
				
			}
		});
		
		jButtonStop.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if( fila != null ) {					
					fila.stop();
					fila = null;
					
				}
				
			}
		});
		
		jButtonLista.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				fila.listaRelatorio();
				
			}
		});
		
		fila.start();
		add(jPanel);
		setVisible(true);
	}
}
