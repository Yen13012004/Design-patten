package entities;

import java.util.Scanner;

import helpers.NumberUtils;

public class Category {
	private int id;
	private String name;
	private boolean status;

	public Category() {
		// TODO Auto-generated constructor stub
	}

	public Category(int id, String name, boolean status) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public void input() {
		Scanner sc = new Scanner(System.in);
		boolean isInteger;
		String dataStr;
		do {
			System.out.println("Nhập mã danh mục: ");
			dataStr = sc.nextLine();
			
			isInteger = true;
			
			for (int i = 0; i < dataStr.length(); i++) {
                if (!Character.isDigit(dataStr.charAt(i))) {
                    isInteger = false;
                    break;
                } else {
                	id = Integer.parseInt(dataStr);
                }
            }
			

            if (!isInteger) {
                System.out.println("Dữ liệu nhập vào không phải là số nguyên. Vui lòng nhập lại.");
            }
		} while (!isInteger);

		
		do {
			System.out.println("Tên sản phẩm: ");
			name = sc.nextLine();

			if (name != null && name != "") 
				continue;
			System.out.println("Tên sản phẩm không được để trống");
		} while (name == null || name == "");

		
		do {
			System.out.println("Trạng thái danh mục: ");
			status = sc.nextBoolean();
			sc.nextLine();
		} while (status != true && status != false );
	}

	public void display() {
		
		System.out.println("| "+id+"                 | " +name + "               |"    + (status == true ? "Hiện" : "Ẩn") + "              |");
		System.out.println("+-------------------+------------------+------------------+");
		
	}

}
