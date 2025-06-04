package com.trabalho.restaurante;

import com.trabalho.restaurante.model.*;
import com.trabalho.restaurante.model.db.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;

@SpringBootApplication
public class RestauranteApplication implements CommandLineRunner{

	public static void main(String[] args){
		SpringApplication.run(RestauranteApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Bebida bebida1 = new Bebida("Refrigerante Guaraná", 5.5, false, "300", "https://i.pinimg.com/736x/39/31/63/3931637bb5aceba1f4aea2ad126248e4.jpg", 3.5);
		Bebida bebida2 = new Bebida("Vinho Tinto Seco", 7.5, true, "300", "https://i.pinimg.com/736x/44/9b/4d/449b4d0186602b22e923c271b23d0755.jpg", 4);

		PratoPrincipal pratoPrincipal1 = new PratoPrincipal("Frango Empanado", 27.5, "Arroz e Batata", false, "https://i.pinimg.com/736x/f0/11/0b/f0110b07a520c5fba692d9475cc40962.jpg", 5);
		PratoPrincipal pratoPrincipal2 = new PratoPrincipal("Contra Filé", 15, "Arroz", false, "https://i.pinimg.com/736x/a8/d0/96/a8d0964e5b32a5ee255d6fdfa95728f5.jpg", 3);

		Sobremesa sobremesa1 = new Sobremesa("Torta de Limão", 12, true, 250, "https://i.pinimg.com/736x/e7/17/80/e717802a74baded680c31e6d24f384b2.jpg", 4.6);
		Sobremesa sobremesa2 = new Sobremesa("Pudim de Leite", 10.7, true, 250, "https://i.pinimg.com/736x/88/c3/e9/88c3e9b62a3af5a6e978ee0955016fff.jpg", 5);

		BebidaDAO bebidaDAO = new BebidaDAO();
		bebidaDAO.inserir(bebida1);
		bebidaDAO.inserir(bebida2);

		PPrincipalDAO pPrincipalDAO = new PPrincipalDAO();
		pPrincipalDAO.inserir(pratoPrincipal1);
		pPrincipalDAO.inserir(pratoPrincipal2);

		SobremesaDAO sobremesaDAO = new SobremesaDAO();
		sobremesaDAO.inserir(sobremesa1);
		sobremesaDAO.inserir(sobremesa2);
	}
}
