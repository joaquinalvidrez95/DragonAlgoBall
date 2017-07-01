package db.app.exception;

@SuppressWarnings("serial")
public class CampoVacioException extends Exception {


    public static void controle(String champ) throws MensajeErrorException {
        if (champ.trim().length() == 0) {
            System.out.println("test3");
            throw new MensajeErrorException("El campo esta vacio !");
        }
    }


    public static String validCampo(String campo) {
        try {
            controle(campo);
            return "";
        } catch (MensajeErrorException e) {
            return e.getMessage();
        }

    }
}
