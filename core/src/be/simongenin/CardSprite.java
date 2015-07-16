package be.simongenin;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * A card sprite represents the card in the world.
 * It contains its position and current texture, and
 * handles the rendering of it.
 */
public class CardSprite {

    // Position
    public int x;
    public int y;

    // Size
    public int width;
    public int height;

    // Graphics
    public boolean isVisible;
    public Texture texture;

    public CardSprite() {
        this.x = 0;
        this.y = 0;
        this.width = Config.CARD_WIDTH;
        this.height = Config.CARD_HEIGT;
        this.isVisible = true;
        texture = null;
    }

    // Render the card
    public void render(SpriteBatch batch) {
        if (isVisible && texture != null) {
            batch.draw(texture, x, y, width, height);
        }

        if (Config.DEBUG_MODE && texture == null) {
            System.err.println("A card must have a texture to be drawn");
        }

    }

}
