import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String connectionString = "jdbc:mysql://localhost:3306/coffee_db";
        String tableName = "customer";
        SQLDataBase database = new SQLDataBase(tableName, connectionString, "root", "");
        String columns[] = {
            "name",
            "phone",
            "email"
        };

        System.out.println("How many items would you like to add to the table?");
        int totalCount = keyboard.nextInt();
        keyboard.nextLine();
        int count = 0;
        String values[] = new String [columns.length];
        while (count < totalCount) {
            int index = 0;
            System.out.println("Customer Name?");
            String customerName = keyboard.next();
            values[index] = customerName;
            index++;

            System.out.println("Customer phone number?");
            String customerPhone = keyboard.next();
            values[index] = customerPhone;
            index++;
            
            System.out.println("Customer Email?");
            String customerEmail = keyboard.next();
            values[index] = customerEmail;
            database.insert(columns, values);
            count++;
        }
        keyboard.close();
    }    
}
