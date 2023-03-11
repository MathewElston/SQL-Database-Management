import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String connectionString = "jdbc:mysql://localhost:3306/coffee_db";
        String tableName = "customer";
        String columns[] = {
            "name",
            "phone",
            "email"
        };
        SQLDataBase database = new SQLDataBase(tableName, connectionString, "root", "");

        System.out.println("How many items would you like to add to the table?");
        int valueSize = keyboard.nextInt();
        keyboard.nextLine();
        String values[] = new String [valueSize * columns.length];
        int index = 0;
        for (int i = 0; i < valueSize -1; i++) {
            System.out.println("Customer Name?");
            String customerName = keyboard.nextLine();
            values[index] = customerName;
            index++;

            System.out.println("Customer phone number?");
            String customerPhone = keyboard.nextLine();
            values[index] = customerPhone;
            index++;

            System.out.println("Customer Email?");
            String customerEmail = keyboard.nextLine();
            values[index] = customerEmail;
            index++;
        }
        database.insert(columns, values);
        keyboard.close();
    }    
}
