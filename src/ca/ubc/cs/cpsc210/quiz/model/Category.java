package ca.ubc.cs.cpsc210.quiz.model;

/**
 * Represents a category of restaurant with name and alias.
 */
public class Category extends java.lang.Object {
    private String name;
    private String alias;
    public Category(String name, String alias){
        this.name = name;
        this.alias = alias;

    }
    public String getName(){
        return name;

    }
    public String getAlias(){
        return alias;

    }


    @Override
    //Produces string representation of Category as the category name
    public String toString(){
        return this.getName();


    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Category)) return false;

        Category category = (Category) o;

        if (!alias.equals(category.alias)) return false;
        if (!name.equals(category.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + alias.hashCode();
        return result;
    }
}
