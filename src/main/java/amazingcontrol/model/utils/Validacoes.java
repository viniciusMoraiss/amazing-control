package amazingcontrol.model.utils;

public class Validacoes {
	
	public static void validaNulo(Object campo) {
		// Nome nulo
		if (campo == null) {
			throw new IllegalArgumentException(campo + " nao pode ser nulo!");
		}
	}
	
	/**
	 * Valida se campo é nulo
	 * @param label
	 * @param campo
	 * @throws Exception
	 */
	public static void validaNuloOuVazio(String label, String campo) {
		// Nome nulo
		if (campo == null) {
			throw new IllegalArgumentException(label + " nao pode ser nulo!");
		}

		// Nome vazio
		if (campo.isEmpty()) {
			throw new IllegalArgumentException(label + " nao pode ser vazio!");
		}

		// Nome em branco
		if (campo.matches("^[ ]+$")) { // REGEX
			throw new IllegalArgumentException(label + " nao pode ser vazio!");
		}
	}
	
	/**
	 * Valida o tamanho minimo e maximo do campo
	 * @param label
	 * @param campo
	 * @param minimo
	 * @param maximo
	 */
	public static void validaTamanho(String label, String campo, int minimo, int maximo) {
		if(campo.length() < minimo) {
			throw new IllegalArgumentException(label + " tem que ser maior que "+ minimo + "!");
		}
		
		if(campo.length() > maximo) {
			throw new IllegalArgumentException(label + " tem que ser menor que "+ maximo+ "!");
		}
	}
}
