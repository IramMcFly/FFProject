import java.util.Scanner;

public class mainPoke {

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }


    //lista de compresion de codigo
    public static void lista(){
        System.out.println("Furrymones disponibles: ");
        System.out.println("");
        System.out.println("1- El Inge");
        System.out.println("2- La Licenciada");
        System.out.println("3- El Arqui");
        System.out.println("4- La Cafe");
        System.out.println("5- El Bisonte");
        System.out.println("");
    }

    //entrada al main
    public static void main(String[] args) throws Exception {
        
        //instanciamos el escaner
        Scanner sc = new Scanner(System.in);
        int select = 0;

        //instanciacion de jugadores
        player player1 = new player();
        player player2 = new player();
        


        //lista
        lista();

        //selector de Furrymon jugador 1
        System.out.print("Jugador 1, Ingresa tu seleccion> ");
        select = sc.nextInt();

        //ciclo en caso de que el jugador seleccione un Furrymon inexistente
        while (select < 1 || select > 5){
            System.out.println("Tu seleccion no existe");
            System.out.print("Jugador 1, Ingresa tu seleccion> ");
            select = sc.nextInt();
        }

        clearScreen();

        //switch de instanciacion de personajes, id, vida, nombre y potenciador de ataque
        switch(select){
            case 1:
                player1.setPokemon(1, 150, "El Inge", 2);
            break;
            
            case 2:
                player1.setPokemon(2, 80, "La Licenciada",3);
            break;
            
            case 3:
                player1.setPokemon(3, 125, "El Arqui", 2);
            break;
            
            case 4:
                player1.setPokemon(4, 80, "La Cafe", 3);
            break;
            
            case 5: 
                player1.setPokemon(5, 200, "El Bisonte", 1);
            break;
            
            default: 
                //lugar imposible de entrar
                System.out.println("Si llegaste a este default llama al 911 y diles que la matrix se rompio");
            break;
        }

        lista();
        //Selector de Furrymon jugador 2
        System.out.print("Jugador 2, Ingresa tu seleccion> ");
        select = sc.nextInt();
        
        //ciclo en caso de que el jugador seleccione un Furrymon inexistente
        while (select < 1 || select > 5){
            System.out.println("Tu seleccion no existe");
            System.out.print("Jugador 2, Ingresa tu seleccion> ");
            select = sc.nextInt();
        }
        
        clearScreen();
        //switch de instanciacion de personajes, id, vida, nombre y potenciador de ataque
        switch(select){        
                
                case 1:
                    player2.setPokemon(1, 150, "El Inge", 2);
                break;
                
                case 2:
                    player2.setPokemon(2, 80, "La Licenciada", 3);
                break;
                
                case 3:
                    player2.setPokemon(3, 125, "El Arqui", 2);
                break;
                
                case 4:
                    player2.setPokemon(4, 80, "La Cafe", 3);
                break;
                
                case 5: 
                    player2.setPokemon(5, 200, "El Bisonte1", 1);
                
                break;
                default: 
                    //lugar imposible de entrar
                    System.out.println("Si llegaste a este default llama al 911 y diles que la matrix se rompio");
                break;
        }

        //rondas del juego
        for(int i = 0; i<10; i++){

            clearScreen();

            if(player1.getVida() <= 0){
                break;
            }
            if(player2.getVida() <= 0){
                break;
            }
            
            if(i%2==0 && i>0){
                System.out.println("Ultimo ataque: Jugador 2 hizo " + player2.getLastAtack() + " de daño");
            }else if(i%2!=0 && i>0){
                System.out.println("Ultimo ataque: Jugador 1 hizo " + player1.getLastAtack() + " de daño");
            }
            
            System.out.println("Jugador 1, vida actual: " + player1.getVida()); // llamamos al metodo para anunciar la vida del p1
            System.out.println("Jugador 2, vida actual: " + player2.getVida()); // llamamos al metodo para anunciar la vida del p2
            System.out.println("");

            if(i%2==0){ 
                //en rondas impares tira el player 1
                System.out.println("Jugador 1, Realiza accion: ");
                System.out.println("1. Atacar    2. Curarse");
                System.out.print("Tu seleccion> ");
                select = sc.nextInt();

                while (select < 1 || select > 2){
                    System.out.println("Tu seleccion no existe");
                    System.out.print("Jugador 1, Ingresa tu seleccion> ");
                    select = sc.nextInt();
                }

                if(select == 2 && player1.getLimitHeal() == 0){ //Si el jugador 1 alcanza el limite de curación
                    while(select == 2){
                        System.out.println("Te has agotado tus curaciones!!");
                        System.out.print("Jugador 1, Ingresa tu seleccion> ");
                        select = sc.nextInt();
                    }
                }

                

                switch(select){
                    case 1:
                        player2.setVida(player1.doAtack());
                    break;           
                    
                    case 2:
                        player1.doHeal();
                    break;
                }

            }else if(i%2!=0){ 
                //en rondas impares tira el player 2
                
                System.out.println("Jugador 2, Realiza accion: ");
                System.out.println("1. Atacar    2. Curarse");
                System.out.print("Tu seleccion> ");
                select = sc.nextInt();

                while (select < 1 || select > 2){
                    System.out.println("Tu seleccion no existe");
                    System.out.print("Jugador 2, Ingresa tu seleccion> ");
                    select = sc.nextInt();
                }

                if(select == 2 && player2.getLimitHeal() == 0){ //Si el jugador 2 alcanza el limite de curación
                    while(select == 2){
                        System.out.println("Te has agotado tus curaciones!!");
                        System.out.print("Jugador 2, Ingresa tu seleccion> ");
                        select = sc.nextInt();
                    }
                }
                
                switch(select){
                    case 1:
                        player1.setVida(player2.doAtack());
                        System.out.println("Ultimo ataque: Jugador 2 hizo " + player2.getLastAtack() + " de daño");
                    break;           
                    
                    case 2:
                        player2.doHeal();
                    break;
                }
            }
            
        }

        clearScreen();
        //revision de la vida cuando la partida acaba
        System.out.println("Jugador 1, vida actual: " + player1.getVida()); // llamamos al metodo para anunciar la vida del p1
        System.out.println("Jugador 2, vida actual: " + player2.getVida()); // llamamos al metodo para anunciar la vida del p2
        
        //anuncio de quien ganó
        clearScreen();
        if(player1.getVida() > player2.getVida()){
            System.out.println("Player 1 gana");
        } else if (player1.getVida() < player2.getVida()){
            System.out.println("Player 2 gana");
        } else {
            System.out.println("Empataron");
        }
        
    }
}