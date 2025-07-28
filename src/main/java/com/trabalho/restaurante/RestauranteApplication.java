package com.trabalho.restaurante;

import com.trabalho.restaurante.model.*;
import com.trabalho.restaurante.model.repository.ClienteRepository;
import com.trabalho.restaurante.model.repository.PratosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestauranteApplication implements CommandLineRunner {

	@Autowired
	private PratosRepository pratosRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	public static void main(String[] args) {
		SpringApplication.run(RestauranteApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Verificando se o banco precisa de dados iniciais...");

		if (pratosRepository.count() == 0 && clienteRepository.count() == 0) {
			System.out.println("Banco de dados vazio. Populando com dados iniciais...");

			PratoPrincipal p1 = new PratoPrincipal("Filé à Parmegiana", 60.0, "Arroz e Fritas", false, "p1.jpg", 4.9);
			Sobremesa s1 = new Sobremesa("Pudim de Leite", 15.0, true, 150, "s1.jpg", 4.8);
			Bebida b1 = new Bebida("Coca-Cola 350ml", 8.0, false, 350, "b1.jpg", 4.5);

			pratosRepository.save(p1);
			pratosRepository.save(s1);
			pratosRepository.save(b1);
			System.out.println("Pratos salvos no banco.");

			Endereco end1 = new Endereco(123, "Rua das Flores", "Centro", "São Paulo", "SP", "01001-000");
			Cliente c1 = new Cliente("João da Silva", 30, "joao.silva@email.com", "123456", end1);

			clienteRepository.save(c1);
			System.out.println("Cliente salvo no banco.");
			System.out.println("DataLoader (na classe principal) finalizado!");
		} else {
			System.out.println("O banco de dados já contém dados. Lógica de popular dados não executada.");
		}
	}
}