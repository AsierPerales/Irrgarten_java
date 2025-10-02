/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgarten;

/**
 *
 * @author asier
 */
public class Shield {
    private float protection;
    private int uses;

    public Shield(float protection, int uses) {
        this.protection = protection;
        this.uses = uses;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "S[" + protection + ", " + uses + ']';
    }
    
    public float protect(){
        if (this.uses > 0){
            uses --;
            return (this.protection);
        }
        else return this.uses;
    }
    
}
