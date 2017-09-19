package carMenu;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;



public class CarMenu extends JFrame{
	private JMenuBar menuBar;
	private ArrayList<Car> cars;
	private HashMap<String, JMyMenu> carNames;//набор марок
	private HashMap<String, JMenuItem> carNameMarks;//набор моделей
	private HashMap<String, String> modelWriteUp;//Cоответствие модели и описания
	private JTextArea text;
	private JButton button;
	private String value;
	
	public CarMenu() {
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		text = new JTextArea();
		text.setBounds(37, 63, 123, 132);
		button = new JButton("Заменить");
		button.setBounds(47, 207, 113, 23);
		
		cars = new ArrayList<>();
		carNames = new HashMap<>();
		carNameMarks = new HashMap<>();
		modelWriteUp = new HashMap<>();
		
		Container c = getContentPane();
		c.setLayout(null);		
		
		setTitle("Редактор описания машин");
		getContentPane().setBackground(Color.cyan);		
		setBounds(100, 100, 250, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);		
		setVisible(true);
		
		addCars(); // заполняем массив cars марками машин
		
		createMenu();//Cоздаем меню

		//обрабатываем слушателя
		//для кнопки
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				modelWriteUp.put(value, text.getText());			
			}
		});
		
		//для итемов
		for (Map.Entry<String, JMenuItem> ent : carNameMarks.entrySet()) {			
			ent.getValue().addActionListener(new ActionListener() {
				

				@Override
				public void actionPerformed(ActionEvent e) {					
					text.setText(modelWriteUp.get(e.getActionCommand()));
					c.add(text);
					c.add(button);
					value = e.getActionCommand();
					getContentPane().repaint();
				}
			});
		}				
		
	}
	


	private void createMenu() {
		for (int i= 0; i < cars.size(); i++) {
			Car car = cars.get(i);
			//Если марки еще нет, то дабавляем ее 
			if (!carNames.containsKey(car.getMark())) {				
				carNames.put(car.getMark(), new JMyMenu(car.getMark()));
				menuBar.add(carNames.get(car.getMark()));
				//и добавляем модель
				carNameMarks.put(car.getModel(), new JMenuItem(car.getModel()));
				carNames.get(car.getMark()).add(carNameMarks.get(car.getModel()));
				//Заполняем modelWriteUp
				modelWriteUp.put(car.getModel(), car.getWriteUp());
			}
			//Иначе добавляем к марке модель
			else {
				carNameMarks.put(car.getModel(), new JMenuItem(car.getModel()));
				carNames.get(car.getMark()).add(carNameMarks.get(car.getModel()));
				//Заполняем modelWriteUp
				modelWriteUp.put(car.getModel(), car.getWriteUp());
			}
		}
	}

	private void addCars() {
		Car bmw1 = new Car("bmw", "x6", "sam anover text");
		Car bmw2 = new Car("bmw", "x5", "sam text");
		Car audi = new Car("audi", "z", "sam text");
					
		cars.add(bmw1);
		cars.add(bmw2);
		cars.add(audi);
	}

}
