import javax.swing.*;

public class MineralCard extends Card {
    private int attribute;
    private double hardness, specificGravity;
    private String cleavage, crustal_abundance, economic_value;

    private String[] cleavageValues = {"none", "poor/none", "1 poor","2 poor" ,"1 good"
            ,"1 good/1 poor" ,"2 good","3 good" ,"1 perfect", "1 perfect/1 good",
            "1 perfect/2 good", "2 perfect/1 good", "3 perfect", "4 perfect", "6 perfect" };

    private String[] crustal_abundance_values = {"ultratrace", "trace", "low", "moderate", "high", "very high"};

    private String[] economicValues = {"trivial", "low", "moderate", "high", "very high", "I'm rich!"};

    public MineralCard(String name, double hardness, double specificGravity, String cleavage, String crustal_abundance, String economic_value){
        this.hardness = hardness;
        this.specificGravity = specificGravity;
        this.cleavage = cleavage;
        this.crustal_abundance = crustal_abundance;
        this.economic_value = economic_value;
        super.setName(name);
    }

    public double getHardness() {
        return hardness;
    }

    public void setHardness(int hardness) {
        this.hardness = hardness;
    }

    public double getSpecificGravity() {
        return specificGravity;
    }

    public String getCleavage() {
        return cleavage;
    }

    public void setCleavage(String cleavage) {
        this.cleavage = cleavage;
    }

    public String getCrustal_abundance() {
        return crustal_abundance;
    }

    public void setCrustal_abundance(String crustal_abundance) {
        this.crustal_abundance = crustal_abundance;
    }

    public String getEconomic_value() {
        return economic_value;
    }

    public void setEconomic_value(String economic_value) {
        this.economic_value = economic_value;
    }

    public void setSpecificGravity(int specificGravity) {
        this.specificGravity = specificGravity;
    }

    public int getAttribute() {
        return attribute;
    }

    public void setAttribute(int attribute) {
        this.attribute = attribute;
    }

    public String[] getEconomicValues() {
        return economicValues;
    }

    public String[] getCleavageValues() {
        return cleavageValues;
    }

    public String[] getCrustal_abundance_values() {
        return crustal_abundance_values;
    }

    public boolean compareValues(MineralCard otherCard, String attribute_to_compare){
        boolean check = true;

        switch (attribute_to_compare) {
            case "Hardness":
                if (hardness < otherCard.getHardness()) {
                    check = false;
                }
                break;
            case "Specific gravity":
                if (specificGravity < otherCard.getSpecificGravity()) {
                    check = false;
                }
                break;
            case "Cleavage":
                if (convert(cleavage, cleavageValues) < convert(otherCard.getCleavage(), cleavageValues))
                    check = false;
                break;
            case "Crustal abundance":
                if (convert(crustal_abundance, crustal_abundance_values) < convert(otherCard.getCrustal_abundance(), crustal_abundance_values))
                    check = false;
                break;
            case "Economic value":
                if (convert(economic_value, economicValues) < convert(otherCard.getEconomic_value(), economicValues))
                    check = false;
                break;
        }
        return check;
    }//this method is used to compare values of two cards by chosen attribute.

    private int convert(String attribute, String[] attributes){
        int i = 0;
        for (String s : attributes){
            i++;
            if (attribute.equals(s))
                break;
        }
        return i;
    }

    public String getAttributes(){
        String attributes;
        attributes = String.format("%s, Hardness: %.1f, Specific Gravity: %.1f, Cleavage: %s, Crustal Abundance: %s, Economic Value: %s", super.getName(), hardness, specificGravity, cleavage, crustal_abundance, economic_value);
        return attributes;
    }
    public void display(String category){
        JFrame frame = new CardFrame("Card", category, this);
        frame.setSize(800, 200);
        frame.setVisible(true);
    }
}