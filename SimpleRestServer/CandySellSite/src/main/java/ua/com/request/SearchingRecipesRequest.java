package ua.com.request;

public class SearchingRecipesRequest {
private String NameRecipes;

public SearchingRecipesRequest(String nameRecipes) {
	super();
	NameRecipes = nameRecipes;
}

public String getNameRecipes() {
	return NameRecipes;
}

public void setNameRecipes(String nameRecipes) {
	NameRecipes = nameRecipes;
}

@Override
public String toString() {
	return "SearchingRecipesRequest [NameRecipes=" + NameRecipes + "]";
}

}
