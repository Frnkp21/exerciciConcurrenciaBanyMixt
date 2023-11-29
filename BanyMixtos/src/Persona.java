public class Persona extends Thread {
    private String name;
    private String type;
    private BanyMixt bany;

    public Persona(String name, String type, BanyMixt bany) {
        this.type = type;
        this.bany = bany;
        this.name = name;
    }

    @Override
    public void run() {
        do {
            trabaja();

            irBaño();
        } while (true);
    }

    public String getPersonName() {
        return name;
    }

    private void irBaño() {
        try {
            bany.entrarBaño(type);

            System.out.println(name + " está en el BAÑO!");

            Thread.sleep((long) ((Math.random() * 1000) + 500));

            bany.salirBaño();

            Thread.sleep((long) (Math.random() * 50));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void trabaja() {
        try {
            System.out.println(name + " está TRABAJANDO!");

            Thread.sleep((long) ((Math.random() * 1000) + 500));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
