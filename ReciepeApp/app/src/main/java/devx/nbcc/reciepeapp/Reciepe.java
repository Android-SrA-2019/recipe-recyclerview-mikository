package devx.nbcc.reciepeapp;

import java.io.Serializable;

public class Reciepe implements Serializable {
    public Reciepe(String name, String description, String image, String ingredients, String directions) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.ingredients = ingredients;
        this.directions = directions;
    }

    private String name;
    private String description;
    private String image;
    private String ingredients;
    private String directions;

    public String getDirections() {
        return directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}