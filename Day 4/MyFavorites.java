public class MyFavorites extends ParentFavorites implements Favorites{

	 public void favoriteFruit(){

		System.out.println("Orange");
	}
	public void favoriteIceCream(){

		System.out.println("Chocolate Ice Cream");
	}

	public void favoriteMovies(){

		System.out.println("The Little Prince");
	}

	public void favoriteSubject(){

		System.out.println("Math");
	}

	public static void main(String[] args) {
		MyFavorites fav = new MyFavorites();
		fav.favoriteSubject();
		fav.favoriteMovies();
		fav.favoriteIceCream();
		fav.favoriteFruit();
		System.out.println("Both extending and implementing");
		fav.parentFavoriteSubject();

	}



}