package db.app.model.entidad.personaje;

public interface DragonBallZParametros {
    interface NombresDeEquipos {
        interface ParametrosDeGuerrerosZ {
            String GUERREROS_Z = "Guerreros Z";
            String GOKU = "Goku";
            String PICCOLO = "Piccolo";
            String GOHAN = "Gohan";
        }

        interface ParamentrosDeEnemigosDeLaTierra {
            String ENEMIGOS_DE_LA_TIERRA = "Enemigos de la Tierra";
            String FREEZER = "Freezer";
            String CELL = "Cell";
            String MAJIN_BOO = "Majin Boo";
        }
    }

    interface AtaquesEspeciales {
        interface Kamehameha {
            int COSTO = 20;
            String NOMBRE = "Kamehameha";
        }

        interface Masenko {
            int COSTO = 10;
            String NOMBRE = "Masenko";
        }

        interface Makankosappo {
            int COSTO = 10;
            String NOMBRE = "Makankosappo";
        }

        interface Absorber {
            int COSTO = 5;
            String NOMBRE = "Absorber";
        }

        interface ConvierteteEnChocolate {
            int COSTO = 30;
            String NOMBRE = "Conviértete en chocolate";
        }

        interface RayoMortal {
            int COSTO = 20;
            String NOMBRE = "Rayon mortal";
        }
    }

    interface ParametrosDePersonajes {
        interface Goku {
            double VIDA = 500;
            //double VIDA = 1;
            String SRC_Img = "/img/Goku.png";

            interface GokuNormal {
                double PODER_DE_PELEA = 20;
                int DISTANCIA_DE_ATAQUE = 2;
                int VELOCIDAD = 2;
                String NOMBRE = "Goku Normal";
            }

            interface GokuKaioKen {
                double PODER_DE_PELEA = 40;
                int DISTANCIA_DE_ATAQUE = 4;
                int VELOCIDAD = 3;
                String NOMBRE = "Kaio-Ken";
            }

            interface GokuSuperSayajin {
                double PODER_DE_PELEA = 60;
                int DISTANCIA_DE_ATAQUE = 4;
                int VELOCIDAD = 5;
                String NOMBRE = "SuperSayajin";
            }

        }

        interface Gohan {
            double VIDA = 300;
            //double VIDA = 1;
            String SRC_Img = "/img/Gohan.png";

            interface GohanNormal {
                double PODER_DE_PELEA = 15;
                int DISTANCIA_DE_ATAQUE = 2;
                int VELOCIDAD = 2;
                String NOMBRE = "Gohan Normal";
            }

            interface GohanSuperSayajinFase1 {
                double PODER_DE_PELEA = 30;
                int DISTANCIA_DE_ATAQUE = 2;
                int VELOCIDAD = 2;
                String NOMBRE = "Super Sayajin fase 1";
            }

            interface GohanSuperSayajinFase2 {
                double PODER_DE_PELEA = 100;
                int DISTANCIA_DE_ATAQUE = 4;
                int VELOCIDAD = 3;
                String NOMBRE = "Super Sayajin";
            }

        }

        interface Piccolo {
            double VIDA = 500;
            //double VIDA = 1;
            String SRC_Img = "/img/Piccolo.png";


            interface PiccoloNormal {
                double PODER_DE_PELEA = 20;
                int DISTANCIA_DE_ATAQUE = 2;
                int VELOCIDAD = 2;
                String NOMBRE = "Piccolo Normal";
            }

            interface PiccoloFortalecido {
                double PODER_DE_PELEA = 40;
                int DISTANCIA_DE_ATAQUE = 4;
                int VELOCIDAD = 3;
                String NOMBRE = "Fortalecido";
            }

            interface PiccoloProtector {
                double PODER_DE_PELEA = 60;
                int DISTANCIA_DE_ATAQUE = 6;
                int VELOCIDAD = 4;
                String NOMBRE = "Protector";

            }

        }

        interface Cell {
            double VIDA = 500;
            //double VIDA = 1;
            String SRC_Img = "/img/Cell.png";

            interface CellNormal {
                double PODER_DE_PELEA = 20;
                int DISTANCIA_DE_ATAQUE = 3;
                int VELOCIDAD = 2;
                String NOMBRE = "Cell Normal";
            }

            interface CellSemiPerfecto {
                double PODER_DE_PELEA = 40;
                int DISTANCIA_DE_ATAQUE = 4;
                int VELOCIDAD = 3;
                String NOMBRE = "Semi Perfecto";
            }

            interface CellPerfecto {
                double PODER_DE_PELEA = 80;
                int DISTANCIA_DE_ATAQUE = 4;
                int VELOCIDAD = 4;
                String NOMBRE = "Perfecto";
            }

        }

        interface Freezer {
            double VIDA = 400;
            //double VIDA = 1;
            String SRC_Img = "/img/Freezer.png";

            interface FreezerNormal {
                double PODER_DE_PELEA = 20;
                int DISTANCIA_DE_ATAQUE = 2;
                int VELOCIDAD = 4;
                String NOMBRE = "Freezer Normal";
            }

            interface FreezerSegundaForma {
                double PODER_DE_PELEA = 40;
                int DISTANCIA_DE_ATAQUE = 3;
                int VELOCIDAD = 4;
                String NOMBRE = "Segunda Forma";

            }

            interface FreezerDefinitivo {
                double PODER_DE_PELEA = 50;
                int DISTANCIA_DE_ATAQUE = 3;
                int VELOCIDAD = 6;
                String NOMBRE = "definitivo";
            }
        }

        interface MajinBoo {
            double VIDA = 300;
            //double VIDA = 1;
            String SRC_Img = "/img/MajinBoo.png";

            interface MajinBooNormal {
                double PODER_DE_PELEA = 30;
                int DISTANCIA_DE_ATAQUE = 2;
                int VELOCIDAD = 2;
                String NOMBRE = "Boo Normal";
            }

            interface BooMalo {
                double PODER_DE_PELEA = 50;
                int DISTANCIA_DE_ATAQUE = 2;
                int VELOCIDAD = 3;
                String NOMBRE = "Boo Malo";
            }

            interface BooOriginal {
                double PODER_DE_PELEA = 60;
                int DISTANCIA_DE_ATAQUE = 3;
                int VELOCIDAD = 4;
                String NOMBRE = "Boo Original";
            }

        }
    }

    interface Consumibles {
        interface EsferaDelDragon {
            String NOMBRE = "Esfera del Dragón";
            String SRC_Img = "/img/EsferaDelDragon.png";
        }

        interface NubeVoladora {
            String NOMBRE = "Nube Voladora";
            String SRC_Img = "/img/NubeVoladora.png";
        }

        interface SemillaDelErmitano {
            String NOMBRE = "Semilla del Ermitano";
            String SRC_Img = "/img/SemillaDelErmitano.png";
        }

    }

}
