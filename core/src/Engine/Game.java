package Engine;

enum Token{
    P1,
    P2
}
public class Game {
    private Player p1;
    private Player p2;
    private Token playerToken;
    public Game(){
        init();
    }

    private void init() {
        playerToken = Token.P1;
    }
    public void changePlayer(){
        if(playerToken == Token.P1) {
            playerToken=Token.P2;
        } else
            playerToken=Token.P1;
    }
}
