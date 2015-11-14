package amazingcontrol.model;

public enum UF {
    ESCOLHA, AC, AL, AM, AP, BA, CE, DF, ES, GO, MA, MG, MS, 
    MT, PA, PB, PE, PI, PR, RJ, RN, RO, RR, RS, SC, SE, SP, TO;

    public boolean isSelecionado() {
        return !ESCOLHA.equals(this);
    }

    public boolean isNotSelecionado() {
        return !isSelecionado();
    }

}
