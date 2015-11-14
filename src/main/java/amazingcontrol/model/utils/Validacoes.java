package amazingcontrol.model.utils;

import java.util.Map;

public class Validacoes {
	
	public static void valida(Map<String, String> campo) throws Exception {
		
		
		for (String string : campo.values()) {
			// Nome nulo
			if (campo.get(string) == null) {
				throw new IllegalArgumentException(string + " nao pode ser nulo!");
			}

			// Nome vazio
			if (campo.get(string).isEmpty()) { // nome.equals("");
				throw new IllegalArgumentException(string + " nao pode ser vazio!");
			}

			// Nome em branco
			if (campo.get(string).matches("^[ ]+$")) { // REGEX
				throw new IllegalArgumentException(string + " nao pode ser branco!");
			}
			
			// Nao pode ter menos de 2 caracteres
			if (campo.get(string).length() < 2) {
				throw new IllegalArgumentException(string + " nao pode ser branco!");
			}
			
		}
	}
	
}
