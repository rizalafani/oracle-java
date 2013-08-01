package oracrud;
import java.sql.*;
public class DBConnection {
    public DBConnection() {
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("Driver ditemukan");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "rizal", "admin");
        }catch(SQLException e){
            e.printStackTrace();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    
    private Connection conn;
    private Statement stat;
    private String sql;

    /* using singleton pattern for create instance object */
    public static DBConnection obj = null;
    public static DBConnection GetInstance(){
        if(obj == null){
            obj = new DBConnection();
        }
        return obj;
    }
    /* end singleton */

    private ResultSet GetData(String sql){
        try{
            stat = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            return stat.executeQuery(sql);
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    private int ManipulasiData(String sql){
        try{
            stat = conn.createStatement();
            return stat.executeUpdate(sql);
        }catch(SQLException e){
            e.printStackTrace();
            return 0;
        }
    }

    public ResultSet GetMahasiswa(){
        sql = "select * from mahasiswa";
        return GetData(sql);
    }

    public ResultSet GetMahasiswa(String where){
        sql = "select * from mahasiswa "+where;
        return GetData(sql);
    }

    public int DeleteMahasiswa(String where){
        sql = "delete from mahasiswa "+where;
        return ManipulasiData(sql);
    }

    public int UpdateData(String nim,String nama,String alamat){
        sql = "update mahasiswa set nama = '"+nama+"',alamat = '"+alamat+"' where nim = '"+nim+"'";
        return ManipulasiData(sql);
    }

    public int InsertData(String nim,String nama,String alamat){
        sql = "insert into mahasiswa (nim,nama,alamat) values ('"+nim+"','"+nama+"','"+alamat+"')";
        return ManipulasiData(sql);
    }
}
