package testing;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Application {
	
	Application(){
		JFrame f = new JFrame("Testing Interface");
	
		// create the buttons 
		JButton assessment = new JButton("Run Assessment Testing");
		assessment.setBounds(75, 10, 250, 50);
		JButton bookshelf = new JButton("Run Bookshelf Testing");
		bookshelf.setBounds(75, 70, 250, 50);
		JButton classboard = new JButton("Run Class Board Testing");
		classboard.setBounds(75, 130, 250, 50);
		JButton gradebook = new JButton("Run Gradebook Testing");
		gradebook.setBounds(75, 190, 250, 50);
		JButton lessons = new JButton("Run Lessons Testing");
		lessons.setBounds(75, 250, 250, 50);

		
		// add the buttons to the jframe
		f.add(assessment);
		f.add(bookshelf);
		f.add(classboard);
		f.add(gradebook);
		f.add(lessons);

		
		// set the size
		f.setSize(400, 400);
		f.setLayout(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// add action listener for assessment
		assessment.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				AssessmentTesting test = new AssessmentTesting();
				
				test.Login();
				
				test.openAssessmentTab();
				test.openAssessments();
				
				test.Close();

			}
		});
		
		// add action listener for bookshelf
		bookshelf.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				BookshelfTesting test = new BookshelfTesting();
							
				test.Login();
				
				test.openBookshelfTab();
				test.openResources();
				test.openMyBookshelfTab();
				test.addFile();
				test.addPhoto();
				test.addRainyPhoto();
				test.openMyBookshelfResources();
				
				test.Close();

			}
		});
		
		// add action listener for classboard
		classboard.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ClassBoardTesting test = new ClassBoardTesting();
				
				
				test.Login();
				
				test.openClassesTab();
				test.openClassBoards();
						
				test.Close();

			}
		});
		
		// add action listener for the gradebook
		gradebook.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				GradeBookTesting GBtest = new GradeBookTesting();
				
				GBtest.Login();
				
				GBtest.openGradebookTab();
				GBtest.openGrades();
						
				GBtest.Close();
				
			}
		});
		
		// add action listener for lessons
		lessons.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("made it here");
				LessonsTesting lessonsTest = new LessonsTesting();
				
				lessonsTest.Login();
				
				lessonsTest.openLessonsTab();
				lessonsTest.clickLesson();
				
				lessonsTest.Close();

				
			}
		});
		
	}
	
	public static void main(String[] args) {
		new Application();
		
	}
}
