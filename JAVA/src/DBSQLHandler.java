//import java.sql.*;
//import java.util.ArrayList;
//
//import org.mariadb.jdbc.*;
//
//public class DBSQLHandler
//{
//    private static DBSQLHandler instance;
//
//    public static DBSQLHandler GetInstance()
//    {
//        if(instance == null)
//        {
//            instance = new DBSQLHandler();
//        }
//        return instance;
//    }
//
//    private DBSQLHandler()
//    {
//        Init();
//    }
//
//    String driver        = "org.mariadb.jdbc.Driver";
//    String url           = "jdbc:mariadb://127.0.0.1:3306/matzip";
//    String uId           = "root";
//    String uPwd          = "1111";
//
//    Connection con;
//    PreparedStatement pstmt;
//    Statement stmt;
//    ResultSet rs;
//
//    private void Init()
//    {
//        try
//        {
//            Class.forName(driver);
//            con = DriverManager.getConnection(url,uId,uPwd);
//
//            if(con!=null){
//                System.out.println("DB 접속 성공");
//            }
//        }catch(ClassNotFoundException e){
//            System.out.println("드라이버 로드 실패");
//        }catch(SQLException e) {
//            System.out.println("DB접속실패");
//        }
//    }
//
//    public int TryLogin(String userId, String pw)
//    {
//        String sql = "select pw from users where ID='"+userId+"'";
//        try {
//            pstmt                = con.prepareStatement(sql);
//            rs                   = pstmt.executeQuery();
//            if(rs.next()){
//                String rightpw = rs.getString("pw");
//                if(rightpw.equals(pw)) {
//                    pstmt.close();
//                    return 200;
//                }
//                else {
//                    System.out.println("비번이 다르다 " + rightpw);
//                }
//            }
//            pstmt.close();
//        } catch (SQLException e) { System.out.println("쿼리 수행 실패"); }
//        return 400; //실패
//    }
//
//    public ArrayList<String> SearchRestaurant(String keyword, String category, String sortby)
//    {
//        ArrayList<String> resultList = new ArrayList<>();
//        String sql = "select res_id,name,category,location,avg(Review.rate) \n" +
//                "From Restaurant " +
//                "natural join Review \n" +
//                "where name like '%"+keyword+"%' " +
//                (category.length()>1 ? "and category='"+category+"'" : "") +
//                "group by res_id \n" +
//                (sortby == "rate" ? "order by avg(Review.rate) desc;" :
//                        (sortby == "location" ? "order by location;" :
//                                "order by name;"));
//
//
//        try {
//            pstmt                = con.prepareStatement(sql);
//            rs                   = pstmt.executeQuery();
//            System.out.println("res_id\t\tname\t\tcategory");
//            while(rs.next()){
//                System.out.print(rs.getInt("res_id")+"\t\t");
//                System.out.print(rs.getString("name")+"\t\t\t");
//                System.out.println(rs.getString("category")+"\t\t");
//                resultList.add(rs.getString("name"));
//            }
//            pstmt.close();
//        } catch (SQLException e) { System.out.println("쿼리 수행 실패"); }
//        return resultList;
//    }
//
//    public void WriteReview(int rate, String review, int res_id, int user_id)
//    {
//        String sql = "INSERT INTO Review(rate,review,res_id,user_id) VALUES("+rate+",'"+review +"',"+res_id+","+user_id+");";
//        try {
//            pstmt                = con.prepareStatement(sql);
//            rs                   = pstmt.executeQuery();
//            pstmt.close();
//        } catch (SQLException e) { System.out.println("쿼리 수행 실패 : "+e.toString()); }
//    }
//
//    public ArrayList<String> GetReviews(int res_id)
//    {
//        ArrayList<String> resultList = new ArrayList<>();
//        String sql = "select Users.id,`review`,rate\n" +
//                "from Review natural join Users\n" +
//                "where res_id="+res_id;
//
//
//        try {
//            pstmt                = con.prepareStatement(sql);
//            rs                   = pstmt.executeQuery();
//            System.out.println("userid\t\treview\t\trate");
//            while(rs.next()){
//                System.out.print(rs.getString("id")+"\t\t");
//                System.out.print(rs.getString("review")+"\t\t\t");
//                System.out.println(rs.getInt("rate")+"\t\t");
//                resultList.add(rs.getString("review"));
//            }
//            pstmt.close();
//        } catch (SQLException e) { System.out.println("쿼리 수행 실패"); }
//        return resultList;
//    }
//
//    public String GetRestaurantInformation(int res_id)
//    {
//        String resultInformation = "";
//        String sql = "select name,avg(rate) as rate\n" +
//                "from Restaurant natural join Review\n" +
//                "where res_id=" + res_id+";";
//
//
//        try {
//            pstmt                = con.prepareStatement(sql);
//            rs                   = pstmt.executeQuery();
//            System.out.println("name\t\trate");
//            while(rs.next()){
//                System.out.print(rs.getString("name")+"\t\t");
//                System.out.print(rs.getFloat("rate")+"\t\t\t");
//                resultInformation = rs.getString("name") + "|" + rs.getFloat("rate");
//            }
//            pstmt.close();
//        } catch (SQLException e) { System.out.println("쿼리 수행 실패"); }
//        return resultInformation;
//    }
//}
