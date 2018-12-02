import java.sql.*;
import java.util.ArrayList;
import java.util.Random;

import org.mariadb.jdbc.*;

public class DBSQLHandler
{
    private static DBSQLHandler instance;

    public static DBSQLHandler GetInstance()
    {
        if(instance == null)
        {
            instance = new DBSQLHandler();
        }
        return instance;
    }

    private DBSQLHandler()
    {
        Init();
    }

    String driver        = "org.mariadb.jdbc.Driver";
    String url           = "jdbc:mariadb://127.0.0.1:3306/matzip";
    String uId           = "root";
    String uPwd          = "1111";

    Connection con;
    PreparedStatement pstmt;
    Statement stmt;
    ResultSet rs;

    private void Init()
    {
        try
        {
            Class.forName(driver);
            con = DriverManager.getConnection(url,uId,uPwd);

            if(con!=null){
                System.out.println("DB 접속 성공");
            }
        }catch(ClassNotFoundException e){
            System.out.println("드라이버 로드 실패");
        }catch(SQLException e) {
            System.out.println("DB접속실패");
        }
    }

    public int TryLogin(String userId, String pw)
    {
        String sql = "select user_id, pw from account where ID='"+userId+"'";
        try {
            pstmt                = con.prepareStatement(sql);
            rs                   = pstmt.executeQuery();
            if(rs.next()){
                String rightpw = rs.getString("pw");
                if(rightpw.equals(pw)) {
                    pstmt.close();
                    return rs.getInt("user_id");
                }
                else {
                    System.out.println("비번이 다르다 " + rightpw);
                }
            }
            pstmt.close();
        } catch (SQLException e) { System.out.println("쿼리 수행 실패"); }
        return -1; //실패
    }

    public ArrayList<RestaurantInfoClass> SearchRestaurant(String keyword, String category, String sortby)
    {
        ArrayList<RestaurantInfoClass> resultList = new ArrayList<>();
        String sql = "select res_id,name,category,location \n" +
                "From Restaurant " +
                "where name like '%"+keyword+"%' " +
                (category.length()>1 ? "and category='"+category+"'" : "") +
                "group by res_id \n" +
                //(sortby == "rate" ? "order by avg(Review.rate) desc;" :
                        (sortby == "location" ? "order by location;" :
                                "order by name;");


        try {
            pstmt                = con.prepareStatement(sql);
            rs                   = pstmt.executeQuery();
            System.out.println("res_id\t\tname\t\tcategory");
            while(rs.next()){
                System.out.print(rs.getInt("res_id")+"\t\t");
                System.out.print(rs.getString("name")+"\t\t\t");
                System.out.println(rs.getString("category")+"\t\t");
                RestaurantInfoClass info = new RestaurantInfoClass(rs.getInt("res_id"), rs.getString("name"));
                resultList.add(info);
            }
            pstmt.close();
        } catch (SQLException e) { System.out.println("쿼리 수행 실패"); }
        return resultList;
    }

    public ArrayList<String> GetReviews(int res_id)
    {
        ArrayList<String> resultList = new ArrayList<>();
        String sql = "select Users.user_id as id,`review`,rate\n" +
                "from Review natural join Users\n" +
                "where res_id="+res_id;


        try {
            pstmt                = con.prepareStatement(sql);
            rs                   = pstmt.executeQuery();
            System.out.println("userid\t\treview\t\trate");
            while(rs.next()){
                System.out.print(rs.getString("id")+"\t\t");
                System.out.print(rs.getString("review")+"\t\t\t");
                System.out.println(rs.getInt("rate")+"\t\t");
                resultList.add(rs.getInt("rate") + "점 : " + rs.getString("review"));
            }
            pstmt.close();
        } catch (SQLException e) { System.out.println("쿼리 수행 실패"); }
        return resultList;
    }

    public String GetRestaurantInformation(int res_id)
    {
        String resultInformation = "";
        String sql = "select name,avg(rate) as rate, category\n" +
                "from Restaurant natural join Review\n" +
                "where res_id=" + res_id+";";


        try {
            pstmt                = con.prepareStatement(sql);
            rs                   = pstmt.executeQuery();
            System.out.println("name\t\trate");
            while(rs.next()){
                System.out.print(rs.getString("name")+"\t\t");
                System.out.print(rs.getFloat("rate")+"\t\t\t");
                resultInformation = rs.getString("name") + "|" + rs.getFloat("rate") + "|" + rs.getString("category");
                System.out.print(resultInformation);
            }
            pstmt.close();
        } catch (SQLException e) { System.out.println("쿼리 수행 실패"); }
        return resultInformation;
    }

    public int WriteReview(int res_id, int user_id, String rv, int rate)
    {
        String resultInformation = "";
        String sql = "INSERT INTO Review(rate, review, res_id, user_id) VALUES("+rate+",'"+rv+"',"+res_id+","+user_id+");";


        try {
            pstmt                = con.prepareStatement(sql);
            rs                   = pstmt.executeQuery();
            System.out.println("리뷰 씀");
            pstmt.close();
            return 200;
        } catch (SQLException e) { System.out.println("쿼리 수행 실패"); }
        return 400;
    }

    public ArrayList<String> GetCoupons(int res_id)
    {
        ArrayList<String> resultInformation = new ArrayList<>();
        String sql = "select cp_id,Restaurant.name as name,discount,`point`\n" +
                "from Coupon natural join Restaurant\n" +
                "where res_id="+res_id;
        try
        {
            pstmt                = con.prepareStatement(sql);
            rs                   = pstmt.executeQuery();
            // System.out.println("name\t\trate");
            while(rs.next()){
                String row = rs.getString("cp_id") + "|" + rs.getInt("discount") + "|" + rs.getInt("point");
                System.out.print(row);
                resultInformation.add(row);
            }
            pstmt.close();
        } catch (SQLException e) { System.out.println("쿼리 수행 실패\n" + e); }
        return resultInformation;
    }

    public int BuyCoupon(String cp_id, int user_id)
    {
        String coupon = "";
        Random r = new Random();
        for(int i=0;i<12;i++)
        {
            coupon += r.nextInt(10);
        }
        String sql = "insert into `User-Coupon`(user_id,cp_id,code)\n" +
                "values('"+user_id+"','"+cp_id+"','"+coupon+"');";
        try
        {
            pstmt                = con.prepareStatement(sql);
            rs                   = pstmt.executeQuery();
            pstmt.close();
            return 1;
        } catch (SQLException e) { System.out.println("쿼리 수행 실패\n" + e); }
        return -1;
    }

    public int PutReservation(int user_id, int res_id, int nop, String time)
    {
        String coupon = "";
        Random r = new Random();
        for(int i=0;i<12;i++)
        {
            coupon += r.nextInt(10);
        }
        String sql = "insert into Reservation(user_id, res_id, number_of_people, time)\n" +
                    "values("+user_id+","+res_id+","+nop+",'"+time +"');";
        try
        {
            pstmt                = con.prepareStatement(sql);
            rs                   = pstmt.executeQuery();
            pstmt.close();
            return 1;
        } catch (SQLException e) { System.out.println("쿼리 수행 실패\n" + e); }
        return -1;
    }

    public int AddRestaurant(String name, String category, int location)
    {
        String sql = "insert into Restaurant(name,category,location) \n" +
                "values ('"+name+"','"+category+"',"+location+");";
        try
        {
            pstmt                = con.prepareStatement(sql);
            rs                   = pstmt.executeQuery();
            pstmt.close();
            return 1;
        } catch (SQLException e) { System.out.println("쿼리 수행 실패\n" + e); }
        return -1;
    }

    public int DeleteRestaurant(int res_id)
    {
        String sql = "delete from Restaurant where res_id="+res_id;
        try
        {
            pstmt                = con.prepareStatement(sql);
            rs                   = pstmt.executeQuery();
            pstmt.close();
            return 1;
        } catch (SQLException e) { System.out.println("쿼리 수행 실패\n" + e); }
        return -1;
    }


    public int AddMenu(int res_id, String name, int price)
    {
        String sql = "INSERT INTO `Menu-Res`(res_id,menu_name,price) " +
                "VALUES("+res_id+",'"+name+"',"+price+")";
        try
        {
            pstmt                = con.prepareStatement(sql);
            rs                   = pstmt.executeQuery();
            pstmt.close();
            return 1;
        } catch (SQLException e) { System.out.println("쿼리 수행 실패\n" + e); }
        return -1;
    }

    public int DeleteMenu(int res_id, String name)
    {
        String sql = "delete from `Menu-Res` where res_id="+res_id+" and Menu_name='"+name+"'";
        try
        {
            pstmt                = con.prepareStatement(sql);
            rs                   = pstmt.executeQuery();
            pstmt.close();
            return 1;
        } catch (SQLException e) { System.out.println("쿼리 수행 실패\n" + e); }
        return -1;
    }

    public ArrayList<String> GetMenus(int res_id)
    {
        ArrayList<String> result = new ArrayList<>();
        String sql = "select Menu_name from `Menu-Res` where res_id="+res_id;
        try
        {
            pstmt                = con.prepareStatement(sql);
            rs                   = pstmt.executeQuery();
            while(rs.next())
            {
                result.add(rs.getString("Menu_name"));
            }
            pstmt.close();
        } catch (SQLException e) { System.out.println("쿼리 수행 실패\n" + e); }
        return result;
    }
}
