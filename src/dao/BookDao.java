package dao;

import java.sql.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import dto.BookDTO;

public class BookDao extends Dao{
	
	public List<String> getBookTitle() throws SQLException
	{
		Map<String,Integer> mp= new HashMap<String,Integer>();
		List<String> booktitle = new ArrayList<String>();
		PreparedStatement statement = this.connection.prepareStatement("Select distinct booktitle from books");
		System.out.println("Inside getBookTitle method");
		ResultSet resultset = statement.executeQuery();
		System.out.println("After resultset in getBookTitle method");
		while(resultset.next())
		
			booktitle.add(resultset.getString("BOOKTITLE"));
			resultset.close();
			statement.close();
			for (String string : booktitle) {
				System.out.println(string.toString());
			}
			return booktitle;
	}
	
	
	public List<String> getBookTitle2() throws SQLException
	{
		Map<String,Integer> mp= new HashMap<String,Integer>();
		List<String> booktitle = new ArrayList<String>();
		PreparedStatement statement = this.connection.prepareStatement("Select distinct booktitle,bookid from books");
		System.out.println("Inside getBookTitle method");
		ResultSet resultset = statement.executeQuery();
		System.out.println("After resultset in getBookTitle method");
		while(resultset.next())
			
		
			//booktitle.add(resultset.getString("BOOKTITLE"));
			resultset.close();
			statement.close();
			for (String string : booktitle) {
				System.out.println(string.toString());
			}
			return booktitle;
	}
	
	
	
	public boolean BookReview(String review,String bk_name) throws SQLException
	{
			boolean success= false;
			PreparedStatement statement = connection.prepareStatement("UPDATE BOOKS SET BOOKREVIEW=? WHERE BOOKTITLE=?");
			System.out.println("After execution of prepared statement");
			statement.setString(1, review);
			statement.setString(2, bk_name);
			int count = statement.executeUpdate();
			if(count!=0)
			{
				success=true;
				System.out.println("Updated success");
			}
			return success;
	}
	
	
	
	public ResultSet BookSearch(String title) throws SQLException
	{
		PreparedStatement statement = connection.prepareStatement("SELECT * FROM BOOKS WHERE BOOKTITLE =?");
		//Array array = connection.createArrayOf("VARCHAR",title.toArray());
		statement.setString(1, title);
		ResultSet rs = statement.executeQuery();
		return rs;
		
	}
	
	
	public ResultSet ShowDetailsOfSelectedBooks(String bookname) throws SQLException
	{
		PreparedStatement statement= connection.prepareStatement("SELECT * FROM BOOKS WHERE BOOKTITLE=?");
		statement.setString(1, bookname);
		ResultSet rs = statement.executeQuery();
		return rs;
	}
	
	public int insertBook(BookDTO bookdto) throws SQLException
	{
		connection.setAutoCommit(true);
		//boolean success = false;
		PreparedStatement statement = connection.prepareStatement("INSERT INTO BOOKS VALUES(?,?,?,?,?)");
		statement.setInt(1,bookdto.getBookid());
		statement.setString(2,bookdto.getBooktitle());
		statement.setString(3,bookdto.getBookauthor());
		statement.setString(4, bookdto.getBookreview());
		statement.setInt(5,bookdto.getBookprice());
		statement.execute();
		System.out.println("Inside Book Dao....Successfully Inserted");
		//success=true;
		return 1;
	}


	public ArrayList<BookDTO> showTableData() throws SQLException
	{
		ArrayList<BookDTO> bklist = new ArrayList<BookDTO>();
		Statement stmt = connection.createStatement();
		String query="SELECT * FROM BOOKS";
		ResultSet rs = stmt.executeQuery(query);
		while(rs.next())
		{
			BookDTO books=new BookDTO();
			books.setBookid(rs.getInt("bookid"));
			books.setBooktitle(rs.getString("bookauthor"));
			books.setBookauthor(rs.getString("bookauthor"));
			books.setBookreview(rs.getString("bookreview"));
			books.setBookprice(rs.getInt("bookprice"));
			bklist.add(books);
			
		}
		for (BookDTO bookDTO : bklist) {
			System.out.println("List.... " +bklist);
		}
		return bklist;
		
		
	}
	

}
