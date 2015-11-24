package amazingcontrol.model;

public enum Tipo {
	
	ESCOLHA, Litro , Litrao , LongNeck , Latinha, Latao;
	
	 public boolean isSelecionado() {
        return !ESCOLHA.equals(this);
    }

    public boolean isNotSelecionado() {
        return !isSelecionado();
    }


}
