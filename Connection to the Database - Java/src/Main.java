import java.sql.*;


public class Main {

    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            System.out.println("Start");
            Connection connect = DriverManager.getConnection("jdbc:mysql://dijkstra.ug.bcc.bilkent.edu.tr/burak_korkmaz","burak.korkmaz", "BqGpEqx1");
            System.out.println("Connected");


            Statement st = connect.createStatement();
            System.out.println("Statement Connected");

            st.execute("DROP TABLE IF EXISTS owns,account,customer");
            System.out.println("Dropped Table");

            String customer = "CREATE TABLE customer " +
                              "(cid CHAR(12)," +
                              "name VARCHAR(20)," +
                              "bdate DATE," +
                              "address VARCHAR(50)," +
                              "city VARCHAR(20),"+
                              "nationality VARCHAR(20)," +
                              "PRIMARY KEY(cid))";

            String account = "CREATE TABLE account " +
                             "(aid CHAR(8)," +
                             "branch VARCHAR(20)," +
                             "balance FLOAT," +
                             "openDate DATE," +
                             "PRIMARY KEY(aid))";

            String owns = "CREATE TABLE owns " +
                          "(cid CHAR(12)," +
                          "aid VARCHAR(8)," +
                          "PRIMARY KEY(cid,aid), " +
                          "FOREIGN KEY (cid) REFERENCES customer(cid)," +
                          "FOREIGN KEY (aid) REFERENCES account(aid))";


            st.execute(customer);
            System.out.println("Customer Created");

            st.execute(account);
            System.out.println("Account Created");

            st.execute(owns);
            System.out.println("Owns Created");

            st.execute("INSERT INTO customer VALUES " +
                            "(20000001,'Cem','1980-10-10' , 'Tunali' , 'Ankara' , 'TC' ) , " +
                            "(20000002, 'Asli' , '1985-09-08' , 'Nisantasi' , 'Istanbul' , 'TC' ) , " +
                            "(20000003, 'Ahmet' , '1995-02-11' , 'Karsiyaka' , 'Izmir' , 'TC' ) , " +
                            "(20000004, 'John' , '1990-04-16' , 'Kizilay' , 'Ankara', 'ABD' ) ; " );

            System.out.println("Customers Inserted");


            st.execute("INSERT INTO account VALUES " +
                            "('A0000001' , 'Kizilay' , 2000.00 , '2009-01-01' )," +
                            "('A0000002' , 'Bilkent' , 8000.00, '2011-01-01' )," +
                            "('A0000003' , 'Cankaya' , 4000.00, '2012-01-01' )," +
                            "('A0000004' , 'Sincan' , 1000.00, '2012-01-01' )," +
                            "('A0000005' , 'Tandogan' , 3000.00, '2013-01-01' )," +
                            "('A0000006' , 'Eryaman' , 5000.00, '2015-01-01' )," +
                            "('A0000007' , 'Umitkoy' , 6000.00, '2017-01-01' );" );

            System.out.println("Account Inserted");

            st.execute("INSERT INTO owns VALUES " +
                            "(20000001,'A0000001')," +
                            "(20000001,'A0000002')," +
                            "(20000001,'A0000003')," +
                            "(20000001,'A0000004')," +
                            "(20000002,'A0000002')," +
                            "(20000002,'A0000003')," +
                            "(20000002,'A0000005')," +
                            "(20000003,'A0000006')," +
                            "(20000003,'A0000007')," +
                            "(20000004,'A0000006');" );

            System.out.println("Owns Inserted");

            System.out.println("Contents of each table is printing...");
            System.out.println();

            ResultSet resultSet1 = st.executeQuery("SELECT * FROM customer");

            System.out.println("cid \t name \t bdate \t\t\t address \t city \t\t nationality");

            while(resultSet1.next() ) {
                System.out.println(resultSet1.getString("cid") + " " +
                        resultSet1.getString("name") + " \t " +
                        resultSet1.getString("bdate") + " \t " +
                        resultSet1.getString("address") + " \t " +
                        resultSet1.getString("city") + "  \t " +
                        resultSet1.getString("nationality") );
            }

            System.out.println();

            ResultSet resultSet2 = st.executeQuery("SELECT * FROM account");

            System.out.println("aid \t\t branch \t balance \topenDate");

            while(resultSet2.next() ) {
                System.out.println(resultSet2.getString("aid") + " \t " +
                        resultSet2.getString("branch") +  " \t " +
                        resultSet2.getString("balance") + " \t" +
                        resultSet2.getString("openDate") );
            }

            System.out.println();

            ResultSet resultSet = st.executeQuery("SELECT * FROM owns");

            System.out.println("cid \t aid ");

            while(resultSet.next() ) {
                System.out.println(resultSet.getString("cid") + " " +
                        resultSet.getString("aid"));
            }

        }


        catch (Exception e) {
            System.out.println(e);
        }
    }
}
