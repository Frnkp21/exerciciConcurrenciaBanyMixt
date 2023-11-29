public class BanyMixt {

    public String ocupado;

    private int cont;

    private final int max;

    public BanyMixt(int max) {
        this.ocupado = "vacio";
        this.cont = 0;
        this.max = max;
    }

    public synchronized void entrarBaño(String quien) {
        do {
            if (this.ocupado.equals(quien) && cont < max) {
                cont++;
                break;
            } else if (this.ocupado.equals("vacio")) {
                ocupado = quien;
                cont++;
                System.out.println("CAMBIO a " + ocupado);
                notifyAll();
                break;
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        } while (true);
    }

    public synchronized void salirBaño() {
        cont--;

        if (cont == 0) {
            ocupado = "vacio";
        }

        notifyAll();
    }
}
