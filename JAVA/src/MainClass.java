public class MainClass {
    public static void main(String[] args)
    {
        System.out.println("HELLO WORLD");
        DBSQLHandler.GetInstance();
        System.out.println(DBSQLHandler.GetInstance().TryLogin("이가네","2234"));
        DBSQLHandler.GetInstance().SearchRestaurant("","한식","rate");
        //DBSQLHandler.GetInstance().WriteReview(3,"haha",100,2);
        DBSQLHandler.GetInstance().GetReviews(100);
        DBSQLHandler.GetInstance().GetRestaurantInformation(100);
    }
}
