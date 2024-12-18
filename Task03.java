import java.util.Scanner;
public class Task03 {
    static int count=0;//counts the number of contacts created
    static String[][]contact;// an array to store the contacts
    public static boolean numberChecker(String num){
        int counter=0;
        for(int i=0; i<num.length(); i++){
            char eachDigit=num.charAt(i);
            if(Character.isDigit(eachDigit)){
                counter++;
            }
        }
        return(counter==num.length()||((counter==num.length()-1)&&(num.charAt(0)=='+')));
    }
    public static String[][]deleteContact(String[][]contact, String number){
        if(count==0){
            System.out.print("No more contact to delete.");
            return contact;
        }
        String [][]newArray=new String[count][3];
        int index=0;
        for(int i=0; i<count;i++){
            if(!(number.equals(contact[i][0]))){
              newArray[index][0]=contact[i][0];
              newArray[index][1]=contact[i][1];
              newArray[index][2]=contact[i][2];
              index++;
            }
        }
        count--;
        return newArray;
    }
    public static void main(String[]args){
        Scanner input=new Scanner(System.in);
        boolean continuation=true;
        contact=new String [10][3];
         while (continuation) {
            System.out.println("\n1. Create a contact\n2. Edit contact\n3. Delete a contact\n4. View contact list\n5. Exit");
            System.out.print("Please choose: ");
            char choice = input.next().charAt(0);

            while (choice != '1' && choice != '2' && choice != '3' && choice != '4' && choice != '5') {
                System.out.print("Invalid choice. Enter a new one: ");
                choice = input.next().charAt(0);
            }
        if(choice=='1'){
            if(count==contact.length){
                String [][]temp=new String[contact.length*2][3];
                for(int i=0;i<count;i++){
                    temp[i][0]=contact[i][0];
                    temp[i][1]=contact[i][1];
                    temp[i][2]=contact[i][2];
                }
                contact=temp;
            }
        System.out.print("Enter the phone number: ");
        String number=input.next();
        while(numberChecker(number)==false){
            System.out.print("Invalid number entered. Enter a new one: ");
            number=input.next();
        }
        contact[count][0]=number;
        System.out.print("Enter the name: ");
        String name=input.next();
        contact[count][1]=name;
        System.out.print("Enter the email address: ");
        String email=input.next();
        contact[count][2]=email;
        System.out.println("Contact has been successfully created.");
        count++;
        }
        if(choice=='2'){
             if(count==0){
                System.out.print("No contact to edit.");
             }
             else{
            String num;
            boolean lookForNumber;
            do{
            System.out.print("Enter the phone number of the contact you want to edit: ");
            num=input.next();
            lookForNumber=false;
            for(int i=0;i<count;i++){
                if(num.equals(contact[i][0])){
                lookForNumber=true;
                break;
                }
            }
               if(!lookForNumber){
                System.out.println("phone number not found. Please try again.");
               }
            }while(!lookForNumber);
               for(int i=0; i<count;i++){
                   if(num.equals(contact[i][0])){
                   System.out.print("1.To edit number\n2.To edit name\n3.To edit email\n");
                   System.out.print("please choose: ");
                   char edit=input.next().charAt(0);
                   while(edit!='1'&&edit!='2'&&edit!='3'){
                   System.out.print("Invalid choice. Enter a new one: ");
                   edit=input.next().charAt(0);
                   }
                       if(edit=='1'){
                       System.out.print("Enter the editted number: ");
                       String edittedNumber=input.next();
                       while (!numberChecker(edittedNumber)) {
                          System.out.print("Invalid number entered. Please enter a number: ");
                          edittedNumber = input.next();
                        }        
                       contact[i][0]=edittedNumber;
                       System.out.println("Contact updated successfully");
                       }
                       else if(edit=='2'){
                       System.out.print("Enter the editted name: ");
                       String edittedName=input.next();
                       contact[i][1]=edittedName; 
                       System.out.println("Contact updated successfully");
                       }
                       else{
                       System.out.print("Enter the editted email: ");
                       String edittedEmail=input.next();
                       contact[i][2]=edittedEmail; 
                       System.out.println("Contact updated successfully");
                       }
                    }   
                }
             }
        }
        if(choice=='3'){
            if(count==0){
                System.out.print("No contact to delete.");
            }
            else{
            String num;
            boolean lookForNumber;
            do{
            System.out.print("Enter the phone number of the contact you want to delete: ");
            num=input.next();
            lookForNumber=false;
            for(int i=0;i<count;i++){
                if(num.equals(contact[i][0])){
                lookForNumber=true;
                break;
                }
            }
            if(!lookForNumber){
                System.out.println("phone number not found. Please try again.");
            }
            }while(!lookForNumber);
            contact=deleteContact(contact,num);
            System.out.print("Contact deleted successfully");
            }
        }
        if(choice=='4'){
            if(count==0){
                System.out.print("No contact to display.");
            }
           for(int i=0; i<count;i++){
                System.out.print("\nPhone: "+ contact[i][0]+"\nName: "+contact[i][1]+"\nEmail: "+contact[i][2]);
           }
        }
        if(choice=='5'){
            continuation=false;
            System.out.println("Thank you!");
            System.exit(0);
        }
      }
    }
}