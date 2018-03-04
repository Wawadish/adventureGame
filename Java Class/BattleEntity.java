package com.company;

public class BattleEntity {
    private int HP;
    private int SP;
    private int ATK;
    private int DEF;
    private int SPD;
    private boolean alive = true;
    private boolean player = false;

    public BattleEntity(int HP, int SP, int ATK, int DEF, int SPD, boolean player) {
        this.HP = HP;
        this.SP = SP;
        this.ATK = ATK;
        this.DEF = DEF;
        this.SPD = SPD;
        this.player = player;
        System.out.println("player created");
    }

    public void battle(BattleEntity opponent){
        while(opponent.alive && alive) {
            boolean priority = false;
            if (SPD > opponent.SPD) {
                priority = true;
            }else{
                priority = false;
            }

            if (priority){
                opponent.setHP(opponent.getHP() - (getATK() - getATK() * opponent.getDEF()));
                opponent.checkHP();
                if(opponent.winLose())
                    break;
                setHP(getHP() - (opponent.getATK() - opponent.getATK() * getDEF()));
                checkHP();
                winLose();
            }else{
                setHP(getHP() - (opponent.getATK() - opponent.getATK() * getDEF()));
                if(!winLose()){
                    opponent.setHP(opponent.getHP() - (getATK() - getATK() * opponent.getDEF()));
                    opponent.checkHP();
                    opponent.checkHP();
                    if(opponent.winLose())
                        break;
                }

            }
            System.out.println("HP: " + getHP());
            System.out.println("Opponent HP: " + opponent.getHP());
        }
    }
    public BattleEntity(BattleEntity player){
        this.HP = player.HP/3;
        this.SP = player.SP/3;
        this.ATK = player.ATK/3;
        this.DEF = player.DEF/3;
        this.SPD = player.SPD/3;
        System.out.println("Enemy created");
    }


    private void checkHP(){
        if(HP <= 0)
            alive = false;
    }

    private boolean winLose(){
        if(player) {
            if (alive == false) {
                System.out.println("Sorry, you lost! GAME OVER.");
                System.exit(0);
            }
        }else{
            if(alive == false){
                System.out.println("Enemy Defeated! CONGRATULATIONS!!");
                return true;
            }
        }
        return false;
    }
    public int getHP() {
        return HP;
    }

    public int getSP() {
        return SP;
    }

    public int getATK() {
        return ATK;
    }

    public int getDEF() {
        return DEF/100;
    }

    public int getSPD() {
        return SPD;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public void setSP(int SP) {
        this.SP = SP;
    }

    public void setATK(int ATK) {
        this.ATK = ATK;
    }

    public void setDEF(int DEF) {
        this.DEF = DEF;
    }

    public void setSPD(int SPD) {
        this.SPD = SPD;
    }
}
