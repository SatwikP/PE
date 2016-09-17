import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import calculateWeekday.CalculateWeekday; 

public class Main extends Application 
{
	private static final int String =0;
	TextField uidText;
	TextField nameText;
	TextField ageText;
	TextField sexText;
	TextField dobText;
	TextField heightText;
	TextField weightText;
	TextField birthdayText;
	TextField addressText;
	TextField aadhaarnoText;
	@Override
	public void start(Stage stage)
	{
		VBox pane=new VBox();
		
		createControls(pane);
		
		stage.setScene(new Scene(pane, 640, 480));
		stage.setTitle("Clinical Informatics");
		stage.setResizable(false);
		stage.show();
	}
	
	private void createControls(VBox pane) 
	{
		Text uidLabel=new Text("UID");
		uidText=new TextField();
		
		Text nameLabel=new Text("Name");
		nameText=new TextField();
		
		Text ageLabel=new Text("Age");
		ageText=new TextField();
		
		Text sexLabel=new Text("Sex");
		sexText=new TextField();
		
		Text dobLabel=new Text("DOB(dd/mm/yyyy)");
		dobText=new TextField();
		
		Text heightLabel=new Text("Height");
		heightText=new TextField();
		
		Text weightLabel=new Text("Weight");
		weightText=new TextField();
		
		Text birthdayLabel=new Text("BirthDay");
		birthdayText=new TextField();
		
		Text addressLabel=new Text("Address");
		addressText=new TextField();
		
		Text aadhaarnoLabel=new Text("AadhaarNo");
		aadhaarnoText=new TextField();
		
		Button saveButton=new Button("Save");
		saveButton.setOnAction(e-> validateData());
		
		pane.getChildren().addAll(uidLabel, uidText, nameLabel, nameText,ageLabel,ageText,sexLabel ,sexText,dobLabel,dobText,heightLabel,heightText,weightLabel,weightText,birthdayLabel,birthdayText,addressLabel,addressText,aadhaarnoLabel,aadhaarnoText,saveButton);
	}
	
	private void validateData()
	{
		 uidValidation();//calling method
		 nameValidation();
		 ageValidation();
		 sexValidation();
		 dobValidation();
		 heightValidation();
		 weightValidation();
		 birthdayValidation();
		 addressValidation();
		 aadhaarnoValidation();
	}
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
private void birthdayValidation() 
{
	CalculateWeekday calc=new CalculateWeekday();
	System.out.println(calc.getWeekday());
		
}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
private boolean aadhaarnoValidation() 
{
	try
	{
	
		long aadhaarno=Long.parseLong(aadhaarnoText.getText());
		System.out.println(aadhaarno);
		return true;
	}
	catch(Exception ex)
	{
		errorMessageBox("aadhaar should only contain numbers");
		return false;
	}
	
}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
private void addressValidation() 
{

		String address=(addressText.getText());
		String address1="gdfkjshk";
		if(address.compareTo(address1)>0)
		{
			errorMessageBox("Address is satisfied");
		}
		else
		{
			errorMessageBox("Address should only contain characters and numbers combination");
		}
	
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
private boolean weightValidation() 
{
	try  
	{
		long weight=Long.parseLong(weightText.getText());
		if(weight<=0)
		{
			errorMessageBox("In weight negative values are not accepted ");	
		}
		if(weight<=300)
		{
			errorMessageBox("weight is applicable");
			return true;
		}
		else
		{
			errorMessageBox("weight is not applicable");
			return false;
		}
	}
	catch(Exception ex)
	{
		errorMessageBox("weight should only contain numbers");
		return false;
	}
}		

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	

private boolean heightValidation() 
{
	String height=(heightText.getText());
	System.out.println(height.charAt(0));
		char c=height.charAt(3);
		int number=57;
		int number2=50;
		int number1=49;
		int length1=5;
		int length2=6;
		if(length1==5)
		{
			if(c<=number)
			{
				System.out.println("inches value is accepted");
			}
		}
		char c1=height.charAt(3);
		char c2=height.charAt(4);
		if(length2==6)
		{
			if(c1==number1&&c2<=number2)
			{
				System.out.println("inches value is accepted");
			}
			else
			{
				System.out.println("inches value is not accepted");
			}
		}
	
	try
	{
		char c3=height.charAt(0);
		int number3=57;
		if(c3<=number3)
		{
			System.out.println("Feets value is accepted");
			return true;
		}
	}
	catch (Exception ex) 
	{
		{
			System.out.println("Feets value is not accepted");
			return false;
		}
		
	}		
		
		int length=height.length(); 
		if(length==5||length==6)
		{
			System.out.println("true");
		}
		else
		{
			System.out.println("error");
			return false;
		}
		return false;		
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
private boolean dobValidation() 
{
	
		String dob=(dobText.getText());
		SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
		String date=dob;
		String[] datesplit= date.split("/");
		int year=Integer.parseInt(datesplit[2]);
		if(year>=1866)
		{
			System.out.println("It is valid");
		}
		else
		{
			errorMessageBox("It is not valid");
			return false;
		}
		String todaydate="17-09-2016";
		if(dob.compareTo(todaydate)<0)
		{
			return true;
		}
		else
		{
			errorMessageBox("greater than today date is not valid");
		}
		try
		{
			Date d= fmt.parse(dob);
			System.out.println(d);
			return true;
		}
		catch (Exception ex) 
		{
			errorMessageBox("given date is not in correct format");
			return false;
		}			
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	private void sexValidation() 
	{
			String sex=(sexText.getText());
			String female="female";
			String male="male";
			if(sex.compareTo(female)==0||sex.compareTo(male)==0)
			{
				errorMessageBox("It should accepts");
			}
			else
			{
				errorMessageBox("only male or female");
			}
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	private boolean ageValidation() 
	{
		try  
		{
			long a=Long.parseLong(ageText.getText());
			if(a<=150)
			{
				errorMessageBox("given age is accepted");
			}
			else
			{
				errorMessageBox("In age field more than 150 age is not accepted");
			}
			if(a<=0)
			{
				errorMessageBox("given age should not be in zero and negative values");;
			}
		}
		catch(Exception ex)
		{
			errorMessageBox("Age should only contain numbers");
			return false;
		}
		return false;
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	private void nameValidation()
	{
		String name=(nameText.getText());
		int asciinumber=0;

		int ascii=name.charAt(0);
		System.out.println(ascii);
		for(int i=0;i<=name.length()-1;i++)
		{
			asciinumber=name.charAt(i);
			System.out.println(asciinumber);
			
			if(asciinumber>=97 && asciinumber<=122 || asciinumber>=65 && asciinumber<=90)
			{
				System.out.println("ascii value is avaliable");
			}
			else
			{
				errorMessageBox("ascii value is not avaliable");
				break;
			}
		}

			if(name.length()>50)
			{
				errorMessageBox("Name should contain only 50 charcters");
			}
	}
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	private boolean uidValidation()//called method and method definition
	{
		try  
		{
			long a=Long.parseLong(uidText.getText());
			if(a<=0)
			{
				errorMessageBox("In UID zero value and negative values are not accepted ");
			}
			if(a<=9999999999l)
			{
				return true;
			}
			else
			{
				System.out.println("It is not applicable");
				return false;
			}
		}
		catch(Exception ex)
		{
			errorMessageBox("UID should only contain numbers");
			return false;
		}
	} 

	private void errorMessageBox(String message) 
	{
		Alert alert=new Alert(AlertType.ERROR);
		alert.setTitle("Clinical Informatics");
		alert.setContentText(message);
		alert.showAndWait();
	}

	public static void main(String args[])
	{
		launch(args);
	}
}