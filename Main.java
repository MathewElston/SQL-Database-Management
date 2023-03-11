public class Main {
    public static void main(String[] args) {
        String connectionString = "jdbc:mysql://localhost:3306/coffee_db";
        String tableName = "coffee";
        String columns[] = {
            "product_name",
            "product_price"
        };
        String values[] = {
            "columbia",
            "$2.99"
        };
        String value = "Seattles Best";
        
        SQLDataBase database = new SQLDataBase(tableName, connectionString, "root", "");
        database.insert(columns, values);
    }
    
}
