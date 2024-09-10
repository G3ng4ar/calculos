package app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Entrada;
import app.entity.Resultado;
import app.repository.CalculosRepository;

@Service
public class CalculosService {
	
	@Autowired
	private CalculosRepository calculosRepository;
	
	
	public List<Resultado> findAll(){
		return this.calculosRepository.findAll();
	}
	
	public Resultado calcular(Entrada entrada) {
		
		Resultado resultado = new Resultado();
		int soma = this.somar(  entrada.getLista() );
		System.out.println("A soma deu "+ soma);
		
		resultado.setSoma(soma);
		
		double media = this.media(entrada.getLista());
		resultado.setMedia(media);
		
		resultado = this.calculosRepository.save(resultado);
		
		return resultado;
		
	}
	
	public Integer somar(List<Integer> lista) {
		
		int soma = 0;
		
		for(int i=0; i<lista.size(); i++) {
			soma += lista.get(i);
		}
		
		return soma;
		
	}
	
	public Integer media(List<Integer> lista) {
		return this.somar(lista) / lista.size();
	}
	
	public int maiorNumList (List<Integer> lista) {
		int maior = Integer.MIN_VALUE;
		for (int i=0; i < lista.size(); i++) {
			if (lista.get(i)>maior) {
				maior = lista.get(i);
			}
		}
		return maior;
	}
	
	public int menorNumList (List<Integer> lista) {
		int menor = Integer.MAX_VALUE;
		for (int i=0; i < lista.size(); i++) {
			if (lista.get(i)>menor) {
				menor = lista.get(i);
			}
		}
		return menor;
	}
	
	public int totalElementos (List<Integer> lista) {
		return lista.size();
	}
	
	public double multiplicar (List<Integer> lista) {
		double total = 1;
		for (int i=0; i < lista.size(); i++) {
			total *= lista.get(i);
		}
		return total; 
	}
	
	public List<Integer> moda (List<Integer> lista){
		double cont=0;
		int max = 0;
		List<Integer> moda = new ArrayList<>();
		for(int i=0; i<lista.size(); i++) {
			double aux=0;
			for(int x=0; x<lista.size(); x++) {
				if(lista.get(i)==lista.get(x)) {
					aux++;
					if(aux > cont) {
						cont = aux;
						max = lista.get(x);
					}
				}
			}
		}
		
		moda.add(max);
		return moda;
	}
}
