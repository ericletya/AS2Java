public class SuperTrumpCard extends Card {
    private String attribute;

    public SuperTrumpCard(String name ,String attribute){
        this.attribute = attribute;
        super.setName(name);
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public String getAttributes(){
        String attributes;
        attributes = String.format("%s, %s", super.getName(), attribute);
        return  attributes;
    }
}
