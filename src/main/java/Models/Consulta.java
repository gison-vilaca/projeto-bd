package Models;

public class Consulta {

    private String comando;

    public Consulta(String comando) {
        this.comando = comando;
    }

    public String getComando() {
        return comando;
    }

    public void setComando(String comando) {
        this.comando = comando;
    }

    @Override
    public String toString() {
        return "Consulta{" +
                "comando='" + comando + '\'' +
                '}';
    }
}
