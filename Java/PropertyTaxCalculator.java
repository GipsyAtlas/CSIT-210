import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.*; //  Importing the core swing packages in java
 
public class PropertyTaxCalculator extends JFrame {
 
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField propertyValueTextField, assessmentValueTextField, propertyTaxTextField;
	private JLabel propertyValueLabel, assessmentValueLabel, propertyTaxLabel;
	private JButton calculateButton;
	
	//----------------------------//
	//  Lunching The Application  //
	//----------------------------//
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PropertyTaxCalculator frame = new PropertyTaxCalculator();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
 
	//----------------------//
	//  The Frame Creation  //
	//----------------------//

	public PropertyTaxCalculator() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		//  The Label for entering property value
		
		propertyValueLabel = new JLabel("Enter Property Value ($): ");
		propertyValueLabel.setPreferredSize(new Dimension(200, 40));
		contentPane.add(propertyValueLabel);
		
		//  The text field for entering property value
		
		propertyValueTextField = new JTextField();
		propertyValueTextField.setPreferredSize(new Dimension(200, 40));
		contentPane.add(propertyValueTextField);
		
		//  The Label for displaying the assessment value
		
		assessmentValueLabel = new JLabel ("Assement Value($):");
		assessmentValueLabel.setPreferredSize(new Dimension(200, 40));
		contentPane.add(assessmentValueLabel);
		
		//  The Text field for displaying the assessment value
		
		assessmentValueTextField = new JTextField();
		assessmentValueTextField.setPreferredSize(new Dimension(200, 40));
		assessmentValueTextField.setEditable(false);
		contentPane.add(assessmentValueTextField);
		
		//  The Label for displaying the property tax
		
		propertyTaxLabel = new JLabel("Property Tax ($): ");
		propertyTaxLabel.setPreferredSize(new Dimension(200, 40));
		contentPane.add(propertyTaxLabel);
		
		//  The Text field for displaying the property tax
		
		propertyTaxTextField = new JTextField();
		propertyTaxTextField.setPreferredSize(new Dimension(200, 40));
		propertyTaxTextField.setEditable(false);
		contentPane.add(propertyTaxTextField);
		
		//  The Button to calculate the property tax
		
		calculateButton = new JButton("Calculate");
		calculateButton.setPreferredSize(new Dimension(200, 40));
		contentPane.add(calculateButton);
		
		//  The Action listener for the button
		
		calculateButton.addActionListener(e ->{
		
			try {
				
				//  Getting the value from the text field and parse it as a double
				
				double propertyValue = Double.parseDouble(propertyValueTextField.getText());
			
				//  The Calculation assessment value (60% of actual value)
				
				double assessmentValue = propertyValue * 0.60;
			
				//  The Calculation property tax (assessment value * 0.64%)
				
				double propertyTax = (assessmentValue/100) * 0.64;
			
			    //  Setting the calculated values in the output text fields
				
				assessmentValueTextField.setText(String.format("%.2f", assessmentValue));
				propertyTaxTextField.setText(String.format("%.2f", propertyTax));
				
			} catch (NumberFormatException ex) {
				
				//  Display message for if the input is not valid
				
				assessmentValueTextField.setText("Invalid input");
				propertyTaxTextField.setText("Invalid input");
			}
			
		});
		
		
	}
 
}