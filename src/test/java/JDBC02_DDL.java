import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC02_DDL {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

    /*
 	A) CREATE TABLE, DROP TABLE, ALTER TABLE gibi DDL ifadeleri icin sonuc kümesi (ResultSet)
 	   dondurmeyen metotlar kullanilmalidir. Bunun icin JDBC'de 2 alternatif bulunmaktadir.

 	    1) execute() metodu
 	    2) executeUpdate() metodu.

 	B) - execute() metodu her tur SQL ifadesiyle kullanibilen genel bir komuttur.
 	   - execute(), Boolean bir deger dondurur. DDL islemlerinde false dondururken,
 	     DML islemlerinde true deger dondurur.
 	   - Ozellikle, hangi tip SQL ifadesinin kullanilmasinin gerektiginin belli olmadigi
 	     durumlarda tercih edilmektedir.

 	C) - executeUpdate() metodu ise INSERT, Update gibi DML islemlerinde yaygin kullanilir.
 	   - bu islemlerde islemden etkilenen satir sayisini dondurur.
 	   - Ayrıca, DDL islemlerinde de kullanilabilir ve bu islemlerde 0 dondurur.
 */

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC", "root", "235263");
        Statement st = con.createStatement();

    /*======================================================================
		  ORNEK1: isciler tablosunu siliniz.
 	========================================================================*/
        // String dropTable = "DROP TABLE isciler";

        // if (st.execute(dropTable))
        //   System.out.println("isciler tablosu silme işlemi gerçekleşmedi!!");
        // else
        //  System.out.println("İsciler tablosu silindi");


    /*=======================================================================
          ORNEK2: isciler adinda bir tablo olusturunuz id int,
          birim VARCHAR(10), maas int
	========================================================================*/

       // String createTable = "CREATE TABLE isciler" +
       //                     "(id INT, " +
       //                     "birim VARCHAR(10), " +
       //                     "maas INT)";

       // if (st.execute(createTable))
       //     System.out.println("Isciler tablosu create edildi!");
       // else
       //    System.out.println("Isciler tablosu create islemi basariyla gerceklesmedi!");

        /*=======================================================================
		  ORNEK3: isciler tablosuna yeni bir kayit (80, 'ARGE', 4000)
		  ekleyelim
		========================================================================*/

        String insertVeri = "INSERT INTO isciler VALUES(80, 'ARGE', 4000)";

        int satirSayisi = st.executeUpdate(insertVeri);

        System.out.println("Islemden etkilenen satir sayisi : " + satirSayisi);


    }

}