package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Rooms;

public class Rent_list {

	@SuppressWarnings("checked")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Quantos quartos serão alugados?");
		int qttRooms = sc.nextInt();
		int newId = 0;
		sc.nextLine();
		List<Rooms> list = new ArrayList<>();

		for (int i = 0; i < qttRooms; i++) {
			System.out.println("Qual o nome do locatário?");
			String name = sc.nextLine();
			System.out.println("Qual o email do locatário?");
			String email = sc.nextLine();
			System.out.println("Qual dos quartos você deseja?");
			int id = sc.nextInt();
			sc.nextLine();
			while (hasId(list, id)) {
				System.out.println("Quarto ocupado. Escolha outro:");
				id = sc.nextInt();
			}
			list.add(new Rooms(name, email, id));
		}

		System.out.println("Quais dos seguintes quartos você deseja alterar?");
		System.out.println(list.stream().map(Rooms::getId).collect(Collectors.toList()));
		int id = sc.nextInt();
		sc.nextLine();
		while (!hasId(list, id)) {
			System.out.println("Você não agendou esse quarto. Escolha outro:");
			id = sc.nextInt();
		}

		System.out.println("E qual você deseja?");
		newId = sc.nextInt();
		sc.nextLine();
		while (id == newId) {
			System.out.println("Se quer mudar, escolha outro, por favor:");
			newId = sc.nextInt();
		}
		for (Rooms x : list) {
			if (x.getId() == id) {
				x.setId(newId);
			}
			System.out.println("Quarto: "+x.getId()+". Nome: "+x.getName()+". Email "+x.getEmail());
		}
		sc.close();
	}

	public static boolean hasId(List<Rooms> list, int id) {
		Rooms emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return emp != null;
	}
}