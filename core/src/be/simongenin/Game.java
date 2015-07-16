package be.simongenin;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.List;

public class Game extends ApplicationAdapter {
	SpriteBatch batch;

	List<Card> cards;

	@Override
	public void create() {
		batch = new SpriteBatch();
		cards = new ArrayList<Card>();

		// Textures
		Texture tex = new Texture("sauron.png");

		// Create attributs list
		List<Attribut> list = new ArrayList<Attribut>();
		list.add(Attribut.AURA_OF_TERROR);

		// Create cards
		Card c1 = new Card("Sauron", list, tex, 20, 30, 30);
		c1.setFace(CardFace.FACE_DOWN);

		cards.add(c1);
		c1.flip();
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(0.2f, 0.3f, 0.3f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();
			cards.get(0).render(batch);
		batch.end();
	}

}
