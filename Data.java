package couriermanagementsystem.models;

public class Data {
    public static User[] users = new User[100];
    public static int userCount = 0;

    public static Order[] orders = new Order[100];
    public static int orderCount = 0;

    public static void addUser(User user) {
        if (userCount < users.length) {
            users[userCount++] = user;
        }
    }

    public static void addOrder(Order order) {
        if (orderCount < orders.length) {
            orders[orderCount++] = order;
        }
    }
}