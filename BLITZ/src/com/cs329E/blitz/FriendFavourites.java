package com.cs329E.blitz;
import android.graphics.drawable.Drawable;
public class FriendFavourites {
	
	private Drawable profPic;
	
	public FriendFavourites(Drawable profPic) {
		this.profPic = profPic;
	}

	public Drawable getProfPic() {
		return profPic;
	}

	public void setProfPic(Drawable profPic) {
		this.profPic = profPic;
	}
}
