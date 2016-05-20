package dto;

public class BookDTO {
	int bookid;
	String booktitle;
	String bookauthor;
	String bookreview;
	int bookprice;
	
	public BookDTO() {
		this(0,"","","",0);
	}

	public BookDTO(int bookid, String booktitle, String bookauthor, String bookreview, int bookprice) {
		super();
		this.bookid = bookid;
		this.booktitle = booktitle;
		this.bookauthor = bookauthor;
		this.bookreview = bookreview;
		this.bookprice = bookprice;
	}

	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public String getBooktitle() {
		return booktitle;
	}

	public void setBooktitle(String booktitle) {
		this.booktitle = booktitle;
	}

	public String getBookauthor() {
		return bookauthor;
	}

	public void setBookauthor(String bookauthor) {
		this.bookauthor = bookauthor;
	}

	public String getBookreview() {
		return bookreview;
	}

	public void setBookreview(String bookreview) {
		this.bookreview = bookreview;
	}

	public int getBookprice() {
		return bookprice;
	}

	public void setBookprice(int bookprice) {
		this.bookprice = bookprice;
	}

	@Override
	public String toString() {
		return "BookDTO [bookid=" + bookid + ", booktitle=" + booktitle + ", bookauthor=" + bookauthor + ", bookreview="
				+ bookreview + ", bookprice=" + bookprice + "]";
	}
	
	
	
	

}
