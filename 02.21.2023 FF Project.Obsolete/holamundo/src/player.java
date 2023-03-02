import java.math.*;

public class player {

    //cosas que se pueden tocar
    private int pokemon;
    private int vida;
    private String pokename;
    private int potenciador;

    //variables Privadas sin interaccion humana
    private int limitHeal;
    private int lastAtack;

    //costructores default y de llenado
    public player(){
        pokemon = 0;
        vida = 100;
        pokename = "Furrymon desconocido";
        limitHeal = 3;
    }
    
    public void setPokemon(int id, int hp, String name, int poten) {
        pokemon = id;
        vida = hp;
        pokename = name;
        potenciador = poten;
    }    

    //metodos Get y Set
    public void setVida(int health) {
        vida += health;
    }

    public int getVida() {
        if(vida<0){ 
            vida = 0; //Si la vida del jugador es negativa esta se cambiará a 0
        }
        return vida;
    }
    //cargar limites de curacion
    public int getLimitHeal() {
        return limitHeal;
    }
    //devoover el ultimo ataque
    public int getLastAtack() {
        return lastAtack;
    }

    //metodos Do

    public int doAtack(){
        int ataque = (int) (Math.random() * 15) + 1;
    
        ataque = ataque * potenciador;
        lastAtack = ataque;
        return (ataque * -1);
    }

    public void doHeal(){
        
        if(vida > 0 && vida <200){
            if(limitHeal > 0){
                limitHeal--;
                setVida(10);
            }else{
                System.out.println("Te has agotado tus curaciones!!");
            }
        }
    }

//hasta este punto el juego de consola funciona 
//el intento de GUI aun no funciona
}
