
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        BanyMixt banyMixt = new BanyMixt(5);
        ArrayList<Persona> personas = new ArrayList<>();
        personas.add(new Persona("Frank","hombre", banyMixt));
        personas.add(new Persona("Franklin","hombre", banyMixt));
        personas.add(new Persona("Lucia","mujer", banyMixt));
        personas.add(new Persona("Laura","mujer", banyMixt));
        personas.add(new Persona("NIÑO1","niño", banyMixt));
        personas.add(new Persona("NIÑO2","niño", banyMixt));

        personas.forEach(persona -> {
            System.out.println(persona.getPersonName());
            persona.start();
        });
    }
}
