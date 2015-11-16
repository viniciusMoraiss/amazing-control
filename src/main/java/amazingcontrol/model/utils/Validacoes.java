package amazingcontrol.model.utils;

import java.util.Map;

public class Validacoes {
	
	public static void valida(Map<String, String> campo) throws Exception {
		
		
		for (String key : campo.keySet()) {
			// Nome nulo
			if (campo.get(key) == null) {
				throw new IllegalArgumentException(key + " nao pode ser nulo!");
			}

			// Nome vazio
			if (campo.get(key).isEmpty()) { // nome.equals("");
				throw new IllegalArgumentException(key + " nao pode ser vazio!");
			}

			// Nome em branco
			if (campo.get(key).matches("^[ ]+$")) { // REGEX
				throw new IllegalArgumentException(key + " nao pode ser branco!");
			}
			
			// Nao pode ter menos de 2 caracteres
			if (campo.get(key).length() < 2) {
				throw new IllegalArgumentException(key + " nao pode ser branco!");
			}
			
		}
	}
	
}
