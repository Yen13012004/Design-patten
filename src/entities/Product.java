package entities;

import java.util.Scanner;

public class Product {
	private String id;
	private String name;
	private double price;
	private int category_id;
	private boolean status;

	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(String id, String name, double price, int category_id, boolean status) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.category_id = category_id;
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public void input() {
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Mã sản phẩm: ");
			id = sc.nextLine();
		} while (id == null && id == "");

		
		do {
			System.out.println("Tên sản phẩm: ");
			name = sc.nextLine();

			if (name != null && name != "") 
				continue;
			System.out.println("Tên sản phẩm không được để trống");
		} while (name == null || name == "");

		do {
			System.out.println("Giá sản phẩm: ");
			price = Double.parseDouble(sc.nextLine());

			if (price > 1000) 
				continue;
			System.out.println("Price tối thiểu là 1000");
		} while (price < 1000);

		
			System.out.println("Mã danh mục của sản phẩm: ");
			category_id = Integer.parseInt(sc.nextLine());
			
			System.out.println("Trạng thái sản phẩm: ");
			status = Boolean.parseBoolean(sc.nextLine());
	}
	

	public void display() {
		System.out.println("|"+id+"                 | " +name + "         |"+ price+"          | "+category_id+"                |"    + (status == true ? "Hiện" : "Ẩn") + "              |");
		System.out.println("+-------------------+------------------+------------------+------------------+------------------+");
		
	
	}
}
