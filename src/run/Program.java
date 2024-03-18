package run;

import java.util.List;
import java.util.Scanner;

import dao.impl.CategoryDAOImpl;
import dao.impl.ProductDAOImpl;
import entities.Category;
import entities.Product;
import factory.DAOFactory;

public class Program {
	public static void Category() {
		Scanner sc = new Scanner(System.in);
		Category category = new Category();

		CategoryDAOImpl cateDao = (CategoryDAOImpl) DAOFactory.getDAO(CategoryDAOImpl.class);

		int choice_cate = 5;
		

		do {
			System.out.println("\n -----QUẢN LÍ DANH MỤC-----");
			System.out.println("1. Hiển thị d/s danh mục sắp xếp theo tên A-Z (status hiển thị ẩn/hiện)");
			System.out.println("2. Thêm mới danh mục");
			System.out.println("3. Cập nhật danh mục");
			System.out.println("4. Xóa danh mục");
			System.out.println("5. Quay lại");
			System.out.println("Mời bạn lựa chọn: ");
			choice_cate = sc.nextInt();
			sc.nextLine();

			switch (choice_cate) {
			case 1:
				List<Category> list = cateDao.get();
				if (list.size() == 0) {
					System.out.println("KHÔNG CÓ DỮ LIỆU");
				} else {
					System.out.println("\n DANH SÁCH DANH MỤC");
					System.out.println("+-------------------+------------------+------------------+");
					System.out.println("| Id                | Name             | Status           |");
					System.out.println("+-------------------+------------------+------------------+");
					for (Category cate : list) {
						cate.display();
					}
				}
				break;

			case 2:
				category.input();
				boolean check = cateDao.add(category);
				if (check) {
					System.out.println("\nThêm mới danh mục thành công.");
				} else {
					System.out.println("\nThêm mới danh mục thất bại.");
				}
				break;

			case 3:
				System.out.print("Nhập ID cần cập nhật: ");
				Integer idUpdate = sc.nextInt();
				Category dataByIdUpdate = cateDao.findId(idUpdate);
				if (dataByIdUpdate == null) {
					System.out.println("Không có danh mục nào với Id là: " + idUpdate);
				} else {
					dataByIdUpdate.display();
					category.input();
					boolean checkUpdate = cateDao.edit(category);
					if (checkUpdate) {
						System.out.println("\nCập nhật danh mục thành công.");
					} else {
						System.out.println("\nCập nhật danh mục thất bại.");
					}
				}
				break;

			case 4:
				System.out.print("Nhập ID cần xóa: ");
				Integer foundId = sc.nextInt();
				Category dataUpdate = cateDao.findId(foundId);
				boolean checkDelete = cateDao.remove(dataUpdate);
				if (checkDelete) {
					System.out.println("\nXóa danh mục thành công.");
				} else {
					System.out.println("\nXóa danh mục thất bại.");
				}
				break;

			case 5:
				Menu();
				break;

			default:
				System.out.println("Bạn chỉ được chọn từ 1 đến 5!!!!");
			}
		} while (choice_cate != 5);

	}

	public static void Product() {
		Scanner sc = new Scanner(System.in);
		Product product = new Product();

		ProductDAOImpl proDao = (ProductDAOImpl) DAOFactory.getDAO(ProductDAOImpl.class);

		int choice_pro = 5;
		
		do {
			System.out.println("\n -----QUẢN LÍ SẢN PHẨM-----");
			System.out.println("1. Hiển thị d/s sản phẩm (id, name, price, categoryName, status(ẩn/hiện))");
			System.out.println("2. Thêm mới sản phẩm");
			System.out.println("3. Cập nhật thông tin sản phẩm");
			System.out.println("4.Xóa sản phẩm");
			System.out.println("5. Quay lại");
			System.out.println("Mời bạn lựa chọn: ");
			choice_pro = sc.nextInt();
			sc.nextLine();

			switch (choice_pro) {
			case 1:
				List<Product> list = proDao.get();
				if (list.size() == 0) {
					System.out.println("KHÔNG CÓ DỮ LIỆU");
				} else {
					System.out.println("\n DANH SÁCH SẢN PHẨM");
					System.out.println("+-------------------+------------------+------------------+------------------+------------------+");
					System.out.println("| Id                | Name             | Price            | Category_id      | Status           |");
					System.out.println("+-------------------+------------------+------------------+------------------+------------------+");
					for (Product cate : list) {
						cate.display();
					}
				}
				break;

			case 2:
				product.input();
				boolean check = proDao.add(product);
				if (check) {
					System.out.println("\nThêm mới sản phẩm thành công.");
				} else {
					System.out.println("\nThêm mới sản phẩm thất bại.");
				}
				break;

			case 3:
				System.out.print("Nhập ID cần cập nhật: ");
				String idUpdate = sc.nextLine();
				Product dataByIdUpdate = proDao.findId(idUpdate);
				if (dataByIdUpdate == null) {
					System.out.println("Không có sản phẩm nào với Id là: " + idUpdate);
				} else {
					dataByIdUpdate.display();
					product.input();
					boolean checkUpdate = proDao.edit(product);
					if (checkUpdate) {
						System.out.println("\nCập nhật sản phẩm thành công.");
					} else {
						System.out.println("\nCập nhật sản phẩm thất bại.");
					}
				}
				break;

			case 4:
				System.out.print("Nhập ID cần xóa: ");
				String foundId = sc.nextLine();
				Product dataUpdate = proDao.findId(foundId);
				boolean checkDelete = proDao.remove(dataUpdate);
				if (checkDelete) {
					System.out.println("\nXóa sản phẩm thành công.");
				} else {
					System.out.println("\nXóa sản phẩm thất bại.");
				}
				break;

			case 5:
				Menu();
				break;

			default:
				System.out.println("Bạn chỉ được chọn từ 1 đến 5!!!!");
			}
		} while (choice_pro != 5);

	}

	public static void Menu() {
		int choice;
		Scanner sc = new Scanner(System.in);
		System.out.println("\n-----MENU-----");
		System.out.println("1. Quản lý danh mục");
		System.out.println("2. Quản lý sản phẩm");
		System.out.println("3. Thoát");
		System.out.println("Mời bạn lựa chọn: ");
		choice = Integer.parseInt(sc.nextLine());

		if (choice == 1) {
			Category();
		} else if (choice == 2) {
			Product();
		} else if (choice == 3) {
			System.exit(0);
		} else {
			System.out.println("Vui lòng nhập từ 1 - 3 !!!");
		}
	}

	public static void main(String[] args) {
		Menu();
	}

}
