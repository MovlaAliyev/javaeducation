package dogdoors;

public class Bark {

    private String sound;

    public Bark(String sound) {
        this.sound = sound;
    }

    public String getSound() {
        return sound;
    }
    
    public boolean equlas(Object bark){
        if(bark instanceof Bark){
            Bark otherBark = (Bark) bark;
            if(this.sound.equalsIgnoreCase(otherBark.getSound())){
                return true;
            }
        }
        return false;
    }

}
